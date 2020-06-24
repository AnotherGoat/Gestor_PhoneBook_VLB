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
     * ArrayList con los números de teléfono del contacto
     */
    private List<Telefono> telefonos = new ArrayList<>();
    /**
     * Dirección de residencia del contacto
     */
    private Direccion direccion;
    /**
     * Dirección de correo electrónico del contacto
     */
    private String email;
    /**
     * Apodos con los que se conoce al contacto
     */
    private String apodo;
    /**
     * Fecha de cumpleaños del contacto
     */
    private Date fechaCumple = new Date();
    /**
     * Notas adicionales que se quieran agregar sobre el contacto
     */
    private String notas;

    //// Constructores
    public Contacto(){
    }

    public Contacto(String nombre) {
        this.nombre = nombre;
    }

    // Constructor para copiar un contacto
    public Contacto(Contacto c){
        if(c!=null){
            this.nombre = c.nombre;

            // Copia los telefonos desde c
            this.telefonos.addAll(c.telefonos);

            // Hace lo mismo con los otros ArrayList
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

    public List<Telefono> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<Telefono> telefonos) {
        this.telefonos = telefonos;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
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

        if (telefonos != null) {
            s.append("\nTeléfonos registrados:");
            for(Telefono t: telefonos) {
                s.append("\n"+t.toString());
            }
        }
        if (direccion != null) {
            s.append("\n" + direccion.toString());
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

/**
 * Clase que contiene los datos de un teléfono (número y tipo)
 */
class Telefono {

    //// Atributos
    /**
     * Número de teléfono
     */
    int numero;
    /**
     * Tipo de teléfono ("Celular, "Fijo", "Trabajo")
     */
    String tipo;

    //// Constructores
    public Telefono(int numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }

    //// Getters y Setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return tipo+": "+ numero;
    }
}

/**
 * Clase que contiene los datos de una dirección
 */
class Direccion {

    //// Atributos
    /**
     * Ciudad donde vive
     */
    String ciudad;
    /**
     * Calle donde se encuentra la casa
     */
    String calle;
    /**
     * Número de la casa
     */
    int numero;

    //// Constructores
    public Direccion() {
    }

    public Direccion(String ciudad, String calle, int numero) {
        this.ciudad = ciudad;
        this.calle = calle;
        this.numero = numero;
    }

    //// Getters y Setters
    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Dirección: "+ciudad + ", " + calle + ", #" + numero;
    }
}