
// Importa la clase Scanner
import java.util.Scanner;
import java.util.ArrayList;

/** Acá ira el menú del proyecto PhoneBook y todo lo relacionado con él */
public class Menu {

    //// Atributos
    /**
     * Arreglo de Strings que contiene las opciones del menú
     */
    private ArrayList<String> opciones;
    /**
     * Scanner para recibir la entrada por teclado
     */
    private Scanner teclado = new Scanner(System.in);
    /**
     * Opción que ingresa el usuario, se usa en los métodos desplegarMenu y seleccionMenu
     */
    private int seleccion;
    private int seleccionContacto; //se usa en Switch case para la seleccion de numero de lista de contacto
    // Intanciar
    PhoneBook clasePhoneBook = new PhoneBook();

    //// Constructores
    public Menu(String opciones) {
        this.opciones = opciones;
    }


    //// Métodos
    /**
     * Metodo que muestra un menú con las opciones del gestor
     */
    private void desPliegueMenu() {
        System.out.println("******************************************");
        System.out.println("=========\\\\Gestor PhoneBook VLB//=========");
        System.out.println("******************************************");
        System.out.println("Menu de Selección:");

        // Muestra las opciones
        for (int i = 1; i <= opciones.size(); i++) {
            System.out.println(i + ".- " + opciones.get(i-1));
        }

        this.seleccion = validarInt();
    }

    /**
     * Metodo para la Seleccion de menú
     */
    private void seleccionMenu() {
        //Switch para la seleccion, tomando variable seleccion del metodo despliegueMenu
        switch (seleccion) {
            case 1:
                System.out.println("Usted ha seleccionado mostrar lista de contactos");
                //metodo mostrar contactos de clase agenda
                linea();
                break;
            case 2:
                System.out.println("Usted ha seleccionado ver un contacto");
                //metodo mostrar contacto enumerado
                System.out.println("Eliga el N° de lista del contacto que desea ver");
                seleccionContacto = validarInt(); //No olvidar Validar rango de numero de 0 a largo total de contactos
                linea();
                break:
            case 3:
                System.out.println("Usted ha seleccionado crear un contacto nuevo");
                //metodo crear contacto
                linea();
                break;
            case 4:
                System.out.println("Usted ha seleccionado editar un contacto");
                //metodo editar
                break;
            case 5:
                System.out.println("Usted ha seleccionado eliminar un contacto");
                //metodo eliminar
                linea();
                break;
            case 6:
                salir();
                linea();
                break;
            default:
                System.out.println("La opción ingresada no existe");
                linea();
        }
    }

    /**
     * Metodo salir
     */
    private void salir() {
        boolean valido = false;
        int a;
        do {
            System.out.println("¿Desea salir del programa? 1=Sí 0=No");
            a = validarInt();
            switch (eleccion) {
                case 1:
                    PhoneBook.seguir = false;
                    valido = true;
                    break;
                case 0:
                    valido = true;
                    break;
                default:
                    System.out.println("La opción ingresada no existe");
            }
        } while (!valido);
    }

    /**
     * Metodo de decoracion
     */
    private void linea() {
        System.out.println("------------------------------------------------");
    }

    //Validaciones

    /**
     * Valida entrada de tipo int
     */
    private int validarInt() {
        boolean repetir = true; // Boolean para repetir en caso de ingresar una letra o símbolo
        int a = 0; // Variable con la que se trabaja

        while (repetir) {
            try {
                System.out.print("Escoja una opción: ");
                a = this.teclado.nextInt();
                repetir = false;
            } catch (Exception e) {
                this.teclado.next();
                System.out.println("Error: " + e.getMessage() + ". Ingrese un número, por favor");
                repetir = true;
            }
        }

        return a;
    }

    //// Setters y Getters

    public String[] getOpciones() {
        return opciones;
    }

    public void setOpciones(String[] opciones) {
        this.opciones = opciones;
    }

}
