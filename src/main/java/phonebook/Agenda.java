package phonebook;

import datos.GestorJSON;
import utilidades.Validador;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

/**
 * Esta clase almacena todos los contactos y métodos para trabajar con ellos
 */
/*Relación de Dependencia: Agenda usa recursos de la clase Validador, es decir, depende de las funcionalidades de las otras clases
y no de forma inversa,es decir, la otra clase no necesitan de la clase Agenda.
  Relación de Agregación: Agenda es parte de la clase Contacto, con atributo de multiplicidad cero es a muchos considerando un ArrayList.   */
public class Agenda {

    //// Atributos
    /**
     * List con los contactos guardados
     */
    private List<Contacto> lista_contactos = new ArrayList<>();
    /**
     * List con el nombre de cada contacto
     */
    List<String> lista_nombres = new ArrayList<>();

    //// Constructores
    public Agenda() {
    }

    //// Métodos
    /**
     * Método para crear un contacto nuevo a partir de un String
     * @return int con la posición en la que se añadió el contacto
     */
    public int crearContacto(String entrada) {
        // Pide el nombre del contacto
        // String nombreContacto = v.recibirString("Ingrese el nombre del contacto: ");

        // Crea el contacto nuevo y lo agrega a la List
        Contacto nuevo = new Contacto(entrada);
        lista_contactos.add(nuevo);
        // Ordena la lista de contactos
        ordenarContactos();

        GestorJSON.guardarJSON("agenda.json");

        // Retorna el índice del contacto nuevo
        return lista_contactos.indexOf(nuevo);
    }

    /**
     * Método para crear un contacto nuevo a partir de otro contacto
     * @return int con la posición en la que se añadió el contacto
     */
    public int crearContacto(Contacto original) {
        // Pide el nombre del contacto
        // String nombreContacto = v.recibirString("Ingrese el nombre del contacto: ");

        // Crea el contacto nuevo y lo agrega a la List
        Contacto nuevo = new Contacto(original);
        lista_contactos.add(nuevo);
        // Ordena la lista de contactos
        ordenarContactos();

        GestorJSON.guardarJSON("agenda.json");

        // Retorna el índice del contacto nuevo
        return lista_contactos.indexOf(nuevo);
    }

    public void borrarContacto(int posicion){
        this.lista_contactos.remove(posicion);
        this.lista_nombres.remove(posicion);

        // Actualiza el json
        GestorJSON.guardarJSON("agenda.json");
    }

    /**
     * Método para eliminar un contacto
     * @param posicion int con la posición del contacto, debe ser negativo
     */
    public void eliminarContacto(int posicion) {
        // Borra el contacto de las listas de contactos y de nombres
        lista_contactos.remove(posicion);
        lista_nombres.remove(posicion);
        // Guarda el archivo JSON con los cambios
        GestorJSON.guardarJSON("agenda.json");
    }

    /**
     * Ordena la lista de contactos alfabéticamente según el nombre de cada uno y actualiza la lista de nombres
     */
    public void ordenarContactos(){
        // Se necesita crear un comparador para ordenar contactos
        Comparator c = new Comparator<Contacto>() {
            // Se añade un método para que compare contactos según su nombre
            public int compare(Contacto c1, Contacto c2) {
                return c1.getNombre().compareTo(c2.getNombre());
            }
        };

        // Se usa el método sort para ordenar lista_contactos alfabéticamente, usando el comparador
        Collections.sort(lista_contactos, c);
        // Actualiza la lista de nombres
        actualizarListaNombres();
    }

    /**
     * Este método actualiza la lista de nombres de la agenda en base a la lista de contactos actual
     */
    public void actualizarListaNombres(){
        // Limpia la lista
        this.lista_nombres.clear();

        // Añade cada nombre a la lista
        for (Contacto c : lista_contactos) {
            lista_nombres.add(c.getNombre());
        }
    }

    /**
     * Borra todos los datos guardados en la agenda y el archivo "agenda.json"
     */
    public void borrarTodo(){
        // Limpia los 2 ArrayLists que contienen todos los datos
        this.getLista_Nombres().clear();
        this.getLista_Contactos().clear();
        // Hace que el GestorJSON borre el archivo "agenda.json"
        GestorJSON.borrarJSON("agenda.json");
    }

    //// Getters y Setters
    public List<Contacto> getLista_Contactos() {
        return lista_contactos;
    }

    public void setLista_Contactos(List<Contacto> contactos) {
        this.lista_contactos = contactos;
    }

    public List<String> getLista_Nombres() {
        return lista_nombres;
    }

    //// toString
    @Override
    /**
     * Convierte la información guardada en la agenda a un String
     */
    public String toString() {
        StringBuilder s = new StringBuilder();

        // Si hay contactos en la lista
        if(!lista_contactos.isEmpty()) {
            s.append("Lista de contactos guardados:");

            for (Contacto c : lista_contactos) {
                s.append("\n\n*****Contacto #").append(lista_contactos.indexOf(c) + 1).append("*****\n");
                s.append(c.toString());
            }
        }

        return s.toString();
    }
}
