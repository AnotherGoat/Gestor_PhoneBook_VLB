package interfaz_grafica;

import lanzador.Principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaDatosContacto extends JDialogTextoGeneral{

    //// Atributos
    /**
     * Posición del contacto que se va a leer
     */
    private int posicion;

    //// Constructores
    public VentanaDatosContacto(int posicion) {
        this.posicion = posicion;
        this.texto = Principal.agenda.getLista_Contactos().get(posicion).toString();

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
        setTitle("Datos de "+Principal.agenda.getLista_Nombres().get(posicion));
        // La ventana inicia centrada (no funciona bien si se pone en las clases padres)
        setLocationRelativeTo(null);
    }
}
