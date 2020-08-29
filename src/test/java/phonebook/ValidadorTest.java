package phonebook;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Clase que incluye los tests unitarios de la clase Validador
 */
public class ValidadorTest {

    /**
     * Validador usado en ValidadorTest
     */
    Validador v;

    @Before
    public void setUp() throws Exception {
        v = new Validador(); // Crea una nueva instancia
    }

    @After
    public void tearDown() throws Exception {
        v = null; // Liberar memoria
    }

    /**
     * Test para revisar que la entrada acepta ints válidos
     */
    @Test
    public void esInt1() {
        assertTrue(v.esInt("1"));
        assertTrue(v.esInt("100"));
        assertTrue(v.esInt("-256"));
    }

    /**
     * Test para revisar que al ingresar símbolos o letras no se valida como un int
     */
    @Test
    public void esInt2() {
        assertFalse(v.esInt("a"));
        assertFalse(v.esInt(" "));
        assertFalse(v.esInt("asdasda"));
        assertFalse(v.esInt("!\"#=?"));
    }

    /**
     * Test para revisar que al ingresar un número demasiado grande no se valida como un int
     */
    @Test
    public void esInt3() {
        assertFalse(v.esInt("23172617381238"));
        assertFalse(v.esInt("-92347821332912"));
    }

    /**
     * Test para revisar que al ingresar un String null no se valida como un int
     */
    @Test
    public void esInt4() {
        assertFalse(v.esInt(null));
    }

    /**
     * Test que revisa los casos donde se ingresa un número de teléfono válido
     */
    @Test
    public void esTelefono1() {
        assertTrue(v.esTelefono(912345678));
        assertTrue(v.esTelefono(133));
        assertTrue(v.esTelefono(911));
    }

    /**
     * Test que revisa los casos donde se ingresa un número de teléfono no válido
     */
    @Test
    public void esTelefono2() {
        assertFalse(v.esTelefono(0));
        assertFalse(v.esTelefono(-12312312));
        assertFalse(v.esTelefono(1000000000));
    }

    /**
     * Test para revisar que el método acepta emails válidos
     */
    @Test
    public void esEmail1() {
        assertTrue(v.esEmail("v.mardones04@gmail.com"));
        assertTrue(v.esEmail("l.burgos02@ufromail.cl"));
        assertTrue(v.esEmail("b.munoz15@hotmail.com"));
    }

    /**
     * Test para revisar que el método rechaza emails no válidos
     */
    @Test
    public void esEmail2() {
        assertFalse(v.esEmail("0.#$s.213"));
        assertFalse(v.esEmail("..."));
        assertFalse(v.esEmail("holamundo"));
    }

    /**
     * Test para revisar que si se ingresa un String null, el email no es válido
     */
    @Test
    public void esEmail3() {
        assertFalse(v.esEmail(null));
    }
}