package com.vlb.phonebook;

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
     * ArrayList con el nombre de cada contacto
     */
    ArrayList<String> listaNombres = new ArrayList<>();
    /**
     * Boolean que indica si se va a seguir editando
     */
    private boolean seguirEditando;
    /**
     * Validador usado en la clase Agenda
     */
    private final Validador v = new Validador();

    //// Constructores
    public Agenda() {
    }

    //// Métodos
    /**
     * Método para crear un contacto nuevo
     */
    public void crearContacto() {
        // Pide el nombre del contacto
        String s = v.recibirString("Ingrese el nombre del contacto: ");

        // Crea el contacto nuevo y lo agrega al ArrayList
        Contacto a = new Contacto(s);
        contactos.add(a);
        listaNombres.add(s);
        System.out.println("El contacto fue guardado exitosamente.");
    }

    /**
     * Método para mostrar una lista de todos los contactos guardados
     */
    public void listarContactos() {
        // Mostrar nombres de los contactos registrados
        System.out.println("Contactos registrados:");
        App.menu.enumerarArrayList(listaNombres);
    }

    /**
     * Método para mostrar detalles de un contacto específico
     */
    public void mostrarContacto() {
        int a = elegirContacto("ver");

        // Muestra los detalles del contacto
        System.out.println("****Contacto #"+a+"****");
        System.out.println(contactos.get(a - 1).toString());
    }

    /**
     * Método que muestra una lista de los contactos registrados y pide al usuario que escoja uno
     * @param verbo Verbo usado en el String "Escoja el contacto que quiere... :"
     * @return int con el contacto elegido
     */
    public int elegirContacto(String verbo){
        // Muestra la lista de contactos
        listarContactos();

        // Toma la entrada entre 1 y el contacto de rango máximo
        return v.validarInt(1, contactos.size(),
                "Escoja el contacto que quiere "+verbo+": ",
                "El contacto ingresado no existe.");
    }

    /**
     * Método para mostrar un menú de edición de un contacto
     */
    public void editarContacto() {
        int a = elegirContacto("editar");

        seguirEditando = true;
        Contacto c = contactos.get(a-1);
        MenuEditor ed = new MenuEditor(c, a-1);

        // Repite el menú de edición hasta que el usuario escoja salir
        do {
            ed.desplegarMenu();
            ed.switchMenu();
        } while (seguirEditando);
    }

    /**
     * Método para copiar datos de un contacto a otro, pero manteniendo ambas instancias distintas (paso por valor)
     * @param base Contacto que se va a copiar
     */
    public void copiarContacto(Contacto base, Contacto objetivo){
        if(base!=null && objetivo!=null) {
            objetivo.setNombre(base.getNombre());
            objetivo.setTelefonoCelular(base.getTelefonoCelular());
            objetivo.setTelefonoCasa(base.getTelefonoCasa());
            objetivo.setTelefonoTrabajo(base.getTelefonoTrabajo());
            objetivo.setDireccion(base.getDireccion());
            objetivo.setEmail(base.getEmail());
        }
    }

    /**
     * Método para eliminar un contacto
     */
    public void eliminarContacto() {
        int a = elegirContacto("eliminar");
        // Pide confirmación para borrar el contacto elegido
        confirmarBorrado(a);
    }

    /**
     * Método para confirmar la eliminación de un contacto
     */
    private void confirmarBorrado(int num) {
        int x;
        x = v.validarInt(0, 1,
                "Se borrará el contacto "+contactos.get(num - 1).getNombre()+" ¿Está seguro? 1=Sí 0=No\nEscoja una opción: ",
                "La opción ingresada no existe.");

        switch (x) {
            case 1:
                contactos.remove(num - 1);
                listaNombres.remove(num-1);
                System.out.println("El contacto ha sido borrado exitosamente.");
                break;
            case 0:
                System.out.println("El contacto no se borró.");
                break;
        }
    }

    //// Getters y Setters
    public boolean isSeguirEditando() {
        return seguirEditando;
    }

    public void setSeguirEditando(boolean seguirEditando) {
        this.seguirEditando = seguirEditando;
    }
}
