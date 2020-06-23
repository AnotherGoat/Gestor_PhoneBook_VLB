package com.vlb.phonebook;

public class SubmenuEditor extends Menu{

    //// Atributos
    /**
     * Contacto que se va a editar
     */
    Contacto contacto;
    /**
     * <p>Int que define el tipo de dato que edita el submenú, se usan las constantes de la clase Menu</p>
     * <p>Estas constantes son: NOMBRE, TELEFONO, DIRECCION, EMAIL, APODO, FECHACUMPLE, NOTAS</p>
     */
    int tipo; // entre 0 y 8
    /**
     * Tipo de atributo que se usará en las opciones, en singular
     */
    String tipoSingular;
    /**
     * Tipo de atributo que se usará en las opciones, en plural
     */
    String tipoPlural;

    //// Constructores
    public SubmenuEditor(Contacto contacto, int tipo) {
        // Iniciar atributos
        this.contacto = contacto;
        this.tipo = tipo;
        inicializarNombres(); // tipoSingular y tipoPlural
        this.nombreMenu = "menú de edición de "+tipoPlural;

        if(tipo<NOMBRE || tipo>NOTAS){
            System.out.println("Error: Tipo de dato fuera de rango");
        }
        else if(tipo==NOMBRE){
            menuNombre(); // Si quiere cambiar el nombre, no hay opciones
        }

        else if(tipo==DIRECCION){
            menuDireccion(); // Si quiere cambiar la dirección, no hay opciones
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
     * <p>Este método se encarga de inicializar los nombres de cada tipo de dato del contacto</p>
     * <p>Se inician por separado en singular y plural</p>
     */
    public void inicializarNombres(){
        switch(tipo){
            case NOMBRE:
                tipoSingular = "nombre";
                tipoPlural = "nombres";
                break;
            case TELEFONO:
                tipoSingular = "número de teléfono";
                tipoPlural = "números de teléfono";
                break;
            case DIRECCION:
                tipoSingular = "dirección";
                tipoPlural = "";
                break;
            case EMAIL:
                tipoSingular = "e-mail";
                tipoPlural = "e-mails";
                break;
            case APODO:
                tipoSingular = "apodo";
                tipoPlural = "apodos";
                break;
            case FECHACUMPLE:
                tipoSingular = "fecha de cumpleaños";
                tipoPlural = "";
                break;
            case NOTAS:
                tipoSingular = "nota";
                tipoPlural = "notas";
        }
    }

    /**
     * Método con la opción 1 del menú editor, cambiar nombre
     */
    public void menuNombre(){
        String s = v.recibirString("Nombre actual: " +contacto.getNombre()+
                "\nIngrese el nuevo "+tipoSingular+" del contacto: ");
        contacto.setNombre(s);
        System.out.println(mensajeExito("cambiado"));
    }

    public void menuDireccion(){
        // Aquí va un menú parecido al menuNombre
    }

    /**
     * Método que llena las opciones del submenú
     */
    public void llenarOpciones(){
        opciones.add("Agregar "+tipoSingular);
        opciones.add("Cambiar "+tipoSingular);
        opciones.add("Borrar "+tipoSingular);
        opciones.add("Volver atrás");
    }

    /**
     * Método que muestra las opciones del submenú
     */
    private void desplegarMenu(){
        // Muestra el nombre del gestor con algo de decoración
        mostrarLogo();

        System.out.println("Menú de edición de "+tipoPlural+":");

        // Muestra las opciones
        System.out.println(enumerarListaString(opciones));

        eleccion = v.validarInt(1, opciones.size(),
                "Escoja una opción: ",
                "La opción ingresada no existe.");
    }

    /**
     * Método para realizar procedimientos distintos según la opción ingresada
     */
    private void switchMenu(){
        switch(eleccion){
            case 1: //// "Añadir ..."
                switchCaso1();
                break;

            case 2: //// "Cambiar ..."
                switchCaso2();
                break;

            case 3: //// "Borrar ..."
                switchCaso3();
                break;

            case 4: //// "Volver atrás"
                System.out.println("Ha salido del "+nombreMenu);
                seguir = false; // No pide confirmación
        }
    }

    //// Métodos del switch
    /**
     * Método para la opción "Añadir ..."
     */
    private void switchCaso1(){
        int a, b; // Se usan para tomar entrada en las opciones

        switch(tipo){
            case TELEFONO: // En caso de querer agregar un teléfono
                a = v.validarInt(1, 999999999,
                        "Ingrese el "+tipoSingular,
                        "El "+tipoSingular+" ingresado no es válido.");

                System.out.println("¿Qué tipo de teléfono agregó?\n1=Celular, 2=Fijo, 3=Trabajo");

                b = v.validarInt(1, 3,
                        "Escoja una opción:",
                        "La opción ingresada no es válida");
                // Pero esta sección cambia según el caso

                System.out.println(mensajeExito("agregado"));

                switch(b){
                    case 1:
                        contacto.getTelefonos().add(new Telefono (a, "Celular"));
                        break;
                    case 2:
                        contacto.getTelefonos().add(new Telefono (a, "Fijo"));
                        break;
                    case 3:
                        contacto.getTelefonos().add(new Telefono (a, "Trabajo"));
                }
                break;

            case DIRECCION:
            case EMAIL:
            case APODO:
            case FECHACUMPLE:
            case NOTAS:
        }
    }

    /**
     * Método para la opción "Cambiar ..."
     */
    private void switchCaso2(){
        int a; // Se usa para recibir entrada en este switch

        switch(tipo){
            case CELULAR:
                if(contacto.getTelefonosCelular().size() == 0){
                    System.out.println("Este contacto no tiene "+ tipoPlural +" guardados");
                }
                else {
                    // Muestra los ... ya registrados
                    System.out.println(enumerarListaInteger(contacto.getTelefonosCelular()));

                    // Pide al usuario que elija uno
                    a = v.validarInt(1, contacto.getTelefonosCelular().size(),
                            "Escoja el número de celular que quiere cambiar: ",
                            "El número ingresado no es válido.");

                    // Muestra el ... actual y pide uno nuevo
                    System.out.println("Actual: "+contacto.getTelefonosCelular().get(a-1));
                    a = v.validarInt(1, 999999999,
                            "Nuevo: ",
                            "El número ingresado no es válido.");

                    // Almacena el ... y muestra un mensaje de que funcionó
                    contacto.getTelefonosCelular().add(a);
                    System.out.println("El "+tipoSingular+" fue agregado con éxito.");
                }

            case FIJO:
            case TRABAJO:
            case DIRECCION:
            case EMAIL:
            case APODO:
            case FECHACUMPLE:
            case NOTAS:
        }
    }

    /**
     * Método para la opción "Borrar ..."
     */
    private void switchCaso3(){

    }

    //// Métodos de texto
    /**
     * Retorna un String con un mensaje de éxito, dependiendo de la acción ingresada
     * @param accion Verbo que va entre "fue ... con éxito"
     * @return Retorna un String con un mensaje de éxito
     */
    private String mensajeExito(String accion){
        return "El "+tipoSingular+" fue "+accion+" con éxito.";
    }
}