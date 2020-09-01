package interfaz_grafica;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaElegirContacto extends JDialog {

    //// Atributos
    /**
     * Panel principal
     */
    private JPanel panel;
    /**
     * Label que tendrá el texto ingresado en el constructor
     */
    private JLabel labelEscojaContacto;
    /**
     * String con el texto del label
     */
    private String texto;
    /**
     * Botón para volver atrás
     */
    private JButton botonVolverAtras;

    //// Constructores
    public VentanaElegirContacto(String texto) {
        this.texto = texto;
        iniciarVentanaElegirContacto();

        //// Otras características de la ventana

        // Título
        setTitle("Elegir contacto");
        // Tamaño inicial
        setSize(300, 200);
        // La ventana inicia centrada
        setLocationRelativeTo(null);
        // Cuando se cierre la ventana, se borra de la memoria
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    //// Métodos
    public void iniciarVentanaElegirContacto(){
        // Instancia el panel
        panel = new JPanel();

        // Instancia el label
        labelEscojaContacto = new JLabel(texto);

        // Instancia los botones
        botonVolverAtras = new JButton("Volver atrás");

        // Añade el label y los botones al panel
        panel.add(labelEscojaContacto);
        panel.add(botonVolverAtras);

        // Añade el panel a la ventana
        add(panel);

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
}
