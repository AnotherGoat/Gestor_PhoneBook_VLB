package com.vlb.phonebook;

/* Para generar javadoc:
Ir a Tools > Generate JavaDoc...
Elegir una carpeta (vacía) para guardarlo
En la opción "Other command line arguments" poner lo siguiente:
-encoding utf8 -docencoding utf8 -charset utf8
Para abrir el javadoc, abrir el archivo "index.html" con un navegador
 */

/* Estado de validaciones:
AgendaTest:
ContactoTest:
MenuEditorTest:
MenuPrincipalTest:
SubmenuEditorTest:
ValidadorTest: listo
 */

/**
 * <h2>"Gestor PhoneBook VLB"</h2>
 *
 * @author Bayron Muñoz
 * @author Luis Burgos
 * @author Víctor Mardones
 */
public class Principal {

    //// Atributos
    /**
     * Objeto de clase MenuPrincipal que se inicia para mostrar el menú
     */
    public static MenuPrincipal menu;
    /**
     * Objeto de la clase Agenda en el cual se almacenan todos los contactos durante la ejecución del programa
     */
    public static Agenda agenda = new Agenda();

    public static void main(String[] args) {
        menu = new MenuPrincipal();
    }
}
