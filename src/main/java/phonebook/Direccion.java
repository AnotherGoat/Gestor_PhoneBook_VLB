package phonebook;

/**
 * Clase que contiene los datos de una dirección
 */
public class Direccion {

    //// Atributos
    /**
     * Ciudad donde vive
     */
    private String ciudad;
    /**
     * Calle donde se encuentra la casa
     */
    private String calle;
    /**
     * Número de la casa
     */
    private int numero;

    //// Constructores
    /**
     * Constructor vacío de Direccion, sólo usar en tests
     */
    public Direccion() {
    }

    /**
     * Construye una Direccion a partir de los datos entregados
     * @param ciudad String con el nombre de la ciudad
     * @param calle String con el nombre de la calle
     * @param numero String con el número de la dirección
     */
    public Direccion(String ciudad, String calle, int numero) {
        this.ciudad = ciudad;
        this.calle = calle;
        this.numero = numero;
    }

    /**
     * Construye una Direccion a partir de otra Direccion
     * @param d Objeto de clase Direccion que se quiere copiar
     * @see Direccion
     */
    public Direccion(Direccion d) {
        if (d != null) {
            this.ciudad = d.ciudad;
            this.calle = d.calle;
            this.numero = d.numero;
        }
    }

    //// Getters y Setters
    /**
     * Getter para obtener la ciudad
     * @return String con la ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Setter para cambiar la ciudad
     * @param ciudad Ciudad nueva
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Getter para obtener la calle
     * @return String con la calle
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Setter para cambiar la calle de la dirección
     * @param calle Calle nueva
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Getter para obtener el número de la dirección
     * @return Int con el número
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Setter para cambiar el número de la dirección
     * @param numero Int con el número nuevo
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    //// toString
    /**
     * Convierte los datos de la dirección a un String
     * @return String con los datos de la dirección
     * @see String
     */
    @Override
    public String toString() {
        return "Dirección: " + ciudad + ", " + calle + " #" + numero;
    }
}
