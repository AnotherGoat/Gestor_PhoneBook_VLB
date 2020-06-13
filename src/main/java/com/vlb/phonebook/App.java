package com.vlb.phonebook;

/* Para generar javadoc:
Ir a Tools > GenerateJavaDoc
Elegir una carpeta (vacía) para guardarlo
En la opción "Other command line arguments" poner lo siguiente:
-encoding utf8 -docencoding utf8 -charset utf8
Para abrir el javadoc, abrir el archivo "index.html" con un navegador
 */

/**
 * <h2>"Gestor PhoneBook VLB"</h2>
 *
 * @author Bayron Muñoz
 * @author Luis Burgos
 * @author Víctor Mardones
 */

public class App {

    //// Atributos
    /**
     * Objeto de clase MenuPrincipal que se inicia para mostrar el menú
     */
    public static MenuPrincipal menu = new MenuPrincipal();
    /**
     * Boolean global que permite repetir el menú hasta que el usuario escoja salir
     */
    public static boolean seguir = true;
    /**
     * Objeto de la clase Agenda en el cual se almacenan todos los contactos durante la ejecución del programa
     */
    public static Agenda agenda = new Agenda();

    public static void main(String[] args) {
        // Muestra el menú principal del gestor y lo repite
        do {
            menu.desplegarMenu();
            menu.switchMenu();
        } while (seguir);
    }

}
