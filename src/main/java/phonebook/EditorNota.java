package phonebook;

public class EditorNota extends Editor {

    //// Constructores
    EditorNota(Contacto contacto){
        super(contacto);
        this.nombreMenu = "menú de edición de notas";

        // Muestra el editor y lo repite hasta que "seguir" sea false
        this.seguir = true;

        do {
            // Llenar ArrayList con opciones
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
        opciones.add("Agregar nota");

        // Si hay notas guardadas
        if(!contacto.getLista_Notas().isEmpty()) {
            opciones.add("Cambiar nota");
            opciones.add("Borrar nota");
        }
        // Si no hay notas guardadas
        else{
            opciones.add("Cambiar nota (no disponible)");
            opciones.add("Borrar nota (no disponible)");
        }

        opciones.add("Volver atrás");
    }

    /**
     * Método que muestra las opciones del submenú
     */
    private void desplegarMenu(){
        // Muestra el nombre del gestor con algo de decoración
        mostrarLogo();

        System.out.println("Menú de edición de notas:");

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
                agregarNota();
                break;
            case 2:
                // Si no hay notas guardadas
                if(contacto.getLista_Notas().isEmpty()){
                    System.out.println("Este contacto no tiene notas guardadas");
                }

                // En caso de que las haya
                else {
                    cambiarNota();
                }
                break;
            case 3:
                if(contacto.getLista_Notas().isEmpty()){
                    System.out.println("Este contacto no tiene notas guardadas");
                }
                else{
                    borrarNota();
                }
                break;
            case 4:
                volverAtras();
        }
    }

    /**
     * Permite elegir una nota entre las guardadas
     * @param verbo Verbo que va en "Escoja la nota que quiere ..."
     * @return Posición de la nota elegida
     */
    private int elegirNota(String verbo){
        // Muestra las notas guardadas
        System.out.println("Notas guardadas: ");
        System.out.println(enumerarListaString(contacto.getLista_Notas()));

        // Pide al usuario que elija una
        return v.validarInt(1, contacto.getLista_Notas().size(),
                "Escoja la nota que quiere "+verbo+": ",
                "El número ingresado no es válido.");
    }

    /**
     * Permite agregar una nota nueva
     */
    private void agregarNota(){
        String notaNueva = v.recibirString("Ingrese la nota: ");
        contacto.getLista_Notas().add(notaNueva);
        System.out.println("La nota ha sido agregada con éxito");
    }

    /**
     * Permite cambiar una nota guardada por una nueva
     */
    private void cambiarNota(){
        int posicionNota = elegirNota("cambiar");
        posicionNota--; // Le resta 1 porque los ArrayList empiezan con indice 0

        // Nota actual, según la posición escogida
        String notaActual = contacto.getLista_Notas().get(posicionNota);

        // Muestra la nota actual y pide una nueva
        System.out.println("Nota actual: "+notaActual);
        String notaNueva = v.recibirString("Nota nueva: ");

        // Actualizar nota
        contacto.getLista_Notas().set(posicionNota, notaNueva);
        // Muestra el mensaje de éxito
        System.out.println("La nota ha sido cambiada con éxito");
    }

    /**
     * Método que pide la posición de una nota para luego borrarla (después de pedir confirmación)
     */
    private void borrarNota(){
        int posicionNota = elegirNota("borrar");
        posicionNota--;
        confirmarBorradoNota(posicionNota);
    }

    /**
     * Método para confirmar la eliminación de una nota
     * @param posicion Posición de la nota que se desea borrar
     */
    private void confirmarBorradoNota(int posicion) {
        int x = v.validarInt(0, 1,
                "Se borrará la nota \""+contacto.getLista_Notas().get(posicion)+
                        "\"\n¿Está seguro? 1=Sí 0=No\nEscoja una opción: ",
                "La opción ingresada no existe.");

        switch (x) {
            case 1:
                contacto.getLista_Notas().remove(posicion);
                System.out.println("La nota ha sido borrado exitosamente.");
                break;
            case 0:
                System.out.println("La nota no se borró.");
        }
    }
}
