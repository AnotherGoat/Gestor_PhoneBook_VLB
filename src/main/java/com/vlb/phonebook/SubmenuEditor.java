package com.vlb.phonebook;

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
     * Nombre de atributo que se usará en las opciones, en singular
     */
    String singular;
    /**
     * Nombre de atributo que se usará en las opciones, en plural
     */
    String plural;

    //// Constructores
    public SubmenuEditor(Contacto contacto, int tipo) {
        // Iniciar atributos
        this.contacto = contacto;
        this.tipo = tipo;
        inicializarNombres(); // en singular y en plural
        this.nombreMenu = "menú de edición de "+plural;

        if(tipo<NOMBRE || tipo>NOTAS){
            System.out.println("Error: Tipo de submenú fuera de rango");
        }

        else if(tipo==NOMBRE){
            cambiarNombre(); // Si quiere cambiar el nombre, no hay ninguna opción adicional
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
            case NOMBRE: // No puede ser plural
                singular = "nombre";
                plural = "nombre";
                break;
            case TELEFONO:
                singular = "número de teléfono";
                plural = "números de teléfono";
                break;
            case DIRECCION: // No puede ser plural
                singular = "dirección";
                plural = "dirección";
                break;
            case EMAIL:
                singular = "e-mail";
                plural = "e-mails";
                break;
            case APODO:
                singular = "apodo";
                plural = "apodos";
                break;
            case FECHACUMPLE: // No puede ser plural
                singular = "fecha de cumpleaños";
                plural = "fecha de cumpleaños";
                break;
            case NOTAS:
                singular = "nota";
                plural = "notas";
        }
    }

    /**
     * Método que llena las opciones del submenú
     */
    public void llenarOpciones(){

        //// "Agregar ..."
        // En caso de elegir cualquier opción excepto dirección y fecha de cumpleaños
        if((tipo!=DIRECCION && tipo!=FECHACUMPLE)){
            opciones.add("Agregar " + singular);
        }
        // Si no hay una dirección guardada
        else if((tipo==DIRECCION && contacto.getDireccion()==null)){
            opciones.add("Agregar " + singular);
        }
        // Si no hay una fecha de cumpleaños guardada
        else if((tipo==FECHACUMPLE && contacto.getFechaCumple()==null)){
            opciones.add("Agregar " + singular);
        }

        //// "Cambiar ..."
        // En caso de elegir cualquier opción excepto dirección y fecha de cumpleaños
        if((tipo!=DIRECCION && tipo!=FECHACUMPLE)){
            opciones.add("Cambiar " + singular);
        }
        // Si ya hay una dirección guardada
        else if((tipo==DIRECCION && contacto.getDireccion()!=null)){
            opciones.add("Cambiar " + singular);
        }
        // Si ya hay una fecha de cumpleaños guardada
        else if((tipo==FECHACUMPLE && contacto.getFechaCumple()!=null)){
            opciones.add("Cambiar " + singular);
        }

        opciones.add("Borrar "+singular);
        opciones.add("Volver atrás");
    }

    /**
     * Método que muestra las opciones del submenú
     */
    private void desplegarMenu(){
        // Muestra el nombre del gestor con algo de decoración
        mostrarLogo();

        System.out.println("Menú de edición de "+plural+":");

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
                switchOpcion1();
                break;

            case 2: //// "Cambiar ..."
                switchOpcion2();
                break;

            case 3: //// "Borrar ..."
                switchOpcion3();
                break;

            case 4: //// "Volver atrás", no existe en los casos "dirección" y "fechacumple"
                volverAtras();
        }
    }

    //// Métodos del switch
    /**
     * Método con los métodos que realiza la primera opción de switchMenu()
     */
    private void switchOpcion1(){
        // Se usan para recibir entrada en este switch

        switch(tipo){
            case TELEFONO:
                agregarTelefono();
                break;

            case DIRECCION:
                // Variables que se usan en este caso
                String ciudadNueva, calleNueva;
                int numeroDireccionNuevo;

                // En caso de no tener una dirección guardada
                if(contacto.getDireccion()==null){
                    agregarDireccion();
                }

                // En caso de querer cambiar la dirección por una nueva
                else{
                    cambiarDireccion();
                }
                break;

            case EMAIL:
                String emailNuevo = v.validarEmail();

                // Guarda el e-mail y muestra un mensaje de éxito
                contacto.getEmails().add(emailNuevo);

                System.out.println(mensajeExito("El", "agregado"));
                break;

            case APODO:
                String apodoNuevo = v.recibirString("Ingrese el apodo: ");
                contacto.getApodos().add(apodoNuevo);
                System.out.println(mensajeExito("El", "agregado"));
                break;

            case FECHACUMPLE:
                // Variables que se usan en este caso
                int mesNuevo, diaNuevo;
                int diasDelMes = 0;

                // En caso de no tener una fecha de cumpleaños guardada
                if(contacto.getFechaCumple()==null){
                    System.out.println("Este contacto no tiene una fecha de cumpleaños guardada");
                    System.out.println("Ingrese los datos de la fecha de cumpleaños del contacto");

                    mesNuevo = v.validarInt(1, 12, "Mes: ", "Error: Por favor ingrese un número entre 1 y 12");

                    // Define la cantidad de días, según el mes ingresado
                    switch(mesNuevo){
                        case 2: // Febrero
                            diasDelMes = 29;
                            break;
                        case 4: // Abril
                        case 6: // Junio
                        case 9: // Septiembre
                        case 11: // Noviembre
                            diasDelMes = 30;
                            break;
                        case 1: // Enero
                        case 3: // Marzo
                        case 5: // Mayo
                        case 7: // Julio
                        case 8: // Agosto
                        case 10: // Octubre
                        case 12: // Diciembre
                            diasDelMes = 31;
                    }

                    diaNuevo = v.validarInt(1, diasDelMes, "Día: ", "Error: Por favor ingrese un número entre 1 y " + diasDelMes);

                    // Muestra el mensaje de éxito
                    System.out.println("La fecha de cumpleaños fue guardada con éxito.");
                }

                // En caso de querer cambiar la dirección por una nueva
                else{
                    System.out.println("Este contacto ya tiene una fecha de cumpleaños guardada");
                    System.out.println("Fecha de cumpleaños actual: "+contacto.getFechaCumple().toString());
                    System.out.println("Ingrese los datos de la nueva fecha de cumpleaños");

                    // Pide al usuario que ingrese el mes nuevo
                    mesNuevo = v.validarInt(1, 12,
                            "Mes actual: "+contacto.getFechaCumple().getMes()+" ("+contacto.getFechaCumple().getNumeroMes()+")\nCiudad nueva: ",
                            "Error: Por favor ingrese un número entre 1 y 12");

                    // Define la cantidad de días, según el mes ingresado
                    switch(mesNuevo){
                        case 2: // Febrero
                            diasDelMes = 29;
                            break;
                        case 4: // Abril
                        case 6: // Junio
                        case 9: // Septiembre
                        case 11: // Noviembre
                            diasDelMes = 30;
                            break;
                        case 1: // Enero
                        case 3: // Marzo
                        case 5: // Mayo
                        case 7: // Julio
                        case 8: // Agosto
                        case 10: // Octubre
                        case 12: // Diciembre
                            diasDelMes = 31;
                    }

                    diaNuevo = v.validarInt(1, diasDelMes, "Día actual: "+contacto.getFechaCumple().getDia()+"\nDía nuevo: ",
                            "Error: Por favor ingrese un número entre 1 y " + diasDelMes);

                    // Muestra el mensaje de éxito
                    System.out.println("La fecha de cumpleaños fue guardada con éxito.");
                }

                // Guarda la fecha de cumpleaños nueva
                contacto.setFechaCumple(new FechaCumple(diaNuevo, mesNuevo));
                break;

            case NOTAS:
                String notaNueva = v.recibirString("Ingrese la nota: ");

                contacto.getNotas().add(notaNueva);
                System.out.println(mensajeExito("La", "agregada"));
        }
    }

    /**
     * Método con los métodos que realiza la segunda opción de switchMenu)
     */
    private void switchOpcion2(){
        switch(tipo){
            case TELEFONO:
                if(contacto.getTelefonos() == null){
                    System.out.println("Este contacto no tiene "+ plural +" guardados");
                }

                else {
                    int posicionTelefono = elegirTelefono("cambiar");
                    posicionTelefono--; // Le resta 1 porque los ArrayList empiezan con indice 0

                    // Número actual (número + tipo entre paréntesis)
                    String numeroActual = contacto.getTelefonos().get(posicionTelefono).getNumero()+" ("+contacto.getTelefonos().get(posicionTelefono).getTipo()+")";

                    // Muestra el número actual y pide uno nuevo
                    System.out.println("Número actual: "+numeroActual);
                    int numeroNuevo = v.validarInt(1, 999999999,
                            "Número nuevo: ",
                            "El número ingresado no es válido.");

                    int tipoTelefono = elegirTipoTelefono();

                    // Esta sección cambia según el tipo de teléfono
                    String tipoString = "";
                    switch (tipoTelefono) {
                        case 1 -> tipoString = "Celular";
                        case 2 -> tipoString = "Fijo";
                        case 3 -> tipoString = "Trabajo";
                    }

                    // Guarda los cambios
                    contacto.getTelefonos().set(posicionTelefono, new Telefono(numeroNuevo, tipoString));
                    // Muestra el mensaje de éxito
                    System.out.println(mensajeExito("El", "cambiado"));
                }
                break;

            case DIRECCION: // Recordar que en este caso, se escoge "Borrar dirección"
                // Si no tiene una dirección guardada
                if(contacto.getDireccion()==null){
                    System.out.println("El contacto no tiene una dirección guardada");
                }
                else { // Si la tiene, borrarla, pero pedir confirmación antes
                    confirmarBorradoDireccion();
                }
                break;

            case EMAIL:
                // En caso de no tener e-mails guardados
                if(contacto.getEmails() == null){
                    System.out.println("Este contacto no tiene e-mails guardados");
                }

                // Si hay e-mails guardados
                else {
                    int posicionEmail = elegirEmail("cambiar");
                    posicionEmail--; // Le resta 1 porque los ArrayList empiezan desde 0
                    String emailActual = contacto.getEmails().get(posicionEmail);

                    // Muestra el e-mail actual y pide uno nuevo
                    System.out.println("E-mail actual: "+emailActual);
                    String emailNuevo = v.validarEmail();

                    // Actualizar email
                    contacto.getEmails().set(posicionEmail, emailNuevo);
                    // Muestra el mensaje de éxito
                    System.out.println(mensajeExito("El", "cambiado"));
                }
                break;

            case APODO:
                // En caso de no tener apodos guardados
                if(contacto.getApodos() == null){
                    System.out.println("Este contacto no tiene apodos guardados");
                }

                // En caso de sí tener apodos guardados
                else {
                    int posicionApodo = elegirApodo("cambiar");
                    posicionApodo--; // Le resta 1 porque los ArrayList funcionan así

                    // Apodo actual
                    String apodoActual = contacto.getApodos().get(posicionApodo);

                    // Muestra el apodo actual y pide uno nuevo
                    System.out.println("Apodo actual: "+apodoActual);
                    String apodoNuevo = v.recibirString("Apodo nuevo: ");

                    // Actualizar apodo
                    contacto.getApodos().set(posicionApodo, apodoNuevo);
                    // Muestra el mensaje de éxito
                    System.out.println(mensajeExito("El", "cambiado"));
                }
                break;

            case FECHACUMPLE: // Recordar que en este caso, se escoge "Borrar fecha de cumpleaños"
                // Si no tiene una fecha de cumpleaños guardada
                if(contacto.getFechaCumple()==null){
                    System.out.println("El contacto no tiene una fecha de cumpleaños guardada");
                }
                else { // Si la tiene, borrarla, pero pedir confirmación antes
                    confirmarBorradoFechaCumple();
                }
                break;

            case NOTAS:
                // Si no hay notas guardadas
                if(contacto.getNotas() == null){
                    System.out.println("Este contacto no tiene notas guardadas");
                }

                // En caso de que las haya
                else {
                    int posicionNota = elegirNota("cambiar");
                    posicionNota--; // Le resta 1 por el índice

                    String notaActual = contacto.getNotas().get(posicionNota);

                    // Muestra la nota actual y pide uno nuevo
                    System.out.println("Nota actual: "+notaActual);
                    String notaNueva = v.recibirString("Nota nueva: ");

                    // Actualizar nota
                    contacto.getNotas().set(posicionNota, notaNueva);
                    // Muestra el mensaje de éxito
                    System.out.println(mensajeExito("La", "cambiada"));
                }
                break;
        }
    }

    /**
     * Método con los métodos que realiza la tercera opción de switchMenu)
     */
    private void switchOpcion3(){
        switch(tipo){
            case TELEFONO:
                // Si no hay teléfonos guardados
                if(contacto.getTelefonos() == null){
                    System.out.println("Este contacto no tiene "+ plural +" guardados");
                }
                else{
                    int posicionTelefono = elegirTelefono("borrar");
                    posicionTelefono--; // Le resta 1 por el índice que debe tener
                    confirmarBorradoTelefono(posicionTelefono);
                }
                break;

            // Esto ocurre porque en los casos "dirección" y "fechacumple" solo hay 3 opciones (la opción 4 es "volver atrás")
            case DIRECCION:
            case FECHACUMPLE:
                volverAtras();
                break;

            case EMAIL:
                // Si no hay e-mails guardados
                if(contacto.getEmails() == null){
                    System.out.println("Este contacto no tiene e-mails guardados");
                }
                else{
                    int posicionEmail = elegirEmail("borrar");
                    posicionEmail--; // Le resta 1 porque los índices empiezan desde 0
                    confirmarBorradoEmail(posicionEmail);
                }
                break;

            case APODO:
                if(contacto.getApodos() == null){
                    System.out.println("Este contacto no tiene apodos guardados");
                }
                else{
                    int posicionApodo = elegirApodo("borrar");
                    posicionApodo--;
                    confirmarBorradoApodo(posicionApodo);
                }
                break;

            case NOTAS:
                if(contacto.getNotas() == null){
                    System.out.println("Este contacto no tiene "+ plural +" guardadas");
                }
                else{
                    int posicionNota = elegirNota("borrar");
                    posicionNota--;
                    confirmarBorradoNota(posicionNota);
                }
                break;
        }
    }

    //// Métodos de atributo NOMBRE
    /**
     * Método que pide al usuario que ingrese un nombre y lo cambia
     */
    public void cambiarNombre(){
        String s = v.recibirString("Nombre actual: " +contacto.getNombre()+"\nNombre nuevo: ");
        contacto.setNombre(s);
        System.out.println(mensajeExito("El", "cambiado"));
    }

    //// Métodos de atributo TELEFONO
    public int elegirTelefono(String verbo){
        // Muestra los números guardados
        System.out.println("Números de teléfono guardados: ");
        System.out.println(enumerarListaTelefono(contacto.getTelefonos()));

        // Pide al usuario que elija uno
        return v.validarInt(1, contacto.getTelefonos().size(),
                "Escoja el "+singular+" que quiere "+verbo+": ",
                "El número ingresado no es válido.");
    }

    public int elegirTipoTelefono(){
        return v.validarInt(1, 3,
                "¿Qué tipo de teléfono agregó? 1=Celular, 2=Fijo, 3=Trabajo\nEscoja una opción: ",
                "La opción ingresada no es válida");
    }

    public void agregarTelefono(){
        int numeroNuevo = v.validarInt(1, 999999999,
                "Ingrese el número de teléfono: ",
                "El número de teléfono ingresado no es válido.");

        int tipoNumero = elegirTipoTelefono();

        // Esta sección cambia según el tipo de número que escogió
        switch (tipoNumero) {
            case 1 -> contacto.getTelefonos().add(new Telefono(numeroNuevo, "Celular"));
            case 2 -> contacto.getTelefonos().add(new Telefono(numeroNuevo, "Fijo"));
            case 3 -> contacto.getTelefonos().add(new Telefono(numeroNuevo, "Trabajo"));
        }

        System.out.println(mensajeExito("El","agregado"));
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

    //// Métodos de atributo DIRECCION
    private void agregarDireccion(){
        System.out.println("Este contacto no tiene una dirección guardada");
        System.out.println("Ingrese los datos de la dirección del contacto");

        String ciudadNueva = v.recibirString("Ciudad: ");
        String calleNueva = v.recibirString("Calle: ");
        int numeroDireccionNuevo = v.validarInt("Número: ");

        // Guarda la dirección nueva usando los datos ingresados
        Direccion direccionNueva = new Direccion(ciudadNueva, calleNueva, numeroDireccionNuevo);
        contacto.setDireccion(direccionNueva);

        // Muestra el mensaje de éxito
        System.out.println("La dirección fue guardada con éxito.");
    }

    private void cambiarDireccion(){
        // Datos actuales de la dirección
        String direccionActual = contacto.getDireccion().toString();
        String ciudadActual = contacto.getDireccion().getCiudad();
        String calleActual = contacto.getDireccion().getCalle();
        int numeroDireccionActual = contacto.getDireccion().getNumero();

        System.out.println("Este contacto ya tiene una dirección guardada");
        System.out.println("Dirección actual: "+direccionActual);
        System.out.println("Ingrese los datos de la nueva dirección del contacto");

        // Datos nuevos de la dirección
        String ciudadNueva = v.recibirString("Ciudad actual: "+ciudadActual+"\nCiudad nueva: ");
        String calleNueva = v.recibirString("Calle actual: "+calleActual+"\nCalle nueva: ");
        int numeroDireccionNuevo = v.validarInt("Número actual: "+numeroDireccionActual+"\nNúmero nuevo: ");

        // Guarda la dirección nueva usando los datos ingresados
        Direccion direccionNueva = new Direccion(ciudadNueva, calleNueva, numeroDireccionNuevo);
        contacto.setDireccion(direccionNueva);

        // Muestra el mensaje de éxito
        System.out.println("La dirección fue guardada con éxito.");
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

    //// Métodos de atributo EMAIL
    public int elegirEmail(String verbo){
        // Muestra los números guardados
        System.out.println("E-mails guardados: ");
        System.out.println(enumerarListaString(contacto.getEmails()));

        // Pide al usuario que elija uno
        return v.validarInt(1, contacto.getEmails().size(),
                "Escoja el "+singular+" que quiere "+verbo+": ",
                "El número ingresado no es válido.");
    }

    /**
     * Método para confirmar la eliminación de un e-mail
     * @param posicion Posición del e-mail que se desea borrar
     */
    private void confirmarBorradoEmail(int posicion) {
        int x = v.validarInt(0, 1,
                "Se borrará el e-mail "+contacto.getEmails().get(posicion)+
                        " ¿Está seguro? 1=Sí 0=No\nEscoja una opción: ",
                "La opción ingresada no existe.");

        switch (x) {
            case 1:
                contacto.getEmails().remove(posicion);
                System.out.println("El e-mail ha sido borrado exitosamente.");
                break;
            case 0:
                System.out.println("El e-mail no se borró.");
        }
    }

    //// Métodos de atributo APODO
    public int elegirApodo(String verbo){
        // Muestra los apodos guardados
        System.out.println("Apodos guardados: ");
        System.out.println(enumerarListaString(contacto.getApodos()));

        // Pide al usuario que elija uno
        return v.validarInt(1, contacto.getApodos().size(),
                "Escoja el "+singular+" que quiere "+verbo+": ",
                "El número ingresado no es válido.");
    }

    /**
     * Método para confirmar la eliminación de un apodo
     * @param posicion Posición del apodo que se desea borrar
     */
    private void confirmarBorradoApodo(int posicion) {
        int x = v.validarInt(0, 1,
                "Se borrará el apodo "+contacto.getApodos().get(posicion)+
                        " ¿Está seguro? 1=Sí 0=No\nEscoja una opción: ",
                "La opción ingresada no existe.");

        switch (x) {
            case 1:
                contacto.getApodos().remove(posicion);
                System.out.println("El apodo ha sido borrado exitosamente.");
                break;
            case 0:
                System.out.println("El apodo no se borró.");
        }
    }

    //// Métodos de atributo FECHACUMPLE
    private void confirmarBorradoFechaCumple(){
        int x = v.validarInt(0, 1,
                "Se borrará la fecha de cumpleaños del contacto "+contacto.getNombre()+
                        " ¿Está seguro? 1=Sí 0=No\nEscoja una opción: ",
                "La opción ingresada no existe.");

        switch(x){
            case 1:
                contacto.setFechaCumple(new FechaCumple());
                System.out.println("La dirección ha sido borrada exitosamente.");
                break;
            case 0:
                System.out.println("La dirección no se borró.");
        }
    }

    //// Métodos de atributo NOTA
    public int elegirNota(String verbo){
        // Muestra las notas guardadas
        System.out.println("Notas guardadas: ");
        System.out.println(enumerarListaString(contacto.getNotas()));

        // Pide al usuario que elija una
        return v.validarInt(1, contacto.getNotas().size(),
                "Escoja la "+singular+" que quiere "+verbo+": ",
                "El número ingresado no es válido.");
    }

    /**
     * Método para confirmar la eliminación de una nota
     * @param posicion Posición de la nota que se desea borrar
     */
    private void confirmarBorradoNota(int posicion) {
        int x = v.validarInt(0, 1,
                "Se borrará la nota \""+contacto.getNotas().get(posicion)+
                        "\"\n¿Está seguro? 1=Sí 0=No\nEscoja una opción: ",
                "La opción ingresada no existe.");

        switch (x) {
            case 1:
                contacto.getNotas().remove(posicion);
                System.out.println("La nota ha sido borrado exitosamente.");
                break;
            case 0:
                System.out.println("La nota no se borró.");
        }
    }

    //// Métodos de uso general
    /**
     * Método para volver atrás (cuarta o tercera opción de switchMenu)
     */
    private void volverAtras(){
        System.out.println("Ha salido del "+nombreMenu);
        seguir = false; // No pide confirmación
    }

    /**
     * Retorna un String con un mensaje de éxito (artículo "el")
     * @param articulo Artículo con el que empieza el mensaje (debe empezar con mayúscula)
     * @param accion Verbo que va entre "fue ... con éxito"
     * @return Retorna un String con un mensaje de éxito
     */
    private String mensajeExito(String articulo, String accion) {
        return articulo + " " + singular + " fue " + accion + " con éxito.";
    }
}