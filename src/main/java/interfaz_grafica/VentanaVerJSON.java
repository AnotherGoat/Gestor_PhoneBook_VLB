package interfaz_grafica;

import json.GestorArchivo;
import lanzador.Principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VentanaVerJSON extends JDialogTextoGeneral {

    /**
     * Instancia del gestor de archivos
     */
    static GestorArchivo ga = new GestorArchivo();

    //// Constructores
    public VentanaVerJSON(Component ventanaAnterior) {
        super(ventanaAnterior);
        this.texto = ga.leerArchivo("agenda.json");

        inicializar();

        //// Otras características de la ventana

        // Título
        setTitle("Información guardada en \"agenda.json\"");
        // Tamaño inicial
        setSize(400, 350);

        configurar();
    }
}
