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
        iniciar();

        //// Otras características de la ventana

        // Título
        setTitle("Nuevo contacto");
        // Tamaño inicial
        setSize(300, 200);
        configurar();
    }

    //// Métodos
    public void iniciar(){
        super.iniciar();

        // Instancia el label
        labelIngreseNombre = new JLabel("Nombre del contacto:");

        // Instancia el text field
        textFieldIngreseNombre = new JTextField(10);

        // Instancia los botones
        botonGuardar = new JButton("Guardar");

        // Añade el label y los botones al panel
        panel.add(labelIngreseNombre);
        panel.add(textFieldIngreseNombre);
        panel.add(botonGuardar);
        panel.add(botonVolverAtras);

        // Añade el panel a la ventana
        add(panel);

        // Implementación de ActionListener para botonGuardar
        botonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(textFieldIngreseNombre.getText().equals("")){
                    // Muestra mensaje de error en algún lugar
                }
                else{
                    Principal.agenda.crearContacto(textFieldIngreseNombre.getText());

                    textFieldIngreseNombre.setText("");
                    dispose();
                }
            }
        });
    }
}
