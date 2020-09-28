package interfaz_grafica.ventanas;

import lanzador.Principal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * JDialog que muestra los datos guardados sobre un contacto
 * @see JDialogTextoGeneral
 */
public class VentanaDatosContacto extends JDialogTextoGeneral{

    //// Atributos
    /**
     * Posición del contacto que se va a leer
     */
    private int posicion;

    //// Constructores
    /**
     * Construye una ventana con los datos del contacto
     * @param posicion Posición del contacto en la agenda
     * @see phonebook.Contacto#toString
     * @see JDialogGeneral#cargarIcono()
     * @see JDialogTextoGeneral#inicializarComponentes()
     * @see JDialogTextoGeneral#ubicarComponentes()
     * @see JDialogGeneral#implementarListeners()
     * @see VentanaDatosContacto#configurarVentana()
     */
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
    /**
     * Configura el JDialog
     * @see JDialogTextoGeneral#configurarVentana()
     */
    @Override
    protected void configurarVentana() {
        super.configurarVentana();

        // Título
        setTitle("Datos de "+Principal.agenda.getLista_Nombres().get(posicion));
        // La ventana inicia centrada (no funciona bien si se pone en las clases padres)
        setLocationRelativeTo(null);
    }
}
