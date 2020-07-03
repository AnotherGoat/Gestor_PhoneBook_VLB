package com.vlb.phonebook;

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
    public Validador() {
        this.teclado = new Scanner(System.in);
    }

    //// Métodos
    /**
     * Valida entrada de tipo int
     * @param texto String que mostrará el programa antes de recibir entrada
     * @return Int ingresado
     */
    public int validarInt(String texto) {
        boolean repetir = true; // Boolean para repetir en caso de ingresar un símbolo
        int x = 0; // Variable con la que se trabaja

        while (repetir) {
            // Crea nueva instancia del teclado, para evitar errores
            this.teclado = new Scanner(System.in);

            try {
                System.out.print(texto);
                x = this.teclado.nextInt();
                repetir = false;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage() + ". Ingrese un número válido, por favor.");
                repetir = true;
            }
        }
        return x;
    }

    /**
     * Valida entrada de tipo int y se asegura de que esté dentro de un rango
     * @param min Valor mínimo que se acepta como válido
     * @param max Valor máximo que se acepta como válido
     * @param texto String que mostrará el programa antes de recibir entrada
     * @param mensajeError Mensaje de error en caso de que no se cumpla la condición
     * @return Int ingresado, que está entre los valores de los parámetros
     */
    public int validarInt(int min, int max, String texto, String mensajeError) {
        boolean repetir = true; // Boolean para repetir en caso de ingresar una letra o símbolo
        int x = 0; // Variable con la que se trabaja

        while(repetir) {
            // Crea nueva instancia del teclado, para evitar errores
            this.teclado = new Scanner(System.in);

            try {
                System.out.print(texto);
                x = this.teclado.nextInt();
                repetir = false;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage() + ". Ingrese un número válido, por favor.");
                repetir = true;
                continue;
            }
            if(x<min || x>max){
                System.out.println(mensajeError);
                repetir = true;
            }
        }
        return x;
    }

    /**
     * Caso específico de validarInt, se usa para validar un número de teléfono
     * @return Número de teléfono válido, de no más de 9 dígitos
     */
    public int validarNumeroTelefono(){
        return validarInt(1, 999999999,
                "Ingrese el número de teléfono: ",
                "El número de teléfono ingresado no es válido.");
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
     * Este método se usa para validar un email
     * @return Email ingresado, después de haber sido validado
     */
    public String validarEmail(){
        // Crea nueva instancia del teclado, para evitar errores
        this.teclado = new Scanner(System.in);

        String entrada = "";

        do{
            System.out.print("Ingrese el email: ");
            entrada = this.teclado.nextLine(); // Pide la dirección de email

            if(!esEmailValido(entrada)){ // Si la entrada no es válida, muestra un mensaje de error
                System.out.println("Error: No ha ingresado un email válido");
            }
        }while(esEmailValido(entrada));

        return entrada; // Retorna el email ingresado
    }

    /**
     * Este método verifica que el String del parámetro es un email válido
     * @param email Email que se quiere verificar
     * @return Retorna un boolean que indica si el email ingresado es válido (true) o no (false)
     */
    public Boolean esEmailValido (String email) {
        if(email!=null) {
            Pattern pattern = Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
            Matcher matcher = pattern.matcher(email);
            return matcher.matches();
        }
        return false;
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

    /**
     * Versión simple del try-catch usado en validarInt, se usa para las pruebas unitarias
     * @param texto String que mostrará el programa antes de recibir entrada
     * @return Int ingresado, en caso de ingresar un símbolo retorna -1
     */
    public int tryCatchInt(String texto){
        int x = -1; // Variable con la que se trabaja

        // Crea nueva instancia del teclado, para evitar errores
        this.teclado = new Scanner(System.in);

        try {
            System.out.print(texto);
            x = this.teclado.nextInt();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + ". Ingrese un número válido, por favor.");
        }

        return x;
    }
}
