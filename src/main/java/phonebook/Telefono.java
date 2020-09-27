package phonebook;

/**
 * Clase que contiene los datos de un teléfono (número y tipo)
 */
public class Telefono {

    //// Atributos
    /**
     * Número de teléfono, almacenado en un long
     */
    private long numero;
    /**
     * String con el tipo del teléfono
     * @see Telefono#lista_tipos
     */
    private String tipo;
    /**
     * Arreglo con la lista de tipos válidos (se escogíó no usar un enum)
     */
    final String[] lista_tipos = {"Celular", "Casa", "Trabajo"};

    //// Constructores
    /**
     * Construye un teléfono con los datos entregados
     * @param numero Número de teléfono, puede ser de hasta 15 dígitos
     * @param tipo String con el tipo de teléfono
     * @see Telefono#lista_tipos
     */
    public Telefono(long numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }

    //// Getters y Setters
    /**
     * Getter para obtener el número de teléfono
     * @return Long (clase primitiva) con el número de teléfono
     */
    public long getNumero() {
        return numero;
    }

    /**
     * Este getter retorna el tipo de teléfono
     * @return Tipo en forma de String
     */
    public String getTipo() {
        return tipo;
    }

    //// toString
    /**
     * Convierte los datos del teléfono a un String
     * @return Datos del teléfono
     * @see String
     */
    @Override
    public String toString() {
        return tipo+": "+numero;
    }
}
