package interfaz_grafica;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaElegirContacto extends JDialogGeneral {

    //// Atributos
    /**
     * Label que tendrá el texto ingresado en el constructor
     */
    private JLabel labelEscojaContacto;
    /**
     * String con el texto del label
     */
    private String texto;

    //// Constructores
    public VentanaElegirContacto(String texto) {
        this.texto = texto;

        iniciar();

        //// Otras características de la ventana

        // Título
        setTitle("Elegir contacto");
        // Tamaño inicial
        setSize(300, 200);

        configurar();
    }

    //// Métodos
    public void iniciar(){
        super.iniciar();

        // Usa el BoxLayout (para mostrar los botones de arriba a abajo
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Instancia el label
        labelEscojaContacto = new JLabel(texto);
        labelEscojaContacto.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Instancia los botones
        botonVolverAtras.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Añade el label y los botones al panel
        panel.add(labelEscojaContacto);
        panel.add(botonVolverAtras);

        // Añade el panel a la ventana
        add(panel);
    }
}
