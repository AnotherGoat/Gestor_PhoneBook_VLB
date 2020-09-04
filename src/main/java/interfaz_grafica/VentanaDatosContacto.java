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
        setSize(300, 400);

        configurar();
    }

    //// Métodos
    @Override
    public void inicializar(){
        super.inicializar();

        textArea = new JTextArea(Principal.agenda.getLista_Contactos().get(posicion).toString());
        textArea.setVisible(true);

        panel.add(textArea, BorderLayout.NORTH);
        panel.add(botonVolverAtras, BorderLayout.SOUTH);

        add(panel);
    }
}
