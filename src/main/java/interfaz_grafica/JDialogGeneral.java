package interfaz_grafica;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JDialogGeneral extends JDialog implements ActionListener {

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
    protected JDialogGeneral() {
        // Este constructor es protegido, significa que esta clase no se puede instanciar
    }

    //// Métodos
    /**
     * Método que carga el ícono de la aplicación desde un archivo externo
     */
    protected void cargarIcono() {
        Image icono = Toolkit.getDefaultToolkit().getImage("archivos/icono_phonebook_nuevo.png");
        setIconImage(icono);
    }

    /**
     * Método para iniciar la ventana
     */
    protected void inicializarComponentes(){
        // Instancia el JPanel
        panel = new JPanel();

        // Instancia el JButton para volver atrás
        botonVolverAtras = new JButton("Volver atrás");
    }

    protected void implementarListeners(){
        // Implementa ActionListener para los botones
        botonVolverAtras.addActionListener(this);
    }

    /**
     * Método para configurar las propiedades que todas las ventanas JDialog tienen en común
     */
    protected void configurarVentana(){
        // Cuando se cierre la ventana, se borra de la memoria
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        // Modalidad, para hacer que las ventanas anteriores no funcionen
        setModalityType(ModalityType.APPLICATION_MODAL);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == botonVolverAtras){
            // Borra la ventana actual
            dispose();
        }
    }
}
