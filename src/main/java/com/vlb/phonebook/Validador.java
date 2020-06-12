package com.vlb.phonebook;

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
     * @return int ingresado
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
     * @param texto String que mostrará el programa antes de recibir entrada
     * @param min Valor mínimo que se acepta como válido
     * @param max Valor máximo que se acepta como válido
     * @param mensajeError Mensaje de error en caso de que no se cumpla la condición
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
     * Versión simple del try-catch usado en validarInt, se usa para las pruebas unitarias
     * @param texto String que mostrará el programa antes de recibir entrada
     * @return int ingresado, en caso de ingresar un símbolo retorna -1
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
