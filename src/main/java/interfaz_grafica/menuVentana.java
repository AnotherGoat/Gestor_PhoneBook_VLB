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
        setTitle("Gestor Phonebook VLB"); // Título
        add(panel1); // Se le añade el panel creado en menuVentana.form
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Cuando se cierre la ventana se finaliza el programa
        setSize(300,600); // Se define el tamaño de ventana
        setLocationRelativeTo(null); // Centrar la ventana
    }
}
