package interfaz_grafica;

import json.GestorArchivo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent.*;

public class VentanaVerJSON extends JDialogTextoGeneral {

    /**
     * Instancia del gestor de archivos
     */
    private GestorArchivo ga = new GestorArchivo();

    //// Constructores
    public VentanaVerJSON() {
        this.texto = ga.leerArchivo("agenda.json");

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
        setTitle("Información guardada en \"agenda.json\"");
        // La ventana inicia centrada (no funciona bien si se pone en las clases padres)
        setLocationRelativeTo(null);
    }
}
