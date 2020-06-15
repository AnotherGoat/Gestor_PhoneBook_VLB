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
     * Número de celular del contacto
     */
    private int telefonoCelular;
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
        this.telefonoCelular = -1;
        this.telefonoFijo = -1;
        this.telefonoTrabajo = -1;
    }

    public Contacto(String nombre) {
        this.nombre = nombre;

        // Inician en -1 para no mostrarlos en el toString()
        this.telefonoCelular = -1;
        this.telefonoFijo = -1;
        this.telefonoTrabajo = -1;
    }

    // Constructor para copiar un contacto
    public Contacto(Contacto c){
        if(c!=null){
            this.nombre = c.getNombre();
            this.telefonoCelular = c.getTelefonoCelular();
            this.telefonoFijo = c.getTelefonoFijo();
            this.telefonoTrabajo = c.getTelefonoTrabajo();
            this.direccion = c.getDireccion();
            this.email = c.getEmail();
            this.apodo = c.getApodo();
            this.fechaCumple = c.getFechaCumple();
            this.notas = c.getNotas();
        }
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
        String s;
        s = "Nombre: " + nombre;

        if (telefonoCelular != -1) {
            s += "\nTeléfono Celular: " + telefonoCelular;
        }
        if (telefonoFijo != -1) {
            s += "\nTeléfono Fijo: " + telefonoFijo;
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
            s += "\nApodo: " + apodo;
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
