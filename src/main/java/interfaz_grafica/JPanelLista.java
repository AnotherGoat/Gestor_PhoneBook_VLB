package interfaz_grafica;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JPanelLista extends JPanel {

    //// Atributos
    private String titulo;
    private DefaultListModel<String> modelo;
    private JList<String> lista;
    private JScrollPane scroll;

    //// Constructores
    public JPanelLista(String titulo){
        this.titulo = titulo;

        inicializarComponentes();
        ubicarComponentes();
    }

    //// Métodos
    private void inicializarComponentes(){
        // Configura el borde y el layout del panel
        setBorder(BordeGeneral.crearBorde(titulo));
        setLayout(new BorderLayout());

        // Instancia un modelo para usarlo en la JList
        modelo = new DefaultListModel();
        // Instancia una JList con los datos del modelo
        lista = new JList(modelo);
        // Instancia el JScrollPane, usando la JList (y define el funcionamiento vertical y horizontal)
        scroll = new JScrollPane(lista, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    }

    private void ubicarComponentes(){
        add(scroll, BorderLayout.CENTER);
    }

    public int getEleccion() {
        return lista.getSelectedIndex();
    }

    public void reiniciarEleccion() {
        lista.setSelectedIndex(-1);
    }

    public void agregarElemento(String elemento){
        modelo.addElement(elemento);
    }

    public void agregarElemento(String elemento, int posicion){
        modelo.insertElementAt(elemento, posicion);
    }

    public void borrar(int posicion){
        modelo.remove(posicion);
    }

    public void borrarElegido(){
        modelo.remove(lista.getSelectedIndex());
    }

    public void limpiar(){
        modelo.clear();
    }
}
