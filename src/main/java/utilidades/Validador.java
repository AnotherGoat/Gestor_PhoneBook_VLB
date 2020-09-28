package utilidades;

import java.io.ByteArrayInputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Esta clase tiene métodos para validar entrada
 */
public class Validador {

    //// Constructores
    /**
     * Constructor de Validador. Es privado para que esta clase no pueda instanciarse
     */
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
}
