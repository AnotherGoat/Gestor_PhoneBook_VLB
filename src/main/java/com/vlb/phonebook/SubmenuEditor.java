package com.vlb.phonebook;

import java.beans.FeatureDescriptor;
import java.util.Date;

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
        String s = v.recibirString("Nombre actual: " +contacto.getNombre()+"\nNombre nuevo: ");
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

        // En caso de elegir cualquier opción excepto dirección y fecha de cumpleaños
        if((tipo!=DIRECCION && tipo!=FECHACUMPLE)){
            opciones.add("Agregar " + tipoSingular);
        }
        // Si no hay una dirección guardada
        else if((tipo==DIRECCION && contacto.getDireccion()==null)){
            opciones.add("Agregar " + tipoSingular);
        }
        // Si no hay una fecha de cumpleaños guardada
        else if((tipo==FECHACUMPLE && contacto.getFechaCumple()==null)){
            opciones.add("Agregar " + tipoSingular);
        }

        // En caso de elegir cualquier opción excepto dirección y fecha de cumpleaños
        if((tipo!=DIRECCION && tipo!=FECHACUMPLE)){
            opciones.add("Cambiar " + tipoSingular);
        }
        // Si ya hay una dirección guardada
        else if((tipo==DIRECCION && contacto.getDireccion()!=null)){
            opciones.add("Cambiar " + tipoSingular);
        }
        // Si ya hay una fecha de cumpleaños guardada
        else if((tipo==FECHACUMPLE && contacto.getFechaCumple()!=null)){
            opciones.add("Cambiar " + tipoSingular);
        }

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

            case 4: //// "Volver atrás", no existe en los casos "dirección" y "fechacumple"
                volverAtras();
        }
    }

    //// Métodos del switch
    /**
     * Método con los métodos que realiza la primera opción de switchMenu()
     */
    private void switchCaso1(){
        // Se usan para recibir entrada en este switch
        int a, b;
        String s, t;

        switch(tipo){
            case TELEFONO:
                // En caso de querer agregar un teléfono
                a = v.validarInt(1, 999999999,
                        "Ingrese el "+tipoSingular +": ",
                        "El "+tipoSingular+" ingresado no es válido.");

                b = elegirTipoTelefono();

                // Esta sección cambia según el caso
                switch (b) {
                    case 1 -> contacto.getTelefonos().add(new Telefono(a, "Celular"));
                    case 2 -> contacto.getTelefonos().add(new Telefono(a, "Fijo"));
                    case 3 -> contacto.getTelefonos().add(new Telefono(a, "Trabajo"));
                }
                System.out.println(mensajeExito("agregado"));
                break;

            case DIRECCION:
                if(contacto.getDireccion()==null){
                    System.out.println("Este contacto no tiene una dirección guardada");
                    System.out.println("Ingrese los datos de la dirección del contacto");

                    s = v.recibirString("Ciudad: ");
                    t = v.recibirString("Calle: ");
                    a = v.validarInt("Número: ");

                    // Muestra el mensaje de éxito
                    System.out.println("La " + tipoSingular + " fue guardada con éxito.");
                }
                else{
                    System.out.println("Este contacto ya tiene una dirección guardada");
                    System.out.println("Dirección actual: "+contacto.getDireccion().toString());
                    System.out.println("Ingrese los datos de la nueva dirección del contacto");

                    s = v.recibirString("Ciudad actual: "+contacto.getDireccion().getCiudad()+"\nCiudad nueva: ");
                    t = v.recibirString("Calle actual: "+contacto.getDireccion().getCalle()+"\nCalle nueva: ");
                    a = v.validarInt("Número actual: "+contacto.getDireccion().getNumero()+"\nNúmero nuevo: ");

                    // Muestra el mensaje de éxito
                    System.out.println("La " + tipoSingular + " fue cambiada con éxito.");
                }
                // Guarda la dirección
                contacto.setDireccion(new Direccion(s, t, a));
                break;

            case EMAIL:
            case APODO:
            case FECHACUMPLE:
            case NOTAS:
        }
    }

    /**
     * Método con los métodos que realiza la segunda opción de switchMenu)
     */
    private void switchCaso2(){
        // Se usan para recibir entrada en este switch
        int a, b, c;

        switch(tipo){
            case TELEFONO:
                if(contacto.getTelefonos() == null){
                    System.out.println("Este contacto no tiene "+ tipoPlural +" guardados");
                }

                else {
                    a = elegirTelefono("cambiar");
                    String actual = contacto.getTelefonos().get(a-1).getNumero()+" ("+contacto.getTelefonos().get(a-1).getTipo()+")";

                    // Muestra el número actual y pide uno nuevo
                    System.out.println("Número actual: "+actual);
                    b = v.validarInt(1, 999999999,
                            "Número nuevo: ",
                            "El número ingresado no es válido.");

                    c = elegirTipoTelefono();

                    // Esta sección cambia según el caso
                    switch (c) {
                        case 1 -> contacto.getTelefonos().set(a-1, new Telefono(b, "Celular"));
                        case 2 -> contacto.getTelefonos().set(a-1, new Telefono(b, "Fijo"));
                        case 3 -> contacto.getTelefonos().set(a-1, new Telefono(b, "Trabajo"));
                    }
                    // Muestra el mensaje de éxito
                    System.out.println(mensajeExito("cambiado"));
                }
                break;

            case DIRECCION:
                if(contacto.getDireccion()==null){ // Si no tiene una dirección guardada
                    System.out.println("El contacto no tiene una dirección guardada");
                }
                else { // Si la tiene, borrarla
                    confirmarBorradoDireccion();
                }
                break;

            case EMAIL:
            case APODO:
            case FECHACUMPLE:
                if(contacto.getFechaCumple()==null){ // Si no tiene una fecha de cumpleaños guardada
                    System.out.println("El contacto no tiene una fecha de cumpleaños guardada");
                }
                else { // Si la tiene, borrarla
                    confirmarBorradoFechaCumple();
                }
                break;

            case NOTAS:
        }
    }

    /**
     * Método con los métodos que realiza la tercera opción de switchMenu)
     */
    private void switchCaso3(){
        int a;

        switch(tipo){
            case TELEFONO:
                if(contacto.getTelefonos() == null){
                    System.out.println("Este contacto no tiene "+ tipoPlural +" guardados");
                }
                else{
                    a = elegirTelefono("borrar");
                    confirmarBorradoTelefono(a-1);
                }
                break;

            case DIRECCION:
            case FECHACUMPLE:
                volverAtras(); // Esto ocurre porque en los casos "dirección" y "fechacumple" solo hay 3 opciones
                break;

            case EMAIL:
            case APODO:
            case NOTAS:
        }
    }

    /**
     * Método para volver atrás (cuarta o tercera opción de switchMenu)
     */
    private void volverAtras(){
        System.out.println("Ha salido del "+nombreMenu);
        seguir = false; // No pide confirmación
    }

    public int elegirTelefono(String verbo){
        // Muestra los números ya registrados
        System.out.println("Números de teléfono guardados: ");
        System.out.println(enumerarListaTelefono(contacto.getTelefonos()));

        // Pide al usuario que elija uno
        return v.validarInt(1, contacto.getTelefonos().size(),
                "Escoja el "+tipoSingular+" que quiere "+verbo+": ",
                "El número ingresado no es válido.");
    }

    public int elegirTipoTelefono(){
        return v.validarInt(1, 3,
                "¿Qué tipo de teléfono agregó? 1=Celular, 2=Fijo, 3=Trabajo\nEscoja una opción: ",
                "La opción ingresada no es válida");
    }

    /**
     * Método para confirmar la eliminación de un número de teléfono
     * @param posicion Posición del número que se desea borrar
     */
    private void confirmarBorradoTelefono(int posicion) {
        int x = v.validarInt(0, 1,
                "Se borrará el número "+contacto.getTelefonos().get(posicion).getNumero()+
                        " ¿Está seguro? 1=Sí 0=No\nEscoja una opción: ",
                "La opción ingresada no existe.");

        switch (x) {
            case 1:
                contacto.getTelefonos().remove(posicion);
                System.out.println("El contacto ha sido borrado exitosamente.");
                break;
            case 0:
                System.out.println("El número no se borró.");
        }
    }

    private void confirmarBorradoDireccion(){
        int x = v.validarInt(0, 1,
                "Se borrará la dirección del contacto "+contacto.getNombre()+
                        " ¿Está seguro? 1=Sí 0=No\nEscoja una opción: ",
                "La opción ingresada no existe.");

        switch(x){
            case 1:
                contacto.setDireccion(new Direccion());
                System.out.println("La dirección ha sido borrada exitosamente.");
                break;
            case 0:
                System.out.println("La dirección no se borró.");
        }
    }

    private void confirmarBorradoFechaCumple(){
        int x = v.validarInt(0, 1,
                "Se borrará la fecha de cumpleaños del contacto "+contacto.getNombre()+
                        " ¿Está seguro? 1=Sí 0=No\nEscoja una opción: ",
                "La opción ingresada no existe.");

        switch(x){
            case 1:
                contacto.setFechaCumple(new Date());
                System.out.println("La dirección ha sido borrada exitosamente.");
                break;
            case 0:
                System.out.println("La dirección no se borró.");
        }
    }

    //// Métodos de texto
    /**
     * Retorna un String con un mensaje de éxito, dependiendo de la acción ingresada
     * @param accion Verbo que va entre "fue ... con éxito"
     * @return Retorna un String con un mensaje de éxito
     */
    private String mensajeExito(String accion) {
        return "El " + tipoSingular + " fue " + accion + " con éxito.";
    }
}