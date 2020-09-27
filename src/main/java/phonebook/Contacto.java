package phonebook;

import java.util.List;
import java.util.ArrayList;

/**
 * Esta clase representa un contacto y contiene los datos que se guardarán para cada uno
 */
public class Contacto {

    //// Atributos
    /**
     * Nombre del contacto
     */
    private String nombre;
    /**
     * ArrayList con los números de teléfono del contacto
     * @see Telefono
     */
    private List<Telefono> lista_telefonos = new ArrayList<>();
    /**
     * Dirección de residencia del contacto
     * @see Direccion
     */
    private Direccion direccion;
    /**
     * Fecha de cumpleaños del contacto
     * @see FechaCumple
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
    /**
     * String con la ruta de la foto del contacto
     */
    private String rutaFoto;

    //// Constructores
    /**
     * Constructor por defecto de la clase Contacto, no se debería usar fuera de tests
     */
    public Contacto() {
    }

    /**
     * Constructor básico de un objeto de la clase Contacto, el cual sólo necesita un nombre para existir
     * @param nombre String que contiene el nombre del contacto
     */
    public Contacto(String nombre) {
        this.nombre = nombre;
        this.rutaFoto = "";
    }

    /**
     * Constructor para crear una instancia de un contacto con los mismos datos que tiene otro contacto
     * @param c Contacto que se quiere copiar
     * @see Contacto
     */
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

            // Copia la ruta de la foto
            this.rutaFoto=c.rutaFoto;
        }
    }

    //// Getters y Setters
    /**
     * Getter para obtener el nombre del contacto
     * @return String con el nombre del contacto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter para cambiar el nombre del contacto
     * @param nombre String con el nombre nuevo que se le quiere dar al contacto
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter para obtener la lista de teléfonos del contacto
     * @return ArrayList con la lista de teléfonos del contacto
     * @see Telefono
     */
    public List<Telefono> getLista_Telefonos() {
        return lista_telefonos;
    }

    /**
     * Getter para obtener la dirección del contacto
     * @return Dirección del contacto, en un objeto de clase Direccion
     * @see Direccion
     */
    public Direccion getDireccion() {
        return direccion;
    }

    /**
     * Setter para cambiar la dirección del contacto
     * @param direccion Objeto de la clase Direccion con la dirección nueva
     * @see Direccion
     */
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    /**
     * Getter para obtener la fecha de cumpleaños del contacto
     * @return FechaCumple con la fecha de cumpleaños del contacto
     * @see FechaCumple
     */
    public FechaCumple getFechaCumple() {
        return fechaCumple;
    }

    /**
     * Setter para cambiar la fecha de cumpleaños del contacto
     * @param fechaCumple Objeto de la clase FechaCumple con la fecha nueva
     * @see FechaCumple
     */
    public void setFechaCumple(FechaCumple fechaCumple) {
        this.fechaCumple = fechaCumple;
    }

    /**
     * Getter para obtener la lista de emails del contacto
     * @return ArrayList con la lista de emails del contacto
     */
    public List<String> getLista_Emails() {
        return lista_emails;
    }

    /**
     * Getter para obtener la lista de apodos del contacto
     * @return ArrayList con la lista de apodos del contacto
     */
    public List<String> getLista_Apodos() {
        return lista_apodos;
    }

    /**
     * Getter para obtener la lista de notas sobre el contacto
     * @return ArrayList con la lista de notas sobre el contacto
     */
    public List<String> getLista_Notas() {
        return lista_notas;
    }

    /**
     * Getter para obtener la ruta donde se guarda la foto del contacto
     * @return String con la ruta donde se guarda la foto
     */
    public String getRutaFoto() {
        return rutaFoto;
    }

    /**
     * Setter para cambiar la ruta de la foto del contacto
     * @param rutaFoto String que contiene la ruta nueva
     */
    public void setRutaFoto(String rutaFoto) {
        this.rutaFoto = rutaFoto;
    }

    //// toString
    /**
     * Método toString con un formato personalizado, usando un StringBuilder
     * @return String detallando los datos del contacto, no muestra los que todavía no existen
     * @see Direccion#toString()
     * @see FechaCumple#toString()
     */
    @Override
    public String toString() {
        StringBuilder s;
        s = new StringBuilder("Nombre: " + nombre);

        if (!lista_telefonos.isEmpty()) {
            s.append("\nTeléfonos guardados:");
            for(Telefono t: lista_telefonos) {
                s.append("\n    ").append(t.toString());
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
                s.append("\n    ").append(e);
            }
        }

        if (!lista_apodos.isEmpty()) {
            s.append("\nApodos guardados:");
            for(String a: lista_apodos) {
                s.append("\n    ").append(a);
            }
        }

        if (!lista_notas.isEmpty()) {
            s.append("\nNotas guardadas:");
            for(String n: lista_notas) {
                s.append("\n    ").append(n);
            }
        }

        if (rutaFoto!=null && rutaFoto!=""){
            s.append("\nRuta foto: "+rutaFoto);
        }

        return s.toString();
    }
}

