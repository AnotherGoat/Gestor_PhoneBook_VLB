package com.vlb.phonebook;

public class SubmenuEditor extends Menu{

    //// Atributos
    /**
     * Contacto que se va a editar
     */
    Contacto contacto;
    /**
     * <p>Int que define el tipo de dato que edita el submenú, se usan las constantes de la clase Menu</p>
     * <p>Estas constantes son: NOMBRE, CELULAR, FIJO, TRABAJO, DIRECCION, EMAIL, APODO, FECHACUMPLE, NOTAS</p>
     */
    int tipo; // entre 0 y 8
    /**
     * Nombres de los atributos del contacto, en singular
     */
    String[] nombreSingular = {"nombre", "número de celular", "número fijo", "número de trabajo", "dirección", "e-mail", "apodo", "fecha de cumpleaños", "nota"};
    /**
     * Nombres de los atributos del contacto, en plural (los que no pueden ser más de uno están vacíos)
     */
    String[] nombrePlural = {"", "números de celulares", "números fijos", "números de trabajo", "direcciones", "e-mails", "apodos", "", "notas"};


    //// Constructores
    public SubmenuEditor(Contacto contacto, int tipo) {
        // Iniciar atributos
        this.contacto = contacto;
        this.tipo = tipo;

        if(tipo<NOMBRE || tipo>NOTAS){
            System.out.println("Error: Tipo de dato fuera de rango");
        }
        else if(tipo==NOMBRE){
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
        String s = v.recibirString("Nombre actual: " +contacto.getNombre()+
                "\nIngrese el nuevo "+nombreSingular[tipo]+" del contacto: ");
        contacto.setNombre(s);
        System.out.println(mensajeExito("cambiado"));
    }

    /**
     * Método que llena las opciones del submenú
     */
    public void llenarOpciones(){
        opciones.add("Agregar "+nombreSingular[tipo]);
        opciones.add("Cambiar "+nombreSingular[tipo]);
        opciones.add("Borrar "+nombreSingular[tipo]);
        opciones.add("Volver atrás");
    }

    private void desplegarMenu(){
        enumerarListString(opciones);
    }

    private void switchMenu(){

    }

    //// Métodos de mensajes que muestra el programa
    /**
     * Retorna un String con un mensaje de éxito, dependiendo de la acción ingresada
     * @param accion Verbo que va entre "fue ... con éxito"
     * @return Retorna un String con un mensaje de éxito
     */
    private String mensajeExito(String accion){
        return "El "+nombreSingular[tipo]+" fue "+accion+" con éxito.";
    }
}