package phonebook;

/**
 * Esta clase almacena la fecha de cumpleaños de un contacto (día y mes)
 */
public class FechaCumple {
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
    final String[] lista_meses = {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};

    //// Constructores
    public FechaCumple() {

    }

    public FechaCumple(int dia, int numeroMes) {
        this.dia = dia;
        this.numeroMes = numeroMes;
        this.mes = lista_meses[numeroMes - 1];
    }

    public FechaCumple(int dia, String mes) {
        this.dia = dia;
        this.mes = mes;
    }

    public FechaCumple(FechaCumple fc) {
        if (fc != null) {
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
