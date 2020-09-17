package interfaz_grafica;

import json.GestorJSON;
import lanzador.Principal;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;

public class VentanaPrincipal extends JFrame implements ActionListener, KeyListener{

    //// Atributos
    /**
     * WindowListener para el JFrame
     */
    private WindowListener windowListener;
    /**
     * Panel principal
     */
    private JPanel panel;
    /**
     * Panel con el logo del programa
     */
    private JPanelImagen panelLogo;
    /**
     * Label con el nombre del programa
     */
    private JLabel labelGestorPhoneBook;
    /**
     * Panel con las opciones del menú principal
     */
    private JPanel panelOpciones;
    /**
     * Botón para ver los datos guardados en la agenda
     */
    private JButton botonDatosAgenda;
    /**
     * Botón para ver datos guardados en el archivo "agenda.json"
     */
    private JButton botonVerJSON;
    /**
     * Selector de archivos que se usa para importar y exportar
     */
    private JFileChooser selectorArchivo;
    /**
     * Botón para importar un archivo JSON al programa
     */
    private JButton botonImportarJSON;
    /**
     * Botón para exportar un archivo JSON
     */
    private JButton botonExportarJSON;
    /**
     * Botón para borrar todos los datos guardados
     */
    private JButton botonBorrarTodo;
    /**
     * Botón para salir del programa
     */
    private JButton botonSalir;
    /**
     * Panel que tiene la lista de contactos
     */
    private JListGeneral listaC;
    /**
     * Panel que tendrá los componentes necesarios para crear un contacto
     */
    private JPanel panelNuevoContacto;
    /**
     * Label con el nombre del programa
     */
    private JLabel labelIngreseNombre;
    /**
     * TextField para ingresar el nombre
     */
    private JTextField campoIngreseNombre;
    /**
     * Botón para guardar el contacto
     */
    private JButton botonGuardar;
    /**
     * Panel con las opciones para el contacto seleccionado de la lista
     */
    private JPanel panelOpcionesLista;
    /**
     * Botón para ver los datos de un contacto
     */
    private JButton botonDatosContacto;
    /**
     * Botón para acceder al menú de edición de un contacto
     */
    private JButton botonEditarContacto;
    /**
     * Botón para eliminar a un contacto
     */
    private JButton botonEliminarContacto;

    //// Constructores
    public VentanaPrincipal(){
        cargarDatos();
        traducirTextos();
        cargarIcono();
        inicializarComponentes();
        ubicarComponentes();
        implementarListeners();
        configurarVentana();
    }

    //// Métodos
    /**
     * Método que carga los datos del archivo JSON y de las fotos de contactos
     */
    private void cargarDatos() {
        // Carga datos del archivo "agenda.json"
        GestorJSON.cargarJSON("agenda.json");
    }

    /**
     * Método para traducir los textos de los componentes
     */
    private void traducirTextos() {
        // Por algún motivo, se puede traducir a chino pero no a español
        // Locale.setDefault(new Locale("zh", "CN")); // Funciona
        // Locale.setDefault(new Locale("es", "ES")); // No funciona

        // Traduce la opción "Yes" de los JOptionPane
        UIManager.put("OptionPane.yesButtonText", "Sí");
        // Traduce las opciones de los JFileChooser
        UIManager.put("FileChooser.openButtonText", "Abrir");
        UIManager.put("FileChooser.saveButtonText", "Guardar");
        UIManager.put("FileChooser.cancelButtonText", "Cancelar");
        UIManager.put("FileChooser.acceptAllFileFilterText", "Todos los archivos");
    }

    /**
     * Método que carga el ícono de la aplicación desde un archivo externo
     */
    private void cargarIcono() {
        Image icono = Toolkit.getDefaultToolkit().getImage("archivos/icono_phonebook_nuevo.png");
        setIconImage(icono);
    }

    /**
     * Método para iniciar la ventana principal (instancia y configura todos los componentes necesarios)
     */
    private void inicializarComponentes() {

        // Instancia el JPanel
        panel = new JPanel();
        // Usa el GridBagLayout para organizar los componentes
        panel.setLayout(new GridBagLayout());

        // El logo está en la razón 5:2
        panelLogo = new JPanelImagen("archivos/logo_phonebook.png", 200, 80);
        // Le añade un borde al logo
        panelLogo.setBorder(BordeGeneral.crearBorde("Información del proyecto"));

        panelOpciones = new JPanel();
        panelOpciones.setLayout(new BoxLayout(panelOpciones, BoxLayout.Y_AXIS));
        // Crea un borde para el panel con las opciones
        panelOpciones.setBorder(BordeGeneral.crearBorde("Opciones"));

        listaC = new JListGeneral("Lista de contactos");
        // Añade todos los nombres de los contactos al modelo de la lista
        for (String s : Principal.agenda.getLista_Nombres()) {
            listaC.agregarElemento(s);
        }

        panelNuevoContacto = new JPanel();
        panelNuevoContacto.setBorder(BordeGeneral.crearBorde("Nuevo contacto"));
        panelNuevoContacto.setLayout(new GridBagLayout());

        panelOpcionesLista = new JPanel();
        panelOpcionesLista.setBorder(BordeGeneral.crearBorde("Opciones de la lista"));
        panelOpcionesLista.setLayout(new BoxLayout(panelOpcionesLista, BoxLayout.Y_AXIS));

        // Instancia el JLabel
        labelGestorPhoneBook = new JLabel("Gestor PhoneBook VLB");
        // Usa letra más grande
        labelGestorPhoneBook.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));

        // Instancia los JButton
        botonDatosAgenda = new JButton("Ver datos de la agenda");
        botonDatosAgenda.setAlignmentX(Component.CENTER_ALIGNMENT);

        botonVerJSON = new JButton("Ver archivo \"agenda.json\"");
        botonVerJSON.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Instancia el selectorArchivo que se usará para importar y exportar
        selectorArchivo = new JFileChooser();
        // Instancia un FileFilter para sólo mostrar directorios y archivos .json
        FileFilter filtroJSON = new FileFilter(){

            public String getDescription(){
                // Se cambia la descripción
                return "Archivos JSON (*.json)";
            }

            @Override
            public boolean accept(File f) {
                // Mostrará directorios
                if(f.isDirectory()){
                    return true;
                }

                // También mostrará archivos .json
                else{
                    // Pasa el nombre del archivo a minúsculas
                    // Lo hace para aceptar cualquier combinación de mayúsculas o minúsculas al final
                    String nombreArchivo = f.getName().toLowerCase();

                    // Retorna true sólo si el archivo termina con ".json"
                    return nombreArchivo.endsWith(".json");
                }
            }
        };
        // Usar ese filtro en el selector de archivos
        selectorArchivo.setFileFilter(filtroJSON);
        selectorArchivo.setLocale(Locale.getDefault());
        selectorArchivo.updateUI();

        botonImportarJSON = new JButton("Importar archivo json");
        botonImportarJSON.setAlignmentX(Component.CENTER_ALIGNMENT);

        botonExportarJSON = new JButton("Exportar \"agenda.json\"");
        botonExportarJSON.setAlignmentX(Component.CENTER_ALIGNMENT);

        botonBorrarTodo = new JButton("Borrar todos los datos guardados");
        botonBorrarTodo.setAlignmentX(Component.CENTER_ALIGNMENT);

        botonSalir = new JButton("Salir del programa");
        botonSalir.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Instancia el JLabel para crear un nuevo contacto
        labelIngreseNombre = new JLabel("Nombre:");
        labelIngreseNombre.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Instancia el JTextField para crear un nuevo contacto
        campoIngreseNombre = new JTextField(10);
        campoIngreseNombre.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Instancia el JButton para crear un nuevo contacto
        botonGuardar = new JButton("Añadir");
        botonGuardar.setAlignmentX(Component.CENTER_ALIGNMENT);

        botonDatosContacto = new JButton("Ver datos");
        botonDatosContacto.setAlignmentX(Component.CENTER_ALIGNMENT);

        botonEditarContacto = new JButton("Editar");
        botonEditarContacto.setAlignmentX(Component.CENTER_ALIGNMENT);

        botonEliminarContacto = new JButton("Eliminar");
        botonEliminarContacto.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    /**
     * Método que ubica los paneles y el resto de componentes usando GridBagLayout
     */
    private void ubicarComponentes() {
        // Añade el panel con el logo
        panel.add(panelLogo, gbc(0, 0, 1, 1, 0.3, 0.5));

        // Añade panel con las opciones
        panelOpciones.add(botonDatosAgenda);
        panelOpciones.add(botonVerJSON);
        panelOpciones.add(botonImportarJSON);
        panelOpciones.add(botonExportarJSON);
        panelOpciones.add(botonBorrarTodo);
        panelOpciones.add(botonSalir);
        panel.add(panelOpciones, gbc(0, 1, 1, 1, 0.3, 0.5));

        // Añade panel con la lista de contactos
        panel.add(listaC, gbc(1, 0, 1, 2, 0.4, 1));

        // Añade el panel para crear un nuevo contacto
        panelNuevoContacto.add(labelIngreseNombre, gbc(0, 0, 1, 1));
        panelNuevoContacto.add(campoIngreseNombre, gbc(1, 0, 1, 1));
        panelNuevoContacto.add(botonGuardar, gbc(0, 1, 2, 1));
        panel.add(panelNuevoContacto, gbc(2, 0, 1, 1, 0.3, 0.5));

        // Añade el panel con las opciones de la lista de contactos
        panelOpcionesLista.add(botonDatosContacto);
        panelOpcionesLista.add(botonEditarContacto);
        panelOpcionesLista.add(botonEliminarContacto);
        panel.add(panelOpcionesLista, gbc(2, 1, 1, 1, 0.3, 0.5));

        // Añade el JPanel al JFrame
        add(panel);
    }

    private GridBagConstraints gbc(int x, int y, int ancho, int altura){
        // Instancia GriadBagConstraints para configurar un GridBagLayout
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = x;
        c.gridy = y;
        c.gridwidth = ancho;
        c.gridheight = altura;
        c.weightx = 0;
        c.weighty = 0;
        c.fill = GridBagConstraints.BOTH;

        return c;
    }

    private GridBagConstraints gbc(int x, int y, int ancho, int altura, double pesox, double pesoy){
        // Instancia GriadBagConstraints para configurar un GridBagLayout
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = x;
        c.gridy = y;
        c.gridwidth = ancho;
        c.gridheight = altura;
        c.weightx = pesox;
        c.weighty = pesoy;
        c.fill = GridBagConstraints.BOTH;

        return c;
    }

    /**
     * Método que agrega los listeners para los componentes de la ventana
     */
    private void implementarListeners() {
        // Implementación de los listener
        botonDatosAgenda.addActionListener(this);
        botonVerJSON.addActionListener(this);
        botonImportarJSON.addActionListener(this);
        botonExportarJSON.addActionListener(this);
        botonBorrarTodo.addActionListener(this);
        botonSalir.addActionListener(this);
        botonDatosContacto.addActionListener(this);
        botonEditarContacto.addActionListener(this);
        botonEliminarContacto.addActionListener(this);
        botonGuardar.addActionListener(this);
        campoIngreseNombre.addKeyListener(this);

        // Instancia el WindowListener para el JFrame (se agrega en el constructor)
        windowListener = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Crea el panel para pedir confirmación
                int n = JOptionPane.showConfirmDialog(panel.getParent(),
                        "¿Está seguro de que desea salir?",
                        "Salir del programa",
                        JOptionPane.YES_NO_OPTION);

                // Si el usuario escoge "Sí"
                if (n == JOptionPane.YES_OPTION) {
                    // Sale del programa y retorna 0
                    System.exit(0);
                }
            }
        };
    }

    /**
     * Realiza configuraciones de la ventana como tamaño, acción al cerrar, etc.
     */
    private void configurarVentana() {
        // Título
        setTitle("Gestor Phonebook VLB");
        // Tamaño inicial
        setSize(700, 400);
        // La ventana inicia centrada
        setLocationRelativeTo(null);
        // Inhabilita la opción de cambiar el tamaño de la ventana
        // setResizable(false);
        // Cuando se cierre la ventana no hace nada...
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        // Pero se agrega un WindowListener para pedir confirmación al hacer click en la X
        addWindowListener(windowListener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonDatosAgenda){
            // Instancia la ventana con los datos de la agenda
            VentanaDatosAgenda vda = new VentanaDatosAgenda();
            vda.setVisible(true);
        }

        if (e.getSource() == botonVerJSON){
            // Instancia la ventana con los datos de "agenda.json"
            VentanaVerJSON vvj = new VentanaVerJSON();
            vvj.setVisible(true);
        }

        if (e.getSource() == botonImportarJSON){
            // Cambiar título
            selectorArchivo.setDialogTitle("Importar archivo");

            // El resultado indica si se eligió algo válido o no
            int resultado = selectorArchivo.showOpenDialog(panel.getParent());

            // Si el resultado se puede abrir...
            if (resultado == JFileChooser.APPROVE_OPTION) {

                // Guarda la ruta del archivo elegido, si es que existe
                String ruta = selectorArchivo.getSelectedFile().getPath();
                // También indicamos el destino
                String destino = "agenda.json";

                // Si el archivo destino existe, se tiene que pedir confirmación
                if(Files.exists(Paths.get(destino))){

                    // Pide la confirmación para reemplazarlo
                    int n = JOptionPane.showConfirmDialog(panel.getParent(),
                            "El archivo \""+destino+"\" ya existe. ¿Desea reemplazarlo?\nEsta operación no se puede deshacer.",
                            "El archivo ya existe",
                            JOptionPane.YES_NO_OPTION);

                    // Si el usuario escoge "Sí"
                    if(n == JOptionPane.YES_OPTION){
                        // Borra todos los datos
                        Principal.agenda.borrarTodo();

                        // Limpia los datos del modelo
                        listaC.limpiar();

                        GestorJSON.importarJSON(ruta, destino);

                        // Añada todos los nombres de los contactos al modelo
                        for (String s : Principal.agenda.getLista_Nombres()) {
                            listaC.agregarElemento(s);
                        }
                    }
                }

                else{
                    // Borra todos los datos
                    Principal.agenda.borrarTodo();

                    // Limpia los datos del modelo
                    listaC.limpiar();

                    GestorJSON.importarJSON(ruta, destino);

                    // Añada todos los nombres de los contactos al modelo
                    for (String s : Principal.agenda.getLista_Nombres()) {
                        listaC.agregarElemento(s);
                    }
                }
            }
        }

        if (e.getSource() == botonExportarJSON){
            String original = "agenda.json";

            // Si el archivo existe
            if(Files.exists(Paths.get(original))){
                // Cambiar título
                selectorArchivo.setDialogTitle("Exportar archivo");

                // El resultado indica si se eligió algo válido o no
                int resultado = selectorArchivo.showSaveDialog(panel.getParent());

                // Si el resultado es válido...
                if (resultado == JFileChooser.APPROVE_OPTION) {

                    // Guarda la ruta del archivo destino
                    String destino = selectorArchivo.getSelectedFile().getPath();

                    // Si el archivo destino ya existe, se tiene que pedir confirmación
                    if (Files.exists(Paths.get(destino))) {

                        // Pide la confirmación para reemplazarlo
                        int n = JOptionPane.showConfirmDialog(panel.getParent(),
                                "El archivo destino ya existe. ¿Desea reemplazarlo?\nEsta operación no se puede deshacer.",
                                "El archivo ya existe",
                                JOptionPane.YES_NO_OPTION);

                        // Si el usuario escoge "Sí"
                        if (n == JOptionPane.YES_OPTION) {
                            GestorJSON.exportarJSON(original, destino);
                        }
                    }

                    else {
                        GestorJSON.exportarJSON(original, destino);
                    }
                }
            }

            else{
                // Mensaje de que "no existe la agenda en algún lugar"
            }
        }

        if (e.getSource() == botonBorrarTodo){
            // Crea el panel para pedir confirmación
            int n = JOptionPane.showConfirmDialog(panel.getParent(),
                    "¿Está seguro de que quiere borrar TODOS los datos guardados?\nEsta operación no se puede deshacer.",
                    "Borrar todo",
                    JOptionPane.YES_NO_OPTION);

            // Si el usuario escoge "Sí"
            if(n == JOptionPane.YES_OPTION){
                // Borra todos los datos
                Principal.agenda.borrarTodo();

                // Limpia los datos del modelo
                listaC.limpiar();
            }
        }

        if (e.getSource() == botonSalir){
            // Crea el panel para pedir confirmación
            int n = JOptionPane.showConfirmDialog(panel.getParent(),
                    "¿Está seguro de que desea salir?",
                    "Salir del programa",
                    JOptionPane.YES_NO_OPTION);

            // Si el usuario escoge "Sí"
            if(n == JOptionPane.YES_OPTION){
                // Sale del programa y retorna 0
                System.exit(0);
            }
        }

        if(e.getSource() == botonGuardar) {
            if(campoIngreseNombre.getText().equals("")){
                // Muestra mensaje de error en algún lugar
            }

            else {
                // Crea un contacto con el nombre ingresado
                int posicionNueva = Principal.agenda.crearContacto(campoIngreseNombre.getText());
                // Añade el contacto nuevo al modelo, en la misma posición que el ArrayList
                listaC.agregarElemento(campoIngreseNombre.getText(), posicionNueva);
                // Borra el texto del textField
                campoIngreseNombre.setText("");
            }
        }

        if (e.getSource() == botonDatosContacto) {
            // Si el usuario ha seleccionado un objeto de la lista
            if(listaC.getEleccion()!=-1) {
                // Instancia una ventana para elegir un contacto y la hace visible
                VentanaDatosContacto vdc = new VentanaDatosContacto(listaC.getEleccion());
                vdc.setVisible(true);
            }
        }

        if (e.getSource() == botonEditarContacto) {
            // Si el usuario ha seleccionado un objeto de la lista
            if(listaC.getEleccion()!=-1) {
                // Instancia una ventana que muestra el editor de datos del contacto elegido
                VentanaEditor ve = new VentanaEditor(listaC.getEleccion());
                ve.setVisible(true);
            }
        }

        if (e.getSource() == botonEliminarContacto){
            // Crea el panel para pedir confirmación
            int n = JOptionPane.showConfirmDialog(panel.getParent(),
                    "¿Está seguro de que quiere borrar el contacto \""+
                            Principal.agenda.getLista_Nombres().get(listaC.getEleccion())+
                            "\"?\nEsta operación no se puede deshacer.",
                    "Borrar el contacto \""+Principal.agenda.getLista_Nombres().get(listaC.getEleccion())+"\"",
                    JOptionPane.YES_NO_OPTION);

            // Si el usuario escoge "Sí"
            if(n == JOptionPane.YES_OPTION){
                // Borra el contacto seleccionado
                Principal.agenda.eliminarContacto(listaC.getEleccion());

                // Borra el contacto del modelo
                listaC.borrarElegido();

                // Reinicia la elección (para evitar errores del tipo IndexOutOfBounds)
                listaC.reiniciarEleccion();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Si se pulsa enter al estar escribiendo en el textField
        if (e.getSource() == campoIngreseNombre && e.getKeyCode() == KeyEvent.VK_ENTER) {
            if(campoIngreseNombre.getText().equals("")){
                // Muestra mensaje de error en algún lugar
            }

            else {
                // Obtiene la posición en la que se agregó el contacto
                int posicionNueva = Principal.agenda.crearContacto(campoIngreseNombre.getText());

                // Añade el contacto nuevo al modelo, en la misma posición que el ArrayList
                listaC.agregarElemento(campoIngreseNombre.getText(), posicionNueva);

                // Borra el texto del textField
                campoIngreseNombre.setText("");
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
