package utilidades;

import java.io.ByteArrayInputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Esta clase tiene todos los métodos para validar y recibir entrada
 */
public class Validador {

    //// Constructores
    private Validador(){
        // Para que no pueda ser construido
    }

    //// Métodos
    /**
     * Verifica que un String ingresado puede ser convertido a int sin tirar ninguna excepción
     * @param entrada String que contiene la entrada del usuario
     * @return Boolean que indica si la entrada es int (true) o no (false)
     */
    public static boolean esInt(String entrada) {
        // Si la entrada es nula, retornar false automáticamente
        if(entrada == null){
            return false;
        }

        else {
            try {
                // Intenta convertir el String a un int
                int i = Integer.parseInt(entrada);
            } catch (NumberFormatException nfe) {
                // Si la conversión tira un error
                return false;
            }
        }

        return true;
    }

    /**
     * Revisa si el int del parámetro es un teléfono (no tiene más de 9 dígitos)
     * @param numero Número que se quiere verificar
     * @return Boolean que indica si el número es un número de teléfono válido o no
     */
    public static boolean esTelefono(int numero){
        if(numero>=1 && numero <=999999999){
            return true;
        }
        return false;
    }

    /**
     * Revisa si la entrada un número de teléfono válido
     * @param entrada String que representa la entrada del usuario
     * @return Boolean que indica si el número es un número de teléfono válido o no
     */
    public static boolean esNumeroTelefonico(String entrada){
        if (entrada == null){
            return false;
        }

        // El patrón es: puede tener "+" en la primera posición + entre 1 y 15 dígitos, en una sola línea
        Pattern pattern = Pattern.compile("^[+]?[0-9]{1,15}$");
        Matcher matcher = pattern.matcher(entrada);
        return matcher.matches();
    }

    /**
     * Este método verifica que el String del parámetro es un email válido
     * @param entrada Email que se quiere verificar
     * @return Retorna un boolean que indica si el email ingresado es válido (true) o no (false)
     */
    public static boolean esEmail (String entrada) {
        if(entrada == null){
            return false;
        }

        Pattern pattern = Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
        Matcher matcher = pattern.matcher(entrada);
        return matcher.matches();
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
