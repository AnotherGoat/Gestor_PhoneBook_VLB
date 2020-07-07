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
        setDefaultCloseOperation(EXIT_ON_CLOSE);//cuando se cierre la ventana se finaliza el programa
        setBounds(600,400,300,600);//se define posicion y tamaño de ventana

    }
}
