package interfaz_grafica;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Formato de los JDialog del proyecto (ventanas que no crean una "instancia" en la barra de tareas)
 * @see JDialog
 * @see ActionListener
 */
public class JDialogGeneral extends JDialog implements ActionListener {

    //// Atributos
    /**
     * Panel principal
     * @see JPanel
     */
    protected JPanel panel;
    /**
     * Botón para volver atrás
     * @see JButton
     */
    protected JButton botonVolverAtras;

    //// Constructores
    /**
     * Constructor protegido de JDialogGeneral, para que la clase no se pueda instanciar fuera de sus clases hijas
     */
    protected JDialogGeneral() {
        // Este constructor es protegido, significa que esta clase no se puede instanciar
    }

    //// Métodos
    /**
     * Método que carga el ícono de la aplicación desde un archivo externo
     * @see Image
     */
    protected void cargarIcono() {
        Image icono = Toolkit.getDefaultToolkit().getImage("archivos/icono_phonebook_nuevo.png");
        setIconImage(icono);
    }

    /**
     * Método para iniciar el JDialog
     */
    protected void inicializarComponentes(){
        // Instancia el JPanel
        panel = new JPanel();

        // Instancia el JButton para volver atrás
        botonVolverAtras = new JButton("Volver atrás");
    }

    /**
     * Implementa los listeners del JDialog
     */
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

    /**
     * Método que se implementa de la interfaz ActionListener
     * @param e Evento
     * @see ActionListener
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == botonVolverAtras){
            // Borra la ventana actual
            dispose();
        }
    }
}
