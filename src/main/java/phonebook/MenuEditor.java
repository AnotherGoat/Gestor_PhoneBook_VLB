package phonebook;

// Importa la agenda de uso "global"
import json.GestorJSON;
import lanzador.Principal;

/**
 * Acá irá el menú para editar contactos
 */
public class MenuEditor extends Menu {

    //// Atributos
    /**
     * Contacto original de la agenda
     */
    private Contacto original;
    /**
     * Posicion del contacto original en la agenda
     */
    private final int posicionOriginal;
    /**
     * Contacto auxiliar, se usa para permitir elegir si guardar los cambios o no
     */
    protected Contacto aux;

    //// Constructores
    public MenuEditor(int posicionOriginal) {
        // Nombre
        this.nombreMenu = "menú de edición";

        // Llenar ArrayList con opciones
        this.opciones.add("Cambiar nombre");
        this.opciones.add("Editar números de teléfono");
        this.opciones.add("Editar dirección");
        this.opciones.add("Editar fecha de cumpleaños");
        this.opciones.add("Editar emails");
        this.opciones.add("Editar apodos");
        this.opciones.add("Editar notas");
        this.opciones.add("Salir");

        // Tomar contacto que se va a editar (paso por referencia) y su posición
        this.original = Principal.agenda.getLista_Contactos().get(posicionOriginal);
        this.posicionOriginal = posicionOriginal;

        // Copia el contacto original a uno auxiliar (paso por valor)
        this.aux = new Contacto(original);

        // Muestra el menú principal del gestor y lo repite hasta que "seguir" sea false
        this.seguir = true;
        do {
            desplegarMenu();
            switchMenu();
        } while (this.seguir);
    }

    //// Métodos

    /**
     * Método que muestra un menú con las opciones del gestor
     */
    private void desplegarMenu() {

        // Muestra el nombre del gestor con algo de decoración
        mostrarLogo();

        System.out.println("Menú de edición:");

        // Muestra las opciones
        System.out.println(enumerarListaString(opciones));

        //eleccion = v.validarIntEntre(1, opciones.size(),
        //       "Escoja una opción: ",
        //        "La opción ingresada no existe.");
    }

    /**
     * Método para instanciar un submenú dependiendo de lo que haya ingresado el usuario
     */
    private void switchMenu() {

        switch (eleccion) {
            //// "Cambiar nombre"
            case 1 -> new EditorNombre(aux);
            //// "Editar números de teléfono"
            case 2 -> new EditorTelefono(aux);
            //// "Editar dirección"
            case 3 -> new EditorDireccion(aux);
            //// "Editar fecha de cumpleaños"
            case 4 -> new EditorFechaCumple(aux);
            //// "Editar emails"
            case 5 -> new EditorEmail(aux);
            //// "Editar apodos"
            case 6 -> new EditorApodo(aux);
            //// "Editar notas"
            case 7 -> new EditorNota(aux);
            //// "Salir
            //case 8 -> this.seguir = !salirConfirmarCambios(); // Si se escoge salir, no seguir editando
        }
    }

    /*
    /**
     * Método que se usa para confirmar la salida del programa y los cambios realizados
     * @return Boolean que le indica al programa si el usuario quiere salir (true) o no (false)
     */
    /*
    public boolean salirConfirmarCambios() {

        boolean salirEditor = salir();
        // En caso de querer salir, hacer lo siguiente
        if(salirEditor) {
            System.out.println("¿Desea guardar los cambios realizados? 1=Sí, 0=No");
            //int b = v.validarIntEntre(0, 1,
            //        "Escoja una opción: ",
            //        "La opción ingresada no existe.");

            /*
            switch (b) {
                case 1:
                    // Copia el contacto de vuelta a la agenda
                    Principal.agenda.getLista_Contactos().set(posicionOriginal, new Contacto(aux));
                    // Ordena la lista de contactos
                    Principal.agenda.ordenarContactos();
                    // Guarda los cambios hechos en "agenda.json"
                    GestorJSON.guardarJSON("agenda.json");

                    System.out.println("Los cambios han sido guardados.");
                    break;
                case 0:
                    System.out.println("Los cambios no se han guardado.");
            }
             */
        //}
    /*
        return salirEditor;
    }
    */
}