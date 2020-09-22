package interfaz_grafica;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class JPanelImagen extends JPanel {

    //// Atributos
    private BufferedImage imagen;
    private JLabel label;
    private String ruta;
    private int ancho;
    private int altura;

    //// Constructores
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

        label.setIcon(new ImageIcon(imagen.getScaledInstance(ancho, altura, Image.SCALE_SMOOTH)));

        // remove(label);
        // add(label);
        repaint();
        revalidate();
    }

    //// Getters
    public JLabel getLabel() {
        return label;
    }
}
