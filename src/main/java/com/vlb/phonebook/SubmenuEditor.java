package com.vlb.phonebook;

public class SubmenuEditor extends Menu{

    //// Atributos
    /**
     * Constante que define el funcionamiento del submenú
     */
    int constante; // entre 0 y 8

    String[] tipoSingular = {""};
    String[] tipoPlural = {""};


    //// Constructores
    public SubmenuEditor(int constante) {
        // Iniciar atributos
        this.constante = constante;

        // Llenar ArrayList de opciones


        // Muestra el submenú de edición y lo repite hasta que "seguir" sea false
        this.seguir = true;
        do {
            desplegarMenu();
            switchMenu();
        } while (this.seguir);
    }

    //// Métodos
    public void desplegarMenu(){

    }

    public void switchMenu(){

    }
}
