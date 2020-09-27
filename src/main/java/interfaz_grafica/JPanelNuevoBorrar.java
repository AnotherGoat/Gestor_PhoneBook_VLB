package interfaz_grafica;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * JPanel con un label, un campo de texto, y los botones "agregar" y "borrar"
 * @see JPanel
 */
public class JPanelNuevoBorrar extends JPanel {

    //// Atributos
    /**
     * Título del JPanel
     */
    private String titulo;
    /**
     * Letra que va al final de las palabras que cambian según su género
     */
    private char letraFinal;
    /**
     * JLabel con el texto "Nuev@: "
     * @see JLabel
     */
    private JLabel label;
    /**
     * Campo de texto donde se ingresa el texto
     * @see JLabel
     */
    private JTextField campo;
    /**
     * Botón con el texto "Agregar"
     * @see JButton
     */
    private JButton botonAgregar;
    /**
     * Botón con el texto "Borrar"
     * @see JButton
     */
    private JButton botonBorrar;

    //// Constructores
    /**
     * Construye un JPanelNuevoBorrar con los datos ingresados
     * @param titulo Título del JPanel
     * @param letraFinal Letra al final de algunas palabras ('a' o 'o')
     * @see JPanelNuevoBorrar#inicializarComponentes()
     * @see JPanelNuevoBorrar#ubicarComponentes()
     */
    public JPanelNuevoBorrar(String titulo, char letraFinal){
        this.titulo = titulo;
        this.letraFinal = letraFinal;

        inicializarComponentes();
        ubicarComponentes();
    }

    //// Métodos
    /**
     * Inicializa los componentes que tendrá el panel
     */
    private void inicializarComponentes(){
        // Configura el borde y el layout del panel
        setBorder(BordeGeneral.crearBorde(titulo));
        setLayout(new GridBagLayout());

        label = new JLabel("Nuev"+letraFinal+":  ");
        campo = new JTextField(10);
        botonAgregar = new JButton("Añadir");
        botonBorrar = new JButton("Borrar seleccionad"+letraFinal);
    }

    /**
     * Ubica los componentes dentro del panel
     */
    private void ubicarComponentes(){
        add(label, gbc(0, 0, 1, 1));
        add(campo, gbc(1, 0, 1, 1));
        add(botonAgregar, gbc(0, 1, 2, 1));
        add(botonBorrar, gbc(0, 2, 2, 1));
    }

    /**
     * Retorna un objeto GridBagConstraints con las especificaciones dadas
     * @param x Posición en X
     * @param y Posición en Y
     * @param ancho Medida del ancho (en láminas)
     * @param altura Medida de altura (en láminas)
     * @return Objeto GridBagConstraints con los datos
     * @see GridBagConstraints
     */
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

    /**
     * Getter "falso" que obtiene el texto del campo
     * @return Texto del campo de texto
     */
    public String getText(){
        return campo.getText();
    }

    /**
     * Limpia el campo de texto
     */
    public void limpiar(){
        campo.setText("");
    }

    //// Getters
    /**
     * Getter para obtener el Botón agregar
     * @return Botón con el texto "Agregar"
     */
    public JButton getBotonAgregar() {
        return botonAgregar;
    }

    /**
     * Getter para obtener el Botón borrar
     * @return Botón con el texto "Borrar"
     */
    public JButton getBotonBorrar() {
        return botonBorrar;
    }
}
