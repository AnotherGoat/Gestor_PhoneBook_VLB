package interfaz_grafica;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaEditor extends JDialogGeneral{

    //// Atributos
    private JPanel panelNombre;
    private JPanel panelDireccion;
    private JPanel panelFoto;
    private JPanel panelFechaCumple;
    private JPanel panelTelefonos;
    private JPanel panelEmails;
    private JPanel panelApodos;
    private JPanel panelNotas;
    /**
     * Posición del contacto que se va a leer
     */
    private int posicion;

    //// Constructores
    public VentanaEditor(int posicion) {
        this.posicion = posicion;

        cargarIcono();
        inicializarComponentes();
        //ubicarComponentes();
        implementarListeners();
        configurarVentana();
    }

    //// Métodos
    @Override
    protected void configurarVentana() {
        super.configurarVentana();

        // Título
        setTitle("Editando contacto");
        // Tamaño inicial
        setSize(700, 400);
        // La ventana inicia centrada (no funciona bien si se pone en las clases padres)
        setLocationRelativeTo(null);
    }
}
