
/*

 "Gestor PhoneBook VLB"

 Estructura del programa:
 Clases: app, menú, agenda, contacto, validador

 Consejos que dio el profe o de sitios de internet (NO borrar)
 ---Trabajar en una branch que no sea main
 ---Hacer commits por cada cambio
 ---Cuidado con los términos técnicos.
 ---La clase main debe estar casi vacía, sólo instanciar un objeto (menú).
 ---Todos los procedimientos deben realizarlos objetos fuera de la clase principal (main).

 */

// Importa la clase ArrayList
import java.util.ArrayList;

/**
 * <h2>"Gestor PhoneBook VLB</h1>
 *
 * @author Bayron Muñoz
 * @author Luis Burgos
 * @author Víctor Mardones
 *
 * <p></p>
 */
public class App {

    //// Atributos
    /**
     * Boolean global que permite repetir el menú hasta que el usuario escoja salir
     */
    public static boolean seguir = true;
    /**
     * Objeto de la clase Agenda en el cual se almacenan todos los contactos
     */
    public static Agenda agenda = new Agenda();
    /**
     * ArrayList de Strings usado para el menú
     */
    public static ArrayList<String> opciones = new ArrayList<>();
    /**
     * Objeto de clase Menu que se inicia para mostrar el menú
     */
    public static Menu menu = new Menu(opciones);

    public static Contacto aux = new Contacto();

    public static void main(String[] args) {
        // Opciones del ArrayList
        opciones.add("Crear contacto nuevo");
        opciones.add("Mostrar lista de contactos");
        opciones.add("Ver detalles de un contacto");
        opciones.add("Editar un contacto");
        opciones.add("Eliminar un contacto");
        opciones.add("Salir");

        // Muestra el menú principal de la agenda y lo repite
        do {
            menu.desplegarMenu();
            menu.switchMenu();
        } while (seguir);
    }

}
