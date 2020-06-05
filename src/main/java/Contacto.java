
// Importa la clase ArrayList
import java.util.ArrayList;

/** Esta clase contiene los datos que se guardarán para cada contacto */
public class Contacto {

    //// Atributos
    /** Nombre del contacto */
    String nombre;
    /** Dirección de residencia del contacto */
    String direccion;


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
