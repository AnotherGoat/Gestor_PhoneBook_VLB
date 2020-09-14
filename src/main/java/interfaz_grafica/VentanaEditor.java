package interfaz_grafica;

import lanzador.Principal;
import phonebook.Contacto;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaEditor extends JDialogGeneral implements ActionListener{

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
     * Posicion del contacto original en la agenda
     */
    private final int posicion;
    /**
     * Contacto original de la agenda
     */
    private Contacto original;
    /**
     * Contacto auxiliar, se usa para permitir elegir si guardar los cambios o no
     */
    private Contacto aux;

    //// Constructores
    public VentanaEditor(int posicion) {
        this.posicion = posicion;
        // Tomar contacto que se va a editar (paso por referencia)
        this.original = Principal.agenda.getLista_Contactos().get(posicion);

        // Copia el contacto original a uno auxiliar (paso por valor)
        this.aux = new Contacto(original);

        cargarIcono();
        inicializarComponentes();
        // ubicarComponentes();
        implementarListeners();
        configurarVentana();
    }

    //// Métodos
    @Override
    protected void inicializarComponentes() {
        // Usa el GridBagLayout para organizar los componentes
        panel.setLayout(new GridBagLayout());
    }

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

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == botonVolverAtras){
                // Todavía no configurado
        }
    }
}
