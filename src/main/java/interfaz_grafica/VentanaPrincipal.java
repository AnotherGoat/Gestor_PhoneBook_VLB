package interfaz_grafica;

import json.GestorJSON;
import lanzador.Principal;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class VentanaPrincipal extends JFrame implements ActionListener {

    //// Atributos
    /**
     * Panel principal
     */
    private JPanel panel;

    private WindowListener windowListener;
    /**
     * Panel con el nombre del programa
     */
    private JPanel panelTitulo;
    /**
     * Label con el nombre del programa
     */
    private JLabel labelGestorPhoneBook;
    /**
     * Panel con las opciones del menú principal
     */
    private JPanel panelOpciones;
    /**
     * Botón para crear un nuevo contacto
     */
    private JButton botonNuevoContacto;
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
    /**
     * Botón para ver los datos guardados en la agenda
     */
    private JButton botonDatosAgenda;
    /**
     * Botón para ver datos guardados en el archivo "agenda.json"
     */
    private JButton botonVerJSON;
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
    private JPanel panelLista;
    /**
     * Modelo con los nombres de los contactos (se usa en el JList)
     */
    private DefaultListModel<String> modelo_contactos;
    /**
     * Lista con los contactos
     */
    private JList<String> jlist_contactos;
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
    private JTextField textFieldIngreseNombre;
    /**
     * Botón para guardar el contacto
     */
    private JButton botonGuardar;
    /**
     * Panel con opciones para lista de contactos
     */
    private JPanel panelOpcionesLista;
    private List<JButton> lista_botones = new ArrayList<>();
    /**
     * Scroll para el panel con los botones
     */
    private JScrollPane scroll;
    /**
     * Opción que ingresa el usuario, empieza en -1 para validar
     */
    private int eleccion = -1;
    /**
     * MouseListener para la JList
     */
    private MouseListener mouseListener;

    //// Constructores
    public VentanaPrincipal(){
        // Carga datos del archivo "agenda.json"
        GestorJSON.cargarJSON();

        inicializar();

        //// Otras características de la ventana

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

    //// Métodos
    /**
     * Método para iniciar la ventana principal (instancia todos los objetos necesarios)
     */
    private void inicializar(){
        // Carga el ícono de la aplicación
        cargarIcono();

        // Traduce la opción "Yes" de los OptionPane
        UIManager.put("OptionPane.yesButtonText", "Sí");

        // Instancia el JPanel
        panel = new JPanel();
        // Usa el BoxLayout para mostrar los botones verticalmente
        // panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setLayout(new GridBagLayout());

        panelTitulo = new JPanel();
        // Para centrar el label
        panelTitulo.setLayout(new GridBagLayout());
        panelTitulo.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true), "Información del proyecto"));

        panelOpciones = new JPanel();
        panelOpciones.setLayout(new BoxLayout(panelOpciones, BoxLayout.Y_AXIS));
        // Crea un borde para el panel con las opciones
        panelOpciones.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true), "Opciones"));

        panelLista = new JPanel();
        panelLista.setLayout(new BorderLayout());
        panelLista.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true), "Lista de contactos"));

        panelNuevoContacto = new JPanel();
        panelNuevoContacto.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true), "Nuevo contacto"));
        panelNuevoContacto.setLayout(new BoxLayout(panelNuevoContacto, BoxLayout.Y_AXIS));

        panelOpcionesLista = new JPanel();
        panelOpcionesLista.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true), "Opciones de la lista"));
        panelOpcionesLista.setLayout(new BoxLayout(panelOpcionesLista, BoxLayout.Y_AXIS));

        // Instancia el JLabel
        labelGestorPhoneBook = new JLabel("Gestor PhoneBook VLB");
        // Usa letra más grande
        labelGestorPhoneBook.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));

        // Instancia los JButton
        botonNuevoContacto = new JButton("Crear un contacto nuevo");
        botonNuevoContacto.setAlignmentX(Component.CENTER_ALIGNMENT);

        botonDatosAgenda = new JButton("Ver datos de la agenda");
        botonDatosAgenda.setAlignmentX(Component.CENTER_ALIGNMENT);

        botonVerJSON = new JButton("Ver archivo \"agenda.json\"");
        botonVerJSON.setAlignmentX(Component.CENTER_ALIGNMENT);

        botonBorrarTodo = new JButton("Borrar todos los datos guardados");
        botonBorrarTodo.setAlignmentX(Component.CENTER_ALIGNMENT);

        botonSalir = new JButton("Salir del programa");
        botonSalir.setAlignmentX(Component.CENTER_ALIGNMENT);

        botonDatosContacto = new JButton("Ver datos");
        botonDatosContacto.setAlignmentX(Component.CENTER_ALIGNMENT);

        botonEditarContacto = new JButton("Editar");
        botonEditarContacto.setAlignmentX(Component.CENTER_ALIGNMENT);

        botonEliminarContacto = new JButton("Eliminar");
        botonEliminarContacto.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Instancia un modelo para usarlo en la JList
        modelo_contactos = new DefaultListModel();
        // Instancia un JList con los datos de la lista de contactos
        jlist_contactos = new JList(modelo_contactos);

        for(String s : Principal.agenda.getLista_Nombres()){
            modelo_contactos.addElement(s);
        }

        // Instancia el JScrollPane, usando la JList (y define el funcionamiento vertical y horizontal)
        scroll = new JScrollPane(jlist_contactos, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        //// Añade los objetos al JPanel

        // Instancia GriadBagConstraints para configurar el Layout
        GridBagConstraints c = new GridBagConstraints();

        // Añade el panel con el título
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 0.3;
        c.weighty = 0.5;
        panelTitulo.add(labelGestorPhoneBook);
        panel.add(panelTitulo, c);

        // Añade panel con las opciones
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 0.3;
        c.weighty = 0.5;
        panelOpciones.add(botonNuevoContacto);
        panelOpciones.add(botonDatosAgenda);
        panelOpciones.add(botonVerJSON);
        panelOpciones.add(botonBorrarTodo);
        panelOpciones.add(botonSalir);
        panel.add(panelOpciones, c);

        // Añade panel con la lista de contactos
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 2;
        c.weightx = 0.4;
        c.weighty = 1;
        panelLista.add(scroll, BorderLayout.CENTER);
        panel.add(panelLista, c);

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 2;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 0.3;
        c.weighty = 0.5;
        panel.add(panelNuevoContacto, c);

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 2;
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 0.3;
        c.weighty = 0.5;
        panelOpcionesLista.add(botonDatosContacto);
        panelOpcionesLista.add(botonEditarContacto);
        panelOpcionesLista.add(botonEliminarContacto);
        panel.add(panelOpcionesLista, c);
        // panel.add(panelOpciones);

        // Añade el JPanel al JFrame
        add(panel);

        // Implementa ActionListener para los botones
        botonNuevoContacto.addActionListener(this);
        botonDatosContacto.addActionListener(this);
        botonEditarContacto.addActionListener(this);
        botonEliminarContacto.addActionListener(this);
        botonDatosAgenda.addActionListener(this);
        botonVerJSON.addActionListener(this);
        botonBorrarTodo.addActionListener(this);
        botonSalir.addActionListener(this);

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
                if(n == JOptionPane.YES_OPTION){
                    // Sale del programa y retorna 0
                    System.exit(0);
                }
            }
        };

        // Instancia el mouseListener para la JList
        mouseListener = new MouseAdapter() {
            // Al hacer click en un objeto
            public void mouseClicked(MouseEvent e) {
                // Obtiene el índice que se escogió
                eleccion = jlist_contactos.getSelectedIndex();
            }
        };
        jlist_contactos.addMouseListener(mouseListener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonNuevoContacto){
            // Instancia una ventana para crear un contacto y la hace visible
            VentanaNuevoContacto vnc = new VentanaNuevoContacto(this);
            vnc.setVisible(true);
        }

        if (e.getSource() == botonDatosContacto) {
            // Si el usuario ha seleccionado un objeto de la lista
            if(eleccion!=-1) {
                // Instancia una ventana para elegir un contacto y la hace visible
                VentanaDatosContacto vdc = new VentanaDatosContacto(eleccion, this);
                vdc.setVisible(true);
            }
        }

        if (e.getSource() == botonEditarContacto) {
            // Instancia una ventana que muestra los datos del contacto elegido
            VentanaElegirContacto vec = new VentanaElegirContacto("Escoja el contacto que quiere editar", this);
            vec.setVisible(true);
        }

        if (e.getSource() == botonEliminarContacto){
            // Crea el panel para pedir confirmación
            int n = JOptionPane.showConfirmDialog(panel.getParent(),
                    "¿Está seguro de que quiere borrar el contacto \""+Principal.agenda.getLista_Nombres().get(eleccion)+"\"?\nEsta operación no se puede deshacer.",
                    "Borrar el contacto \""+Principal.agenda.getLista_Nombres().get(eleccion)+"\"",
                    JOptionPane.YES_NO_OPTION);

            // Si el usuario escoge "Sí"
            if(n == JOptionPane.YES_OPTION){
                // Borra el contacto seleccionado
                Principal.agenda.eliminarContacto(eleccion);

                modelo_contactos.remove(eleccion);
            }
        }

        if (e.getSource() == botonDatosAgenda){
            // Instancia la ventana con los datos de la agenda
            VentanaDatosAgenda vda = new VentanaDatosAgenda(this);
            vda.setVisible(true);
        }

        if (e.getSource() == botonVerJSON){
            // Instancia la ventana con los datos de "agenda.json"
            VentanaVerJSON vvj = new VentanaVerJSON(this);
            vvj.setVisible(true);
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
                modelo_contactos.clear();
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
    }

    /**
     * Método que carga el ícono de la aplicación desde un archivo externo
     */
    private void cargarIcono() {
        Image icono = Toolkit.getDefaultToolkit().getImage("archivos/icono_phonebook_nuevo.png");
        setIconImage(icono);
    }
}
