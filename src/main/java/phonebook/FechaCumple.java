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

    public FechaCumple(int dia, String mes) {
        this.dia = dia;
        this.mes = mes;
    }

    public FechaCumple(FechaCumple fc) {
        if (fc != null) {
            this.dia = fc.dia;
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
