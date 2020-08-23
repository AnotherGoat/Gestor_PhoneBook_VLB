package phonebook;

public class EditorDireccion extends Editor {

    //// Constructores
    EditorDireccion(Contacto contacto){
        super(contacto);

        nombreMenu = "menú de edición de dirección";

        // Muestra el editor y lo repite hasta que "seguir" sea false
        this.seguir = true;

        do {
            // Llenar ArrayList de opciones (en este caso las opciones puedes cambiar en medio de la ejecución)
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
        if(contacto.getDireccion() == null){
            opciones.add("Registrar dirección");
        }
        else{
            opciones.add("Cambiar dirección");
        }
        opciones.add("Borrar dirección guardada");
        opciones.add("Volver atrás");
    }

    /**
     * Método que muestra las opciones del submenú
     */
    private void desplegarMenu(){
        // Muestra el nombre del gestor con algo de decoración
        mostrarLogo();

        System.out.println("Menú de edición de dirección:");

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
                // En caso de no tener una dirección guardada
                if(contacto.getDireccion() == null){
                    agregarDireccion();
                }

                // En caso de querer cambiar la dirección por una nueva
                else{
                    cambiarDireccion();
                }
                break;
            case 2:
                // Si no tiene una dirección guardada
                if(contacto.getDireccion() == null){
                    System.out.println("El contacto no tiene una dirección guardada");
                }
                else { // Si la tiene, borrarla, pero pedir confirmación antes
                    confirmarBorradoDireccion();
                }
                break;
            case 3:
                volverAtras();
        }
    }

    /**
     * Permite agregar una dirección nueva si no hay ninguna antes guardada
     */
    private void agregarDireccion(){
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

    /**
     * Permite cambiar la dirección guardada por una nueva
     */
    private void cambiarDireccion(){
        // Datos actuales de la dirección
        String direccionActual = contacto.getDireccion().toString();
        String ciudadActual = contacto.getDireccion().getCiudad();
        String calleActual = contacto.getDireccion().getCalle();
        int numeroDireccionActual = contacto.getDireccion().getNumero();

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

    /**
     * Método para confirmar el borrado de la dirección guardada
     */
    private void confirmarBorradoDireccion(){
        int x = v.validarInt(0, 1,
                "Se borrará la dirección del contacto "+contacto.getNombre()+
                        " ¿Está seguro? 1=Sí 0=No\nEscoja una opción: ",
                "La opción ingresada no existe.");

        switch(x){
            case 1:
                contacto.setDireccion(null);
                System.out.println("La dirección ha sido borrada exitosamente.");
                break;
            case 0:
                System.out.println("La dirección no se borró.");
        }
    }
}
