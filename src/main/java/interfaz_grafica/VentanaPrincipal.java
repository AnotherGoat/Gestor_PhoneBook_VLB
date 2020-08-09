package interfaz_grafica;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {
    // Atributos de la ventana (todavía no tienen función los botones)
    private JButton botonNuevoContacto;
    private JButton botonDatosContacto;
    private JButton botonEditarContacto;
    private JButton botonEliminarContacto;
    private JButton botonSalir;

    public VentanaPrincipal(){
        setTitle("Gestor Phonebook VLB"); // Título
        setSize(200, 200); // Se define el tamaño de ventana
        setLocationRelativeTo(null); // Centrar la ventana
        setResizable(false); // Inhabilita el funcionamiento del botón maximizar
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Cuando se cierre la ventana se finaliza el programa

        cargarIcono();
        iniciarBotones();
    }

    private void cargarIcono(){
        Image icono = Toolkit.getDefaultToolkit().getImage("archivos/icono_phonebook_nuevo.png");
        setIconImage(icono);
    }

    private void iniciarBotones(){
        JPanel panel1 = new JPanel();
        //panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));

        botonNuevoContacto = new JButton("Crear un contacto nuevo");
        botonDatosContacto = new JButton("Ver datos de un contacto");
        botonEditarContacto = new JButton("Editar un contacto");
        botonEliminarContacto = new JButton("Eliminar un contacto");
        botonSalir = new JButton("Salir del programa");

        panel1.add(botonNuevoContacto);
        panel1.add(botonDatosContacto);
        panel1.add(botonEditarContacto);
        panel1.add(botonEliminarContacto);
        panel1.add(botonSalir);

        add(panel1);
    }

}
