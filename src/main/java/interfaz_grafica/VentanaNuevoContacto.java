package interfaz_grafica;

import lanzador.Principal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaNuevoContacto extends JDialogGeneral {

    //// Atributos
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

    //// Constructores
    public VentanaNuevoContacto() {
        inicializar();

        //// Otras características de la ventana

        // Título
        setTitle("Nuevo contacto");
        // Tamaño inicial
        setSize(300, 200);
        configurar();
    }

    //// Métodos
    public void inicializar(){
        super.inicializar();

        // Instancia el JLabel
        labelIngreseNombre = new JLabel("Nombre del contacto:");

        // Instancia el JTextField
        textFieldIngreseNombre = new JTextField(10);

        // Instancia el JButton
        botonGuardar = new JButton("Guardar");

        // Añade los objetos al JPanel
        panel.add(labelIngreseNombre);
        panel.add(textFieldIngreseNombre);
        panel.add(botonGuardar);
        panel.add(botonVolverAtras);

        // Añade el JPanel al JFrame
        add(panel);

        // Implementa ActionListener para los botones
        botonGuardar.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae){
        super.actionPerformed(ae);

        if(ae.getSource() == botonGuardar){
            if(textFieldIngreseNombre.getText().equals("")){
                // Muestra mensaje de error en algún lugar
            }
            else{
                Principal.agenda.crearContacto(textFieldIngreseNombre.getText());

                textFieldIngreseNombre.setText("");
                dispose();
            }
        }
    }
}
