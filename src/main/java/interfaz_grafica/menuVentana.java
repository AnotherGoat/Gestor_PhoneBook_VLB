package interfaz_grafica;

import javax.swing.*;

public class menuVentana extends JFrame {
    //atributos de la ventana menu (todavia no tienen funcion los botones)
    private JButton nuevoContactoButton;
    private JPanel panel1;
    private JButton listaDeContactosButton;
    private JButton detalleDeUnContactoButton;
    private JButton editarContactoButton;
    private JButton eliminarContactoButton;
    private JButton salirButton;

    public menuVentana(){
        setTitle("Gestor Phonebook VLB");//tirulo
        add(panel1);//se le añade el panel creado en menuVentana.form
        setSize(300,600);//se le define un tamaño predeterminado
        setDefaultCloseOperation(EXIT_ON_CLOSE);//cuando se cierre la ventana se finaliza el programa
        setLocation(1000,500); //posicion inicial de la ventana

    }
}
