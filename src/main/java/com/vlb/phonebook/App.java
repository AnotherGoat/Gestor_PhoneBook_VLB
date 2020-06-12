package com.vlb.phonebook;

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
/**
 * <h2>"Gestor PhoneBook VLB"</h1>
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
     * Objeto de clase com.vlb.phonebook.Menu que se inicia para mostrar el menú
     */
    public static MenuPrincipal menu = new MenuPrincipal();
    /**
     * Boolean global que permite repetir el menú hasta que el usuario escoja salir
     */
    public static boolean seguir = true;
    /**
     * Objeto de la clase com.vlb.phonebook.Agenda en el cual se almacenan todos los contactos durante la ejecución del programa
     */
    public static Agenda agenda = new Agenda();
    /**
     * com.vlb.phonebook.Contacto auxiliar, se usa cuando se edita un contacto para permitir elegir si guardar los cambios o no
     */
    public static Contacto aux = new Contacto();

    public static void main(String[] args) {
        // Muestra el menú principal de la agenda y lo repite
        do {
            menu.desplegarMenu();
            menu.switchMenu();
        } while (seguir);
    }

}
