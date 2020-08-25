package phonebook;

public class EditorEmail extends Editor {

    //// Constructores
    EditorEmail(Contacto contacto){
        super(contacto);
        this.nombreMenu = "menú de edición de emails";

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
        opciones.add("Agregar email");

        // Si hay emails guardados
        if(!contacto.getLista_Emails().isEmpty()) {
            opciones.add("Cambiar email");
            opciones.add("Borrar email");
        }
        // Si no hay emails guardados
        else{
            opciones.add("Cambiar email (no disponible)");
            opciones.add("Borrar email (no disponible)");
        }

        opciones.add("Volver atrás");
    }

    /**
     * Método que muestra las opciones del submenú
     */
    private void desplegarMenu(){
        // Muestra el nombre del gestor con algo de decoración
        mostrarLogo();

        System.out.println("Menú de edición de emails:");

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
                agregarEmail();
            case 2:
                // En caso de no tener emails guardados
                if(contacto.getLista_Emails().isEmpty()){
                    System.out.println("Este contacto no tiene emails guardados");
                }

                // Si hay emails guardados
                else {
                    cambiarEmail();
                }
                break;
            case 3:
                // Si no hay emails guardados
                if(contacto.getLista_Emails().isEmpty()){
                    System.out.println("Este contacto no tiene emails guardados");
                }
                else{
                    borrarEmail();
                }
                break;
            case 4:
                volverAtras();
        }
    }

    /**
     * Permite elegir un email
     * @param verbo Verbo que va en "Escoja el email que quiere ..."
     * @return Posición del email elegido
     */
    private int elegirEmail(String verbo){
        // Muestra los números guardados
        System.out.println("Emails guardados: ");
        System.out.println(enumerarListaString(contacto.getLista_Emails()));

        // Pide al usuario que elija uno
        return v.validarInt(1, contacto.getLista_Emails().size(),
                "Escoja el email que quiere "+verbo+": ",
                "El número ingresado no es válido.");
    }

    /**
     * Permite agregar un nuevo email después de validarlo
     */
    private void agregarEmail(){
        String emailNuevo = v.validarEmail();

        // Guarda el email y muestra un mensaje de éxito
        contacto.getLista_Emails().add(emailNuevo);
        System.out.println("El email ha sido agregado con éxito");
    }

    /**
     * Permite cambiar un email guardado por uno nuevo
     */
    private void cambiarEmail(){
        int posicionEmail = elegirEmail("cambiar");
        posicionEmail--; // Le resta 1 porque los ArrayList empiezan con indice 0
        String emailActual = contacto.getLista_Emails().get(posicionEmail);

        // Muestra el email actual y pide uno nuevo
        System.out.println("Email actual: "+emailActual);
        String emailNuevo = v.validarEmail();

        // Actualizar email
        contacto.getLista_Emails().set(posicionEmail, emailNuevo);
        // Muestra el mensaje de éxito
        System.out.println("El email ha sido cambiado con éxito");
    }

    /**
     * Método que pide la posición de un email para luego borrarlo (después de pedir confirmación)
     */
    private void borrarEmail(){
        int posicionEmail = elegirEmail("borrar");
        posicionEmail--; // Le resta 1 porque los índices empiezan desde 0
        confirmarBorradoEmail(posicionEmail);
    }

    /**
     * Método para confirmar la eliminación de un email
     * @param posicion Posición del email que se desea borrar
     */
    private void confirmarBorradoEmail(int posicion) {
        int x = v.validarInt(0, 1,
                "Se borrará el email "+contacto.getLista_Emails().get(posicion)+
                        " ¿Está seguro? 1=Sí 0=No\nEscoja una opción: ",
                "La opción ingresada no existe.");

        switch (x) {
            case 1:
                contacto.getLista_Emails().remove(posicion);
                System.out.println("El email ha sido borrado exitosamente.");
                break;
            case 0:
                System.out.println("El email no se borró.");
        }
    }
}
