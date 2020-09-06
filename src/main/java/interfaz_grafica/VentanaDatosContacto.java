package interfaz_grafica;

import lanzador.Principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VentanaDatosContacto extends JDialogTextoGeneral{

    //// Atributos
    /**
     * Posición del contacto que se va a leer
     */
    int posicion;

    //// Constructores
    public VentanaDatosContacto(int posicion, Component ventanaAnterior) {
        super(ventanaAnterior);
        this.posicion = posicion;
        this.texto = Principal.agenda.getLista_Contactos().get(posicion).toString();

        inicializar();

        //// Otras características de la ventana

        // Título
        setTitle("Datos de "+Principal.agenda.getLista_Nombres().get(posicion));
        // Tamaño inicial
        setSize(400, 500);

        configurar();
    }
}
