package com.vlb.phonebook;

public class SubmenuEditor extends Menu{

    //// Atributos
    /**
     * Contacto que se va a editar
     */
    Contacto contacto;
    /**
     * Constante que define el funcionamiento del submenú
     */
    int constante; // entre 0 y 8
    /**
     * Nombres de los atributos del contacto, en singular
     */
    String[] tipoSingular = {"nombre", "teléfono celular", "teléfono fijo", "teléfono de trabajo", "dirección", "e-mail", "apodo", "fecha de cumpleaños", "nota"};
    /**
     * Nombres de los atributos del contacto, en plural (los que no pueden ser más de uno están vacíos)
     */
    String[] tipoPlural = {"", "teléfonos celulares", "teléfonos fijos", "teléfonos de trabajo", "direcciones", "e-mails", "apodos", "", "notas"};


    //// Constructores
    public SubmenuEditor(Contacto contacto, int constante) {
        // Iniciar atributos
        this.contacto = contacto;
        this.constante = constante;

        if(constante==0){
            menuNombre(); // Si quiere cambiar el nombre, no hay opciones
        }

        else{
            // Llenar ArrayList de opciones
            llenarOpciones();

            // Muestra el submenú de edición y lo repite hasta que "seguir" sea false
            this.seguir = true;
            do {
                desplegarMenu();
                switchMenu();
            } while (this.seguir);
        }
    }

    //// Métodos

    /**
     * Método con la opción 1 del menú editor, cambiar nombre
     */
    public void menuNombre(){
        String s = v.recibirString("Ingrese el "+tipoSingular[constante]+" del contacto: ");
        contacto.setNombre(s);
        System.out.println("El nombre fue cambiado con éxito.");
    }

    public void llenarOpciones(){
        switch(this.constante){
            case 0:

        }
    }

    public void desplegarMenu(){

    }

    public void switchMenu(){

    }
}
