

public class Agenda {

    // Atributos
    private String[] opciones = {"hola", "mundo", "Salir"}; // Arreglo con las opciones

    // Constructor
    public Agenda() {
    }

    public void menu(){
        System.out.println("******************************************");
        System.out.println("=========\\\\Gestor PhoneBook VLB//=========");
        System.out.println("******************************************");
        System.out.println("Opciones:");

        // Muestra las opciones
        for (int i=1; i<=opciones.length; i++){
            System.out.println(i+".- "+opciones[i-1]);
        }



    }

}
