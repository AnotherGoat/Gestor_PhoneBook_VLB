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
     * Nombre del menú
     */
    protected String nombreMenu;
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

    //// Constantes
    static final int NOMBRE = 0;
    static final int CELULAR = 1;
    static final int FIJO = 2;
    static final int TRABAJO = 3;
    static final int DIRECCION = 4;
    static final int EMAIL = 5;
    static final int APODO = 6;
    static final int FECHACUMPLE = 7;
    static final int NOTAS = 8;

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
     * Método de uso general para generar una lista numerada de los datos dentro de una List
     * @param lista List de tipo String que se quiere ordenar
     * @return String con la lista numerada
     */
    public static String enumerarListaString(List<String> lista){
        String s;

        if(lista != null) {
            for (int i = 1; i <= lista.size(); i++) {
                s += i + ".- " + lista.get(i - 1);

                if(i != lista.size()){ // Añade un salto de linea en todos excepto el último
                    s += "\n";
                }
            }
        }
        else{
            s = "Error: ArrayList nulo";
        }

        return s;
    }

    /**
     * Método de uso general para generar una lista numerada de los datos dentro de una List
     * @param lista List de tipo Integer que se quiere ordenar
     * @return String con la lista numerada
     */
    public static String enumerarListaInteger(List<Integer> lista){
        StringBuilder s = new StringBuilder();

        if(lista != null) {
            for (int i = 1; i <= lista.size(); i++) {
                s.append(i).append(".- ").append(lista.get(i - 1));

                if(i != lista.size()){ // Añade un salto de linea en todos excepto el último
                    s.append("\n");
                }
            }
        }
        else{
            s = new StringBuilder("Error: ArrayList nulo");
        }

        return s.toString();
    }

    /**
     * Método de uso general para generar una lista numerada de los datos dentro de una List
     * @param lista List de tipo Teléfono que se quiere ordenar
     * @return String con la lista numerada
     */
    public static String enumerarListaTelefono(List<Telefono> lista){
        String s = "";

        if(lista!=null) {
            for(int i = 1; i <= lista.size(); i++) {
                s += i + ".- " + lista.get(i - 1).toString();

                if(i != lista.size()){ // Añade un salto de linea en todos excepto el último
                    s += "\n";
                }
            }
        }
        else{
            s = "Error: ArrayList nulo";
        }

        return s;
    }

    /**
     * Método que se usa para confirmar la salida del programa
     * @return Boolean que le indica al programa si se quiere salir (true) o no (false)
     */
    public boolean salir() {
        int a = v.validarInt(0, 1,
                "¿Desea salir del "+nombreMenu+"? 1=Sí 0=No\nEscoja una opción: ",
                "La opción ingresada no existe.");

        return a == 1;
    }
}
