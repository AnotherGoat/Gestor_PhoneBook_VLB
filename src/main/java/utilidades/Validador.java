package utilidades;

import java.io.ByteArrayInputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    /**
     * Constructor de clase Validador (instancia su Scanner otra vez para evitar errores)
     */
    public Validador() {
        this.teclado = new Scanner(System.in);
    }

    //// Métodos
    /**
     * Verifica que un String ingresado puede ser convertido a int sin tirar ninguna excepción
     * @param entrada String que contiene la entrada del usuario
     * @return Un boolean que indica si la entrada es int (true) o no (false)
     */
    public boolean esInt(String entrada) {
        // Si la entrada es nula, retornar false automáticamente
        if(entrada == null){
            return false;
        }

        else {
            try {
                // Intenta convertir el String a un int
                int i = Integer.parseInt(entrada);
            } catch (NumberFormatException nfe) {
                // Si la conversión tira un err
                System.out.println("Error: NumberFormatException. Ingrese un número válido, por favor.");
                return false;
            }
        }
        return true;
    }

    /**
     * Valida entrada de tipo int, y la sigue pidiendo hasta que se haya ingresado un int
     * @param texto String que mostrará el programa antes de recibir entrada
     * @return Int ingresado
     */
    public int validarInt(String texto) {
        String entrada; // String donde se almacena la entrada

        do {
            // Crea nueva instancia del Scanner, para evitar errores
            this.teclado = new Scanner(System.in);

            // Muestra el texto que se pasó como parámetro
            System.out.print(texto);
            // Toma la entrada del usuario
            entrada = this.teclado.nextLine();

        } while(!esInt(entrada)); // Lo vuelve a repetir si la entrada no es un int

        return Integer.parseInt(entrada);
    }

    /**
     * Valida entrada de tipo int y se asegura de que esté dentro de un rango
     * @param min Valor mínimo que se acepta como válido
     * @param max Valor máximo que se acepta como válido
     * @param texto String que mostrará el programa antes de recibir entrada
     * @param mensajeError Mensaje de error en caso de que no se cumpla la condición
     * @return Int ingresado, que está entre los valores de los parámetros
     */
    public int validarIntEntre(int min, int max, String texto, String mensajeError) {
        int numero;

        do{
            // Se asegura de que el número sea un int
            numero = validarInt(texto);

            // Si el número no está dentro del rango de los parámetros, muestra un mensaje de error y...
            if(numero<min || numero>max){
                System.out.println(mensajeError);
            }

            // Repite el proceso
        } while(numero<min || numero>max);

        // Retorna el número válido
        return numero;
    }

    /**
     * Revisa si el int del parámetro es un teléfono (no tiene más de 9 dígitos)
     * @param numero Número que se quiere verificar
     * @return Boolean que indica si el número es un número de teléfono válido o no
     */
    public boolean esTelefono(int numero){
        if(numero>=1 && numero <=999999999){
            return true;
        }
        return false;
    }

    /**
     * Caso específico de validarIntEntre, se usa para validar un número de teléfono
     * @return Número de teléfono válido, de no más de 9 dígitos
     */
    public int validarNumeroTelefono(){
        int numero;

        do{
            // Se asegura de que el número sea un int
            numero = validarInt("Ingrese un número de teléfono: ");

            // Si no es un número de teléfono válido...
            if(!esTelefono(numero)){
                System.out.println("Error: Por favor ingrese un número de teléfono válido");
            }

            // Repite el proceso
        } while(!esTelefono(numero));

        // Retorna el número válido
        return numero;
    }

    /**
     * Toma entrada de tipo String (no necesita validación)
     * @param texto String que mostrará el programa antes de recibir entrada
     * @return String ingresado
     */
    public String recibirString(String texto){
        // Crea nueva instancia del teclado, para evitar errores
        this.teclado = new Scanner(System.in);

        System.out.print(texto);
        return this.teclado.nextLine();
    }

    /**
     * Este método verifica que el String del parámetro es un email válido
     * @param email Email que se quiere verificar
     * @return Retorna un boolean que indica si el email ingresado es válido (true) o no (false)
     */
    public Boolean esEmail (String email) {
        if(email!=null) {
            Pattern pattern = Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
            Matcher matcher = pattern.matcher(email);
            return matcher.matches();
        }
        return false;
    }

    /**
     * Este método se usa para validar un email
     * @return Email ingresado, después de haber sido validado
     */
    public String validarEmail(){
        // Crea nueva instancia del teclado, para evitar errores
        this.teclado = new Scanner(System.in);

        String entrada;

        do{
            System.out.print("Ingrese el email: ");
            entrada = this.teclado.nextLine(); // Pide la dirección de email

            if(!esEmail(entrada)){ // Si la entrada no es válida, muestra un mensaje de error
                System.out.println("Error: No ha ingresado un email válido");
            }
        }while(!esEmail(entrada));

        return entrada; // Retorna el email ingresado
    }

    //// Métodos que sólo se usan en las pruebas unitarias
    /**
     * Método para simular entrada de usuario en los tests
     * @param entrada String que representa la entrada del usuario
     */
    public void simularInput(String entrada){
        if(entrada!=null) {
            ByteArrayInputStream in = new ByteArrayInputStream(entrada.getBytes());
            System.setIn(in);
        }
    }
}
