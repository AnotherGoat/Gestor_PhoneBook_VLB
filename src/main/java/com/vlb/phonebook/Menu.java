package com.vlb.phonebook;

// Importa la clase ArrayList
import java.util.List;
import java.util.ArrayList;

/**
 * Clase con atributos y métodos para menús en general
 */
public class Menu {

    //// Atributos
    /**
     * Arreglo de Strings que contiene las opciones del menú
     */
    protected List<String> opciones = new ArrayList<>();
    /**
     * Boolean que se usa para seguir usando el menú
     */
    protected boolean seguir;
    /**
     * Opción que ingresa el usuario, se usa en los métodos desplegarMenu y switchMenu
     */
    protected int eleccion;
    /**
     * Validador usado en la clase Menu y sus subclases
     */
    protected final Validador v = new Validador();

    //// Constructores
    public Menu() {
    }

    public Menu(List<String> opciones) {
        this.opciones = opciones;
    }

    //// Métodos
    /**
     * Método para mostrar el nombre del gestor con algo de decoración
     */
    public void mostrarLogo(){
        System.out.println("******************************************");
        System.out.println("=========\\\\Gestor PhoneBook VLB//=========");
        System.out.println("******************************************");
    }

    /**
     * Método de uso general para mostrar una lista numerada de los datos dentro de una List
     * @param al List de tipo String que se quiere ordenar
     */
    public static void enumerarListString(List<String> lista){
        if(lista != null) {
            for (int i = 1; i <= lista.size(); i++) {
                System.out.println(i + ".- " + lista.get(i - 1));
            }
        }
        else{
            System.out.println("Error: ArrayList nulo");
        }
    }

    /**
     * Método de uso general para mostrar una lista numerada de los datos dentro de una List
     * @param al List de tipo Integer que se quiere ordenar
     */
    public static void enumerarListInteger(List<Integer> lista){
        if(lista != null) {
            for (int i = 1; i <= lista.size(); i++) {
                System.out.println(i + ".- " + lista.get(i - 1));
            }
        }
        else{
            System.out.println("Error: ArrayList nulo");
        }
    }

    /**
     * Método que se usa para confirmar la salida del programa
     * @param nombreMenu Nombre del menú del que se desea salir
     * @return Boolean que le indica al programa si se quiere salir (true) o no (false)
     */
    public boolean salir(String nombreMenu) {
        int a = v.validarInt(0, 1,
                "¿Desea salir del "+nombreMenu+"? 1=Sí 0=No\nEscoja una opción: ",
                "La opción ingresada no existe.");

        return a == 1;
    }
}
