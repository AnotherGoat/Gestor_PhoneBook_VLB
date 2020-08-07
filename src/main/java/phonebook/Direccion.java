package phonebook;

/**
 * Clase que contiene los datos de una dirección
 */
public class Direccion {

    //// Atributos
    /**
     * Ciudad donde vive
     */
    String ciudad;
    /**
     * Calle donde se encuentra la casa
     */
    String calle;
    /**
     * Número de la casa
     */
    int numero;

    //// Constructores
    public Direccion() {
    }

    public Direccion(String ciudad, String calle, int numero) {
        this.ciudad = ciudad;
        this.calle = calle;
        this.numero = numero;
    }

    public Direccion(Direccion d) {
        if (d != null) {
            this.ciudad = d.ciudad;
            this.calle = d.calle;
            this.numero = d.numero;
        }
    }

    //// Getters y Setters
    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Dirección: " + ciudad + ", " + calle + " #" + numero;
    }
}
