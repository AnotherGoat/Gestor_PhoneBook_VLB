
// Importa la clase Scanner
import java.util.Scanner;
import java.util.Arrays;

public class Menu {
    /*
    Aca ira el menú del proyecto phoneBook /coordinar con compañeros
     */

    //// Atributos

    /** Arreglo de Strings que contiene las opciones del menú */
    private String[] opciones = {"Crear contacto", "", "salir"};
    /** Scanner para recibir la entrada por teclado */
    Scanner teclado = new Scanner(System.in);
    /** Opción que ingresa el usuario */
    int opcion;

    //// Constructores

    public Menu(){
    }

    //// Métodos

    /** Muestra un menú con las opciones del gestor */
    public void mostrarMenu(){
        System.out.println("******************************************");
        System.out.println("=========\\\\Gestor PhoneBook VLB//=========");
        System.out.println("******************************************");
        System.out.println("Opciones:");

        // Muestra las opciones
        for (int i=1; i<=opciones.length; i++){
            System.out.println(i+".- "+opciones[i-1]);
        }

        this.opcion = validarInt();
    }

    /** Valida entrada de tipo int */
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
                System.out.println("Error: "+e.getMessage()+". Ingrese un número, por favor");
                repetir = true;
            }
        }

        return a;
    }

    //// Setters y Getters

    public String[] getOpciones() {
        return opciones;
    }

    public void setOpciones(String[] op@ciones) {
        this.opciones = opciones;
    }

}
