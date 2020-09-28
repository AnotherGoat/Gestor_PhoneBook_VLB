package interfaz_grafica;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Panel que contiene una imagen
 * @see JPanel
 * @see BufferedImage
 */
public class JPanelImagen extends JPanel {

    //// Atributos
    /**
     * Imagen que cargará el JPanel
     * @see BufferedImage
     */
    private BufferedImage imagen;
    /**
     * Label que contiene la imagen (porque los paneles no pueden contener una)
     * @see JLabel
     */
    private JLabel label;
    /**
     * Ruta de la imagen
     */
    private String ruta;
    /**
     * Ancho de la imagen
     */
    private int ancho;
    /**
     * Altura de la imagen
     */
    private int altura;

    //// Constructores
    /**
     * <p>Construye un panel con la imagen y el tamaño indicados (manteniendo la relación de aspecto)</p>
     * <p>Si el ancho y la altura de la imagen cargada son distintos, se asegura de que el que sea más grande se mantiene</p>
     * @param ruta Ruta de la imagen
     * @param ancho Ancho de la imagen, en píxeles
     * @param altura Altura de la imagen, en píxeles
     */
    public JPanelImagen(String ruta, int ancho, int altura) {
        this.ruta = ruta;
        this.ancho = ancho;
        this.altura = altura;

        setLayout(new BorderLayout());

        // Intenta cargar la imagen
        try {
            imagen = ImageIO.read(new File(ruta));
        } catch(IOException e){

            // Si falla, debería cargar una imagen por defecto
            try {
                imagen = ImageIO.read(new File("archivos/contacto_generico.png"));
            } catch(IOException f){
                // Si falla en esta parte, debería tirar una excepción especial
                new MensajeError("No se ha podido cargar la foto de contacto por defecto.");
            }

        }

        // Tomará el ancho o la altura (el que sea mayor) y conservará la relación de aspecto
        if(imagen.getHeight() >= imagen.getWidth()){
            ancho = -1;
        }
        else{
            altura = -1;
        }

        // Crea un label con la imagen, y usando el ancho y la altura especificada
        label = new JLabel(new ImageIcon(imagen.getScaledInstance(ancho, altura, Image.SCALE_SMOOTH)));
        add(label, BorderLayout.CENTER);
    }

    //// Métodos
    /**
     * Se usa para recargar la imagen
     * @param rutaNueva Ruta de la imagen nueva
     * @see JPanel#repaint()
     * @see JPanel#revalidate()
     */
    public void recargar(String rutaNueva){
        ruta = rutaNueva;

        // Intenta cargar la imagen
        try {
            imagen = ImageIO.read(new File(ruta));
        } catch(IOException e){

            // Si falla, debería cargar una imagen por defecto
            try {
                imagen = ImageIO.read(new File("archivos/contacto_generico.png"));
            } catch(IOException f){
                // Si falla en esta parte, debería tirar una excepción especial
                new MensajeError("No se ha podido cargar la foto de contacto por defecto.");
            }

        }

        // Tomará el ancho o la altura (el que sea mayor) y conservará la relación de aspecto
        if(imagen.getHeight() >= imagen.getWidth()){
            ancho = -1;
        }
        else{
            altura = -1;
        }

        label.setIcon(new ImageIcon(imagen.getScaledInstance(ancho, altura, Image.SCALE_SMOOTH)));

        repaint();
        revalidate();
    }

    //// Getters y Setters
    /**
     * Getter para obtener el label
     * @return JLabel que contiene la imagen
     * @see JLabel
     */
    public JLabel getLabel() {
        return label;
    }
}
