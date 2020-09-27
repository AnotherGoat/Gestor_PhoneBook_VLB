package interfaz_grafica;

import datos.GestorArchivo;
import lanzador.Principal;
import phonebook.Contacto;
import phonebook.Direccion;
import phonebook.FechaCumple;
import phonebook.Telefono;
import utilidades.Validador;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;

/**
 * Clase que representa una ventana para editar los datos de un contacto
 */
public class VentanaEditor extends JDialogGeneral implements ActionListener {

    //// Atributos
    /**
     * JPanel que contiene los otros paneles donde se puede editar un contacto
     * @see JPanel
     */
    private JPanel panelNorte;

    //// Panel que contiene componentes para editar nombre
    /**
     * Panel con el texto "Nombre"
     * @see JPanel
     */

    private JPanel panelNombre;
    /**
     * Label con el texto "Nombre actual"
     * @see JLabel
     */
    private JLabel labelNombreActual;
    /**
     * Campo de texto con el nombre actual, no editable
     * @see JTextField
     */
    private JTextField campoNombreActual;
    /**
     * Label con el texto "Nombre nuevo"
     * @see JLabel
     */
    private JLabel labelNombreNuevo;
    /**
     * Campo de texto para cambiar el nombre
     * @see JTextField
     */
    private JTextField campoNombreNuevo;
    /**
     * Botón para cambiar el nombre
     * @see JButton
     */
    private JButton botonCambiarNombre;

    //// Panel que contiene componentes para editar Direccion
    /**
     * Panel con el texto "Direccion"
     * @see JPanel
     */
    private JPanel panelDireccion;

    /**
     * Panel con el texto "Ciudad"
     * @see JPanel
     */
    private JPanel panelCiudad;
    /**
     * Label con el texto "Ciudad actual"
     * @see JLabel
     */
    private JLabel labelCiudadActual;
    /**
     * Campo de texto con la ciudad actual, no editable
     * @see JTextField
     */
    private JTextField campoCiudadActual;
    /**
     * Label con el texto "Ciudad nueva"
     * @see JLabel
     */
    private JLabel labelCiudadNueva;
    /**
     * Campo de texto para cambiar la ciudad
     * @see JTextField
     */
    private JTextField campoCiudadNueva;

    /**
     * Panel con el texto "Calle"
     * @see JPanel
     */
    private JPanel panelCalle;
    /**
     * Label con el texto "Calle actual"
     * @see JLabel
     */
    private JLabel labelCalleActual;
    /**
     * Campo de texto con la calle actual, no editable
     * @see JTextField
     */
    private JTextField campoCalleActual;
    /**
     * Label con el texto "Calle nueva"
     * @see JLabel
     */
    private JLabel labelCalleNueva;
    /**
     * Campo de texto para cambiar la calle
     * @see JTextField
     */
    private JTextField campoCalleNueva;

    /**
     * Panel con el texto "Número" (de dirección)
     * @see JPanel
     */
    private JPanel panelNo;
    /**
     * Label con el texto "Número actual" (de dirección)
     * @see JLabel
     */
    private JLabel labelNoActual;
    /**
     * Campo de texto con el número actual (de dirección), no editable
     * @see JTextField
     */
    private JTextField campoNoActual;
    /**
     * Label con el texto "Número nuevo" (de dirección)
     * @see JLabel
     */
    private JLabel labelNoNuevo;
    /**
     * Campo de texto para cambiar el número (de dirección)
     * @see JTextField
     */
    private JTextField campoNoNuevo;

    /**
     * Botón para cambiar la dirección
     * @see JButton
     */
    private JButton botonCambiarDireccion;

    //// Panel que contiene componentes para editar Foto
    /**
     * Panel donde va la foto
     * @see JPanel
     */
    private JPanel panelFoto;

    /**
     * PanelImagen que tiene la foto
     * @see JPanelImagen
     */
    private JPanelImagen foto;
    /**
     * Botón para cambiar la foto
     * @see JButton
     */
    private JButton botonCambiarFoto;
    /**
     * Selector de archivos para cambiar la foto
     * @see JFileChooser
     */
    private JFileChooser selectorFoto;

    //// Panel que contiene componentes para editar fecha de cumpleaños
    /**
     * Panel con el texto "Fecha de cumpleaños"
     * @see JPanel
     */
    private JPanel panelFechaCumple;

    /**
     * Panel con el texto "Fecha actual"
     * @see JPanel
     */
    private JPanel panelFechaActual;
    /**
     * ComboBox con el día actual
     * @see JComboBox
     */
    private JComboBox<String> comboDiaActual;
    /**
     * ComboBox con el mes actual
     * @see JComboBox
     */
    private JComboBox<String> comboMesActual;
    /**
     * Panel con el texto "Fecha nueva"
     * @see JPanel
     */
    private JPanel panelFechaNueva;
    /**
     * ComboBox con el día nuevo
     * @see JComboBox
     */
    private JComboBox<String> comboDiaNuevo;
    /**
     * ComboBox con el mes nuevo
     * @see JComboBox
     */
    private JComboBox<String> comboMesNuevo;
    /**
     * Botón para cambiar la fecha
     * @see JButton
     */
    private JButton botonCambiarFecha;

    //// Panel que contiene componentes para editar teléfono
    /**
     * Panel para editar teléfonos
     * @see JPanel
     */
    private JPanel panelTelefonos;

    /**
     * Panel que tiene la lista de teléfonos
     * @see JPanelLista
     */
    private JPanelLista listaT;

    /**
     * Panel con las opciones para editar teléfonos
     * @see JPanel
     */
    private JPanel panelOpcionesT;

    /**
     * Label con el texto "Nuevo teléfono"
     * @see JLabel
     */
    private JLabel labelTelefono;
    /**
     * Campo de texto para escribir un teléfono nuevo
     * @see JTextField
     */
    private JTextField campoTelefono;
    /**
     * ComboBox para elegir el tipo de teléfono
     * @see JComboBox
     */
    private JComboBox<String> comboTelefono;
    /**
     * Botón para agregar el teléfono escrito en el campo
     * @see JButton
     */
    private JButton botonAgregarTelefono;
    /**
     * Botón para borrar el teléfono seleccionado
     * @see JButton
     */
    private JButton botonBorrarTelefono;

    //// Panel que contiene componentes para editar Email
    /**
     * Panel para editar emails
     * @see JPanel
     */
    private JPanel panelEmails;

    /**
     * Panel que tiene la lista de emails
     * @see JPanelLista
     */
    private JPanelLista listaE;

    /**
     * Panel con las opciones para editar emails
     * @see JPanelNuevoBorrar
     */
    private JPanelNuevoBorrar panelOpcionesE;

    //// Panel que contiene componentes para editar Apodos
    /**
     * Panel para editar apodos
     * @see JPanel
     */
    private JPanel panelApodos;
    /**
     * Panel que tiene la lista de apodos
     * @see JPanelLista
     */
    private JPanelLista listaA;
    /**
     * Panel con las opciones para editar apodos
     * @see JPanelNuevoBorrar
     */
    private JPanelNuevoBorrar panelOpcionesA;

    //// Panel que contiene componentes para editar Notas
    /**
     * Panel para editar notas
     * @see JPanel
     */
    private JPanel panelNotas;
    /**
     * Panel que tiene la lista de notas
     * @see JPanelLista
     */
    private JPanelLista listaN;
    /**
     * Panel con las opciones para editar notas
     * @see JPanelNuevoBorrar
     */
    private JPanelNuevoBorrar panelOpcionesN;

    //// Panel sur
    /**
     * Panel que tendrá el botón para guardar cambios y el botón para salir
     * @see JPanel
     */
    private JPanel panelSur;

    /**
     * Botón para guardar los cambios
     * @see JButton
     */
    private JButton botonGuardarCambios;
    /**
     * Posición del contacto original en la agenda
     */
    private final int posicion;
    /**
     * Contacto original de la agenda
     * @see Contacto
     */
    private Contacto original;
    /**
     * Contacto auxiliar, se usa para permitir elegir si guardar los cambios o no
     * @see Contacto
     */
    private Contacto aux;

    //// Constructores
    /**
     * Construye una ventana para editar el contacto de la posicón escogida
     * @param posicion Int con la posición del contacto
     * @see Contacto
     * @see JDialogGeneral#cargarIcono()
     * @see VentanaEditor#inicializarComponentes()
     * @see VentanaEditor#ubicarComponentes()
     * @see VentanaEditor#implementarListeners()
     * @see VentanaEditor#configurarVentana()
     */
    public VentanaEditor(int posicion) {
        this.posicion = posicion;
        // Tomar contacto que se va a editar (paso por referencia)
        this.original = Principal.agenda.getLista_Contactos().get(posicion);

        // Copia el contacto original a uno auxiliar en una nueva instancia (paso por valor)
        this.aux = new Contacto(original);

        cargarIcono();
        inicializarComponentes();
        ubicarComponentes();
        implementarListeners();
        configurarVentana();
    }

    //// Métodos
    /**
     * Inicializa los componentes de VentanaEditor
     * @see JDialogGeneral#inicializarComponentes()
     */
    @Override
    protected void inicializarComponentes() {
        super.inicializarComponentes();

        // Ordena el pabel para organizar componentes verticalmente
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panelNorte = new JPanel();
        // Usa el GridBagLayout para organizar los componentes
        panelNorte.setLayout(new GridBagLayout());

        panelNombre = new JPanel();
        panelNombre.setBorder(BordeGeneral.crearBorde("Nombre"));
        panelNombre.setLayout(new GridBagLayout());

        labelNombreActual = new JLabel("Nombre actual:  ");
        campoNombreActual = new JTextField(10);
        campoNombreActual.setText(aux.getNombre());
        campoNombreActual.setEditable(false);
        labelNombreNuevo = new JLabel("Nombre nuevo:  ");
        campoNombreNuevo = new JTextField(10);
        botonCambiarNombre = new JButton("Cambiar");
        botonCambiarNombre.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelDireccion = new JPanel();
        panelDireccion.setBorder(BordeGeneral.crearBorde("Dirección"));
        panelDireccion.setLayout(new BoxLayout(panelDireccion, BoxLayout.Y_AXIS));

        panelCiudad = new JPanel();
        panelCiudad.setLayout(new GridBagLayout());
        panelCiudad.setBorder(BordeGeneral.crearBorde("Ciudad"));

        labelCiudadActual = new JLabel("Ciudad actual:  ");
        campoCiudadActual = new JTextField(10);
        if (aux.getDireccion() != null) {
            campoCiudadActual.setText(aux.getDireccion().getCiudad());
        }
        campoCiudadActual.setEditable(false);
        labelCiudadNueva = new JLabel("Ciudad nueva:  ");
        campoCiudadNueva = new JTextField(10);

        panelCalle = new JPanel();
        panelCalle.setLayout(new GridBagLayout());
        panelCalle.setBorder(BordeGeneral.crearBorde("Calle"));

        labelCalleActual = new JLabel("Calle actual:  ");
        campoCalleActual = new JTextField(10);
        if (aux.getDireccion() != null) {
            campoCalleActual.setText(aux.getDireccion().getCalle());
        }
        campoCalleActual.setEditable(false);
        labelCalleNueva = new JLabel("Calle nueva:  ");
        campoCalleNueva = new JTextField(10);

        panelNo = new JPanel();
        panelNo.setLayout(new GridBagLayout());
        panelNo.setBorder(BordeGeneral.crearBorde("Número"));

        labelNoActual = new JLabel("Número actual:  ");
        campoNoActual = new JTextField(10);
        if (aux.getDireccion() != null) {
            campoNoActual.setText("" + aux.getDireccion().getNumero());
        }
        campoNoActual.setEditable(false);
        labelNoNuevo = new JLabel("Número nuevo:  ");
        campoNoNuevo = new JTextField(10);

        botonCambiarDireccion = new JButton("Cambiar");
        botonCambiarDireccion.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Tomará el ancho o la altura (el que sea mayor) y conservará la relación de aspecto
        panelFoto = new JPanel();
        panelFoto.setBorder(BordeGeneral.crearBorde("Foto de contacto"));
        panelFoto.setLayout(new BoxLayout(panelFoto, BoxLayout.Y_AXIS));

        foto = new JPanelImagen(aux.getRutaFoto(), 200, 200);
        botonCambiarFoto = new JButton("Cambiar");
        botonCambiarFoto.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Instancia el selectorFoto que se usa para elegir la foto
        selectorFoto = new JFileChooser();
        // Instancia un FileFilter para sólo mostrar directorios y archivos .jpg/.jpeg y .png
        FileFilter filtroFoto = new FileFilter(){

            public String getDescription(){
                // Se cambia la descripción
                return "Imágenes (*.jpg/*jpeg/*.png)";
            }

            @Override
            public boolean accept(File f) {
                // Mostrará directorios
                if(f.isDirectory()){
                    return true;
                }

                // También mostrará imágenes
                else{
                    // Pasa el nombre del archivo a minúsculas
                    // Lo hace para aceptar cualquier combinación de mayúsculas o minúsculas al final
                    String nombreArchivo = f.getName().toLowerCase();

                    // Retorna true sólo si el archivo termina con ".json"
                    return nombreArchivo.endsWith(".jpg") || nombreArchivo.endsWith(".jpeg") || nombreArchivo.endsWith(".png");
                }
            }
        };
        // Usar ese filtro en el selector de archivos
        selectorFoto.setFileFilter(filtroFoto);
        selectorFoto.setLocale(Locale.getDefault());
        selectorFoto.updateUI();
        // Cambia el título
        selectorFoto.setDialogTitle("Cargar una foto nueva");

        panelFechaCumple = new JPanel();
        panelFechaCumple.setBorder(BordeGeneral.crearBorde("Fecha de cumpleaños"));
        panelFechaCumple.setLayout(new BoxLayout(panelFechaCumple, BoxLayout.Y_AXIS));

        panelFechaActual = new JPanel();
        panelFechaActual.setBorder(BordeGeneral.crearBorde("Fecha actual"));

        comboDiaActual = new JComboBox<>();
        comboDiaActual.setEditable(false);
        comboMesActual = new JComboBox<>();
        comboMesActual.setEditable(false);

        if(aux.getFechaCumple()==null) {
            comboDiaActual.addItem("--");
            comboMesActual.addItem("--");
        }
        else{
            comboDiaActual.addItem(""+aux.getFechaCumple().getDia());
            comboMesActual.addItem(aux.getFechaCumple().getMes());
        }

        panelFechaNueva = new JPanel();
        panelFechaNueva.setBorder(BordeGeneral.crearBorde("Fecha nueva"));

        comboDiaNuevo = new JComboBox<>();
        comboDiaNuevo.addItem("--");
        agregarDias();

        comboMesNuevo = new JComboBox<>();
        comboMesNuevo.addItem("--");
        agregarMeses();

        botonCambiarFecha = new JButton("Cambiar");
        botonCambiarFecha.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelTelefonos = new JPanel();
        panelTelefonos.setBorder(BordeGeneral.crearBorde("Teléfonos"));
        panelTelefonos.setLayout(new GridBagLayout());

        listaT = new JPanelLista("Lista de teléfonos");
        // Añade todos los teléfonos al modelo de la lista
        for (Telefono t : aux.getLista_Telefonos()) {
            listaT.agregarElemento(t.getNumero()+" ("+t.getTipo()+")");
        }

        panelOpcionesT = new JPanel();
        panelOpcionesT.setBorder(BordeGeneral.crearBorde("Opciones"));
        panelOpcionesT.setLayout(new GridBagLayout());

        labelTelefono = new JLabel("Nuevo teléfono:");
        campoTelefono = new JTextField(10);
        comboTelefono = new JComboBox<>();
        comboTelefono.addItem("Celular");
        comboTelefono.addItem("Casa");
        comboTelefono.addItem("Trabajo");

        botonAgregarTelefono = new JButton("Añadir");
        botonBorrarTelefono = new JButton("Borrar seleccionado");

        panelEmails = new JPanel();
        panelEmails.setBorder(BordeGeneral.crearBorde("Emails"));
        panelEmails.setLayout(new GridBagLayout());

        listaE = new JPanelLista("Lista de emails");
        // Añade todos los emails al modelo de la lista
        for (String s : aux.getLista_Emails()) {
            listaE.agregarElemento(s);
        }

        panelOpcionesE = new JPanelNuevoBorrar("Opciones", 'o');

        panelApodos = new JPanel();
        panelApodos.setBorder(BordeGeneral.crearBorde("Apodos"));
        panelApodos.setLayout(new GridBagLayout());

        listaA = new JPanelLista("Lista de apodos");
        // Añade todos los apodos al modelo de la lista
        for (String s : aux.getLista_Apodos()) {
            listaA.agregarElemento(s);
        }

        panelOpcionesA = new JPanelNuevoBorrar("Opciones", 'o');

        panelNotas = new JPanel();
        panelNotas.setBorder(BordeGeneral.crearBorde("Notas"));
        panelNotas.setLayout(new GridBagLayout());

        listaN = new JPanelLista("Lista de notas");
        // Añade todas las notas al modelo de la lista
        for (String s : aux.getLista_Notas()) {
            listaN.agregarElemento(s);
        }

        panelOpcionesN = new JPanelNuevoBorrar("Opciones", 'a');

        panelSur = new JPanel();

        botonGuardarCambios = new JButton("Guardar cambios");
        botonVolverAtras.setText("Salir del editor");
    }

    /**
     * Agrega los días del mes al JComboBox comboDiaNuevo
     * @see VentanaEditor#comboDiaNuevo
     */
    private void agregarDias(){
        for(int i=1; i<=31; i++){
            comboDiaNuevo.addItem(""+i);
        }
    }

    /**
     * Agrega los meses al JComboBox comboMesNuevo
     * @see VentanaEditor#comboMesNuevo
     */
    private void agregarMeses(){
        comboMesNuevo.addItem("enero");
        comboMesNuevo.addItem("febrero");
        comboMesNuevo.addItem("marzo");
        comboMesNuevo.addItem("abril");
        comboMesNuevo.addItem("mayo");
        comboMesNuevo.addItem("junio");
        comboMesNuevo.addItem("julio");
        comboMesNuevo.addItem("agosto");
        comboMesNuevo.addItem("septiembre");
        comboMesNuevo.addItem("octubre");
        comboMesNuevo.addItem("noviembre");
        comboMesNuevo.addItem("diciembre");
    }

    /**
     * Ubica los componentes en la VentanaEditor
     */
    private void ubicarComponentes() {

        // Añadir componentes del panel para editar nombre
        panelNombre.add(labelNombreActual, gbc(0, 0, 1, 1));
        panelNombre.add(campoNombreActual, gbc(1, 0, 1, 1));
        panelNombre.add(labelNombreNuevo, gbc(0, 1, 1, 1));
        panelNombre.add(campoNombreNuevo, gbc(1, 1, 1, 1));
        panelNombre.add(botonCambiarNombre, gbc(0, 2, 2, 1));

        // Añade el panel para editar nombre
        panelNorte.add(panelNombre, gbc(0, 0, 1, 1, 0.25, 0.33));

        // Añadir componentes del panel para editar ciudad
        panelCiudad.add(labelCiudadActual, gbc(0, 0, 1, 1));
        panelCiudad.add(campoCiudadActual, gbc(1, 0, 1, 1));
        panelCiudad.add(labelCiudadNueva, gbc(0, 1, 1, 1));
        panelCiudad.add(campoCiudadNueva, gbc(1, 1, 1, 1));
        panelDireccion.add(panelCiudad);

        // Añadir componentes del panel para editar calle
        panelCalle.add(labelCalleActual, gbc(0, 0, 1, 1));
        panelCalle.add(campoCalleActual, gbc(1, 0, 1, 1));
        panelCalle.add(labelCalleNueva, gbc(0, 1, 1, 1));
        panelCalle.add(campoCalleNueva, gbc(1, 1, 1, 1));
        panelDireccion.add(panelCalle);

        // Añadir componentes del panel para editar número
        panelNo.add(labelNoActual, gbc(0, 0, 1, 1));
        panelNo.add(campoNoActual, gbc(1, 0, 1, 1));
        panelNo.add(labelNoNuevo, gbc(0, 1, 1, 1));
        panelNo.add(campoNoNuevo, gbc(1, 1, 1, 1));
        panelDireccion.add(panelNo);

        panelDireccion.add(botonCambiarDireccion);

        // Añadir el panel para editar dirección
        panelNorte.add(panelDireccion, gbc(0, 1, 1, 2, 0.25, 0.67));

        panelFoto.add(foto);
        panelFoto.add(botonCambiarFoto);

        // Añadir el panel para editar foto
        panelNorte.add(panelFoto, gbc(1, 0, 1, 1, 0.15, 0.33));

        // Se instancia JLabel de poca importancia para separar día y mes
        JLabel l = new JLabel(" de ");
        JLabel m = new JLabel(" de ");

        panelFechaActual.add(comboDiaActual);
        panelFechaActual.add(l);
        panelFechaActual.add(comboMesActual);
        panelFechaCumple.add(panelFechaActual);

        panelFechaNueva.add(comboDiaNuevo);
        panelFechaNueva.add(m);
        panelFechaNueva.add(comboMesNuevo);
        panelFechaCumple.add(panelFechaNueva);

        panelFechaCumple.add(botonCambiarFecha);
        // Añadir el panel para editar fecha de cumpleaños
        panelNorte.add(panelFechaCumple, gbc(1, 1, 1, 2, 0.15, 0.67));

        panelTelefonos.add(listaT, gbc(0, 0, 1, 2, 1, 0.75));

        panelOpcionesT.add(labelTelefono, gbc(0, 0, 2, 1));
        panelOpcionesT.add(campoTelefono, gbc(0, 1, 1, 1));
        panelOpcionesT.add(comboTelefono, gbc(1, 1, 1, 1));
        panelOpcionesT.add(botonAgregarTelefono, gbc(0, 2, 2, 1));
        panelOpcionesT.add(botonBorrarTelefono, gbc(0, 3, 2, 1));
        panelTelefonos.add(panelOpcionesT, gbc(0, 2, 1, 1, 1, 0.25));

        // Añadir el panel para editar teléfonos
        panelNorte.add(panelTelefonos, gbc(2, 0, 1, 3, 0.2, 1));

        panelEmails.add(listaE, gbc(0, 0, 1, 1, 0.5, 1));
        panelEmails.add(panelOpcionesE, gbc(1, 0, 1, 1, 0.5, 1));
        // Añadir el panel para editar emails
        panelNorte.add(panelEmails, gbc(3, 0, 2, 1, 0.4, 0.33));

        panelApodos.add(listaA, gbc(0, 0, 1, 1, 0.5, 1));
        panelApodos.add(panelOpcionesA, gbc(1, 0, 1, 1, 0.5, 1));
        // Añadir el panel para editar apodos
        panelNorte.add(panelApodos, gbc(3, 1, 2, 1, 0.4, 0.34));

        panelNotas.add(listaN, gbc(0, 0, 1, 1, 0.5, 1));
        panelNotas.add(panelOpcionesN, gbc(1, 0, 1, 1, 0.5, 1));
        // Añadir el panel para editar notas
        panelNorte.add(panelNotas, gbc(3, 2, 2, 1, 0.4, 0.33));

        // Añadir botones de abajo al panel sur
        panelSur.add(botonGuardarCambios, gbc(0, 3, 1, 1));
        panelSur.add(botonVolverAtras, gbc(1, 3, 1, 1));

        // Añadir los dos paneles al panel principal
        panel.add(panelNorte);
        panel.add(panelSur);

        // Añade el JPanel al JFrame
        add(panel);
    }

    /**
     * Retorna un objeto GridBagConstraints con las especificaciones dadas
     * @param x Posición en X
     * @param y Posición en Y
     * @param ancho Medida del ancho (en láminas)
     * @param altura Medida de altura (en láminas)
     * @return Objeto GridBagConstraints con los datos
     * @see GridBagConstraints
     * @see VentanaEditor#gbc(int, int, int, int, double, double)
     */
    private GridBagConstraints gbc(int x, int y, int ancho, int altura) {
        // Instancia GridBagConstraints para configurar un GridBagLayout
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

    /**
     * Retorna un objeto GridBagConstraints con las especificaciones dadas
     * @param x Posición en X
     * @param y Posición en Y
     * @param ancho Medida del ancho (en láminas)
     * @param altura Medida de altura (en láminas)
     * @param pesox Peso en X (en porcentaje)
     * @param pesoy Peso en Y (en porcentaje)
     * @return Objeto GridBagConstraints con los datos
     * @see GridBagConstraints
     * @see VentanaEditor#gbc(int, int, int, int)
     */
    private GridBagConstraints gbc(int x, int y, int ancho, int altura, double pesox, double pesoy) {
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
     * Implementa los listeners para el JDialog
     * @see JDialogGeneral#implementarListeners()
     */
    @Override
    protected void implementarListeners() {
        super.implementarListeners();

        // Implementa listeners para otros botones
        botonGuardarCambios.addActionListener(this);
        botonCambiarNombre.addActionListener(this);
        botonCambiarFoto.addActionListener(this);
        botonCambiarDireccion.addActionListener(this);
        botonCambiarFecha.addActionListener(this);
        botonAgregarTelefono.addActionListener(this);
        botonBorrarTelefono.addActionListener(this);
        panelOpcionesE.getBotonAgregar().addActionListener(this);
        panelOpcionesE.getBotonBorrar().addActionListener(this);
        panelOpcionesA.getBotonAgregar().addActionListener(this);
        panelOpcionesA.getBotonBorrar().addActionListener(this);
        panelOpcionesN.getBotonAgregar().addActionListener(this);
        panelOpcionesN.getBotonBorrar().addActionListener(this);
    }

    /**
     * Configura el JDialog
     * @see JDialogGeneral#configurarVentana()
     */
    @Override
    protected void configurarVentana() {
        super.configurarVentana();

        // Título
        setTitle("Editando contacto \"" + aux.getNombre() + "\"");
        // Tamaño inicial
        setSize(1200, 600);
        // La ventana inicia centrada (no funciona bien si se pone en las clases padres)
        setLocationRelativeTo(null);
    }

    /**
     * Método añadido al implementar la interfaz ActionListener
     * @param e Evento
     * @see ActionListener
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonCambiarNombre) {

            // Validación de entrada
            if (campoNombreNuevo.getText().equals("")) {
                new MensajeError("No puede ingresar un nombre vacío.");
            }

            // Si la entrada no es válida...
            else {
                // Cambia el nombre del contacto auxiliar
                aux.setNombre(campoNombreNuevo.getText());
                // Cambia el nombre del aux
                campoNombreActual.setText(campoNombreNuevo.getText());
            }
        }

        if (e.getSource() == botonCambiarDireccion) {

            // Validación de entrada
            if(campoCiudadNueva.getText().equals("") && campoCalleNueva.getText().equals("") && campoNoNuevo.getText().equals("")){
                new MensajeError("Debe llenar los campos solicitados para guardar una dirección.");
            }
            else if(campoCiudadNueva.getText().equals("") || campoCalleNueva.getText().equals("") || campoNoNuevo.getText().equals("")){
                new MensajeError("No debe dejar campos de texto vacíos.");
            }
            else if(!Validador.esInt(campoNoNuevo.getText())){
                new MensajeError("El número ingresado no debe contener letras o símbolos.");
            }

            // Si la entrada es válida...
            else {
                // Cambia la dirección del aux usando los datos del campo
                Direccion newD = new Direccion(campoCiudadNueva.getText(), campoCalleNueva.getText(), Integer.parseInt(campoNoNuevo.getText()));
                aux.setDireccion(newD);
                // Cambio de dirección actual
                campoCiudadActual.setText(campoCiudadNueva.getText());
                campoCalleActual.setText(campoCalleNueva.getText());
                campoNoActual.setText(campoNoNuevo.getText());
            }
        }

        if (e.getSource() == botonCambiarFoto) {
            // El resultado indica si se eligió algo válido o no
            int resultado = selectorFoto.showOpenDialog(panel.getParent());

            // Si el resultado se puede abrir...
            if (resultado == JFileChooser.APPROVE_OPTION) {

                // Guarda la ruta de la imagen elegida
                String ruta = selectorFoto.getSelectedFile().getPath();
                String destino ="";

                GestorArchivo ga = new GestorArchivo();
                ga.crearDirectorio("fotos");

                // Borra la foto actual, si es que existe
                if(aux.getRutaFoto()!=null && !aux.getRutaFoto().equals("")) {
                    ga.eliminarArchivo(aux.getRutaFoto());
                }

                if(ruta.toLowerCase().endsWith(".jpg") || ruta.toLowerCase().endsWith(".jpeg")){

                    int num = 1;

                    // Revisa hasta que el archivo no exista
                    while(true){
                        if(Files.exists(Paths.get("fotos/"+num+".jpg"))){
                            num++;
                        }
                        else{
                            break;
                        }
                    }

                    destino = "fotos/"+num+".jpg";
                }
                else if(ruta.toLowerCase().endsWith(".png")){

                    int num = 1;

                    // Revisa hasta que el archivo no exista
                    while(true){
                        if(Files.exists(Paths.get("fotos/"+num+".png"))){
                            num++;
                        }
                        else{
                            break;
                        }
                    }

                    destino = "fotos/"+num+".png";

                }
                else{
                    new MensajeError("Extensión de archivo desconocida.");
                }

                // Intenta copiar el archivo
                try{
                    ga.copiarArchivo(ruta, destino);
                } catch(Exception f){
                    new MensajeError("No se ha podido cargar el archivo.");
                }

                // Le entrega la ruta de la foto al contacto auxiliar
                aux.setRutaFoto(destino);

                // Vuelve a cargar la foto
                foto.recargar(destino);
                panelFoto.repaint();
                panelFoto.revalidate();
            }
        }

        if (e.getSource() == botonCambiarFecha) {

            // Validación de entrada
            if(comboDiaNuevo.getSelectedIndex()==0 && comboMesNuevo.getSelectedIndex()==0){
                new MensajeError("Debe escoger un día y un mes de la lista.");
            }
            else if(comboDiaNuevo.getSelectedIndex()==0){
                new MensajeError("No ha seleccionado un día de la lista.");
            }
            else if(comboMesNuevo.getSelectedIndex()==0){
                new MensajeError("No ha seleccionado un mes de la lista.");
            }

            // Si la entrada es válida...
            else {
                // Cambia los JComboBox
                comboDiaActual.removeItemAt(0);
                comboDiaActual.addItem("" + comboDiaNuevo.getSelectedItem());
                comboMesActual.removeItemAt(0);
                comboMesActual.addItem("" + comboMesNuevo.getSelectedItem());

                FechaCumple newFC = new FechaCumple(Integer.parseInt(""+comboDiaNuevo.getSelectedItem()), ""+comboMesNuevo.getSelectedItem());
                aux.setFechaCumple(newFC);
            }
        }

        if (e.getSource() == botonAgregarTelefono) {

            // Validación de entrada
            if(campoTelefono.getText().equals("")){
                new MensajeError("No puede dejar el campo de texto vacío.");
            }
            else if(!Validador.esNumeroTelefonico(campoTelefono.getText())){
                new MensajeError("Debe ingresar un número de teléfono con formato válido.");
            }

            // Si la entrada es válida...
            else{
                // Borra el + si empieza con uno
                campoTelefono.setText(campoTelefono.getText().replace("+", ""));

                aux.getLista_Telefonos().add(new Telefono(Long.parseLong(campoTelefono.getText()), ""+comboTelefono.getSelectedItem()));
                listaT.agregarElemento(campoTelefono.getText()+" ("+comboTelefono.getSelectedItem()+")");
                // Limpía el campo
                campoTelefono.setText("");
            }
        }

        if (e.getSource() == botonBorrarTelefono) {

            // Validación de entrada
            if(listaT.getEleccion()==-1){
                new MensajeError("No ha seleccionado un teléfono de la lista.");
            }

            // Si la entrada es válida...
            else {
                // Borra la selección del contacto aux
                aux.getLista_Telefonos().remove(listaT.getEleccion());
                // Borra la selección del modelo
                listaT.borrarElegido();
                // Reinicia la elección (para evitar errores del tipo IndexOutOfBounds)
                listaT.reiniciarEleccion();
            }
        }

        if (e.getSource() == panelOpcionesE.getBotonAgregar()) {
            // Validación de entrada
            if(panelOpcionesE.getText().equals("")){
                new MensajeError("El campo de texto está vacío.");
            }
            else if(!Validador.esEmail(panelOpcionesE.getText())){
                new MensajeError("El email ingresado no es válido.");
            }

            // Si la entrada es válida...
            else{
                aux.getLista_Emails().add(panelOpcionesE.getText());
                listaE.agregarElemento(panelOpcionesE.getText());
                // Limpía el campo
                panelOpcionesE.limpiar();
            }
        }

        if (e.getSource() == panelOpcionesE.getBotonBorrar()) {

            // Validación de entrada
            if(listaE.getEleccion()==-1){
                new MensajeError("No ha seleccionado un email de la lista.");
            }

            // Si la entrada es válida...
            else {
                // Borra la selección del contacto aux
                aux.getLista_Emails().remove(listaE.getEleccion());
                // Borra la selección del modelo
                listaE.borrarElegido();
                // Reinicia la elección (para evitar errores del tipo IndexOutOfBounds)
                listaE.reiniciarEleccion();
            }

        }

        if (e.getSource() == panelOpcionesA.getBotonAgregar()) {
            // Validación de entrada
            if(panelOpcionesA.getText().equals("")){
                new MensajeError("El campo de texto está vacío.");
            }

            // Si la entrada es válida...
            else{
                aux.getLista_Apodos().add(panelOpcionesA.getText());
                listaA.agregarElemento(panelOpcionesA.getText());
                // Limpía el campo
                panelOpcionesA.limpiar();
            }
        }

        if (e.getSource() == panelOpcionesA.getBotonBorrar()) {

            // Validación de entrada
            if(listaA.getEleccion()==-1){
                new MensajeError("No ha seleccionado un apodo de la lista.");
            }

            // Si la entrada es válida...
            else {
                // Borra la selección del contacto aux
                aux.getLista_Apodos().remove(listaA.getEleccion());
                // Borra la selección del modelo
                listaA.borrarElegido();
                // Reinicia la elección (para evitar errores del tipo IndexOutOfBounds)
                listaA.reiniciarEleccion();
            }

        }

        if (e.getSource() == panelOpcionesN.getBotonAgregar()) {
            // Validación de entrada
            if(panelOpcionesN.getText().equals("")){
                new MensajeError("El campo de texto está vacío.");
            }

            // Si la entrada es válida...
            else{
                aux.getLista_Notas().add(panelOpcionesN.getText());
                listaN.agregarElemento(panelOpcionesN.getText());
                // Limpía el campo
                panelOpcionesN.limpiar();
            }
        }

        if (e.getSource() == panelOpcionesN.getBotonBorrar()) {

            // Validación de entrada
            if(listaN.getEleccion()==-1){
                new MensajeError("No ha seleccionado una nota de la lista.");
            }

            // Si la entrada es válida...
            else {
                // Borra la selección del contacto aux
                aux.getLista_Notas().remove(listaN.getEleccion());
                // Borra la selección del modelo
                listaN.borrarElegido();
                // Reinicia la elección (para evitar errores del tipo IndexOutOfBounds)
                listaN.reiniciarEleccion();
            }
        }

        if (e.getSource() == botonGuardarCambios) {
            // Borra el contacto de la posición original
            Principal.agenda.borrarContacto(posicion);
            // Borra el contacto del modelo de la ventana principal
            Principal.ventana.getListaC().borrar(posicion);

            // Copia el contacto auxiliar de vuelta a la agenda (y lo reordena)
            int posicionNueva = Principal.agenda.crearContacto(aux);
            // Añade el contacto auxiliar al modelo, en la posición nueva
            Principal.ventana.getListaC().agregarElemento(aux.getNombre(), posicionNueva);
        }

        if(e.getSource() == botonVolverAtras){

            // Crea el panel para pedir confirmación
            int n = JOptionPane.showConfirmDialog(panel.getParent(),
                    "¿Está seguro de que desea salir del editor?\nLos cambios no se guardarán si no ha pulsado el botón \"Guardar cambios\".",
                    "Salir del editor",
                    JOptionPane.YES_NO_OPTION);

            // Si el usuario escoge "Sí"
            if(n == JOptionPane.YES_OPTION){
                // Borra la ventana actual
                dispose();
            }
        }
    }
}

