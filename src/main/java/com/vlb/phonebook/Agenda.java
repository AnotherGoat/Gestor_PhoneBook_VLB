package com.vlb.phonebook;

// Importa la clase ArrayList
import java.util.List;
import java.util.ArrayList;

/**
 * Esta clase almacena todos los contactos y métodos para trabajar con ellos
 */
public class Agenda {

    //// Atributos
    /**
     * List con los contactos registrados
     */
    private List<Contacto> contactos = new ArrayList<>();
    /**
     * List con el nombre de cada contacto
     */
    private List<String> listaNombres = new ArrayList<>();
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
        contactos.add(nuevo);
        listaNombres.add(nombreContacto);
        System.out.println("El contacto fue guardado exitosamente.");
    }

    /**
     * Método para mostrar una lista de todos los contactos guardados
     */
    public void listarContactos() {
        // Mostrar nombres de los contactos registrados
        System.out.println("Contactos registrados:");
        System.out.println(Menu.enumerarListaString(listaNombres));
    }

    /**
     * Método para mostrar detalles de un contacto específico
     */
    public void mostrarContacto() {
        int idContacto = elegirContacto("ver"); // id Contacto = número con el que se identifica

        // Muestra los detalles del contacto
        System.out.println("****Contacto #"+idContacto+"****");
        System.out.println(contactos.get(idContacto - 1).toString());
    }

    /**
     * Método que muestra una lista de los contactos registrados y pide al usuario que escoja uno
     * @param verbo Verbo usado en el String "Escoja el contacto que quiere... :"
     * @return int con el contacto elegido
     */
    public int elegirContacto(String verbo){
        // Muestra la lista de contactos
        listarContactos();

        // Toma la entrada entre 1 y el contacto de rango máximo
        return v.validarInt(1, contactos.size(),
                "Escoja el contacto que quiere "+verbo+": ",
                "El contacto ingresado no existe.");
    }

    /**
     * Método para mostrar un menú de edición de un contacto
     */
    public void editarContacto() {
        int idContacto = elegirContacto("editar"); // id Contacto = número con el que se identifica
        MenuEditor editor = new MenuEditor(idContacto - 1);

        // Actualiza la lista de nombres de la agenda
        listaNombres.set(idContacto-1, contactos.get(idContacto-1).getNombre());
    }

    /**
     * Método para eliminar un contacto
     */
    public void eliminarContacto() {
        int idContacto = elegirContacto("eliminar"); // id Contacto = número con el que se identifica
        // Pide confirmación para borrar el contacto elegido
        confirmarBorrado(idContacto-1);
    }

    /**
     * Método para confirmar la eliminación de un contacto
     * @param posicion Posición del contacto que se desea borrar
     */
    public void confirmarBorrado(int posicion) {
        int x;
        x = v.validarInt(0, 1,
                "Se borrará el contacto "+contactos.get(posicion).getNombre()+" ¿Está seguro? 1=Sí 0=No\nEscoja una opción: ",
                "La opción ingresada no existe.");

        switch (x) {
            case 1:
                contactos.remove(posicion);
                listaNombres.remove(posicion);
                System.out.println("El contacto ha sido borrado exitosamente.");
                break;
            case 0:
                System.out.println("El contacto no se borró.");
                break;
        }
    }

    //// Getters y Setters
    public List<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(List<Contacto> contactos) {
        this.contactos = contactos;
    }

    public List<String> getListaNombres() {
        return listaNombres;
    }

    public void setListaNombres(List<String> listaNombres) {
        this.listaNombres = listaNombres;
    }
}
