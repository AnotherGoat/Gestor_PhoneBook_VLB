package lanzador;

/* Para generar javadoc:
Ir a Tools > Generate JavaDoc...
Elegir una carpeta (vacía) para guardarlo
En la opción "Other command line arguments" poner lo siguiente:
-encoding utf8 -docencoding utf8 -charset utf8
Para abrir el javadoc, abrir el archivo "index.html" con un navegador
 */

/* Estado de validaciones:
AgendaTest: listo
ContactoTest: listo
MenuTest: listo
MenuPrincipalTest: listo
MenuEditorTest: listo
SubmenuEditorTest: listo
ValidadorTest: listo

Nota: Si a alguno se le ocurre otro test unitario relevante, puede añadirlo
 */

import interfaz_grafica.VentanaPrincipal;
import org.json.JSONArray;
import phonebook.Agenda;

/**
 * <h2>"Gestor PhoneBook VLB"</h2>
 *
 * @author Bayron Muñoz
 * @author Luis Burgos
 * @author Víctor Mardones
 */

/*Relacion de Dependencia: Principal usa recursos de las clases GestorJson,Agenda,MenuPrincipal, es decir, depende de las funcionalidades de las otras clases
y no de forma inversa,es decir, las otras clases no necesitan de la clase Principal*/
public class Principal {

    //// Atributos
    /**
     * Objeto de la clase Agenda en el cual se almacenan todos los contactos durante la ejecución del programa
     */
    public static Agenda agenda = new Agenda();
    /**
     * JSONArray que representa la agenda global
     */
    public static JSONArray agenda_json = new JSONArray();

    public static VentanaPrincipal ventana;

    public static void main(String[] args) {
        // Instancia la ventana principal
        ventana = new VentanaPrincipal();
        // Hace que sea visible
        ventana.setVisible(true);
    }
}
