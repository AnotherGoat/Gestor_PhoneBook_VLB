package interfaz_grafica;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public abstract class JDialogGeneral extends JDialog implements ActionListener {

    //// Atributos
    /**
     * Panel principal
     */
    protected JPanel panel;
    /**
     * Botón para volver atrás
     */
    protected JButton botonVolverAtras;

    //// Constructores
    public JDialogGeneral() {
    }

    //// Métodos
    /**
     * Método que carga el ícono de la aplicación desde un archivo externo
     */
    public void cargarIcono() {
        Image icono = Toolkit.getDefaultToolkit().getImage("archivos/icono_phonebook_nuevo.png");
        setIconImage(icono);
    }

    /**
     * Método para iniciar la ventana
     */
    public void inicializarComponentes(){
        // Instancia el JPanel
        panel = new JPanel();

        // Instancia el JButton para volver atrás
        botonVolverAtras = new JButton("Volver atrás");
    }

    public void implementarListeners(){
        // Implementa ActionListener para los botones
        botonVolverAtras.addActionListener(this);
    }

    /**
     * Método para configurar las propiedades que todas las ventanas JDialog tienen en común
     */
    public void configurarVentana(){
        // Cuando se cierre la ventana, se borra de la memoria
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        // Modalidad, para hacer que las ventanas anteriores no funcionen
        setModalityType(ModalityType.APPLICATION_MODAL);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == botonVolverAtras){
            // Borra la ventana actual
            dispose();
        }
    }
}
