package phonebook;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AgendaTest {

    Agenda a;
    Contacto c;
    String nombreContacto;

    @Before
    public void setUp() throws Exception {
        a = new Agenda(); // Crea una nueva instancia
    }

    @After
    public void tearDown() throws Exception {
        a = null; // Liberar memoria
        c = null;
    }

    /**
     * Test para revisar que crearContacto() guarda contactos a partir de un nombre ingresado
     */
    @Test
    public void crearContacto1() {
        a.crearContacto("Juan Pérez");
        nombreContacto = a.getLista_Contactos().get(0).getNombre();
        assertEquals("Juan Pérez", nombreContacto);

        a.crearContacto("Pablo");
        nombreContacto = a.getLista_Contactos().get(1).getNombre();
        assertEquals("Pablo", nombreContacto);
    }

    /**
     * Test para revisar que crearContacto() guarda contactos a partir de otro contacto
     */
    @Test
    public void crearContacto2() {
        c = new Contacto("Diego");
        a.crearContacto(c);
        nombreContacto = a.getLista_Contactos().get(0).getNombre();
        assertEquals("Diego", nombreContacto);

        c = new Contacto("Paula");
        a.crearContacto(c);
        nombreContacto = a.getLista_Contactos().get(1).getNombre();
        assertEquals("Paula", nombreContacto);
    }

    /**
     * Test para revisar que eliminarContacto() funciona correctamente
     */
    @Test
    public void eliminarContacto1() {
        // Crea 2 contactos
        a.crearContacto("Camila");
        a.crearContacto("Francisca");

        assertEquals(2, a.getLista_Contactos().size()); // Tamaño original

        // Simula el borrado del contacto 1 (Camila)
        a.eliminarContacto(0);
        assertEquals(1, a.getLista_Contactos().size()); // Tamaño cambia

        // Revisa que el nombre del contacto en la posición 0 es "Francisca"
        nombreContacto = a.getLista_Contactos().get(0).getNombre();
        assertEquals("Francisca", nombreContacto);
    }

}