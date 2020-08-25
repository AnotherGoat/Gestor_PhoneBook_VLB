package phonebook;

public class EditorApodo extends Editor {

    //// Constructores
    EditorApodo(Contacto contacto){
        super(contacto);
        nombreMenu = "menú de edición de apodos";

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
        opciones.add("Agregar apodo");

        // Si hay apodos guardados
        if(!contacto.getLista_Apodos().isEmpty()) {
            opciones.add("Cambiar apodo");
            opciones.add("Borrar apodo");
        }
        // Si no hay apodos guardados
        else{
            opciones.add("Cambiar apodo (no disponible)");
            opciones.add("Borrar apodo (no disponible)");
        }

        opciones.add("Volver atrás");
    }

    /**
     * Método que muestra las opciones del submenú
     */
    private void desplegarMenu(){
        // Muestra el nombre del gestor con algo de decoración
        mostrarLogo();

        System.out.println("Menú de edición de apodos:");

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
        switch (eleccion) {
            case 1:
                agregarApodo();
                break;
            case 2:
                // En caso de no tener apodos guardados
                if(contacto.getLista_Apodos().isEmpty()){
                    System.out.println("Este contacto no tiene apodos guardados");
                }

                // En caso de sí tener apodos guardados
                else {
                    cambiarApodo();
                }
                break;
            case 3:
                if(contacto.getLista_Apodos().isEmpty()){
                    System.out.println("Este contacto no tiene apodos guardados");
                }
                else{
                    borrarApodo();
                }
                break;
            case 4:
                volverAtras();
        }
    }

    /**
     * Permite elegir un apodo
     * @param verbo Verbo que va en "Escoja el apodo que quiere ..."
     * @return Posición del apodo elegido
     */
    private int elegirApodo(String verbo){
        // Muestra los apodos guardados
        System.out.println("Apodos guardados: ");
        System.out.println(enumerarListaString(contacto.getLista_Apodos()));

        // Pide al usuario que elija uno
        return v.validarInt(1, contacto.getLista_Apodos().size(),
                "Escoja el apodo que quiere "+verbo+": ",
                "El número ingresado no es válido.");
    }

    /**
     * Permite agregar un apodo nuevo
     */
    private void agregarApodo(){
        String apodoNuevo = v.recibirString("Ingrese el apodo: ");
        contacto.getLista_Apodos().add(apodoNuevo);
        System.out.println("El apodo ha sido agregado con éxito");
    }

    /**
     * Permite cambiar un apodo por uno nuevo
     */
    private void cambiarApodo(){
        int posicionApodo = elegirApodo("cambiar");
        posicionApodo--; // Le resta 1 porque los ArrayList empiezan con indice 0

        // Apodo actual, según la posición ingresada
        String apodoActual = contacto.getLista_Apodos().get(posicionApodo);

        // Muestra el apodo actual y pide uno nuevo
        System.out.println("Apodo actual: "+apodoActual);
        String apodoNuevo = v.recibirString("Apodo nuevo: ");

        // Actualizar apodo
        contacto.getLista_Apodos().set(posicionApodo, apodoNuevo);
        // Muestra el mensaje de éxito
        System.out.println("El apodo ha sido cambiado con éxito");
    }

    /**
     * Método que pide la posición de un apodo para luego borrarlo (después de pedir confirmación)
     */
    private void borrarApodo(){
        int posicionApodo = elegirApodo("borrar");
        posicionApodo--;
        confirmarBorradoApodo(posicionApodo);
    }

    /**
     * Método para confirmar la eliminación de un apodo
     * @param posicion Posición del apodo que se desea borrar
     */
    private void confirmarBorradoApodo(int posicion) {
        int x = v.validarInt(0, 1,
                "Se borrará el apodo "+contacto.getLista_Apodos().get(posicion)+
                        " ¿Está seguro? 1=Sí 0=No\nEscoja una opción: ",
                "La opción ingresada no existe.");

        switch (x) {
            case 1:
                contacto.getLista_Apodos().remove(posicion);
                System.out.println("El apodo ha sido borrado exitosamente.");
                break;
            case 0:
                System.out.println("El apodo no se borró.");
        }
    }
}
