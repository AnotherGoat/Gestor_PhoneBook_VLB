
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

    //// Constructores
    public Menu(ArrayList opciones) {
        this.opciones = opciones;
    }

    //// Métodos
    /**
     * Metodo que muestra un menú con las opciones del gestor
     */
    public void desplegarMenu() {
        System.out.println("******************************************");
        System.out.println("=========\\\\Gestor PhoneBook VLB//=========");
        System.out.println("******************************************");
        System.out.println("Menu de selección:");

        // Muestra las opciones
        for (int i = 1; i <= opciones.size(); i++) {
            System.out.println(i + ".- " + opciones.get(i-1));
        }

        this.seleccion = validarInt();
    }

    /**
     * Método para tomar la selección en el menú principal
     */
    public void switchMenu() {
        //Switch para la selección, tomando variable seleccion del método desplegarMenu
        switch (seleccion) {
            case 1:
                if(PhoneBook.agenda.contactos.size() == 0){
                    System.out.println("Todavía no ha guardado ningún contacto.");
                }
                else {
                    //metodo mostrar contactos de clase agenda
                }
                break;
            case 2:
                if(PhoneBook.agenda.contactos.size() == 0){
                    System.out.println("Todavía no ha guardado ningún contacto.");
                }
                else{
                    //metodo mostrar contacto enumerado
                    System.out.println("Eliga el N° de lista del contacto que desea ver");
                    seleccionContacto = validarInt(); //No olvidar Validar rango de numero de 0 a largo total de contactos
                }
                break;
            case 3:
                PhoneBook.agenda.crearContacto();
                break;
            case 4:
                if(PhoneBook.agenda.contactos.size() == 0){
                    System.out.println("Todavía no ha guardado ningún contacto.");
                }
                else{
                    //metodo editar
                }
                break;
            case 5:
                if(PhoneBook.agenda.contactos.size() == 0){
                    System.out.println("Todavía no ha guardado ningún contacto.");
                }
                else {
                    //metodo eliminar
                    System.out.println("");
                }
                break;
            case 6:
                salir();
                break;
            default:
                System.out.println("La opción ingresada no existe.");
        }
    }

    /**
     * Método que se usa para confirmar la salida del programa
     */
    private void salir() {
        boolean valido = false;
        int a;
        do {
            System.out.println("¿Desea salir del programa? 1=Sí 0=No");
            a = validarInt();
            switch (a) {
                case 1:
                    PhoneBook.seguir = false;
                case 0:
                    valido = true;
                    break;
                default:
                    System.out.println("La opción ingresada no existe.");
            }
        } while (!valido);
    }

    // Validaciones

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
                System.out.println("Error: " + e.getMessage() + ". Ingrese un número válido, por favor.");
                repetir = true;
            }
        }

        return a;
    }

    //// Setters y Getters

}
