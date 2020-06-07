
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
     * @param texto String que mostrará el programa antes de recibir entrada
     */
    public int validarInt(String texto) {
        boolean repetir = true; // Boolean para repetir en caso de ingresar una letra o símbolo
        int x = 0; // Variable con la que se trabaja

        while (repetir) {
            try {
                System.out.print(texto);
                x = this.teclado.nextInt();
                repetir = false;
            } catch (Exception e) {
                this.teclado.next();
                System.out.println("Error: " + e.getMessage() + ". Ingrese un número válido, por favor.");
                repetir = true;
                continue;
            }
        }
        return x;
    }

    /*
    /**
     * Valida entrada de tipo int
     * @param texto String que mostrará el programa antes de recibir entrada
     * @param variable Variable que se usará en la condición
     * @param condicion <p>Condición que se revisará después de validar el int.</p>
     *                  <p>Poner "true" si cualquier int funciona.</p>
     *                  <p>Cuidado: evitar poner una condición que siempre sea falsa o se creará un bucle infinito.</p>
     */
    /*
    public int validarIntconCondicion(String texto, String variable, Boolean condicion) {
        boolean repetir = true; // Boolean para repetir en caso de ingresar una letra o símbolo

        int x = 0; // Variable con la que se trabaja
        String textoAux = condicion.toString();
        System.out.println(textoAux);
        textoAux = textoAux.replaceAll(variable, "x");
        System.out.println(textoAux);
        condicion = condicion.parseBoolean(textoAux);
        System.out.println(condicion);

        while (repetir) {
            try {
                System.out.print(texto);
                x = this.teclado.nextInt();
            } catch (Exception e) {
                this.teclado.next();
                System.out.println("Error: " + e.getMessage() + ". Ingrese un número válido, por favor.");
                repetir = true;
                continue;
            }
            if(condicion){
                repetir = false;
            }
        }
        return x;
    }
    */

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
