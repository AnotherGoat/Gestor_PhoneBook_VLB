package interfaz_grafica;

import json.GestorJSON;
import org.json.JSONArray;
import phonebook.Agenda;

import java.awt.*;
import java.net.URL;

/**
 * Launcher de prueba para la interfaz gráfica, copiando a Principal
 */
public class MainPrueba {

    public static void main(String[] args) {
        // Instancia la ventana principal
        VentanaPrincipal vPrincipal = new VentanaPrincipal();
        // Hace que sea visible
        vPrincipal.setVisible(true);
        
        VentanaCrearContacto vCrearContacto = new VentanaCrearContacto();
        vCrearContacto.setVisible(true);
    }
}
