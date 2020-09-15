package interfaz_grafica;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * Clase que tiene un método estático para crear un borde con un formato que se usa en toda la interfaz gráfica
 */
public class BordeGeneral{

    //// Constructores
    private BordeGeneral() {
        // Este constructor es privado, significa que esta clase no se puede instanciar
    }

    //// Métodos
    /**
     * <p>Método estático que retorna un TitledBorder gris, redondeado y con el título que se entrega.</p>
     * <p>Se usa este método para que toda la interfaz gráfica use el mismo tipo de borde.</p>
     * @param titulo Título que lleva el borde
     * @return Borde con título, con el formato especificado
     */
    public static TitledBorder crearBorde(String titulo){
        return BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true), titulo);
    }
}
