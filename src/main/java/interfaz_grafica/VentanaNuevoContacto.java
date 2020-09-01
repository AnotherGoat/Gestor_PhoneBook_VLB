package interfaz_grafica;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaNuevoContacto extends JDialog {

    //// Atributos
    /**
     * Panel principal
     */
    private JPanel panel;
    /**
     * Label con el nombre del programa
     */
    private JLabel labelIngreseNombre;
    /**
     * TextForm para ingresar el nombre
     */
    private JTextField textFieldIngreseNombre;
    /**
     * Botón para guardar el contacto
     */
    private JButton botonGuardar;
    /**
     * Botón para volver atrás
     */
    private JButton botonVolverAtras;

    //// Constructores
    public VentanaNuevoContacto() {
        iniciarVentanaNuevoContacto();

        //// Otras características de la ventana

        // Título
        setTitle("Nuevo contacto");
        // Tamaño inicial
        setSize(300, 200);
        // La ventana inicia centrada
        setLocationRelativeTo(null);
        // Cuando se cierre la ventana, se borra de la memoria
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    //// Métodos
    public void iniciarVentanaNuevoContacto(){
        // Instancia el panel
        panel = new JPanel();

        // Instancia el label
        labelIngreseNombre = new JLabel();
        labelIngreseNombre.setText("Nombre del contacto: ");

        // Instancia el text field
        textFieldIngreseNombre = new JTextField(10);

        // Instancia los botones
        botonGuardar = new JButton();
        botonGuardar.setText("Guardar");

        botonVolverAtras = new JButton();
        botonVolverAtras.setText("Volver atrás");

        // Añade el label y los botones al panel
        panel.add(labelIngreseNombre);
        panel.add(textFieldIngreseNombre);
        panel.add(botonGuardar);
        panel.add(botonVolverAtras);

        // Añade el panel a la ventana
        add(panel);

        // Carga el ícono de la aplicación
        cargarIcono();

        botonVolverAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crea el panel para pedir confirmación
                int n = JOptionPane.showConfirmDialog(panel.getParent(),
                        "¿Volver atrás?",
                        "Volver atrás",
                        JOptionPane.YES_NO_OPTION);

                // Si el usuario escoge "Sí"
                if(n == JOptionPane.YES_OPTION){
                    // Borra la ventana
                    dispose();
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
