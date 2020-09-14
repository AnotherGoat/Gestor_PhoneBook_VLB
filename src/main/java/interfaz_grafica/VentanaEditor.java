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
    private JPanel panelDireccion;
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

        panelDireccion = new JPanel();
        panelDireccion.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true), "Dirección"));

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
        // Instancia GriadBagConstraints para configurar el GridBagLayout
        GridBagConstraints c = new GridBagConstraints();

        // Añade el panel para editar nombre
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 0.2;
        c.weighty = 0.33;
        panelNorte.add(panelNombre, c);

        // Añadir el panel para editar dirección
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridheight = 2;
        c.weightx = 0.2;
        c.weighty = 0.67;
        panelNorte.add(panelDireccion, c);

        // Añadir el panel para editar foto
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 0.2;
        c.weighty = 0.33;
        panelNorte.add(panelFoto, c);

        // Añadir el panel para editar fecha de cumpleaños
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridheight = 2;
        c.weightx = 0.2;
        c.weighty = 0.67;
        panelNorte.add(panelFechaCumple, c);

        // Añadir el panel para editar teléfonos
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 2;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 3;
        c.weightx = 0.2;
        c.weighty = 1;
        panelNorte.add(panelTelefonos, c);

        // Añadir el panel para editar emails
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 3;
        c.gridy = 0;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.weightx = 0.4;
        c.weighty = 0.33;
        panelNorte.add(panelEmails, c);

        // Añadir el panel para editar apodos
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 3;
        c.gridy = 1;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.weightx = 0.4;
        c.weighty = 0.34;
        panelNorte.add(panelApodos, c);

        // Añadir el panel para editar notas
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 3;
        c.gridy = 2;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.weightx = 0.4;
        c.weighty = 0.33;
        panelNorte.add(panelNotas, c);

        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 0;
        c.weighty = 0;
        panelSur.add(botonGuardarCambios, c);

        c.fill = GridBagConstraints.NONE;
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 0;
        c.weighty = 0;
        panelSur.add(botonVolverAtras, c);

        panel.add(panelNorte);
        panel.add(panelSur);

        // Añade el JPanel al JFrame
        add(panel);
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
