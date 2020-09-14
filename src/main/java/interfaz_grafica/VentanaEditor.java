package interfaz_grafica;

import lanzador.Principal;
import phonebook.Contacto;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaEditor extends JDialogGeneral implements ActionListener{

    //// Atributos
    private JPanel panelNorte;
    private JPanel panelNombre;
    private JLabel labelNombreActual;
    private JTextField campoNombreActual;
    private JLabel labelNombreNuevo;
    private JTextField campoNombreNuevo;
    private JButton botonCambiarNombre;
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
    private JButton botonGuardarDireccion;
    private JPanel panelFoto;
    private JPanel panelFechaCumple;
    private JPanel panelTelefonos;
    private JPanel panelEmails;
    private JPanel panelApodos;
    private JPanel panelNotas;
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

        // Copia el contacto original a uno auxiliar (paso por valor)
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
        panelNombre.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true), "Nombre"));
        panelNombre.setLayout(new GridBagLayout());

        labelNombreActual = new JLabel("Nombre actual:");
        campoNombreActual = new JTextField(10);
        campoNombreActual.setText(aux.getNombre());
        campoNombreActual.setEditable(false);
        labelNombreNuevo = new JLabel("Nombre nuevo:");
        campoNombreNuevo = new JTextField(10);
        botonCambiarNombre = new JButton("Cambiar");
        botonCambiarNombre.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelDireccion = new JPanel();
        panelDireccion.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true), "Dirección"));
        panelDireccion.setLayout(new BoxLayout(panelDireccion, BoxLayout.Y_AXIS));

        panelCiudad = new JPanel();
        panelCiudad.setLayout(new GridBagLayout());
        panelCiudad.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true), "Ciudad"));

        labelCiudadActual = new JLabel("Ciudad actual:");
        campoCiudadActual = new JTextField(10);
        if(aux.getDireccion()!=null) {
            campoCiudadActual.setText(aux.getDireccion().getCiudad());
        }
        campoCiudadActual.setEditable(false);
        labelCiudadNueva = new JLabel("Ciudad nueva:");
        campoCiudadNueva = new JTextField(10);

        panelCalle = new JPanel();
        panelCalle.setLayout(new GridBagLayout());
        panelCalle.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true), "Calle"));

        labelCalleActual = new JLabel("Calle actual:");
        campoCalleActual = new JTextField(10);
        if(aux.getDireccion()!=null) {
            campoCalleActual.setText(aux.getDireccion().getCalle());
        }
        campoCalleActual.setEditable(false);
        labelCalleNueva = new JLabel("Calle nueva:");
        campoCalleNueva = new JTextField(10);

        panelNo = new JPanel();
        panelNo.setLayout(new GridBagLayout());
        panelNo.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true), "Número"));

        labelNoActual = new JLabel("Número actual:");
        campoNoActual = new JTextField(10);
        if(aux.getDireccion()!=null) {
            campoNoActual.setText("" + aux.getDireccion().getNumero());
        }
        campoNoActual.setEditable(false);
        labelNoNuevo = new JLabel("Número nuevo:");
        campoNoNuevo = new JTextField(10);

        botonGuardarDireccion = new JButton("Guardar");

        panelFoto = new JPanel();
        panelFoto.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true), "Foto de contacto"));

        panelFechaCumple = new JPanel();
        panelFechaCumple.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true), "Fecha de cumpleaños"));

        panelTelefonos = new JPanel();
        panelTelefonos.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true), "Teléfonos"));

        panelEmails = new JPanel();
        panelEmails.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true), "Emails"));

        panelApodos = new JPanel();
        panelApodos.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true), "Apodos"));

        panelNotas = new JPanel();
        panelNotas.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true), "Notas"));

        panelSur = new JPanel();

        botonGuardarCambios = new JButton("Guardar cambios");
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

        // Añadir el panel para editar dirección
        panelNorte.add(panelDireccion, gbc(0, 1, 1, 2, 0.2, 0.67));

        // Añadir el panel para editar foto
        panelNorte.add(panelFoto, gbc(1, 0, 1, 1, 0.2, 0.33));

        // Añadir el panel para editar fecha de cumpleaños
        panelNorte.add(panelFechaCumple, gbc(1, 1, 1, 2, 0.2, 0.67));

        // Añadir el panel para editar teléfonos
        panelNorte.add(panelTelefonos, gbc(2, 0, 1, 3, 0.2, 1));

        // Añadir el panel para editar emails
        panelNorte.add(panelEmails, gbc(3, 0, 2, 1, 0.4, 0.33));

        // Añadir el panel para editar apodos
        panelNorte.add(panelApodos, gbc(3, 1, 2, 1, 0.4, 0.34));

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

    public GridBagConstraints gbc(int x, int y, int ancho, int altura){
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

    public GridBagConstraints gbc(int x, int y, int ancho, int altura, double pesox, double pesoy){
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
    protected void configurarVentana() {
        super.configurarVentana();

        // Título
        setTitle("Editando contacto \""+aux.getNombre()+"\"");
        // Tamaño inicial
        setSize(700, 500);
        // La ventana inicia centrada (no funciona bien si se pone en las clases padres)
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == botonVolverAtras){
                // Todavía no configurado
        }
    }
}
