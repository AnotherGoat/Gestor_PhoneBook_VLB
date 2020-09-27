package lanzador;

/* Para generar javadoc:
Ir a Tools > Generate JavaDoc...
Elegir una carpeta (vacía) para guardarlo
En la opción "Other command line arguments" poner lo siguiente:
-encoding utf8 -docencoding utf8 -charset utf8
Para abrir el javadoc, abrir el archivo "index.html" con un navegador
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
     * @see Agenda
     */
    public static Agenda agenda = new Agenda();
    /**
     * JSONArray que representa la agenda global
     * @see JSONArray
     */
    public static JSONArray agenda_json = new JSONArray();
    /**
     * JFrame que contiene la ventana principal del programa
     * @see VentanaPrincipal
     */
    public static VentanaPrincipal ventana;

    /**
     * Método main del programa. El programa inicia su ejecución desde aquí
     * @param args Necesario para que funcione la línea de comandos
     */
    public static void main(String[] args) {
        // Instancia la ventana principal
        ventana = new VentanaPrincipal();
        // Hace que sea visible
        ventana.setVisible(true);
    }
}
