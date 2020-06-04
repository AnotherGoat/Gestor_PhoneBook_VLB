
// Importa la clase Scanner

import java.util.Scanner;
import java.util.Arrays;

public class Menu {
    /*
    Aca ira el menú del proyecto phoneBook /coordinar con compañeros
     */

    //// Atributos

    /**
     * Arreglo de Strings que contiene las opciones del menú
     */
    private String[] opciones = {"Crear contacto", "", "salir"};
    /**
     * Scanner para recibir la entrada por teclado
     */
    Scanner teclado = new Scanner(System.in);
    /**
     * Opción que ingresa el usuario
     */
    int seleccion; //Se usa en el metodo despliegue menú y switch case
    int seleccionContacto; //se usa en Switch case para la seleccion de numero de lista de contacto
    int eleccion; //se usa en metodo salir para ingreso de datos
    //intanciar
    PhoneBook clasePhoneBook = new PhoneBook();

    //// Constructores
    public Menu() {
    }

    //// Métodos

    /**
     * Metodo que muestra un menú con las opciones del gestor
     */
    public void desPliegueMenu() {
        System.out.println("******************************************");
        System.out.println("=========\\\\Gestor PhoneBook VLB//=========");
        System.out.println("******************************************");
        System.out.println("Menu de Selección:");

        // Muestra las opciones
        for (int i = 1; i <= opciones.length; i++) {
            System.out.println(i + ".- " + opciones[i - 1]);
        }

        this.seleccion = validarInt();
    }

    /**
     * Metodo para la Seleccion de menú
     */
    public void seleccionMenu() {
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
            case 3:
                System.out.println("Usted ha seleccionado crear un contacto nuevo");
                //metodo crear contacto
                linea();
            case 4:
                System.out.println("Usted ha seleccionado editar un contacto");
                //metodo editar
            case 5:
                System.out.println("Usted ha seleccionado eliminar un contacto");
                //metodo eliminar
                linea();
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
    public void salir() {
        boolean valido = false;
        do {
            System.out.println("¿Desea salir del programa? 1=Sí 0=No");
            eleccion = validarInt();
            switch (eleccion) {
                case 1:
                    clasePhoneBook.seguir = false;
                    valido = true;
                    break;
                case 0:
                    valido = true;
                    break;
                default:
                    System.out.println("La opcion ingresada no existe");
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
