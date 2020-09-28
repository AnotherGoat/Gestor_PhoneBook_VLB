package interfaz_grafica.paneles;

import interfaz_grafica.utilidades_gui.BordeGeneral;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * JPanel que contiene una lista, un modelo y un scrollpane
 * @see JPanel
 */
public class JPanelLista extends JPanel {

    //// Atributos
    /**
     * String con el título
     */
    private String titulo;
    /**
     * Modelo de la lista (de Strings)
     * @see DefaultListModel
     */
    private DefaultListModel<String> modelo;
    /**
     * Lista de Strings
     * @see JList
     */
    private JList<String> lista;
    /**
     * JScrollPane para permitir el movimiento si la lista es muy grande
     */
    private JScrollPane scroll;

    //// Constructores
    /**
     * Constructor de la lista, usando el título ingresado
     * @param titulo Título de la lista
     * @see JPanelLista#inicializarComponentes()
     * @see JPanelLista#ubicarComponentes()
     */
    public JPanelLista(String titulo){
        this.titulo = titulo;

        inicializarComponentes();
        ubicarComponentes();
    }

    //// Métodos
    /**
     * Inicia los componentes del JPanel
     */
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

    /**
     * Ubica los componentes dentro del JPanel
     */
    private void ubicarComponentes(){
        add(scroll, BorderLayout.CENTER);
    }

    /**
     * Getter "falso" que obtiene el índice seleccionado
     * @return Int con el índice seleccionado
     */
    public int getEleccion() {
        return lista.getSelectedIndex();
    }

    /**
     * Reinicia la elección de la lista (la cambia a -1)
     */
    public void reiniciarEleccion() {
        lista.setSelectedIndex(-1);
    }

    /**
     * Agrega un elemento usando la String del parámetro
     * @param elemento String con el elemento
     * @see DefaultListModel#addElement(Object)
     * @see JPanelLista#agregarElemento(String, int)
     */
    public void agregarElemento(String elemento){
        modelo.addElement(elemento);
    }

    /**
     * Agrega un elemento en la posición indicada
     * @param elemento String con el elemento
     * @param posicion Int que representa la posición
     * @see DefaultListModel#insertElementAt(Object, int)
     * @see JPanelLista#agregarElemento(String)
     */
    public void agregarElemento(String elemento, int posicion){
        modelo.insertElementAt(elemento, posicion);
    }

    /**
     * Borra el elemento en la posición indicada
     * @param posicion Posición del elemento que se quiere borrar
     * @see DefaultListModel#remove(int)
     */
    public void borrar(int posicion){
        modelo.remove(posicion);
    }

    /**
     * Borra el elemento de la posición elegida
     * @see DefaultListModel#remove(int)
     */
    public void borrarElegido(){
        modelo.remove(lista.getSelectedIndex());
    }

    /**
     * Limpia el modelo de la lista
     * @see DefaultListModel#clear()
     */
    public void limpiar(){
        modelo.clear();
    }
}
