
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

public class PhoneBook {
    //atributos
    public static boolean seguir = true;

    public static void main(String[] args){
        // Crea un objeto de la clase Menu
        Menu menu = new Menu();
        do{
            menu.desPliegueMenu();
            menu.seleccionMenu();
        }while (seguir);
        // Muestra el menú principal de la agenda
    }

}}
