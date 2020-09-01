package interfaz_grafica;

import lanzador.Principal;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class VentanaElegirContacto extends JDialogGeneral {

    //// Atributos
    /**
     * Label que tendrá el texto ingresado en el constructor
     */
    private JLabel labelEscojaContacto;
    /**
     * String con el texto del label
     */
    private String texto;
    /**
     * JPanel que contendrá los botones de cada contacto
     */
    private JPanel panelBotones;
    /**
     * List con los botones que representan a cada contacto
     */
    private List<JButton> lista_botones = new ArrayList<>();
    /**
     * Scroll para el panel con los botones
     */
    private JScrollPane scroll;
    /**
     * Panel principal (parte 2)
     */
    private JPanel panel2;

    //// Constructores
    public VentanaElegirContacto(String texto) {
        this.texto = texto;

        iniciar();

        //// Otras características de la ventana

        // Título
        setTitle("Elegir contacto");
        // Tamaño inicial
        setSize(300, 400);

        configurar();
    }

    //// Métodos
    public void iniciar(){
        super.iniciar();

        // Usa el BoxLayout (para mostrar los botones de arriba a abajo
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
        panel2 = new JPanel();

        // Instancia el label
        labelEscojaContacto = new JLabel(texto);
        labelEscojaContacto.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Instancia los botones
        botonVolverAtras.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel2.add(botonVolverAtras);

        for(String s : Principal.agenda.getLista_Nombres()){
            lista_botones.add(new JButton(s));
        }

        for(JButton jb : lista_botones){
            panelBotones.add(jb);
            jb.setAlignmentX(Component.CENTER_ALIGNMENT);
        }

        // Configurar JScrollPane
        scroll = new JScrollPane(panelBotones);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        // Añade el label y los botones al panel
        panel.add(labelEscojaContacto);
        panel.add(scroll);
        panel.add(botonVolverAtras);

        // Añade el panel a la ventana
        add(panel);
    }
}
