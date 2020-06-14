package com.vlb.phonebook;

// Importa la agenda de uso "global"
import static com.vlb.phonebook.App.agenda;

/**
 * Acá irá el menú principal del proyecto PhoneBook
 */
public class MenuPrincipal extends Menu {

    //// Constructores
    public MenuPrincipal() {
        // Llenar ArrayList con opciones
        this.opciones.add("Crear contacto nuevo");
        this.opciones.add("Mostrar lista de contactos");
        this.opciones.add("Ver detalles de un contacto");
        this.opciones.add("Editar un contacto");
        this.opciones.add("Eliminar un contacto");
        this.opciones.add("Salir");
    }

    //// Métodos
    /**
     * Método que muestra un menú con las opciones del gestor
     */
    public void desplegarMenu() {

        // Muestra el nombre del gestor con algo de decoración
        mostrarLogo();

        System.out.println("************\\\\Menú principal//************");

        // Muestra las opciones
        enumerarArrayList(opciones);

        eleccion = v.validarInt(1, opciones.size(),
                "Escoja una opción: ",
                "La opción ingresada no existe.");
    }

    /**
     * Método para llamar otros métodos dependiendo de lo que haya ingresado el usuario
     */
    public void switchMenu() {
        switch (eleccion) {
            case 1: //// "Crear contacto nuevo"
                agenda.crearContacto(); // recordar que agenda = App.agenda
                break;

            case 2: //// "Mostrar lista de contactos"
                // Verificar que hayan contactos guardados antes de usar
                if (agenda.getContactos().size() == 0) {
                    System.out.println("Todavía no ha guardado ningún contacto.");
                }
                else {
                    agenda.listarContactos();
                }
                break;

            case 3: //// "Ver detalles de un contacto"
                // Verificar que hayan contactos guardados antes de usar
                if (agenda.getContactos().size() == 0) {
                    System.out.println("Todavía no ha guardado ningún contacto.");
                }
                else {
                    agenda.mostrarContacto();
                }
                break;

            case 4: //// "Editar un contacto"
                // Verificar que hayan contactos guardados antes de usar
                if (agenda.getContactos().size() == 0) {
                    System.out.println("Todavía no ha guardado ningún contacto.");
                }
                else {
                    agenda.editarContacto();
                }
                break;

            case 5: //// "Eliminar un contacto"
                // Verificar que hayan contactos guardados antes de usar
                if (agenda.getContactos().size() == 0) {
                    System.out.println("Todavía no ha guardado ningún contacto.");
                }
                else {
                    agenda.eliminarContacto();
                }
                break;

            case 6: //// "Salir"
                App.seguir = !salir("programa"); // Si se escoge salir, no seguir con el menú principal
        }
    }
}
