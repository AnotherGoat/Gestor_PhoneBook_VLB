package interfaz_grafica;

import lanzador.Principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VentanaDatosContacto extends JDialogGeneral{

    //// Atributos
    /**
     * Área con el texto
     */
    JTextArea textArea;
    /**
     * Scroll para el área de texto
     */
    private JScrollPane scroll;

    int posicion;

    //// Constructores
    public VentanaDatosContacto(int posicion, Component ventanaAnterior) {
        super(ventanaAnterior);
        this.posicion = posicion;

        inicializar();

        //// Otras características de la ventana

        // Título
        setTitle("Datos de "+Principal.agenda.getLista_Nombres().get(posicion));
        // Tamaño inicial
        setSize(400, 500);

        configurar();
    }

    //// Métodos
    @Override
    public void inicializar(){
        super.inicializar();

        // Usa el BoxLayout para mostrar los botones verticalmente
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        botonVolverAtras.setAlignmentX(Component.CENTER_ALIGNMENT);

        textArea = new JTextArea(Principal.agenda.getLista_Contactos().get(posicion).toString());
        textArea.setVisible(true);

        // Instancia el JScrollPane para la textArea (y define el funcionamiento vertical y horizontal)
        scroll = new JScrollPane(textArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        panel.add(scroll);
        panel.add(botonVolverAtras);

        add(panel);
    }
}
