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

    //// Constructores
    public JPanelImagen(String ruta, int ancho, int altura) {

        setLayout(new BorderLayout());

        // Intenta cargar la imagen
        try {
            imagen = ImageIO.read(new File(ruta));
        } catch(IOException e){
            // Si falla, debería cargar una imagen por defecto
        }

        // Crea un label con la imagen, y usando el ancho y la altura especificada
        label = new JLabel(new ImageIcon(imagen.getScaledInstance(ancho, altura, Image.SCALE_SMOOTH)));
        add(label, BorderLayout.CENTER);
    }
}
