package phonebook;

import lanzador.Principal;

/**
 * Acá irá el menú principal del proyecto PhoneBook
 */

/*Relacion de Dependencia: MenuPrincipal usa recursos de las clase Agenda, es decir, depende de las funcionalidades de la clase
  y no de forma inversa,es decir, la otra clase no necesita de la clase MenuValidador
  Relacion de Generalización(Herencia): La clase MenuPrincipal es una clase hija de la clase Menu,por lo tanto, la clase hija hereda
  recursos de la clase padre excepto los privados*/
public class MenuPrincipal extends Menu {

    //// Constructores
    public MenuPrincipal() {
        // Nombre
        this.nombreMenu = "programa";

        // Muestra el menú principal del gestor y lo repite hasta que "seguir" sea false
        this.seguir = true;
        do {
            // Llenar ArrayList con opciones
            llenarOpciones();
            // Mostrar menú
            desplegarMenu();
            // Pedir opción al usuario
            switchMenu();
            // Limpiar las opciones
            opciones.clear();
        } while (this.seguir);
    }

    //// Métodos
    /**
     * Método que llena las opciones del menú
     */
    public void llenarOpciones() {
        opciones.add("Crear un contacto nuevo");

        // Si hay contactos guardados
        if(!Principal.agenda.getLista_Contactos().isEmpty()){
            opciones.add("Mostrar lista de contactos");
            opciones.add("Ver datos de un contacto");
            opciones.add("Editar un contacto");
            opciones.add("Eliminar un contacto");
        }

        // Si no hay contactos guardados
        else {
            opciones.add("Mostrar lista de contactos (no disponible)");
            opciones.add("Ver datos de un contacto (no disponible)");
            opciones.add("Editar un contacto (no disponible)");
            opciones.add("Eliminar un contacto (no disponible)");
        }

        opciones.add("Salir");
    }

    /**
     * Método que muestra un menú con las opciones del gestor
     */
    private void desplegarMenu() {

        // Muestra el nombre del gestor con algo de decoración
        mostrarLogo();

        System.out.println("Menú principal:");

        // Muestra las opciones
        System.out.println(enumerarListaString(opciones));

        //eleccion = v.validarIntEntre(1, opciones.size(),
        //        "Escoja una opción: ",
        //        "La opción ingresada no existe.");
    }

    /**
     * Método para llamar otros métodos dependiendo de lo que haya ingresado el usuario
     */
    private void switchMenu() {
        switch (eleccion) {
            case 1: //// "Crear contacto nuevo"
                //## agenda.crearContacto(); // recordar que agenda = App.agenda
                break;

            case 2: //// "Mostrar lista de contactos"
                // Verificar que hayan contactos guardados antes de usar
                if (Principal.agenda.getLista_Contactos().isEmpty()) {
                    System.out.println("Todavía no ha guardado ningún contacto.");
                }
                else {
                    Principal.agenda.listarContactos();
                }
                break;

            case 3: //// "Ver detalles de un contacto"
                // Verificar que hayan contactos guardados antes de usar
                if (Principal.agenda.getLista_Contactos().isEmpty()) {
                    System.out.println("Todavía no ha guardado ningún contacto.");
                }
                else {
                    Principal.agenda.mostrarContacto();
                }
                break;

            case 4: //// "Editar un contacto"
                // Verificar que hayan contactos guardados antes de usar
                if (Principal.agenda.getLista_Contactos().isEmpty()) {
                    System.out.println("Todavía no ha guardado ningún contacto.");
                }
                else {
                    Principal.agenda.editarContacto();
                }
                break;

            case 5: //// "Eliminar un contacto"
                // Verificar que hayan contactos guardados antes de usar
                if (Principal.agenda.getLista_Contactos().isEmpty()) {
                    System.out.println("Todavía no ha guardado ningún contacto.");
                }
                else {
                    // Principal.agenda.eliminarContacto();
                }
                break;

            case 6: //// "Salir"
                //this.seguir = !salir(); // Si se escoge salir, no seguir con el menú principal
        }
    }
}
