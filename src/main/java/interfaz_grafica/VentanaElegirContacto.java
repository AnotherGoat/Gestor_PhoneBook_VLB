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
     * Opción que ingresa el usuario
     */
    private int eleccion;

    //// Constructores
    public VentanaElegirContacto(String texto) {
        this.texto = texto;

        inicializar();

        //// Otras características de la ventana

        // Título
        setTitle("Elegir contacto");
        // Tamaño inicial
        setSize(300, 400);

        configurar();
    }

    //// Métodos
    public void inicializar(){
        super.inicializar();

        // Usa el BoxLayout para mostrar los botones verticalmente
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Si no hay contactos guardados...
        if(Principal.agenda.getLista_Contactos().isEmpty()) {
            // Cambia el texto del JLabel a un mensaje de error
            labelEscojaContacto.setText("Error: Todavía no hay contactos guardados en la agenda");

            // Añade los objetos al JPanel
            panel.add(labelEscojaContacto);
            panel.add(botonVolverAtras);
        }

        // Si hay contactos guardados...
        else {
            // Instancia un JPanel para los botones
            panelBotones = new JPanel();
            panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
            panelBotones.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true), "Lista de contactos"));

            // Instancia el JLabel
            labelEscojaContacto = new JLabel(texto);
            labelEscojaContacto.setAlignmentX(Component.CENTER_ALIGNMENT);

            // Instancia los JButton
            botonVolverAtras.setAlignmentX(Component.CENTER_ALIGNMENT);

            // Por cada nombre dentro de la agenda crea un JButton
            for (String s : Principal.agenda.getLista_Nombres()) {
                lista_botones.add(new JButton(s));
            }
            // Añade todos los JButton al panelBotones y los centra
            for (JButton jb : lista_botones) {
                panelBotones.add(jb);
                jb.setAlignmentX(Component.CENTER_ALIGNMENT);
            }

            // Instancia el JScrollPane, usando el JPanel con los botones
            scroll = new JScrollPane(panelBotones);
            // Define como funciona el scroll vertical y horizontal
            scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
            scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

            // Implementa ActionListener para los JButton
            for(JButton jb : lista_botones) {
                    jb.addActionListener(this);
            }

            // Añade los objetos al JPanel
            panel.add(labelEscojaContacto);
            panel.add(scroll);
            panel.add(botonVolverAtras);
        }

        // Añade el JPanel al JFrame
        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        super.actionPerformed(ae);

        for(JButton jb : lista_botones) {
            if(ae.getSource() == jb) {
                // Elección pasa a ser el índice del botón
                eleccion = lista_botones.indexOf(jb);
                // Esconde la ventana
                //setVisible(false);

                switch(getTitle()) {
                    case "Escoja el contacto que quiere ver":
                        VentanaDatosContacto vdc = new VentanaDatosContacto(eleccion);
                        vdc.setVisible(true);
                        break;

                    case "Escoja el contacto que quiere editar":
                        break;

                    case "Escoja el contacto que quiere borrar":
                }
            }
        }
    }
}
