
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
    ArrayList<Contacto> contactos = new ArrayList<>();
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
    public void crearContacto() {
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
        if (contactos.size() == 0) {
            System.out.println("Todavía no ha guardado ningún contacto.");
        } else {
            System.out.println("Contactos registrados:");
            PhoneBook.menu.enumerarArrayList(contactos);
        }
    }

    /**
     * Método para mostrar detalles de un contacto específico
     */
    public void mostrarContacto() {
        // Verificar que hayan contactos guardados antes de usar
        if (contactos.size() == 0) {
            System.out.println("Todavía no ha guardado ningún contacto.");
        } else {
            // Muestra la lista de contactos
            listarContactos();
            int a = 0;
            boolean f = false;
            //while para repetir en caso de que no se ingrese un rango deseado
            while (!f) {
                a = validarInt("Escoja el contacto que quiere ver: ");
                if (a < 1 || a > contactos.size()) {
                    System.out.println("El contacto ingresado no existe.");
                    f = false;
                } else {
                    System.out.println(contactos.get(a - 1).toString());
                    f = true;
                }
            }

        }
    }

    /**
     * Método para editar datos de un contacto
     */
    public void editarContacto() {
        // Verificar que hayan contactos guardados antes de usar
        if (contactos.size() == 0) {
            System.out.println("Todavía no ha guardado ningún contacto.");
        } else {
            listarContactos();
            int a = 0;
            boolean f = false;
            while (!f) {
                a = validarInt("Escoja el contacto que quiere editar: ");
                if (a < 1 || a > contactos.size()) {
                    System.out.println("El contacto ingresado no existe.");
                    f = false;
                } else {
                    menuEdicion(a-1);
                    f = true;
                }
            }
        }
    }

    /**
     * Método para eliminar un contacto
     */
    public void eliminarContacto() {
        // Verificar que hayan contactos guardados antes de usar
        if (contactos.size() == 0) {
            System.out.println("Todavía no ha guardado ningún contacto.");
        } else {
            listarContactos();
            int a = 0;
            boolean f = false;
            while (!f) {
                a = validarInt("Escoja el contacto que quiere eliminar: ");
                if (a < 1 || a > contactos.size()) {
                    System.out.println("El contacto ingresado no existe.");
                    f = false;
                } else {
                    confirmarBorrado(a);
                    f = true;
                }
            }
        }
    }

    /**
     * Método para hacer y confirmar los cambios hechos a un contacto
     */
    public void menuEdicion(int posicion) {
        boolean repetir = true;
        Contacto c = contactos.get(posicion);
        Contacto p = PhoneBook.aux;

        p.setNombre(c.getNombre());
        p.setTelefonoCelular(c.getTelefonoCelular());
        p.setTelefonoCasa(c.getTelefonoCasa());
        p.setTelefonoTrabajo(c.getTelefonoTrabajo());
        p.setDireccion(c.getDireccion());
        p.setCorreoElectronico(c.getCorreoElectronico());

        do {
            repetir = switchEdicion(crearOpciones());
        } while (repetir);

        int b;
        while(!repetir) {
            System.out.println("¿Desea guardar los cambios realizados? 1=Sí 0=No");
            b = validarInt("Escoja una opción: ");
            switch (b) {
                case 1:
                    c.setNombre(p.getNombre());
                    c.setTelefonoCelular(p.getTelefonoCelular());
                    c.setTelefonoCasa(p.getTelefonoCasa());
                    c.setTelefonoTrabajo(p.getTelefonoTrabajo());
                    c.setDireccion(p.getDireccion());
                    c.setCorreoElectronico(p.getCorreoElectronico());
                    System.out.println("Los cambios han sido guardados.");
                    repetir = true;
                    break;
                case 0:
                    System.out.println("Los cambios no se han guardado.");
                    repetir = true;
                    break;
                default:
                    System.out.println("La opción ingresada no existe.");
            }
        }
    }

    public ArrayList crearOpciones() {
        String a = "Agregar ", c = "Cambiar ";

        // Cambia las opciones del menú
        ArrayList<String> opcionesEd = new ArrayList<>();
        opcionesEd.add(a+"nombre");

        if (PhoneBook.aux.telefonoCelular == -1) {
            opcionesEd.add(a+ " " +"número de celular");
        } else {
            opcionesEd.add("Cambiar número de celular");
        }

        if (PhoneBook.aux.telefonoCasa == -1) {
            opcionesEd.add("Agregar número de casa");
        } else {
            opcionesEd.add("Cambiar número de casa");
        }

        if (PhoneBook.aux.telefonoTrabajo == -1) {
            opcionesEd.add("Agregar número de trabajo");
        } else {
            opcionesEd.add("Cambiar número de trabajo");
        }

        if (PhoneBook.aux.direccion == null) {
            opcionesEd.add("Agregar dirección");
        } else {
            opcionesEd.add("Cambiar dirección");
        }

        if (PhoneBook.aux.correoElectronico == null) {
            opcionesEd.add("Agregar correo electrónico");
        } else {
            opcionesEd.add("Cambiar correo electrónico");
        }

        /*
        // Todavía no implementado (no borrar)
        if(aux.sobrenombre==null){
            opcionesEd.add("Agregar sobrenombre");
        }
        else{
            opcionesEd.add("Cambiar sobrenombre");
        }

        if(aux.fechaCumple==null){
            opcionesEd.add("Agregar fecha de cumpleaños");
        }
        else{
            opcionesEd.add("Cambiar fecha de cumpleaños");
        }

        if(aux.notas==null){
            opcionesEd.add("Agregar notas adicionales");
        }
        else{
            opcionesEd.add("Cambiar notas adicionales");
        }
        */

        opcionesEd.add("Salir");

        return opcionesEd;
    }

    public boolean switchEdicion(ArrayList<String> opcionesEd) {
        Menu ed = new Menu(opcionesEd);

        ed.desplegarMenu();
        String s;
        int b;
        Scanner teclado2 = new Scanner(System.in);

        switch (ed.getSeleccion()) {
            case 1: // Nombre
                System.out.print("Ingrese el nombre del contacto: ");
                s = teclado2.nextLine();
                PhoneBook.aux.setNombre(s);
                return true;
            case 2: // Número de celular
                b = validarInt("Ingrese el número de celular: ");
                if (b < 1) {
                    System.out.println("El número ingresado no es válido.");
                } else {
                    PhoneBook.aux.setTelefonoCelular(b);
                }
                return true;
            case 3: // Número de casa
                b = validarInt("Ingrese el número de casa: ");
                if (b < 1) {
                    System.out.println("El número ingresado no es válido.");
                } else {
                    PhoneBook.aux.setTelefonoCasa(b);
                }
                return true;
            case 4: // Número de trabajo
                b = validarInt("Ingrese el número de trabajo: ");
                if (b < 1) {
                    System.out.println("El número ingresado no es válido.");
                } else {
                    PhoneBook.aux.setTelefonoTrabajo(b);
                }
                return true;
            case 5: // Dirección
                System.out.print("Ingrese la dirección: ");
                s = teclado2.nextLine();
                PhoneBook.aux.setDireccion(s);
                return true;
            case 6: // Correo electrónico
                System.out.print("Ingrese la dirección de correo electrónico: ");
                s = teclado2.nextLine();
                PhoneBook.aux.setCorreoElectronico(s);
                return true;
            case 7: // Salir
                return false;
            default:
                System.out.println("La opción ingresada no existe.");
                return true;
        }
    }

    /**
     * Método para confirmar la eliminación de un contacto
     */
    private void confirmarBorrado(int num) {
        int x;
        boolean valido = false;
        do {
            System.out.println("Se borrará el contacto " + contactos.get(num - 1).getNombre());
            System.out.println("¿Está seguro? 1=Sí 0=No");
            x = validarInt("Escoja una opción: ");
            switch (x) {
                case 1:
                    contactos.remove(num - 1);
                    System.out.println("El contacto ha sido borrado exitosamente.");
                    valido = true;
                    break;
                case 0:
                    System.out.println("El contacto no se borró.");
                    valido = true;
                    break;
                default:
                    System.out.println("La opción ingresada no existe.");
            }
        } while (!valido);
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
