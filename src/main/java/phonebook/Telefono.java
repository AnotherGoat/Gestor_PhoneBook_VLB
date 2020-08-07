package phonebook;

/**
 * Clase que contiene los datos de un teléfono (número y tipo)
 */
public class Telefono {

    //// Atributos
    /**
     * Número de teléfono
     */
    int numero;
    /**
     * Tipo de teléfono ("Celular, "Fijo", "Trabajo")
     */
    String tipo;

    //// Constructores
    public Telefono(int numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }

    //// Getters y Setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return tipo + ": " + numero;
    }
}

enum Tipo{
    CELULAR,
    FIJO,
    TRABAJO;
}