
// Importa la clase Scanner
import java.util.Scanner;

public class Agenda {

    //// Atributos
    private String[] opciones = {"hola", "mundo", "Salir"}; // Arreglo con las opciones
    Scanner teclado = new Scanner(System.in); // Scanner para recibir la entrada por teclado
    int opcion; // Opción que ingresa el usuario

    //// Constructores
    public Agenda() {
    }

    public void menu(){
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

    //// Métodos de validación de entrada
    // Valida un int
    private int validarInt() {
        boolean repetir = true; // Boolean para repetir en caso de ingresar una letra o símbolo
        int a = 0; // Variable con la que se trabaja

        while (repetir) {
            try {
                System.out.print("Ingrese la opción: ");
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

}
