package interfaz_grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * JDialog especial que se usa para mostrar texto
 * @see JDialog
 * @see JDialogGeneral
 */
public class JDialogTextoGeneral extends JDialogGeneral {

    //// Atributos
    /**
     * Texto que contiene el área
     */
    protected String texto;
    /**
     * Área con el texto
     * @see JTextArea
     */
    protected JTextArea textArea;
    /**
     * Scroll para el área de texto
     * @see JScrollPane
     */
    protected JScrollPane scroll;

    //// Constructores
    /**
     * Constructor protegido para que el JDialogTextoGeneral no se pueda instanciar
     */
    protected JDialogTextoGeneral() {
        // Este constructor es protegido, significa que esta clase no se puede instanciar
    }

    //// Métodos

    /**
     * Método para iniciar el JDialog
     * @see JDialogGeneral#inicializarComponentes()
     */
    @Override
    protected void inicializarComponentes(){
        super.inicializarComponentes();

        // Usa el BoxLayout para mostrar los botones verticalmente
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        botonVolverAtras.setAlignmentX(Component.CENTER_ALIGNMENT);

        textArea = new JTextArea(texto);
        textArea.setVisible(true);
        // Para que no se pueda editar
        textArea.setEditable(false);

        // Instancia el JScrollPane para la textArea (y define el funcionamiento vertical y horizontal)
        scroll = new JScrollPane(textArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    }

    /**
     * Método para ubicar los componentes dentro del JDialog
     */
    protected void ubicarComponentes(){
        panel.add(scroll);
        panel.add(botonVolverAtras);

        add(panel);
    }

    /**
     * Método para configurar las propiedades que todas las ventanas JDialogTextoGeneral tienen en común
     * @see JDialogGeneral#configurarVentana()
     */
    @Override
    protected void configurarVentana(){
        super.configurarVentana();

        // Tamaño inicial
        setSize(400, 350);
    }
}
