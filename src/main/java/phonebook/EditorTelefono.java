package phonebook;

public class EditorTelefono extends Editor {

    //// Constructores
    EditorTelefono(Contacto contacto){
        super(contacto);
        this.nombreMenu = "menú de edición de teléfonos";

        // Muestra el editor y lo repite hasta que "seguir" sea false
        this.seguir = true;

        do {
            // Llenar ArrayList de opciones
            llenarOpciones();
            // Mostrar menú
            desplegarMenu();
            // Pedir opción al usuario
            switchMenu();
            // Limpiar las opciones
            opciones.clear();
        } while (this.seguir);
    }

    //// Métodos
    /**
     * Método que llena las opciones del submenú
     */
    public void llenarOpciones() {
        opciones.add("Agregar teléfono");

        // Si hay teléfonos guardados
        if(!contacto.getLista_Telefonos().isEmpty()){
            opciones.add("Cambiar teléfono");
            opciones.add("Borrar teléfono");
        }
        // Si no hay teléfonos guardados
        else {
            opciones.add("Cambiar teléfono (no disponible)");
            opciones.add("Borrar teléfono (no disponible)");
        }

        opciones.add("Volver atrás");
    }

    /**
     * Método que muestra las opciones del submenú
     */
    private void desplegarMenu(){
        // Muestra el nombre del gestor con algo de decoración
        mostrarLogo();

        System.out.println("Menú de edición de teléfonos:");

        // Muestra las opciones
        System.out.println(enumerarListaString(opciones));

        eleccion = v.validarIntEntre(1, opciones.size(),
                "Escoja una opción: ",
                "La opción ingresada no existe.");
    }

    /**
     * Método para realizar procedimientos distintos según la opción ingresada
     */
    private void switchMenu(){
        switch (eleccion) {
            case 1:
                agregarTelefono();
                break;
            case 2:
                if(contacto.getLista_Telefonos().isEmpty()){
                    System.out.println("Este contacto no tiene números de teléfono guardados");
                }
                else {
                    cambiarTelefono();
                }
                break;
            case 3:
                // Si no hay teléfonos guardados
                if(contacto.getLista_Telefonos().isEmpty()){
                    System.out.println("Este contacto no tiene números de teléfono guardados");
                }
                else{
                    borrarTelefono();
                }
                break;
            case 4:
                volverAtras();
        }
    }

    /**
     * Permite elegir un teléfono
     * @param verbo Verbo que va en "Escoja el número de teléfono que quiere ..."
     * @return posición del teléfono elegido
     */
    private int elegirTelefono(String verbo){
        // Muestra los números guardados
        System.out.println("Números de teléfono guardados: ");
        System.out.println(enumerarListaTelefono(contacto.getLista_Telefonos()));

        // Pide al usuario que elija uno
        return v.validarIntEntre(1, contacto.getLista_Telefonos().size(),
                "Escoja el número de teléfono que quiere "+verbo+": ",
                "El número ingresado no es válido.");
    }

    /**
     * Permite elegir el tipo de teléfono (Celular, Fijo o Trabajo)
     * @return Número de que representa el tipo de teléfono elegido
     */
    private int elegirTipoTelefono(){
        return v.validarIntEntre(1, 3,
                "¿Qué tipo de teléfono agregó? 1=Celular, 2=Fijo, 3=Trabajo\nEscoja una opción: ",
                "La opción ingresada no es válida");
    }

    /**
     * Permite agregar un número de teléfono nuevo
     */
    private void agregarTelefono(){
        int numeroNuevo = v.validarNumeroTelefono();

        int tipoTelefono = elegirTipoTelefono();

        // Esta sección cambia según el tipo de número que escogió
        String tipoString = "";
        switch (tipoTelefono) {
            case 1 -> tipoString = "Celular";
            case 2 -> tipoString = "Fijo";
            case 3 -> tipoString = "Trabajo";
        }

        contacto.getLista_Telefonos().add(new Telefono (numeroNuevo, tipoString));
        System.out.println("El teléfono ha sido agregado con éxito");
    }

    /**
     * Permite cambiar un número de teléfono por uno nuevo
     */
    private void cambiarTelefono(){
        // Pedir la posición del número
        int posicionTelefono = elegirTelefono("cambiar");
        posicionTelefono--; // Le resta 1 porque los ArrayList empiezan con indice 0

        // Número actual (número + tipo entre paréntesis)
        String numeroActual = contacto.getLista_Telefonos().get(posicionTelefono).getNumero()+" ("+contacto.getLista_Telefonos().get(posicionTelefono).getTipo()+")";

        // Muestra el número actual y pide uno nuevo
        System.out.println("Número actual: "+numeroActual);
        int numeroNuevo = v.validarNumeroTelefono();

        int tipoTelefono = elegirTipoTelefono();

        // Esta sección cambia según el tipo de teléfono
        String tipoString = "";
        switch (tipoTelefono) {
            case 1 -> tipoString = "Celular";
            case 2 -> tipoString = "Fijo";
            case 3 -> tipoString = "Trabajo";
        }

        // Guarda los cambios
        contacto.getLista_Telefonos().set(posicionTelefono, new Telefono(numeroNuevo, tipoString));
        // Muestra el mensaje de éxito
        System.out.println("El teléfono ha sido cambiado con éxito");
    }

    /**
     * Permite borrar un número de teléfono (y pide confirmación)
     */
    private void borrarTelefono(){
        int posicionTelefono = elegirTelefono("borrar");
        posicionTelefono--; // Le resta 1 por el índice que debe tener
        confirmarBorradoTelefono(posicionTelefono);
    }

    /**
     * Método para confirmar la eliminación de un número de teléfono
     * @param posicion Posición del número que se desea borrar
     */
    private void confirmarBorradoTelefono(int posicion) {
        int x = v.validarIntEntre(0, 1,
                "Se borrará el número "+contacto.getLista_Telefonos().get(posicion).getNumero()+
                        " ¿Está seguro? 1=Sí 0=No\nEscoja una opción: ",
                "La opción ingresada no existe.");

        switch (x) {
            case 1:
                contacto.getLista_Telefonos().remove(posicion);
                System.out.println("El contacto ha sido borrado exitosamente.");
                break;
            case 0:
                System.out.println("El número no se borró.");
        }
    }
}
