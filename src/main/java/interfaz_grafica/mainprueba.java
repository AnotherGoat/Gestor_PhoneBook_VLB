package interfaz_grafica;

public class mainprueba {
    public static void main(String[] args) {
        menuVentana prueba = new menuVentana();
        prueba.setVisible(true);
        prueba.setResizable(false); // Inhabilita el funcionamiento del boton minimizar
    }
}
