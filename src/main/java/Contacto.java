
// Importa la clase ArrayList (todavía no se usa en esta clase)
import java.util.ArrayList;
// Importa la clase Date
import java.util.Date;

/**
 * Esta clase contiene los datos que se guardarán para cada contacto
 */
public class Contacto {

    //// Atributos
    /**
     * Nombre del contacto
     */
    String nombre;
    /**
     * Número de celular del contacto
     */
    int telefonoCelular;
    /**
     * Número de teléfono de la casa del contacto
     */
    int telefonoCasa;
    /**
     * Número de teléfono de trabajo del contacto
     */
    int telefonoTrabajo;
    /**
     * Dirección de residencia del contacto
     */
    String direccion;
    /**
     * Dirección de correo electrónico del contacto
     */
    String email;
    /**
     * Sobrenombre con el que se conoce al contacto
     */
    String apodo;
    /**
     * Fecha de cumpleaños del contacto
     */
    Date fechaCumple;
    /**
     * Notas adicionales que se quieran agregar sobre el contacto
     */
    String notas;

    //// Constructores
    public Contacto(){
        // Inician en -1 para no mostrarlos en el toString()
        this.telefonoCelular = -1;
        this.telefonoCasa = -1;
        this.telefonoTrabajo = -1;
    }

    public Contacto(String nombre) {
        this.nombre = nombre;

        // Inician en -1 para no mostrarlos en el toString()
        this.telefonoCelular = -1;
        this.telefonoCasa = -1;
        this.telefonoTrabajo = -1;
    }

    //// Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(int telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    public int getTelefonoCasa() {
        return telefonoCasa;
    }

    public void setTelefonoCasa(int telefonoCasa) {
        this.telefonoCasa = telefonoCasa;
    }

    public int getTelefonoTrabajo() {
        return telefonoTrabajo;
    }

    public void setTelefonoTrabajo(int telefonoTrabajo) {
        this.telefonoTrabajo = telefonoTrabajo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String correoElectronico) {
        this.email = correoElectronico;
    }

    public String getApodo() {
        return apodo;
    }

    public void setSobrenombre(String sobrenombre) {
        this.apodo = sobrenombre;
    }

    public Date getFechaCumple() {
        return fechaCumple;
    }

    public void setFechaCumple(Date fechaCumple) {
        this.fechaCumple = fechaCumple;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    /**
     * Método toString con un formato personalizado
     * @return String detallando los datos del contacto, no muestra los que todavía no existen
     */
    @Override
    public String toString() {
        String s;
        s = "Nombre: " + nombre;

        if (telefonoCelular != -1) {
            s += "\nTeléfono Celular: " + telefonoCelular;
        }
        if (telefonoCasa != -1) {
            s += "\nTeléfono Casa: " + telefonoCasa;
        }
        if (telefonoTrabajo != -1) {
            s += "\nTeléfono Trabajo: " + telefonoTrabajo;
        }
        if (direccion != null) {
            s += "\nDirección: " + direccion;
        }
        if (email != null) {
            s += "\nE-mail: " + email;
        }
        if (apodo != null) {
            s += "\nSobrenombre: " + apodo;
        }
        if (fechaCumple != null) {
            s += "\nFecha de cumpleaños: " + fechaCumple;
        }
        if (notas != null) {
            s += "\nNotas adicionales: " + notas;
        }

        return s;
    }
}
