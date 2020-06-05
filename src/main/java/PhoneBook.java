
/*

 "Gestor PhoneBook VLB" (Esta parte deberíamos moverla al readme después)</p>

 Es un gestor de contactos en desarrollo, escrito en Java.
 Desarrollado por Bayron Muñoz, Luis Burgos y Víctor Mardones.
 Para su versión final planeamos que la aplicación permita al usuario administrar una lista de contactos y
 guardarla en un documento de texto.
 Al ejecutar el programa mostrará un menú con opciones como añadir, listar, editar, eliminar o exportar contactos.
 También permite revisar la agenda para que el usuario realice una llamada (¿Cómo?)
 </p>
 (Lo que sigue después debería quedarse en este comentario)

 Estructura del programa:
 Clases: menú, agenda, contacto, entrada,

 Consejos que dió el profe o de sitios de internet (NO borrar)
 ---Trabajar en una branch que no sea main
 ---Hacer commits por cada cambio
 ---¿Por qué hablan de que el programa permite si aún no está implementado?
 ---Falta la especificación del contexto problema.
 ---Falta establecer los usuarios, para qué necesitan esta aplicación y por qué es necesaria.
 ---Cuidado con los términos técnicos... compilar no es lo mismo que ejecutar.
 ---Ideal hacer el proyecto con Maven (¡listo!)
 ---Es ideal que esté separado en clases y orientado a objetos.
 ---La clase main debe estar casi vacía, sólo instanciar un objeto (menú).
 ---Todos los procedimientos deben realizarlos objetos fuera de la clase principal (main).

 */

// Importa la clase ArrayList
import java.util.ArrayList;

/** Clase principal del programa, aquí comienza toda la ejecución */
public class PhoneBook {

    ////atributos
    /** Boolean global que permite repetir el menú hasta que el usuario escoja salir */
    public static boolean seguir = true;
    /** Objeto de la clase Agenda en el cual se almacenan todos los contactos */
    public static Agenda agenda = new Agenda();

    public static void main(String[] args) {
        /** ArrayList de Strings usado para el menú */
        ArrayList<String> opciones = new ArrayList<String>();
        // Opciones del ArrayList
        opciones.add("Mostrar lista de contactos");
        opciones.add("Ver detalles de un contacto");
        opciones.add("Crear contacto nuevo");
        opciones.add("Editar un contacto");
        opciones.add("Eliminar un contacto");
        opciones.add("Salir");

        /** Objeto de clase Menu que se inicia para mostrar el menú */
        Menu menu = new Menu(opciones);

        // Muestra el menú principal de la agenda y lo repite
        do {
            menu.desplegarMenu();
            menu.switchMenu();
        } while (seguir);
    }

}
