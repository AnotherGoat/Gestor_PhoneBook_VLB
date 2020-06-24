package com.vlb.phonebook;

// Importa la agenda de uso "global"
import java.sql.SQLOutput;

import static com.vlb.phonebook.Principal.agenda;

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
    private int posicionOriginal;
    /**
     * Contacto auxiliar, se usa para permitir elegir si guardar los cambios o no
     */
    protected Contacto aux = new Contacto();

    //// Constructores
    public MenuEditor(int posicionOriginal) {
        // Nombre
        this.nombreMenu = "menú de edición";

        // Llenar List con opciones
        this.opciones.add("Cambiar nombre");
        this.opciones.add("Editar números de teléfono");
        this.opciones.add("Editar dirección");
        this.opciones.add("Editar e-mails");
        this.opciones.add("Editar apodos");
        this.opciones.add("Editar fecha de cumpleaños");
        this.opciones.add("Editar notas");
        this.opciones.add("Salir");

        // Tomar contacto que se va a editar (paso por referencia) y su posición
        this.original = agenda.getContactos().get(posicionOriginal);
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

        eleccion = v.validarInt(1, opciones.size(),
                "Escoja una opción: ",
                "La opción ingresada no existe.");
    }

    /**
     * Método para crear menús dependiendo de lo que haya ingresado el usuario
     */
    private void switchMenu() {
        Menu sub;

        switch (eleccion) {
            case NOMBRE+1: //// "Cambiar nombre"
                sub = new SubmenuEditor(aux, NOMBRE);
                break;

            case TELEFONO+1: //// "Editar números de celular"
                sub = new SubmenuEditor(aux, TELEFONO);
                System.out.println(aux.toString());
                break;

            case DIRECCION+1: //// "Editar dirección"
                sub = new SubmenuEditor(aux, DIRECCION);
                System.out.println(aux.toString());
                break;

            case EMAIL+1: //// "Editar e-mails"
                switchEmail();
                System.out.println(aux.toString());
                break;

            case APODO+1: //// "Editar apodo"
                break;

            case FECHACUMPLE+1: //// "Editar fecha de cumpleaños"
                break;

            case NOTAS+1: //// "Editar notas"
                break;

            case NOTAS+2: //// "Salir"
                this.seguir = !salirConfirmarCambios(); // Si se escoge salir, no seguir editando
        }
    }

    /**
     * Método con la opción 6 del menú, editar direcciones
     */
    public void switchEmail(){
        String s;

        s = v.recibirString("Ingrese la dirección de e-mail: ");
        aux.setEmail(s);
        System.out.println("El e-mail fue agregado con éxito.");
    }

    /**
     * Método que se usa para confirmar la salida del programa y los cambios realizados
     * @return Boolean que le indica al programa si el usuario quiere salir (true) o no (false)
     */
    public boolean salirConfirmarCambios() {
        boolean salirEditor = salir();

        // En caso de querer salir, hacer lo siguiente
        if(salirEditor) {
            System.out.println("¿Desea guardar los cambios realizados? 1=Sí 0=No");
            int b = v.validarInt(0, 1,
                    "Escoja una opción: ",
                    "La opción ingresada no existe.");

            switch (b) {
                case 1:
                    // Copia el contacto de vuelta
                    agenda.getContactos().set(posicionOriginal, new Contacto(aux));

                    System.out.println("Los cambios han sido guardados.");
                    break;
                case 0:
                    System.out.println("Los cambios no se han guardado.");
            }
        }

        return salirEditor;
    }
}
