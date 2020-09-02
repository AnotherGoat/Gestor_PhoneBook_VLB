package phonebook;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utilidades.Validador;

import static org.junit.Assert.*;

public class AgendaTest {

    Validador v;
    Agenda a;

    @Before
    public void setUp() throws Exception {
        v = new Validador();
        a = new Agenda(); // Crea una nueva instancia
    }

    @After
    public void tearDown() throws Exception {
        v = null;
        a = null; // Liberar memoria
    }

    /**
     * Prueba para verificar que el nombre de un contacto se guarda correctamente al crear uno nuevo
     */
    @Test
    public void crearContacto1() {
        a.crearContacto("Juan Pérez");
        String nombreContacto = a.getLista_Contactos().get(0).getNombre();
        assertEquals("Juan Pérez", nombreContacto);

        a.crearContacto("Pablo");
        nombreContacto = a.getLista_Contactos().get(1).getNombre();
        assertEquals("Pablo", nombreContacto);
    }

    /**
     * Esta prueba revisa que se borran contactos correctamente
     */
    @Test
    public void eliminarContacto1() {
        // Crea 2 contactos
        a.crearContacto("Camila");
        a.crearContacto("Francisca");

        assertEquals(2, a.getLista_Contactos().size()); // Tamaño original

        // Simula el borrado del contacto 1 (Camila)
        v.simularInput("1");
        int idContacto = a.elegirContacto("eliminar"); // id Contacto = número con el que se identifica
        // Simula la confirmación
        v.simularInput("1");
        a.confirmarBorrado(idContacto-1);

        // Verifica el tamaño y el borrado del contacto correcto
        assertEquals(1, a.getLista_Contactos().size()); // Tamaño cambia
        assertEquals("Francisca", a.getLista_Contactos().get(0).getNombre());
    }

}