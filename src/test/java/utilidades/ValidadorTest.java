package utilidades;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Clase que incluye los tests unitarios de la clase Validador
 */
public class ValidadorTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test para revisar que la entrada acepta ints válidos
     */
    @Test
    public void esInt1() {
        assertTrue(Validador.esInt("1"));
        assertTrue(Validador.esInt("100"));
        assertTrue(Validador.esInt("-256"));
    }

    /**
     * Test para revisar que al ingresar símbolos o letras no se valida como un int
     */
    @Test
    public void esInt2() {
        assertFalse(Validador.esInt("a"));
        assertFalse(Validador.esInt(" "));
        assertFalse(Validador.esInt("asdasda"));
        assertFalse(Validador.esInt("!\"#=?"));
    }

    /**
     * Test para revisar que al ingresar un número demasiado grande no se valida como un int
     */
    @Test
    public void esInt3() {
        assertFalse(Validador.esInt("23172617381238"));
        assertFalse(Validador.esInt("-92347821332912"));
    }

    /**
     * Test para revisar que al ingresar un String null no se valida como un int
     */
    @Test
    public void esInt4() {
        assertFalse(Validador.esInt(null));
    }

    /**
     * Test que revisa los casos donde se ingresa un número de teléfono válido
     */
    @Test
    public void esTelefono1() {
        assertTrue(Validador.esTelefono(912345678));
        assertTrue(Validador.esTelefono(133));
        assertTrue(Validador.esTelefono(911));
    }

    /**
     * Test que revisa los casos donde se ingresa un número de teléfono no válido
     */
    @Test
    public void esTelefono2() {
        assertFalse(Validador.esTelefono(0));
        assertFalse(Validador.esTelefono(-12312312));
        assertFalse(Validador.esTelefono(1000000000));
    }

    /**
     * Test para revisar que el método acepta emails válidos
     */
    @Test
    public void esEmail1() {
        assertTrue(Validador.esEmail("v.mardones04@gmail.com"));
        assertTrue(Validador.esEmail("l.burgos02@ufromail.cl"));
        assertTrue(Validador.esEmail("b.munoz15@hotmail.com"));
    }

    /**
     * Test para revisar que el método rechaza emails no válidos
     */
    @Test
    public void esEmail2() {
        assertFalse(Validador.esEmail("0.#$s.213"));
        assertFalse(Validador.esEmail("..."));
        assertFalse(Validador.esEmail("holamundo"));
    }

    /**
     * Test para revisar que si se ingresa un String null, el email no es válido
     */
    @Test
    public void esEmail3() {
        assertFalse(Validador.esEmail(null));
    }
}