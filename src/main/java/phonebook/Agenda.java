package phonebook;

// Importa la clase ArrayList
import json.GestorJSON;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

/**
 * Esta clase almacena todos los contactos y métodos para trabajar con ellos
 */

/*Relacion de Dependencia: Agenda usa recursos de la clase Validador, es decir, depende de las funcionalidades de las otras clases
y no de forma inversa,es decir, la otra clase no necesitan de la clase Agenda.
  Relacion de Agregación: Agenda es parte de la clase Contacto, con atributo de multiplicidad cero es a muchos considerando un ArrayList.   */
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
    /**
     * Validador usado en la clase Agenda
     */
    private final Validador v = new Validador();

    //// Constructores
    public Agenda() {
    }

    //// Métodos
    /**
     * Método para crear un contacto nuevo
     */
    public void crearContacto() {
        // Pide el nombre del contacto
        String nombreContacto = v.recibirString("Ingrese el nombre del contacto: ");

        // Crea el contacto nuevo y lo agrega a la List
        Contacto nuevo = new Contacto(nombreContacto);
        lista_contactos.add(nuevo);
        // Ordena la lista de contactos
        ordenarContactos();
        System.out.println("El contacto fue guardado exitosamente.");

        GestorJSON.guardarJSON();
    }

    /**
     * Método para mostrar una lista de todos los contactos guardados
     */
    public void listarContactos() {
        // Mostrar nombres de los contactos guardados
        System.out.println("Contactos guardados:");
        System.out.println(Menu.enumerarListaString(lista_nombres));
    }

    /**
     * Método para mostrar detalles de un contacto específico
     */
    public void mostrarContacto() {
        int posicionContacto = elegirContacto("ver");
        posicionContacto--; // Le resta 1 porque los índices empiezan desde 0

        // Muestra los detalles del contacto
        System.out.println("*****Contacto #"+(posicionContacto+1)+"*****");
        System.out.println(lista_contactos.get(posicionContacto).toString());
    }

    /**
     * Método que muestra una lista de los contactos guardados y pide al usuario que escoja uno
     * @param verbo Verbo usado en el String "Escoja el contacto que quiere... :"
     * @return int con el contacto elegido (no su posición en el arreglo)
     */
    public int elegirContacto(String verbo){
        // Muestra la lista de contactos
        listarContactos();

        // Toma la entrada entre 1 y el contacto de rango máximo
        return v.validarInt(1, lista_contactos.size(),
                "Escoja el contacto que quiere "+verbo+": ",
                "El contacto ingresado no existe.");
    }

    /**
     * Método para mostrar un menú de edición de un contacto
     */
    public void editarContacto() {
        int posicionContacto = elegirContacto("editar");
        posicionContacto--; // Le resta 1 porque los índices empiezan desde 0

        // Instancia el menú editor
        new MenuEditor(posicionContacto);
    }

    /**
     * Método para eliminar un contacto
     */
    public void eliminarContacto() {
        int posicionContacto = elegirContacto("eliminar");
        posicionContacto--; // Le resta 1 porque los índices empiezan desde 0

        // Pide confirmación para borrar el contacto elegido
        confirmarBorrado(posicionContacto);

        GestorJSON.guardarJSON();
    }

    /**
     * Método para confirmar la eliminación de un contacto
     * @param posicion Posición del contacto que se desea borrar
     */
    public void confirmarBorrado(int posicion) {
        int x;
        x = v.validarInt(0, 1,
                "Se borrará el contacto "+lista_contactos.get(posicion).getNombre()+" ¿Está seguro? 1=Sí 0=No\nEscoja una opción: ",
                "La opción ingresada no existe.");

        switch (x) {
            case 1:
                // Borra el contacto de las listas de contactos y de nombres
                lista_contactos.remove(posicion);
                lista_nombres.remove(posicion);

                System.out.println("El contacto ha sido borrado exitosamente.");
                break;
            case 0:
                System.out.println("El contacto no se borró.");
                break;
        }
    }

    /**
     * Ordena la lista de contactos alfabéticamente según el nombre de cada uno y actualiza la lista de nombres
     */
    public void ordenarContactos(){
        // Se necesita crear un comparador para ordenar según el nombre de cada contacto
        Comparator c = new Comparator<Contacto>() {
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

    //// Getters y Setters
    public List<Contacto> getLista_Contactos() {
        return lista_contactos;
    }

    public void setLista_Contactos(List<Contacto> contactos) {
        this.lista_contactos = contactos;
    }
}
