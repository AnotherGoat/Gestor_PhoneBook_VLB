package interfaz_grafica;

import lanzador.Principal;
import phonebook.Contacto;
import phonebook.Direccion;
import phonebook.FechaCumple;
import phonebook.Telefono;
import utilidades.Validador;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Clase que representa una ventana para editar los datos de un contacto
 */
public class VentanaEditor extends JDialogGeneral implements ActionListener {

    //// Atributos
    /**
     * JPanel que contiene los otros paneles donde se puede editar un contacto
     */
    private JPanel panelNorte;

    //Panel que contiene componentes para editar nombre
    private JPanel panelNombre;

    private JLabel labelNombreActual;
    private JTextField campoNombreActual;
    private JLabel labelNombreNuevo;
    private JTextField campoNombreNuevo;
    private JButton botonCambiarNombre;

    //Panel que contiene componentes para editar Direccion
    private JPanel panelDireccion;

    private JPanel panelCiudad;
    private JLabel labelCiudadActual;
    private JTextField campoCiudadActual;
    private JLabel labelCiudadNueva;
    private JTextField campoCiudadNueva;
    private JPanel panelCalle;
    private JLabel labelCalleActual;
    private JTextField campoCalleActual;
    private JLabel labelCalleNueva;
    private JTextField campoCalleNueva;
    private JPanel panelNo;
    private JLabel labelNoActual;
    private JTextField campoNoActual;
    private JLabel labelNoNuevo;
    private JTextField campoNoNuevo;
    private JButton botonCambiarDireccion;

    //Panel que contiene componentes para editar Foto
    private JPanel panelFoto;

    //Panel que contiene componentes para editar fecha de cumpleaños
    private JPanel panelFechaCumple;

    private JPanel panelFechaActual;
    private JComboBox<String> comboDiaActual;
    private JComboBox<String> comboMesActual;
    private JPanel panelFechaNueva;
    private JComboBox<String> comboDiaNuevo;
    private JComboBox<String> comboMesNuevo;
    private JButton botonCambiarFecha;

    //Panel que contiene componentes para editar telefono
    private JPanel panelTelefonos;

    private JPanel panelNuevoTelefono;
    /**
     * Panel que tiene la lista de teléfonos
     */
    private JListGeneral listaT;

    private JPanel panelOpcionesT;

    //Panel que contiene componentes para editar Email
    private JPanel panelEmails;
    /**
     * Panel que tiene la lista de emails
     */
    private JListGeneral listaE;
    private JPanel panelOpcionesE;

    //Panel que contiene componentes para editar Apodos
    private JPanel panelApodos;
    /**
     * Panel que tiene la lista de apodos
     */
    private JListGeneral listaA;
    private JPanel panelOpcionesA;

    //Panel que contiene componentes para editar Notas
    private JPanel panelNotas;
    /**
     * Panel que tiene la lista de notas
     */
    private JListGeneral listaN;
    private JPanel panelOpcionesN;

    /**
     * Panel que tendrá el botón para guardar cambios y el botón para salir
     */
    private JPanel panelSur;
    private JButton botonGuardarCambios;
    /**
     * Posicion del contacto original en la agenda
     */
    private final int posicion;
    /**
     * Contacto original de la agenda
     */
    private Contacto original;
    /**
     * Contacto auxiliar, se usa para permitir elegir si guardar los cambios o no
     */
    private Contacto aux;

    //// Constructores
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

        panelFoto = new JPanel();
        panelFoto.setBorder(BordeGeneral.crearBorde("Foto de contacto"));

        panelFechaCumple = new JPanel();
        panelFechaCumple.setBorder(BordeGeneral.crearBorde("Fecha de cumpleaños"));
        panelFechaCumple.setLayout(new BoxLayout(panelFechaCumple, BoxLayout.Y_AXIS));

        panelFechaActual = new JPanel();
        panelFechaActual.setBorder(BordeGeneral.crearBorde("Fecha actual"));

        comboDiaActual = new JComboBox();
        comboDiaActual.setEditable(false);
        comboMesActual = new JComboBox();
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

        panelNuevoTelefono = new JPanel();
        panelNuevoTelefono.setBorder(BordeGeneral.crearBorde("Nuevo teléfono"));

        listaT = new JListGeneral("Lista de teléfonos");
        // Añade todos los teléfonos al modelo de la lista
        for (Telefono t : aux.getLista_Telefonos()) {
            listaT.agregarElemento(t.getNumero()+" ("+t.getTipo()+")");
        }

        panelOpcionesT = new JPanel();
        panelOpcionesT.setBorder(BordeGeneral.crearBorde("Opciones"));
        panelOpcionesT.setLayout(new GridBagLayout());

        panelEmails = new JPanel();
        panelEmails.setBorder(BordeGeneral.crearBorde("Emails"));
        panelEmails.setLayout(new GridBagLayout());

        listaE = new JListGeneral("Lista de emails");
        // Añade todos los emails al modelo de la lista
        for (String s : aux.getLista_Emails()) {
            listaE.agregarElemento(s);
        }

        panelOpcionesE = new JPanel();
        panelOpcionesE.setBorder(BordeGeneral.crearBorde("Opciones"));
        panelOpcionesE.setLayout(new GridBagLayout());

        panelApodos = new JPanel();
        panelApodos.setBorder(BordeGeneral.crearBorde("Apodos"));
        panelApodos.setLayout(new GridBagLayout());

        listaA = new JListGeneral("Lista de apodos");
        // Añade todos los apodos al modelo de la lista
        for (String s : aux.getLista_Apodos()) {
            listaA.agregarElemento(s);
        }

        panelOpcionesA = new JPanel();
        panelOpcionesA.setBorder(BordeGeneral.crearBorde("Opciones"));
        panelOpcionesA.setLayout(new GridBagLayout());

        panelNotas = new JPanel();
        panelNotas.setBorder(BordeGeneral.crearBorde("Notas"));
        panelNotas.setLayout(new GridBagLayout());

        listaN = new JListGeneral("Lista de notas");
        // Añade todas las notas al modelo de la lista
        for (String s : aux.getLista_Notas()) {
            listaN.agregarElemento(s);
        }

        panelOpcionesN = new JPanel();
        panelOpcionesN.setBorder(BordeGeneral.crearBorde("Opciones"));
        panelOpcionesN.setLayout(new GridBagLayout());

        panelSur = new JPanel();

        botonGuardarCambios = new JButton("Guardar cambios");
        botonVolverAtras.setText("Salir del editor");
    }

    private void agregarDias(){
        for(int i=1; i<=31; i++){
            comboDiaNuevo.addItem(""+i);
        }
    }

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

    private void ubicarComponentes() {

        // Añadir componentes del panel para editar nombre
        panelNombre.add(labelNombreActual, gbc(0, 0, 1, 1));
        panelNombre.add(campoNombreActual, gbc(1, 0, 1, 1));
        panelNombre.add(labelNombreNuevo, gbc(0, 1, 1, 1));
        panelNombre.add(campoNombreNuevo, gbc(1, 1, 1, 1));
        panelNombre.add(botonCambiarNombre, gbc(0, 2, 2, 1));

        // Añade el panel para editar nombre
        panelNorte.add(panelNombre, gbc(0, 0, 1, 1, 0.2, 0.33));

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
        panelNorte.add(panelDireccion, gbc(0, 1, 1, 2, 0.2, 0.67));

        // Añadir el panel para editar foto
        panelNorte.add(panelFoto, gbc(1, 0, 1, 1, 0.2, 0.33));

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
        panelNorte.add(panelFechaCumple, gbc(1, 1, 1, 2, 0.2, 0.67));

        panelTelefonos.add(panelNuevoTelefono, gbc(0, 0, 1, 1, 1, 0.25));
        panelTelefonos.add(listaT, gbc(0, 1, 1, 1, 1, 0.5));
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

    private GridBagConstraints gbc(int x, int y, int ancho, int altura) {
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

    @Override
    protected void implementarListeners() {
        super.implementarListeners();

        // Implementa listeners para otros botones
        botonGuardarCambios.addActionListener(this);
        botonCambiarNombre.addActionListener(this);
        botonCambiarDireccion.addActionListener(this);
        botonCambiarFecha.addActionListener(this);
    }

    @Override
    protected void configurarVentana() {
        super.configurarVentana();

        // Título
        setTitle("Editando contacto \"" + aux.getNombre() + "\"");
        // Tamaño inicial
        setSize(1000, 600);
        // La ventana inicia centrada (no funciona bien si se pone en las clases padres)
        setLocationRelativeTo(null);
    }

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

        if (e.getSource() == botonGuardarCambios) {
            // Borra el contacto de la posición original
            Principal.agenda.borrarContacto(posicion);
            // Borra el contacto del modelo de la ventana principal
            Principal.vPrincipal.getListaC().borrar(posicion);

            // Copia el contacto auxiliar de vuelta a la agenda (y lo reordena)
            int posicionNueva = Principal.agenda.crearContacto(aux);
            // Añade el contacto auxiliar al modelo, en la posición nueva
            Principal.vPrincipal.getListaC().agregarElemento(aux.getNombre(), posicionNueva);
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

