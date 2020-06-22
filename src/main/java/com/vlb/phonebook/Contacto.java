package com.vlb.phonebook;

// Importa la clase ArrayList (todavía no se usa en esta clase)
import java.util.List;
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
    private String nombre;
    /**
     * ArrayList con los números de celular del contacto
     */
    private ArrayList<Integer> telefonosCelular;
    /**
     * Número de teléfono fijo del contacto
     */
    private int telefonoFijo;
    /**
     * Número de teléfono de trabajo del contacto
     */
    private int telefonoTrabajo;
    /**
     * Dirección de residencia del contacto
     */
    private String direccion;
    /**
     * Dirección de correo electrónico del contacto
     */
    private String email;
    /**
     * Apodo con el que se conoce al contacto
     */
    private String apodo;
    /**
     * Fecha de cumpleaños del contacto
     */
    private Date fechaCumple;
    /**
     * Notas adicionales que se quieran agregar sobre el contacto
     */
    private String notas;

    //// Constructores
    public Contacto(){
        // Inician en -1 para no mostrarlos en el toString()
        this.telefonoFijo = -1;
        this.telefonoTrabajo = -1;
    }

    public Contacto(String nombre) {
        this.nombre = nombre;

        // Inician en -1 para no mostrarlos en el toString()
        this.telefonoFijo = -1;
        this.telefonoTrabajo = -1;
    }

    // Constructor para copiar un contacto
    public Contacto(Contacto c){
        if(c!=null){
            this.nombre = c.nombre;

            // Limpia los teléfonos registrados y luego los copia desde c
            this.telefonosCelular.clear();
            this.telefonosCelular.addAll(c.telefonosCelular);

            // Hace lo mismo con los otros ArrayList
            this.telefonoFijo = c.telefonoFijo;
            this.telefonoTrabajo = c.telefonoTrabajo;
            this.direccion = c.direccion;
            this.email = c.email;
            this.apodo = c.apodo;
            this.fechaCumple = c.fechaCumple;
            this.notas = c.notas;
        }
    }

    //// Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Integer> getTelefonosCelular() {
        return telefonosCelular;
    }

    public int getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(int telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
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

    public void setApodo(String apodo) {
        this.apodo = apodo;
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
        StringBuilder s;
        s = new StringBuilder("Nombre: " + nombre);

        if (telefonosCelular != null) {
            s.append("\nTeléfonos de Celular: ");
            for(int telefono : telefonosCelular){
                s.append("\n").append(telefono);
            }
        }

        if (telefonoFijo != -1) {
            s.append("\nTeléfono Fijo: ").append(telefonoFijo);
        }
        if (telefonoTrabajo != -1) {
            s.append("\nTeléfono Trabajo: ").append(telefonoTrabajo);
        }
        if (direccion != null) {
            s.append("\nDirección: ").append(direccion);
        }
        if (email != null) {
            s.append("\nE-mail: ").append(email);
        }
        if (apodo != null) {
            s.append("\nApodo: ").append(apodo);
        }
        if (fechaCumple != null) {
            s.append("\nFecha de cumpleaños: ").append(fechaCumple);
        }
        if (notas != null) {
            s.append("\nNotas adicionales: ").append(notas);
        }

        return s.toString();
    }
}


class Telefono {

}

class Direccion {

}