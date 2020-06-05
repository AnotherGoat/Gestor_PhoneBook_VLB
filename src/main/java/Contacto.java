import java.util.ArrayList;

/** Esta clase contiene los datos que se guardarán para cada contacto */
public class Contacto {

    //// Atributos
    /** Nombre del contacto */
    String nombreCompleto;
    /** Dirección de residencia del contacto */
    String direccion;


    //// Constructores
    public Contacto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    //// Métodos

    //// Getters y Setters
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }


    //// toString

}
