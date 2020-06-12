package com.vlb.phonebook;

// Importa la clase ArrayList
import java.util.ArrayList;

// Importa la agenda "global"
import static com.vlb.phonebook.App.agenda;

/**
 * Clase con atributos y métodos para menús en general
 */
public class Menu {

    //// Atributos
    /**
     * Arreglo de Strings que contiene las opciones del menú
     */
    protected ArrayList<String> opciones = new ArrayList<>();
    /**
     * Opción que ingresa el usuario, se usa en los métodos desplegarMenu y switchMenu
     */
    protected int eleccion;
    /**
     * com.vlb.phonebook.Validador usado en la clase com.vlb.phonebook.Menu
     */
    protected final Validador v = new Validador();

    //// Constructores
    public Menu() {
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
     * Método para mostrar una lista numerada de los datos dentro de un ArrayList
     * @param al ArrayList que se quiere ordenar
     */
    public void enumerarArrayList(ArrayList<String> al){
        if(al != null) {
            for (int i = 1; i <= al.size(); i++) {
                System.out.println(i + ".- " + al.get(i - 1));
            }
        }
        else{
            System.out.println("Error: ArrayList nulo");
        }
    }

    /**
     * Método que se usa para confirmar la salida del programa
     * @return Boolean que le indica al programa si debe seguir funcionando (true) o no (false)
     */
    public boolean salir() {
        int a = v.validarInt(0, 1,
                "¿Desea salir del programa? 1=Sí 0=No\nEscoja una opción: ",
                "La opción ingresada no existe.");

        return a != 1;
    }

    //// Getters y Setters
    public int getEleccion() {
        return eleccion;
    }
}

/**
 * Acá irá el menú principal del proyecto PhoneBook
 */
class MenuPrincipal extends Menu {

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

        System.out.println("com.vlb.phonebook.Menu principal:");

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
        // Switch para la selección, tomando la variable eleccion del método desplegarMenu
        switch (eleccion) {
            case 1: //// "Crear contacto nuevo"
                agenda.crearContacto(); // recordar que agenda = com.vlb.phonebook.App.agenda
                break;

            case 2: //// "Mostrar lista de contactos"
                // Verificar que hayan contactos guardados antes de usar
                if (agenda.contactos.size() == 0) {
                    System.out.println("Todavía no ha guardado ningún contacto.");
                }
                else {
                    agenda.listarContactos();
                }
                break;

            case 3: //// "Ver detalles de un contacto"
                // Verificar que hayan contactos guardados antes de usar
                if (agenda.contactos.size() == 0) {
                    System.out.println("Todavía no ha guardado ningún contacto.");
                }
                else {
                    agenda.mostrarContacto();
                }
                break;

            case 4: //// "Editar un contacto"
                // Verificar que hayan contactos guardados antes de usar
                if (agenda.contactos.size() == 0) {
                    System.out.println("Todavía no ha guardado ningún contacto.");
                }
                else {
                    agenda.editarContacto();
                }
                break;

            case 5: //// "Eliminar un contacto"
                // Verificar que hayan contactos guardados antes de usar
                if (agenda.contactos.size() == 0) {
                    System.out.println("Todavía no ha guardado ningún contacto.");
                }
                else {
                    agenda.eliminarContacto();
                }
                break;

            case 6: //// "Salir"
                App.seguir = salir();
        }
    }
}

/**
 * Acá irá el menú para editar contactos
 */
class MenuEditor extends Menu {

    //// Constructores
    public MenuEditor() {
        // Llenar ArrayList con opciones
        this.opciones.add("Cambiar nombre");
        this.opciones.add("Editar números de celular");
        this.opciones.add("Editar números de casa");
        this.opciones.add("Editar números de trabajo");
        this.opciones.add("Editar direcciones");
        this.opciones.add("Editar e-mails");
        this.opciones.add("Salir");
    }

    //// Métodos
    /**
     * Método que muestra un menú con las opciones del gestor
     */
    public void desplegarMenu() {

        // Muestra el nombre del gestor con algo de decoración
        mostrarLogo();

        System.out.println("Menu de edición:");

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
        // Switch para la selección, tomando la variable eleccion del método desplegarMenu
        switch (eleccion) {
            case 1: //// "Cambiar nombre"
                break;

            case 2: //// "Editar números de celular"

                break;

            case 3: //// "Editar números de casa"

                break;

            case 4: //// "Editar números de trabajo"

                break;

            case 5: //// "Editar direcciones"
                break;

            case 6: //// "Editar e-mails"
                break;

            case 7: //// "Salir"
                App.seguir = salirConfirmarCambios();
        }
    }

    /**
     * Método que se usa para confirmar la salida del programa
     * @return Boolean que le indica al programa si debe seguir funcionando (true) o no (false)
     */
    public boolean salirConfirmarCambios() {
        return salir();
    }
}