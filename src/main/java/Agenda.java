
// Importa la clase Scanner
import java.util.Scanner;
// Importa la clase ArrayList
import java.util.ArrayList;

/**
 * Esta clase almacena todos los contactos y métodos para trabajar con ellos
 */
public class Agenda {

    //// Atributos
    /**
     * ArrayList con los contactos registrados
     */
    ArrayList<Contacto> contactos = new ArrayList<Contacto>();
    /**
     * Scanner para tomar entrada
     */
    Scanner teclado = new Scanner(System.in);
    //// Constructores
    public Agenda() {
    }

    //// Métodos

    /**
     * Método para crear un contacto nuevo
     */
    public void crearContacto(){
        // Pide el nombre del contacto

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
        if(contactos.size() == 0){
            System.out.println("Todavía no ha guardado ningún contacto.");
        }

        else {
            System.out.println("Contactos registrados:");

            for (int i = 1; i <= contactos.size(); i++) {
                System.out.println(i + ".- " + contactos.get(i-1).getNombre());
            }
        }
    }

    /**
     * Método para mostrar detalles de un contacto específico
     */
    public void mostrarContacto(){
        // Verificar que hayan contactos guardados antes de usar
        if(contactos.size() == 0){
            System.out.println("Todavía no ha guardado ningún contacto.");
        }

        else {
            // Muestra la lista de contactos
            Scanner teclado = new Scanner(System.in);
            listarContactos();
            int a = validarInt("Escoja un contacto: ");

            if(a<1 || a>contactos.size()){
                System.out.println("El contacto ingresado no existe.");
            }

            else{
                System.out.println(contactos.get(a-1).toString());
            }
        }
    }

    /**
     * Método para editar datos de un contacto
     */
    public void editarContacto(){
        // Verificar que hayan contactos guardados antes de usar
        if(contactos.size() == 0){
            System.out.println("Todavía no ha guardado ningún contacto.");
        }

        else {

        }
    }

    /**
     * Método para eliminar un contacto
     */
    public void eliminarContacto(){
        // Verificar que hayan contactos guardados antes de usar
        if(contactos.size() == 0){
            System.out.println("Todavía no ha guardado ningún contacto.");
        }

        else {

        }
    }

    /**
     * Valida entrada de tipo int
     */
    private int validarInt(String s) {
        boolean repetir = true; // Boolean para repetir en caso de ingresar una letra o símbolo
        int a = 0; // Variable con la que se trabaja

        while (repetir) {
            try {
                System.out.print(s);
                a = teclado.nextInt();
                repetir = false;
            } catch (Exception e) {
                teclado.next();
                System.out.println("Error: " + e.getMessage() + ". Ingrese un número válido, por favor.");
                repetir = true;
            }
        }
        return a;
    }

    //// Getters y Setters

    //// toString

}
