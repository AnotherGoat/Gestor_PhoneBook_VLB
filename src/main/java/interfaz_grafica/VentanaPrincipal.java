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

        //// Otras características de la ventana

        // Título
        setTitle("Gestor Phonebook VLB");
        // Tamaño inicial
        setSize(500, 500);
        // La ventana inicia centrada
        setLocationRelativeTo(null);
        // Inhabilita la opción de cambiar el tamaño de la ventana
        // setResizable(false);
        // Cuando se cierre la ventana se finaliza el programa
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    //// Métodos
    private void iniciarVentanaPrincipal(){
        // Instancia el panel
        panel = new JPanel();
        // Usa el BoxLayout (para mostrar los botones de arriba a abajo
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Instancia el label
        labelGestorPhoneBook = new JLabel();
        labelGestorPhoneBook.setText("Gestor PhoneBook VLB");
        // Centra el label (con los botones se hace lo mismo)
        labelGestorPhoneBook.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Instancia los botones
        botonNuevoContacto = new JButton();
        botonNuevoContacto.setText("Crear un contacto nuevo");
        botonNuevoContacto.setAlignmentX(Component.CENTER_ALIGNMENT);

        botonDatosContacto = new JButton();
        botonDatosContacto.setText("Ver datos de un contacto");
        botonDatosContacto.setAlignmentX(Component.CENTER_ALIGNMENT);

        botonEditarContacto = new JButton();
        botonEditarContacto.setText("Editar un contacto");
        botonEditarContacto.setAlignmentX(Component.CENTER_ALIGNMENT);


        botonEliminarContacto = new JButton();
        botonEliminarContacto.setText("Eliminar un contacto");
        botonEliminarContacto.setAlignmentX(Component.CENTER_ALIGNMENT);

        botonSalir = new JButton();
        botonSalir.setText("Salir del programa");
        botonSalir.setAlignmentX(Component.CENTER_ALIGNMENT);

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

        // Implementación de ActionListener para el botón salirButton
        botonNuevoContacto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Instancia una ventana para crear un contacto y la hace visible
                VentanaCrearContacto vcc = new VentanaCrearContacto();
                vcc.setVisible(true);

                
            }
        });

        // Implementación de ActionListener para el botón salirButton
        botonSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

    /**
     * Método que carga el ícono de la aplicación desde un archivo externo
     */
    private void cargarIcono() {
        Image icono = Toolkit.getDefaultToolkit().getImage("archivos/icono_phonebook_nuevo.png");
        setIconImage(icono);
    }
}
