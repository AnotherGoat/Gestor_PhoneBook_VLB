package interfaz_grafica;

import lanzador.Principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * JDialog que muestra los datos guardados en la agenda
 * @see JDialogTextoGeneral
 */
public class VentanaDatosAgenda extends JDialogTextoGeneral {

    //// Constructores
    /**
     * Construye una ventana con los datos de la agenda
     * @see phonebook.Agenda#toString
     * @see JDialogGeneral#cargarIcono()
     * @see JDialogTextoGeneral#inicializarComponentes()
     * @see JDialogTextoGeneral#ubicarComponentes()
     * @see JDialogGeneral#implementarListeners()
     * @see VentanaDatosAgenda#configurarVentana()
     */
    public VentanaDatosAgenda() {
        this.texto = Principal.agenda.toString();

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
        setTitle("Datos guardados en la agenda");
        // La ventana inicia centrada (no funciona bien si se pone en las clases padres)
        setLocationRelativeTo(null);
    }
}
