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
        // Llenar List con opciones
        this.opciones.add("Cambiar nombre");
        this.opciones.add("Editar números de celular");
        this.opciones.add("Editar números de teléfono fijo");
        this.opciones.add("Editar números de trabajo");
        this.opciones.add("Editar direcciones");
        this.opciones.add("Editar e-mails");
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
        enumerarListString(opciones);

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
            case 1: //// "Cambiar nombre"
                sub = new SubmenuEditor(aux, NOMBRE);
                break;

            case 2: //// "Editar números de celular"
                sub = new SubmenuEditor(aux, CELULAR);
                System.out.println(aux.toString());
                break;

            case 3: //// "Editar números de teléfono fijo"
                switchFijo();
                System.out.println(aux.toString());
                break;

            case 4: //// "Editar números de trabajo"
                switchTrabajo();
                System.out.println(aux.toString());
                break;

            case 5: //// "Editar direcciones"
                switchDireccion();
                System.out.println(aux.toString());
                break;

            case 6: //// "Editar e-mails"
                switchEmail();
                System.out.println(aux.toString());
                break;

            case 7: //// "Salir"
                this.seguir = !salirConfirmarCambios(); // Si se escoge salir, no seguir editando
        }
    }

    /**
     * Método con la opción 3 del menú, editar números de teléfono fijo
     */
    public void switchFijo(){
        int b;

        b = v.validarInt(1, 999999999,
                "Ingrese el número de teléfono fijo: ",
                "El número ingresado no es válido.");
        aux.setTelefonoFijo(b);;
        System.out.println("El número de teléfono fijo fue agregado con éxito.");
    }

    /**
     * Método con la opción 4 del menú, editar números de trabajo
     */
    public void switchTrabajo(){
        int b;

        b = v.validarInt(1, 999999999,
                "Ingrese el número de trabajo: ",
                "El número ingresado no es válido.");
        aux.setTelefonoTrabajo(b);
        System.out.println("El número de trabajo fue agregado con éxito.");
    }

    /**
     * Método con la opción 5 del menú, editar direcciones
     */
    public void switchDireccion(){
        String s;

        s = v.recibirString("Ingrese la dirección: ");
        aux.setDireccion(s);
        System.out.println("La dirección fue agregada con éxito.");
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
        boolean salirEditor = salir("menú de edición");

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
