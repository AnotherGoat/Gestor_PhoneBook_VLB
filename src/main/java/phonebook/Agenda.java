package phonebook;

// Importa la clase ArrayList
import json.GestorJSON;

import java.util.List;
import java.util.ArrayList;

/**
 * Esta clase almacena todos los contactos y métodos para trabajar con ellos
 */
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
        lista_nombres.add(nombreContacto);
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
     * @return int con el contacto elegido
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

        // Actualiza la lista de nombres de la agenda
        lista_nombres.set(posicionContacto, lista_contactos.get(posicionContacto).getNombre());

        GestorJSON.guardarJSON();
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
                lista_contactos.remove(posicion);
                lista_nombres.remove(posicion);
                System.out.println("El contacto ha sido borrado exitosamente.");
                break;
            case 0:
                System.out.println("El contacto no se borró.");
                break;
        }
    }

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