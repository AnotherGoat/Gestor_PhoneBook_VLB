
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
    public void crearContacto(){
        Scanner teclado = new Scanner(System.in);
        String s;
        System.out.print("Ingrese el nombre del contacto: ");
        s = teclado.nextLine();

        Contacto a = new Contacto(s);
        contactos.add(a);

        System.out.println("El contacto fue guardado exitosamente");
    }

    //// Getters y Setters

    //// toString

}
