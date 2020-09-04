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
     * Método para iniciar la ventana
     */
    public void inicializar(){
        // Carga el ícono de la aplicación
        cargarIcono();

        // Instancia el JPanel
        panel = new JPanel();

        // Instancia el JButton para volver atrás
        botonVolverAtras = new JButton("Volver atrás");

        // Implementa ActionListener para los botones
        botonVolverAtras.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == botonVolverAtras){
            // Crea el panel para pedir confirmación
            int n = JOptionPane.showConfirmDialog(panel.getParent(),
                    "¿Volver atrás?",
                    "Volver atrás",
                    JOptionPane.YES_NO_OPTION);

            // Si el usuario escoge "Sí"
            if(n == JOptionPane.YES_OPTION){
                // Borra la ventana
                dispose();
            }
        }
    }

    /**
     * Método para configurar las propiedades que todas las ventanas JDialog tienen en común
     */
    public void configurar(){
        // La ventana inicia centrada
        setLocationRelativeTo(null);
        // Cuando se cierre la ventana, se borra de la memoria
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * Método que carga el ícono de la aplicación desde un archivo externo
     */
    private void cargarIcono() {
        Image icono = Toolkit.getDefaultToolkit().getImage("archivos/icono_phonebook_nuevo.png");
        setIconImage(icono);
    }
}
