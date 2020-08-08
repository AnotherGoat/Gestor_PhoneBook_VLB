package phonebook;

public class EditorFechaCumple extends Editor {
    //// Atributos
    /**
     * Contacto que se va a editar
     */
    Contacto contacto;

    //// Constructores
    EditorFechaCumple(Contacto contacto){
        this.contacto=contacto;
        this.nombreMenu = "menú de edición de fecha de cumpleaños";

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
        if(contacto.getFechaCumple() == null){
            opciones.add("Registrar fecha de cumpleaños");
        }
        else{
            opciones.add("Cambiar fecha de cumpleaños");
        }
        opciones.add("Borrar fecha de cumpleaños guardada");
        opciones.add("Volver atrás");
    }

    /**
     * Método que muestra las opciones del submenú
     */
    private void desplegarMenu(){
        // Muestra el nombre del gestor con algo de decoración
        mostrarLogo();

        System.out.println("Menú de edición de fecha de cumpleaños:");

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
                // En caso de no tener una fecha de cumpleaños guardada
                if(contacto.getFechaCumple() == null){
                    agregarFechaCumple();
                }

                // En caso de querer cambiar la dirección por una nueva
                else{
                    cambiarFechaCumple();
                }
                break;
            case 2:
                // Si no tiene una fecha de cumpleaños guardada
                if(contacto.getFechaCumple() == null){
                    System.out.println("El contacto no tiene una fecha de cumpleaños guardada");
                }
                else { // Si la tiene, borrarla, pero pedir confirmación antes
                    confirmarBorradoFechaCumple();
                }
                break;
            case 3:
                volverAtras();
        }
    }

    /**
     * Permite agregar una fecha de cumpleaños nueva
     */
    private void agregarFechaCumple(){
        System.out.println("Ingrese los datos de la fecha de cumpleaños del contacto");

        int mesNuevo = v.validarInt(1, 12, "Mes: ", "Error: Por favor ingrese un número entre 1 y 12");
        int diasDelMes = obtenerDiasDelMes(mesNuevo);
        int diaNuevo = v.validarInt(1, diasDelMes, "Día: ", "Error: Por favor ingrese un número entre 1 y " + diasDelMes);

        // Guarda la fecha de cumpleaños nueva
        contacto.setFechaCumple(new FechaCumple(diaNuevo, mesNuevo));
        // Muestra el mensaje de éxito
        System.out.println("La fecha de cumpleaños fue guardada con éxito.");
    }

    /**
     * Permite cambiar la fecha de cumpleaños
     */
    private void cambiarFechaCumple(){
        System.out.println("Fecha de cumpleaños actual: "+contacto.getFechaCumple().toString());
        System.out.println("Ingrese los datos de la nueva fecha de cumpleaños");

        // Pide al usuario que ingrese el mes nuevo
        int mesNuevo = v.validarInt(1, 12,
                "Mes actual: "+contacto.getFechaCumple().getMes()+" ("+contacto.getFechaCumple().getNumeroMes()+")\nMes nuevo: ",
                "Error: Por favor ingrese un número entre 1 y 12");

        int diasDelMes = obtenerDiasDelMes(mesNuevo);

        int diaNuevo = v.validarInt(1, diasDelMes, "Día actual: "+contacto.getFechaCumple().getDia()+"\nDía nuevo: ",
                "Error: Por favor ingrese un número entre 1 y " + diasDelMes);

        // Guarda la fecha de cumpleaños nueva
        contacto.setFechaCumple(new FechaCumple(diaNuevo, mesNuevo));
        // Muestra el mensaje de éxito
        System.out.println("La fecha de cumpleaños fue guardada con éxito.");
    }

    /**
     * Método que retorna la cantidad de días en un mes, según el mes ingresado
     * @param mesIngresado Número del mes, entre 1 y 12
     * @return Cantidad de días que tiene el mes ingresado
     */
    private int obtenerDiasDelMes(int mesIngresado){
        switch(mesIngresado){
            case 2: // Febrero
                return 29;
            case 4: // Abril
            case 6: // Junio
            case 9: // Septiembre
            case 11: // Noviembre
                return 30;
            case 1: // Enero
            case 3: // Marzo
            case 5: // Mayo
            case 7: // Julio
            case 8: // Agosto
            case 10: // Octubre
            case 12: // Diciembre
                return 31;
        }

        // En caso de error
        return -1;
    }

    /**
     * Método para confirmar el borrado de la fecha de cumpleaños guardada
     */
    private void confirmarBorradoFechaCumple(){
        int x = v.validarInt(0, 1,
                "Se borrará la fecha de cumpleaños del contacto "+contacto.getNombre()+
                        " ¿Está seguro? 1=Sí 0=No\nEscoja una opción: ",
                "La opción ingresada no existe.");

        switch(x){
            case 1:
                contacto.setFechaCumple(null);
                System.out.println("La fecha de cumpleaños ha sido borrada exitosamente.");
                break;
            case 0:
                System.out.println("La fecha de cumpleaños no se borró.");
        }
    }
}
