package phonebook;

public class Editor extends Menu{

    //// Atributos
    /**
     * Contacto que se va a editar
     */
    Contacto contacto;

    //// Constructores
    Editor(Contacto contacto){
        this.contacto = contacto;
    }

    //// Métodos
    /**
     * Método para volver al menú editor (cuarta o tercera opción de switchMenu)
     */
    protected void volverAtras(){
        System.out.println("Ha salido del "+nombreMenu);
        seguir = false; // No pide confirmación
    }
}
