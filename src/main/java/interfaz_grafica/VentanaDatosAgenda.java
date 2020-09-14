package interfaz_grafica;

import lanzador.Principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
    protected void configurarVentana() {
        super.configurarVentana();

        // Título
        setTitle("Datos guardados en la agenda");
        // La ventana inicia centrada (no funciona bien si se pone en las clases padres)
        setLocationRelativeTo(null);
    }
}
