package phonebook;

// Importa la agenda de uso "global"
import static lanzador.Principal.agenda;

/**
 * Acá irá el menú principal del proyecto PhoneBook
 */
public class MenuPrincipal extends Menu {

    //// Constructores
    public MenuPrincipal() {
        // Nombre
        this.nombreMenu = "programa";

        // Llenar ArrayList con opciones


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
        this.opciones.add("Crear un contacto nuevo");

        if(agenda.getLista_Contactos().isEmpty()){
            this.opciones.add("Mostrar lista de contactos (No disponible)");
            this.opciones.add("Ver datos de un contacto (No disponible)");
            this.opciones.add("Editar un contacto (No disponible)");
            this.opciones.add("Eliminar un contacto (No disponible)");
        }
        else {
            this.opciones.add("Mostrar lista de contactos");
            this.opciones.add("Ver datos de un contacto");
            this.opciones.add("Editar un contacto");
            this.opciones.add("Eliminar un contacto");
        }
        this.opciones.add("Salir");
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

        eleccion = v.validarInt(1, opciones.size(),
                "Escoja una opción: ",
                "La opción ingresada no existe.");
    }

    /**
     * Método para llamar otros métodos dependiendo de lo que haya ingresado el usuario
     */
    private void switchMenu() {
        switch (eleccion) {
            case 1: //// "Crear contacto nuevo"
                agenda.crearContacto(); // recordar que agenda = App.agenda
                break;

            case 2: //// "Mostrar lista de contactos"
                // Verificar que hayan contactos guardados antes de usar
                if (agenda.getLista_Contactos().isEmpty()) {
                    System.out.println("Todavía no ha guardado ningún contacto.");
                }
                else {
                    agenda.listarContactos();
                }
                break;

            case 3: //// "Ver detalles de un contacto"
                // Verificar que hayan contactos guardados antes de usar
                if (agenda.getLista_Contactos().isEmpty()) {
                    System.out.println("Todavía no ha guardado ningún contacto.");
                }
                else {
                    agenda.mostrarContacto();
                }
                break;

            case 4: //// "Editar un contacto"
                // Verificar que hayan contactos guardados antes de usar
                if (agenda.getLista_Contactos().isEmpty()) {
                    System.out.println("Todavía no ha guardado ningún contacto.");
                }
                else {
                    agenda.editarContacto();
                }
                break;

            case 5: //// "Eliminar un contacto"
                // Verificar que hayan contactos guardados antes de usar
                if (agenda.getLista_Contactos().isEmpty()) {
                    System.out.println("Todavía no ha guardado ningún contacto.");
                }
                else {
                    agenda.eliminarContacto();
                }
                break;

            case 6: //// "Salir"
                this.seguir = !salir(); // Si se escoge salir, no seguir con el menú principal
        }
    }
}
