package interfaz_grafica;

import json.GestorJSON;
import lanzador.Principal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaPrincipal extends JFrame implements ActionListener {

    //// Atributos
    /**
     * Panel principal
     */
    private JPanel panel;
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

    //// Constructores
    public VentanaPrincipal(){
        // Carga datos del archivo "agenda.json"
        GestorJSON.cargarJSON();

        inicializar();

        //// Otras características de la ventana

        // Título
        setTitle("Gestor Phonebook VLB");
        // Tamaño inicial
        setSize(500, 500);
        // La ventana inicia centrada
        setLocationRelativeTo(null);
        // Inhabilita la opción de cambiar el tamaño de la ventana
        // setResizable(false);

        // Cuando se cierre la ventana no hace nada...
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        // Pero se agrega un WindowListener para pedir confirmación al hacer click en la X
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
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
        });
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
        GridBagConstraints c = new GridBagConstraints();

        panelTitulo = new JPanel();
        panelTitulo.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true)));

        panelOpciones = new JPanel();
        panelOpciones.setLayout(new BoxLayout(panelOpciones, BoxLayout.Y_AXIS));
        // Crea un borde para el panel con las opciones
        panelOpciones.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true), "Opciones"));

        panelLista = new JPanel();
        panelLista.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true), "Lista de contactos"));

        panelNuevoContacto = new JPanel();
        panelNuevoContacto.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true), "Nuevo contacto"));
        panelNuevoContacto.setLayout(new BoxLayout(panelNuevoContacto, BoxLayout.Y_AXIS));

        panelOpcionesLista = new JPanel();
        panelOpcionesLista.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true), "Opciones de la lista"));
        panelOpcionesLista.setLayout(new BoxLayout(panelOpcionesLista, BoxLayout.Y_AXIS));

        // Instancia el JLabel
        labelGestorPhoneBook = new JLabel("Gestor PhoneBook VLB");
        // Centra el label (con los botones se hace lo mismo)
        labelGestorPhoneBook.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelGestorPhoneBook.setAlignmentY(Component.CENTER_ALIGNMENT);
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

        //// Añade los objetos al JPanel
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
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == botonNuevoContacto){
            // Instancia una ventana para crear un contacto y la hace visible
            VentanaNuevoContacto vnc = new VentanaNuevoContacto(this);
            vnc.setVisible(true);
        }

        if (ae.getSource() == botonDatosContacto) {
            // Instancia una ventana para elegir un contacto y la hace visible
            VentanaElegirContacto vec = new VentanaElegirContacto("Escoja el contacto que quiere ver", this);
            vec.setVisible(true);
        }

        if (ae.getSource() == botonEditarContacto) {
            // Instancia una ventana para elegir un contacto y la hace visible
            VentanaElegirContacto vec = new VentanaElegirContacto("Escoja el contacto que quiere editar", this);
            vec.setVisible(true);
        }

        if (ae.getSource() == botonEliminarContacto){
            // Instancia una ventana para elegir un contacto y la hace visible
            VentanaElegirContacto vec = new VentanaElegirContacto("Escoja el contacto que quiere borrar", this);
            vec.setVisible(true);
        }

        if (ae.getSource() == botonDatosAgenda){
            // Instancia la ventana con los datos de la agenda
            VentanaDatosAgenda vda = new VentanaDatosAgenda(this);
            vda.setVisible(true);
        }

        if (ae.getSource() == botonVerJSON){
            // Instancia la ventana con los datos de "agenda.json"
            VentanaVerJSON vvj = new VentanaVerJSON(this);
            vvj.setVisible(true);
        }

        if (ae.getSource() == botonBorrarTodo){
            // Crea el panel para pedir confirmación
            int n = JOptionPane.showConfirmDialog(panel.getParent(),
                    "¿Está seguro de que quiere borrar TODOS los datos guardados?\nEsta operación no se puede deshacer.",
                    "Borrar todo",
                    JOptionPane.YES_NO_OPTION);

            // Si el usuario escoge "Sí"
            if(n == JOptionPane.YES_OPTION){
                // Borra todos los datos
                Principal.agenda.borrarTodo();
            }
        }

        if (ae.getSource() == botonSalir){
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
