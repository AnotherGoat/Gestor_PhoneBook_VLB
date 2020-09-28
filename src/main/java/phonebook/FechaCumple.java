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
    /**
     * Constructor vacío de FechaCumple, sólo usar en tests
     */
    public FechaCumple() {
    }

    /**
     * Construye una fecha de cumpleaños con los datos ingresados
     * @param dia Int con el día del mes
     * @param mes String con el nombre del mes, sólo puede ser uno de la lista de meses
     * @see FechaCumple#lista_meses
     */
    public FechaCumple(int dia, String mes) {
        this.dia = dia;
        this.mes = mes;
    }

    /**
     * Construye una fecha de cumpleaños con los datos de otra
     * @param fc Fecha de cumpleaños original
     * @see FechaCumple
     */
    public FechaCumple(FechaCumple fc) {
        if (fc != null) {
            this.dia = fc.dia;
            this.mes = fc.mes;
        }
    }

    //// Getters y Setters
    /**
     * Getter para obtener el día de la fecha
     * @return Int con el día
     */
    public int getDia() {
        return dia;
    }

    /**
     * Getter para obtener el mes de la fecha
     * @return String con el nombre del mes
     */
    public String getMes() {
        return mes;
    }

    //// toString()
    /**
     * Convierte los datos de la fecha de cumpleaños a un String
     * @return String con los datos
     * @see String
     */
    @Override
    public String toString() {
        return "Fecha de cumpleaños: " + dia + " de " + mes;
    }
}
