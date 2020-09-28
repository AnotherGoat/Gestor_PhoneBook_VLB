package interfaz_grafica.utilidades_gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Clase para mostrar un error genérico en la aplicación, que se puede construir sólo con un mensaje de error
 * @see JOptionPane
 * @see JOptionPane#ERROR_MESSAGE
 */
public class MensajeError extends JOptionPane {

    //// Atributos
    /**
     * Mensaje que va después de "Error: "
     */
    private String mensaje;

    //// Constructores
    /**
     * Construye un MensajeError usando el mensaje que se le entrega
     * @param mensaje Mensaje que va después de "Error: "
     * @see JOptionPane#showMessageDialog(Component, Object)
     * @see JOptionPane#ERROR_MESSAGE
     */
    public MensajeError(String mensaje){
        this.mensaje = mensaje;

        showMessageDialog(null, "Error: "+mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
