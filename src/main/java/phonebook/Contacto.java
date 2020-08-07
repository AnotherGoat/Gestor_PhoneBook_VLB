package phonebook;

// Importa la clase ArrayList (todavía no se usa en esta clase)
import java.util.List;
import java.util.ArrayList;

/**
 * Esta clase contiene los datos que se guardarán para cada contacto
 */
public class Contacto {

    //// Atributos
    /**
     * Nombre del contacto
     */
    private String nombre;
    /**
     * ArrayList con los números de teléfono del contacto
     */
    private List<Telefono> telefonos = new ArrayList<>();
    /**
     * Dirección de residencia del contacto
     */
    private Direccion direccion;
    /**
     * Fecha de cumpleaños del contacto
     */
    private FechaCumple fechaCumple;
    /**
     * ArrayList con los emails del contacto
     */
    private List<String> emails = new ArrayList<>();
    /**
     * ArrayList con los apodos con los que se conoce al contacto
     */
    private List<String> apodos = new ArrayList<>();
    /**
     * ArrayList con las notas adicionales que se quieran agregar sobre el contacto
     */
    private List<String> notas = new ArrayList<>();

    //// Constructores
    public Contacto(){
    }

    public Contacto(String nombre) {
        this.nombre = nombre;
    }

    // Constructor para copiar un contacto
    public Contacto(Contacto c){
        if(c!=null) {
            // Copia el nombre desde c
            this.nombre = c.nombre;

            // Copia los telefonos desde c
            this.telefonos.addAll(c.telefonos);

            // Copia la dirección desde c, en una nueva instancia
            if (c.direccion != null) {
                this.direccion = new Direccion(c.direccion);
            }

            // Copia la fecha de cumpleaños desde c, en una nueva instancia
            if (c.fechaCumple != null) {
                this.fechaCumple = new FechaCumple(c.fechaCumple);
            }

            // Copia los emails desde c
            this.emails.addAll(c.emails);

            // Copia los apodos desde c
            this.apodos.addAll(c.apodos);

            // Copia las notas desde c
            this.notas.addAll(c.notas);
        }
    }

    //// Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Telefono> getTelefonos() {
        return telefonos;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public FechaCumple getFechaCumple() {
        return fechaCumple;
    }

    public void setFechaCumple(FechaCumple fechaCumple) {
        this.fechaCumple = fechaCumple;
    }

    public List<String> getEmails() {
        return emails;
    }

    public List<String> getApodos() {
        return apodos;
    }

    public List<String> getNotas() {
        return notas;
    }

    /**
     * Método toString con un formato personalizado
     * @return String detallando los datos del contacto, no muestra los que todavía no existen
     */
    @Override
    public String toString() {
        StringBuilder s;
        s = new StringBuilder("Nombre: " + nombre);

        if (telefonos.size() != 0) {
            s.append("\nTeléfonos guardados:");
            for(Telefono t: telefonos) {
                s.append("\n  "+t.toString());
            }
        }

        if (direccion != null) {
            s.append("\n" + direccion.toString());
        }

        if (fechaCumple != null) {
            s.append("\n" + fechaCumple.toString());
        }

        if (emails.size() != 0) {
            s.append("\nEmails guardados:");
            for(String e: emails) {
                s.append("\n  "+e);
            }
        }

        if (apodos.size() != 0) {
            s.append("\nApodos guardados:");
            for(String a: apodos) {
                s.append("\n  "+a);
            }
        }

        if (notas.size() != 0) {
            s.append("\nNotas guardadas:");
            for(String n: notas) {
                s.append("\n  "+n);
            }
        }

        return s.toString();
    }
}

