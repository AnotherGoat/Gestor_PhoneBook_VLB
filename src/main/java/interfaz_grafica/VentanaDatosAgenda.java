package interfaz_grafica;

import lanzador.Principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VentanaDatosAgenda extends JDialogTextoGeneral {

    //// Constructores
    public VentanaDatosAgenda() {
        this.texto = Principal.agenda.toString();

        cargarIcono();
        inicializarComponentes();
        ubicarComponentes();
        implementarListeners();
        configurarVentana();
    }

    //// Métodos
    @Override
    public void configurarVentana() {
        super.configurarVentana();

        // Título
        setTitle("Datos guardados en la agenda");
        // La ventana inicia centrada (no funciona bien si se pone en las clases padres)
        setLocationRelativeTo(null);
    }
}
