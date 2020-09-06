package interfaz_grafica;

import lanzador.Principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VentanaDatosAgenda extends JDialogTextoGeneral {

    //// Constructores
    public VentanaDatosAgenda(Component ventanaAnterior) {
        super(ventanaAnterior);
        this.texto = Principal.agenda.toString();

        inicializar();

        //// Otras características de la ventana

        // Título
        setTitle("Datos guardados en la agenda");
        // Tamaño inicial
        setSize(400, 500);

        configurar();
    }
}
