package interfaz_grafica;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaPrincipal extends JFrame {

    //// Atributos
    /**
     * Panel principal
     */
    private JPanel panel;
    /**
     * Label con el nombre del programa
     */
    private JLabel labelGestorPhoneBook;
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
     * Botón para salir del programa
     */
    private JButton botonSalir;

    //// Constructores
    public VentanaPrincipal(){
        iniciarVentanaPrincipal();

        // Título
        setTitle("Gestor Phonebook VLB");
        setSize(200, 400); // Se define el tamaño de ventana
        setLocationRelativeTo(null); // Centrar la ventana
        setResizable(false); // Inhabilita el funcionamiento del botón maximizar
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Cuando se cierre la ventana se finaliza el programa
    }

    //// Métodos
    private void iniciarVentanaPrincipal(){
        // Instancia el panel
        panel = new JPanel();
        //panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));

        // Instancia el label
        labelGestorPhoneBook = new JLabel();
        labelGestorPhoneBook.setText("Gestor PhoneBook VLB");

        // Instancia los botones
        botonNuevoContacto = new JButton();
        botonNuevoContacto.setText("Crear un contacto nuevo");

        botonDatosContacto = new JButton();
        botonDatosContacto.setText("Ver datos de un contacto");

        botonEditarContacto = new JButton();
        botonEditarContacto.setText("Editar un contacto");

        botonEliminarContacto = new JButton();
        botonEliminarContacto.setText("Eliminar un contacto");

        botonSalir = new JButton();
        botonSalir.setText("Salir del programa");

        // Añade el label y los botones al panel
        panel.add(labelGestorPhoneBook);
        panel.add(botonNuevoContacto);
        panel.add(botonDatosContacto);
        panel.add(botonEditarContacto);
        panel.add(botonEliminarContacto);
        panel.add(botonSalir);

        // Añade el panel a la ventana
        add(panel);

        // Carga el ícono de la aplicación
        cargarIcono();
    }

    /**
     * Método que carga el ícono de la aplicación desde un archivo externo
     */
    private void cargarIcono() {
        Image icono = Toolkit.getDefaultToolkit().getImage("archivos/icono_phonebook_nuevo.png");
        setIconImage(icono);
    }
}
