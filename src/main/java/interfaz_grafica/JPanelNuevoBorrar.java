package interfaz_grafica;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JPanelNuevoBorrar extends JPanel {

    //// Atributos
    private String titulo;
    private char letraFinal;
    private JLabel label;
    private JTextField campo;
    private JButton botonAgregar;
    private JButton botonBorrar;

    //// Constructores
    public JPanelNuevoBorrar(String titulo, char letraFinal){
        this.titulo = titulo;
        this.letraFinal = letraFinal;

        inicializarComponentes();
        ubicarComponentes();
    }

    //// Métodos
    private void inicializarComponentes(){
        // Configura el borde y el layout del panel
        setBorder(BordeGeneral.crearBorde(titulo));
        setLayout(new GridBagLayout());

        label = new JLabel("Nuev"+letraFinal+":  ");
        campo = new JTextField(10);
        botonAgregar = new JButton("Añadir");
        botonBorrar = new JButton("Borrar seleccionad"+letraFinal);
    }

    private void ubicarComponentes(){
        add(label, gbc(0, 0, 1, 1));
        add(campo, gbc(1, 0, 1, 1));
        add(botonAgregar, gbc(0, 1, 2, 1));
        add(botonBorrar, gbc(0, 2, 2, 1));
    }

    private GridBagConstraints gbc(int x, int y, int ancho, int altura){
        // Instancia GriadBagConstraints para configurar un GridBagLayout
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = x;
        c.gridy = y;
        c.gridwidth = ancho;
        c.gridheight = altura;
        c.weightx = 0;
        c.weighty = 0;
        c.fill = GridBagConstraints.BOTH;

        return c;
    }

    public String getText(){
        return campo.getText();
    }

    public void limpiar(){
        campo.setText("");
    }

    //// Getters
    public JButton getBotonAgregar() {
        return botonAgregar;
    }

    public JButton getBotonBorrar() {
        return botonBorrar;
    }
}
