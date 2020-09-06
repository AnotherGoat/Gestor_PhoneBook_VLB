package phonebook;

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
    private List<Telefono> lista_telefonos = new ArrayList<>();
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
    private List<String> lista_emails = new ArrayList<>();
    /**
     * ArrayList con los apodos con los que se conoce al contacto
     */
    private List<String> lista_apodos = new ArrayList<>();
    /**
     * ArrayList con las notas adicionales que se quieran agregar sobre el contacto
     */
    private List<String> lista_notas = new ArrayList<>();

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
            this.lista_telefonos.addAll(c.lista_telefonos);

            // Copia la dirección desde c, en una nueva instancia
            if (c.direccion != null) {
                this.direccion = new Direccion(c.direccion);
            }

            // Copia la fecha de cumpleaños desde c, en una nueva instancia
            if (c.fechaCumple != null) {
                this.fechaCumple = new FechaCumple(c.fechaCumple);
            }

            // Copia los emails desde c
            this.lista_emails.addAll(c.lista_emails);

            // Copia los apodos desde c
            this.lista_apodos.addAll(c.lista_apodos);

            // Copia las notas desde c
            this.lista_notas.addAll(c.lista_notas);
        }
    }

    //// Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Telefono> getLista_Telefonos() {
        return lista_telefonos;
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

    public List<String> getLista_Emails() {
        return lista_emails;
    }

    public List<String> getLista_Apodos() {
        return lista_apodos;
    }

    public List<String> getLista_Notas() {
        return lista_notas;
    }

    // toString
    /**
     * Método toString con un formato personalizado
     * @return String detallando los datos del contacto, no muestra los que todavía no existen
     */
    @Override
    public String toString() {
        StringBuilder s;
        s = new StringBuilder("Nombre: " + nombre);

        if (!lista_telefonos.isEmpty()) {
            s.append("\nTeléfonos guardados:");
            for(Telefono t: lista_telefonos) {
                s.append("\n  ").append(t.toString());
            }
        }

        if (direccion != null) {
            s.append("\n").append(direccion.toString());
        }

        if (fechaCumple != null) {
            s.append("\n").append(fechaCumple.toString());
        }

        if (!lista_emails.isEmpty()) {
            s.append("\nEmails guardados:");
            for(String e: lista_emails) {
                s.append("\n  ").append(e);
            }
        }

        if (!lista_apodos.isEmpty()) {
            s.append("\nApodos guardados:");
            for(String a: lista_apodos) {
                s.append("\n  ").append(a);
            }
        }

        if (!lista_notas.isEmpty()) {
            s.append("\nNotas guardadas:");
            for(String n: lista_notas) {
                s.append("\n  ").append(n);
            }
        }

        return s.toString();
    }
}

