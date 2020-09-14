package interfaz_grafica;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Clase para mostrar un error de la aplicación, que se puede construir sólo con un mensaje de error
 */
public class MensajeError extends JOptionPane {

    //// Atributos
    private String mensaje;

    //// Constructores
    public MensajeError(String mensaje){
        showMessageDialog(null, "Error: "+mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
