
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

            for (int i = 1; i <= contactos.size(); i++) {
                System.out.println(i + ".- " + contactos.get(i - 1).getNombre());
            }
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
                    menuEdicion(a);
                    f = true;
                }
            }
        }
    }

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
    public void menuEdicion(int a) {
        boolean repetir = true;

        do {
            Menu edicion = crearOpciones(a);
            repetir = switchEdicion(a, edicion);
        } while (repetir);
    }

    public Menu crearOpciones(int a) {
        Contacto aux = contactos.get(a - 1);

        // Cambia las opciones del menú
        ArrayList<String> opcionesEd = new ArrayList<>();
        opcionesEd.add("Cambiar nombre");

        if (aux.telefonoCelular == -1) {
            opcionesEd.add("Agregar número de celular");
        } else {
            opcionesEd.add("Cambiar número de celular");
        }

        if (aux.telefonoCasa == -1) {
            opcionesEd.add("Agregar número de casa");
        } else {
            opcionesEd.add("Cambiar número de casa");
        }

        if (aux.telefonoTrabajo == -1) {
            opcionesEd.add("Agregar número de trabajo");
        } else {
            opcionesEd.add("Cambiar número de trabajo");
        }

        if (aux.direccion == null) {
            opcionesEd.add("Agregar dirección");
        } else {
            opcionesEd.add("Cambiar dirección");
        }

        if (aux.correoElectronico == null) {
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

        Menu ed = new Menu(opcionesEd);
        return ed;
    }

    public boolean switchEdicion(int a, Menu ed) {
        if (ed != null) {
            Contacto aux = contactos.get(a - 1);
            ed.desplegarMenu();
            String s = "";
            int b;

            switch (ed.getSeleccion()) {
                case 1: // Nombre
                    System.out.print("Ingrese el nombre del contacto: ");
                    s = teclado.nextLine();
                    aux.setNombre(s);
                    return true;
                case 2: // Número de celular
                    b = validarInt("Ingrese el número de celular: ");
                    if (b < 1) {
                        System.out.println("El número ingresado no es válido.");
                    } else {
                        aux.setTelefonoCelular(b);
                    }
                    return true;
                case 3: // Número de casa
                    b = validarInt("Ingrese el número de casa: ");
                    if (b < 1) {
                        System.out.println("El número ingresado no es válido.");
                    } else {
                        aux.setTelefonoCasa(b);
                    }
                    return true;
                case 4: // Número de trabajo
                    b = validarInt("Ingrese el número de trabajo: ");
                    if (b < 1) {
                        System.out.println("El número ingresado no es válido.");
                    } else {
                        aux.setTelefonoTrabajo(b);
                    }
                    return true;
                case 5: // Dirección
                    System.out.print("Ingrese la dirección: ");
                    s = teclado.next();
                    aux.setDireccion(s);
                    return true;
                case 6: // Correo electrónico
                    System.out.print("Ingrese la dirección de correo electrónico: ");
                    s = teclado.next();
                    aux.setCorreoElectronico(s);
                    return true;
                case 7: // Salir
                    boolean valido = false;
                    do {
                        System.out.println("¿Desea guardar los cambios realizados? 1=Sí 0=No");
                        b = validarInt("Escoja una opción: ");
                        switch (b) {
                            case 1:
                                contactos.set(a - 1, aux);
                                System.out.println("Los cambios han sido guardados.");
                                break;
                            case 0:
                                valido = true;
                                break;
                            default:
                                System.out.println("La opción ingresada no existe.");
                        }
                    } while (!valido);
                    return false;
                default:
                    System.out.println("La opción ingresada no existe.");
                    return true;
            }
        } else {
            return false;
        }
    }

    /**
     * Método para eliminar un contacto
     */

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
