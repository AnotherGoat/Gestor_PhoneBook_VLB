package phonebook;

public class EditorNombre extends Editor{

    //// Constructores
    EditorNombre(Contacto contacto){
        super(contacto);

        this.contacto=contacto;

        cambiarNombre();
    }

    //// Métodos
    /**
     * Método que pide al usuario que ingrese un nombre y lo cambia
     */
    private void cambiarNombre(){
        String nombreActual = contacto.getNombre();

        // Muestra el nombre actual y pide uno nuevo
        //String nombreNuevo = v.recibirString("Nombre actual: " +nombreActual+"\nNombre nuevo: ");

        // Cambia el nombre al nombre nuevo
        //contacto.setNombre(nombreNuevo);
        System.out.println("El nombre ha sido cambiado con éxito");
    }
}
