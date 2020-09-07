package interfaz_grafica;

import lanzador.Principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public abstract class JDialogTextoGeneral extends JDialogGeneral {

    //// Atributos
    /**
     * Texto que contiene el área
     */
    protected String texto;
    /**
     * Área con el texto
     */
    protected JTextArea textArea;
    /**
     * Scroll para el área de texto
     */
    private JScrollPane scroll;

    //// Constructores
    public JDialogTextoGeneral(Component ventanaAnterior) {
        super(ventanaAnterior);
    }

    //// Métodos
    @Override
    public void inicializar(){
        super.inicializar();

        // Usa el BoxLayout para mostrar los botones verticalmente
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        botonVolverAtras.setAlignmentX(Component.CENTER_ALIGNMENT);

        textArea = new JTextArea(texto);
        textArea.setVisible(true);
        // Para que no se pueda editar
        textArea.setEditable(false);

        // Instancia el JScrollPane para la textArea (y define el funcionamiento vertical y horizontal)
        scroll = new JScrollPane(textArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        panel.add(scroll);
        panel.add(botonVolverAtras);

        add(panel);
    }
}
