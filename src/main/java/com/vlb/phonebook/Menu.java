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
     * Validador usado en la clase Menu
     */
    protected final Validador v = new Validador();

    //// Constructores
    public Menu() {
    }

    public Menu(ArrayList<String> opciones) {
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
     * @return Boolean que le indica al programa si se quiere salir (true) o no (false)
     */
    public boolean salir(String palabra) {
        int a = v.validarInt(0, 1,
                "¿Desea salir del "+palabra+"? 1=Sí 0=No\nEscoja una opción: ",
                "La opción ingresada no existe.");

        return a == 1;
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

        System.out.println("Menú principal:");

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

/**
 * Acá irá el menú para editar contactos
 */
class MenuEditor extends Menu {

    //// Atributos
    /**
     * Contacto original de la agenda
     */
    private Contacto original;
    /**
     * Posicion del contacto original
     */
    private int posicionOriginal;
    /**
     * Contacto auxiliar, se usa para permitir elegir si guardar los cambios o no
     */
    private Contacto aux = new Contacto();

    //// Constructores
    public MenuEditor(Contacto original, int posicionOriginal) {
        // Llenar ArrayList con opciones
        this.opciones.add("Cambiar nombre");
        this.opciones.add("Editar números de celular");
        this.opciones.add("Editar números de casa");
        this.opciones.add("Editar números de trabajo");
        this.opciones.add("Editar direcciones");
        this.opciones.add("Editar e-mails");
        this.opciones.add("Salir");

        // Tomar contacto que se va a editar (paso por referencia)
        this.original = original;

        // Copia el contacto original a uno auxiliar (paso por valor)
        agenda.copiarContacto(original, aux);

        this.posicionOriginal = posicionOriginal;
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

        // Se usan temporalmente para recibir entrada
        String s;
        int b;

        switch (eleccion) {
            case 1: //// "Cambiar nombre"
                switchNombre();
                break;

            case 2: //// "Editar números de celular"
                switchCelular();
                break;

            case 3: //// "Editar números de casa"
                switchCasa();
                break;

            case 4: //// "Editar números de trabajo"
                switchTrabajo();
                break;

            case 5: //// "Editar direcciones"
                switchDireccion();
                break;

            case 6: //// "Editar e-mails"
                switchEmail();
                break;

            case 7: //// "Salir"
                agenda.setSeguirEditando(!salirConfirmarCambios()); // Si se escoge salir, no seguir editando
        }
    }

    /**
     * Método con la opción 1 del menú, cambiar nombre
     */
    public void switchNombre(){
        String s;

        s = v.recibirString("Ingrese el nombre del contacto: ");
        aux.setNombre(s);
        System.out.println("El nombre fue cambiado con éxito.");
    }

    /**
     * Método con la opción 2 del menú, editar números de celular
     */
    public void switchCelular(){
        int b;

        b = v.validarInt(1, 999999999,
                "Ingrese el número de celular: ",
                "El número ingresado no es válido.");
        aux.setTelefonoCelular(b);
        System.out.println("El número de celular fue agregado con éxito.");
    }

    /**
     * Método con la opción 3 del menú, editar números de casa
     */
    public void switchCasa(){
        int b;

        b = v.validarInt(1, 999999999,
                "Ingrese el número de teléfono de casa: ",
                "El número ingresado no es válido.");
        aux.setTelefonoCasa(b);;
        System.out.println("El número de casa fue agregado con éxito.");
    }

    /**
     * Método con la opción 4 del menú, editar números de trabajo
     */
    public void switchTrabajo(){
        int b;

        b = v.validarInt(1, 999999999,
                "Ingrese el número de trabajo: ",
                "El número ingresado no es válido.");
        aux.setTelefonoTrabajo(b);
        System.out.println("El número de trabajo fue agregado con éxito.");
    }

    /**
     * Método con la opción 5 del menú, editar direcciones
     */
    public void switchDireccion(){
        String s;

        s = v.recibirString("Ingrese la dirección: ");
        aux.setDireccion(s);
        System.out.println("La dirección fue agregada con éxito.");
    }

    /**
     * Método con la opción 6 del menú, editar direcciones
     */
    public void switchEmail(){
        String s;

        s = v.recibirString("Ingrese la dirección de e-mail: ");
        aux.setEmail(s);
        System.out.println("El e-mail fue agregado con éxito.");
    }

    /**
     * Método que se usa para confirmar la salida del programa y los cambios realizados
     * @return Boolean que le indica al programa si el usuario quiere salir (true) o no (false)
     */
    public boolean salirConfirmarCambios() {
        boolean salirEditor = salir("menú de edición");

        // En caso de querer salir, hacer lo siguiente
        if(salirEditor) {
            System.out.println("¿Desea guardar los cambios realizados? 1=Sí 0=No");
            int b = v.validarInt(0, 1,
                    "Escoja una opción: ",
                    "La opción ingresada no existe.");

            switch (b) {
                case 1:
                    // Copia el contacto de vuelta
                    agenda.copiarContacto(aux, original);
                    // Vacía el contacto auxiliar
                    aux = null;

                    // Actualiza la lista de nombres de la agenda
                    agenda.getListaNombres().set(posicionOriginal, original.getNombre());

                    System.out.println("Los cambios han sido guardados.");
                    break;
                case 0:
                    System.out.println("Los cambios no se han guardado.");
            }
        }

        return salirEditor;
    }
}