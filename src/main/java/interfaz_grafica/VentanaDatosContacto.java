package interfaz_grafica;

import lanzador.Principal;

import javax.swing.*;
import java.awt.*;

public class VentanaDatosContacto extends JDialogGeneral{

    //// Atributos
    /**
     * Área con el texto
     */
    JTextArea textArea;

    int posicion;

    //// Constructores
    public VentanaDatosContacto(int posicion) {
        this.posicion = posicion;

        inicializar();

        //// Otras características de la ventana

        // Título
        setTitle("Datos de "+Principal.agenda.getLista_Nombres().get(posicion));
        // Tamaño inicial
        setSize(300, 400);

        configurar();
    }

    //// Métodos
    public void inicializar(){
        super.inicializar();

        textArea = new JTextArea(Principal.agenda.getLista_Contactos().get(posicion).toString());
        textArea.setVisible(true);

        panel.setLayout(new FlowLayout());

        //panel.add(textArea);
         panel.add(botonVolverAtras);
    }

}
