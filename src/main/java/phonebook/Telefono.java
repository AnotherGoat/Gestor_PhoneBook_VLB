package phonebook;

/**
 * Clase que contiene los datos de un teléfono (número y tipo)
 */
public class Telefono {

    //// Atributos
    /**
     * Número de teléfono
     */
    long numero;
    /**
     * Tipo de teléfono ("Celular", "Casa", "Trabajo")
     */
    String tipo;

    //// Constructores
    public Telefono(long numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }

    //// Getters y Setters
    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    /**
     * Este getter toma el tipo del Telefono y lo convierte en un String
     * @return Tipo en forma de String
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Este setter toma un String y lo convierte en el tipo
     * @param tipo String que tiene el nombre del tipo2
     */
    public void setTipo(String tipo) {
        // Siempre que el tipo no sea nulo...
        if(tipo!=null) {
            this.tipo = tipo;
        }
    }

    @Override
    public String toString() {
        return tipo+": "+numero;
    }
}
