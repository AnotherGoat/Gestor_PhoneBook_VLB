package com.vlb.phonebook;

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
     * ArrayList con los e-mails del contacto
     */
    private List<String> emails = new ArrayList<>();
    /**
     * ArrayList con los apodos con los que se conoce al contacto
     */
    private List<String> apodos = new ArrayList<>();
    /**
     * Fecha de cumpleaños del contacto
     */
    private FechaCumple fechaCumple = new FechaCumple();
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
        if(c!=null){
            // Copia el nombre desde c
            this.nombre = c.nombre;

            // Copia los telefonos desde c
            this.telefonos.addAll(c.telefonos);

            // Copia la dirección desde c
            this.direccion = new Direccion(c.direccion);

            // Copia los e-mails desde c
            this.emails.addAll(c.emails);

            // Copia los apodos desde c
            this.apodos.addAll(c.apodos);

            // Copia la fecha de cumpleaños desde c
            this.fechaCumple = new FechaCumple(c.fechaCumple);

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

    public void setTelefonos(List<Telefono> telefonos) {
        this.telefonos = telefonos;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public List<String> getApodos() {
        return apodos;
    }

    public void setApodos(List<String> apodos) {
        this.apodos = apodos;
    }

    public FechaCumple getFechaCumple() {
        return fechaCumple;
    }

    public void setFechaCumple(FechaCumple fechaCumple) {
        this.fechaCumple = fechaCumple;
    }

    public List<String> getNotas() {
        return notas;
    }

    public void setNotas(List<String> notas) {
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
            s.append("\nTeléfonos guardados:");
            for(Telefono t: telefonos) {
                s.append("\n"+t.toString());
            }
        }

        if (direccion != null) {
            s.append("\n" + direccion.toString());
        }

        if (emails != null) {
            s.append("\nE-mails guardados:");
            for(String e: emails) {
                s.append("\n"+e);
            }
        }

        if (apodos != null) {
            s.append("\nApodos guardados:");
            for(String a: apodos) {
                s.append("\n"+a);
            }
        }

        if (fechaCumple != null) {
            s.append("\n" + fechaCumple.toString());
        }

        if (notas != null) {
            s.append("\nNotas guardadas:");
            for(String n: notas) {
                s.append("\n"+n);
            }
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

    public Direccion(Direccion d) {
        if(d!=null) {
            this.ciudad = d.ciudad;
            this.calle = d.calle;
            this.numero = d.numero;
        }
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

/**
 * Esta clase almacena la fecha de cumpleaños de un contacto (día y mes)
 */
class FechaCumple {
    /**
     * Int con el número del día de cumpleaños
     */
    private int dia;
    /**
     * Int que representa el mes del cumpleaños
     */
    private int numeroMes;
    /**
     * String con el nombre del mes de cumpleaños
     */
    private String mes;
    /**
     * Arreglo con los meses del año
     */
    private final String[] listaMeses = {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};

    //// Constructores
    public FechaCumple() {

    }

    public FechaCumple(int dia, int numeroMes) {
        this.dia = dia;
        this.numeroMes = numeroMes;
        this.mes = listaMeses[numeroMes - 1];
    }

    public FechaCumple(FechaCumple fc) {
        if(fc!=null) {
            this.dia = fc.dia;
            this.numeroMes = fc.numeroMes;
            this.mes = fc.mes;
        }
    }

    //// Getters y Setters
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getNumeroMes() {
        return numeroMes;
    }

    public void setNumeroMes(int numeroMes) {
        this.numeroMes = numeroMes;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    //// toString
    @Override
    public String toString() {
        return "Fecha de cumpleaños: " + dia + " de " + mes;
    }
}