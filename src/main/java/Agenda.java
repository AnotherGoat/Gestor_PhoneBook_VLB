
import java.util.ArrayList;
import java.util.Scanner;

/** Esta clase contiene todos los Contactos y métodos para trabajar con ellos */
public class Agenda {

    //// Atributos
    /**
     * ArrayList con los contactos registrados
     */
    ArrayList<Contacto> contactos = new ArrayList<Contacto>();
    //// Constructores
    public Agenda() {
    }

    //// Métodos

    /**
     * Método para crear un contacto nuevo
     */
    public void crearContacto(){
        // Pide el nombre del contacto
        Scanner teclado = new Scanner(System.in);
        System.out.print("Ingrese el nombre del contacto: ");
        String s = teclado.nextLine();

        // Crea el contacto nuevo y lo agrega al ArrayList
        Contacto a = new Contacto(s);
        contactos.add(a);
        System.out.println("El contacto fue guardado exitosamente.");
    }

    /**
     * Método para mostrar una lista de todos los contactos guardados
     */
    public void listarContactos() {
        // Verificar que hayan contactos guardados antes de usar
        if(PhoneBook.agenda.contactos.size() == 0){
            System.out.println("Todavía no ha guardado ningún contacto.");
        }

        else {

        }
    }

    public void mostrarContacto(){
        // Verificar que hayan contactos guardados antes de usar
        if(PhoneBook.agenda.contactos.size() == 0){
            System.out.println("Todavía no ha guardado ningún contacto.");
        }

        else {

        }
    }

    public void editarContacto(){
        // Verificar que hayan contactos guardados antes de usar
        if(PhoneBook.agenda.contactos.size() == 0){
            System.out.println("Todavía no ha guardado ningún contacto.");
        }

        else {

        }
    }

    public void eliminarContacto(){
        // Verificar que hayan contactos guardados antes de usar
        if(PhoneBook.agenda.contactos.size() == 0){
            System.out.println("Todavía no ha guardado ningún contacto.");
        }

        else {

        }
    }

    //// Getters y Setters

    //// toString

}
