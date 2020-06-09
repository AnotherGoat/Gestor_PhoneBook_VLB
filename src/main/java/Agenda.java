
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
            // Crear ArrayList con los nombres de los contactos
            ArrayList<String> nombresC = obtenerNombres();

            // Mostrar nombres de los contactos registrados
            System.out.println("Contactos registrados:");
            App.menu.enumerarArrayList(nombresC);
        }
    }

    /**
     * Método para obtener los nombres de todos los contactos
     * @return ArrayList con los nombres
     */
    public ArrayList<String> obtenerNombres(){
        ArrayList<String> al = new ArrayList<>();

        for (Contacto contacto : contactos) {
            al.add(contacto.getNombre());
        }
        return al;
    }

    /**
     * Método para mostrar detalles de un contacto específico
     */
    public void mostrarContacto() {
        // Verificar que hayan contactos guardados antes de usar
        if (contactos.size() == 0) {
            System.out.println("Todavía no ha guardado ningún contacto.");
        } else {
            int a = elegirContacto("ver");

            // Muestra los detalles del contacto
            System.out.println("Contacto #"+a);
            System.out.println(contactos.get(a - 1).toString());
        }
    }

    public int elegirContacto(String verbo){
        // Muestra la lista de contactos
        listarContactos();

        // Toma la entrada entre 1 y el contacto de rango máximo
        return v.validarInt(1, contactos.size(),
                "Escoja el contacto que quiere "+verbo+":",
                "El contacto ingresado no existe.");
    }

    /**
     * Método para editar datos de un contacto
     */
    public void editarContacto() {
        // Verificar que hayan contactos guardados antes de usar
        if (contactos.size() == 0) {
            System.out.println("Todavía no ha guardado ningún contacto.");
        } else {
            int a = elegirContacto("editar");

            // Abre el menú de edición
            menuEdicion(a-1);
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
            int a = elegirContacto("eliminar");

            // Pide confirmación para borrar el contacto elegido
            confirmarBorrado(a);
        }
    }

    /**
     * Método para hacer y confirmar los cambios hechos a un contacto
     * @param posicion posición del contacto en el ArrayList
     */
    public void menuEdicion(int posicion) {
        Contacto c = contactos.get(posicion);

        copiarContacto(c, App.aux);

        // Muestra el switch con el menú de edición
        switchEdicion();

        System.out.println("¿Desea guardar los cambios realizados? 1=Sí 0=No");
        int b = v.validarInt(0, 1,
                "Escoja una opción: ",
                "La opción ingresada no existe.");

        switch (b) {
            case 1:
                copiarContacto(App.aux, c);
                System.out.println("Los cambios han sido guardados.");
                break;
            case 0:
                System.out.println("Los cambios no se han guardado.");
        }
    }

    /**
     * Copia datos de un contacto a otro, pero manteniendo ambas instancias distintas
     * @param base Contacto que se va a copiar
     * @return Contacto nuevo
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
     * <p>Este método crea opciones para un ArrayList que se usará en un menú.</p>
     * <p>Cambia el texto entre "Agregar" (si no existe un dato de ese tipo) o "Cambiar" (si ya existe un dato de ese tipo).</p>
     * @return ArrayList con las opciones
     */
    public ArrayList<String> crearOpciones() {
        // a=agregar, c=cambiar
        String a = "Agregar ", c = "Cambiar ";
        // Crea opciones para guardarlas en un ArrayList
        ArrayList<String> opcionesEd = new ArrayList<>();
        opcionesEd.add(c+"nombre");

        // Arreglos para ahorrar espacio
        boolean[] check = {App.aux.telefonoCelular == -1,App.aux.telefonoCasa == -1, App.aux.telefonoTrabajo == -1, App.aux.direccion == null, App.aux.email == null};
        String[] datos = {"número de celular", "número de casa", "número de trabajo", "dirección", "e-mail",};

        for(int i=0; i<check.length; i++){
            if(check[i]){
                opcionesEd.add(a + datos[i]);
            }
            else{
                opcionesEd.add(c + datos[i]);
            }
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

    /**
     * Método que maneja las opciones del menú de edición
     */
    public void switchEdicion() {
        Menu ed;
        String s;
        int b = 0;

        do {
            ArrayList<String> opcionesEd = crearOpciones();
            ed = new Menu(opcionesEd);
            ed.desplegarMenu();

            switch (ed.getEleccion()) {
                case 1: // Nombre
                    s = v.recibirString("Ingrese el nombre del contacto: ");
                    App.aux.setNombre(s);
                    break;

                case 2: // Número de celular
                    b = v.validarInt(1, 999999999,
                            "Ingrese el número de celular: ",
                            "El número ingresado no es válido.");
                    App.aux.setTelefonoCelular(b);
                    break;

                case 3: // Número de casa
                    b = v.validarInt(1, 999999999,
                            "Ingrese el número de teléfono de casa: ",
                            "El número ingresado no es válido.");
                    App.aux.setTelefonoCasa(b);
                    break;

                case 4: // Número de trabajo
                    b = v.validarInt(1, 999999999,
                            "Ingrese el número de trabajo: ",
                            "El número ingresado no es válido.");
                    App.aux.setTelefonoTrabajo(b);
                    break;

                case 5: // Dirección
                    s = v.recibirString("Ingrese la dirección: ");
                    App.aux.setDireccion(s);
                    break;

                case 6: // E-mail
                    s = v.recibirString("Ingrese la dirección de e-mail: ");
                    App.aux.setEmail(s);
                    break;
            }
        } while(ed.getEleccion()!=7);
    }

    /**
     * Método para confirmar la eliminación de un contacto
     */
    private void confirmarBorrado(int num) {
        int x;
        x = v.validarInt(0, 1,
                "Se borrará el contacto "+contactos.get(num - 1).getNombre()+"¿Está seguro? 1=Sí 0=No\nEscoja una opción: ",
                "La opción ingresada no existe.");

        switch (x) {
            case 1:
                contactos.remove(num - 1);
                System.out.println("El contacto ha sido borrado exitosamente.");
                break;
            case 0:
                System.out.println("El contacto no se borró.");
                break;
        }

    }

    //// Getters y Setters

    //// toString

}
