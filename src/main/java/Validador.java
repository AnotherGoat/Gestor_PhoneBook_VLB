
import java.util.Scanner;

/**
 * Esta clase incluye todos los métodos para validar y recibir entrada
 */
public class Validador {

    //// Atributos
    /**
     * Scanner para recibir entrada por teclado;
     */
    private Scanner teclado;

    //// Constructores
    public Validador() {
        this.teclado = new Scanner(System.in);
    }

    //// Métodos

    /**
     * Valida entrada de tipo int
     * @param s String que mostrará el programa antes de recibir entrada
     */
    public int validarInt(String s) {
        boolean repetir = true; // Boolean para repetir en caso de ingresar una letra o símbolo
        int a = 0; // Variable con la que se trabaja

        while (repetir) {
            try {
                System.out.print(s);
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

    /**
     * Toma entrada de tipo String (no necesita validación)
     * @param s String que mostrará el programa antes de recibir entrada
     */
    public String recibirString(String s){
        // Crea nueva instancia del teclado, para evitar errores
        this.teclado = new Scanner(System.in);
        System.out.print(s);
        return this.teclado.nextLine();
    }

    //// Getters y Setters

    //// toString();
}
