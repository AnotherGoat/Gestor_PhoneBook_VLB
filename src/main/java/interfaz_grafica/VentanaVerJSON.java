package interfaz_grafica;

import datos.GestorArchivo;
import phonebook.Agenda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent.*;

/**
 * JDialog que muestra los datos guardados en el archivo "agenda.json"
 * @see JDialogTextoGeneral
 */
public class VentanaVerJSON extends JDialogTextoGeneral {

    /**
     * Instancia del gestor de archivos
     * @see GestorArchivo
     */
    private GestorArchivo ga = new GestorArchivo();

    //// Constructores
    /**
     * Construye una ventana con los datos del archivo "agenda.json"
     * @see GestorArchivo#leerArchivo(String)
     * @see JDialogGeneral#cargarIcono()
     * @see JDialogTextoGeneral#inicializarComponentes()
     * @see JDialogTextoGeneral#ubicarComponentes()
     * @see JDialogGeneral#implementarListeners()
     * @see VentanaDatosAgenda#configurarVentana()
     */
    public VentanaVerJSON() {
        this.texto = ga.leerArchivo("agenda.json");

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
        setTitle("Información guardada en \"agenda.json\"");
        // La ventana inicia centrada (no funciona bien si se pone en las clases padres)
        setLocationRelativeTo(null);
    }
}
