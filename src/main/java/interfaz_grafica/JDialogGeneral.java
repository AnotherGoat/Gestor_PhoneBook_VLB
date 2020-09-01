package interfaz_grafica;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public abstract class JDialogGeneral extends JDialog {

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
    public void iniciar(){
        // Carga el ícono de la aplicación
        cargarIcono();

        // Instancia el panel
        panel = new JPanel();

        // Instancia el botón para volver atrás
        botonVolverAtras = new JButton("Volver atrás");

        // Implementación de ActionListener para botonVolverAtras
        botonVolverAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
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
        });
    }

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
