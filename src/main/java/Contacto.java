
// Importa la clase ArrayList
import java.util.ArrayList;
// Importa la clase Date
import java.util.Date;

/** Esta clase contiene los datos que se guardarán para cada contacto */
public class Contacto {

    //// Atributos
    /** Nombre del contacto */
    String nombre;
    /** Número de celular del contacto */
    int telefonoCelular;
    /** Número de teléfono de la casa del contacto */
    int telefonoCasa;
    /** Número de teléfono de trabajo del contacto */
    int telefonoTrabajo;
    /** Dirección de residencia del contacto */
    String direccion;
    /** Dirección de correo electrónico del contacto */
    String correoElectronico;
    /** Sobrenombre con el que se conoce al contacto */
    String sobrenombre;
    /** Fecha de cumpleaños del contacto */
    Date fechaCumple;
    /** Notas adicionales que se quieran agregar sobre el contacto */
    String notas;

    //// Constructores
    public Contacto(String nombre) {
        this.nombre = nombre;
    }

    //// Métodos

    //// Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    //// toString
    @Override
    public String toString() {
        String s;
        s = "Nombre: " + nombre;

        if(direccion!=null){
            s+="\nDirección: " + direccion;
        }

        return s;
    }
}
