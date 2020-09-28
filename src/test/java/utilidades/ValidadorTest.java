package utilidades;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Clase que contiene las pruebas unitarias de la clase Validador
 */
public class ValidadorTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test para revisar que esInt() acepta ints válidos
     */
    @Test
    public void esInt1() {
        assertTrue(Validador.esInt("0"));
        assertTrue(Validador.esInt("100"));
        assertTrue(Validador.esInt("-256"));
        assertTrue(Validador.esInt("-2147483648")); // Valor mínimo de un int
        assertTrue(Validador.esInt("2147483647")); // Valor máximo de un int
    }

    /**
     * Test para revisar que esInt() no acepta números demasiado grandes
     */
    @Test
    public void esInt2() {
        assertFalse(Validador.esInt("23172617381238"));
        assertFalse(Validador.esInt("-92347821332912"));
        assertFalse(Validador.esInt("-2147483649")); // Valor mínimo de un int -1
        assertFalse(Validador.esInt("2147483648")); // Valor máximo de un int +1
    }

    /**
     * Test para revisar que esInt() no acepta símbolos o letras
     */
    @Test
    public void esInt3() {
        assertFalse(Validador.esInt("A"));
        assertFalse(Validador.esInt("asdasda"));
        assertFalse(Validador.esInt("!\"#=?"));
        assertFalse(Validador.esInt(" "));
        assertFalse(Validador.esInt("         "));
    }

    /**
     * Test para revisar que esInt() no acepta entrada nula
     */
    @Test
    public void esInt4() {
        assertFalse(Validador.esInt(null));
    }

    /**
     * Test para revisar que esNumeroTelefonico() acepta números de teléfono válidos
     */
    @Test
    public void esNumeroTelefonico1() {
        assertTrue(Validador.esNumeroTelefonico("912345678"));
        assertTrue(Validador.esNumeroTelefonico("133"));
        assertTrue(Validador.esNumeroTelefonico("911"));
    }

    /**
     * Test para revisar que esNumeroTelefonico() también acepta números de teléfonos válidos si se antepone un +
     */
    @Test
    public void esNumeroTelefonico2() {
        assertTrue(Validador.esNumeroTelefonico("+56971717171"));
        assertTrue(Validador.esNumeroTelefonico("+123456789"));
    }

    /**
     * Test para revisar que esNumeroTelefonico() no acepta números en otros formatos
     */
    @Test
    public void esNumeroTelefonico3() {
        assertFalse(Validador.esNumeroTelefonico("+56 111 222 333"));
        assertFalse(Validador.esNumeroTelefonico("+123-456-789"));
        assertFalse(Validador.esNumeroTelefonico("1 0 3"));
    }

    /**
     * Test para revisar que esNumeroTelefonico() no acepta entrada que tenga símbolos
     */
    @Test
    public void esNumeroTelefonico4() {
        assertFalse(Validador.esNumeroTelefonico("+"));
        assertFalse(Validador.esNumeroTelefonico("asdfsdghasd"));
        assertFalse(Validador.esNumeroTelefonico(" "));
    }

    /**
     * Test para revisar que esNumeroTelefonico() no acepta entrada nula
     */
    @Test
    public void esNumeroTelefonico5() {
        assertFalse(Validador.esNumeroTelefonico(null));
    }

    /**
     * Test para revisar que esEmail() acepta emails válidos
     */
    @Test
    public void esEmail1() {
        assertTrue(Validador.esEmail("v.mardones07@gmail.com"));
        assertTrue(Validador.esEmail("l.burgos08@ufromail.cl"));
        assertTrue(Validador.esEmail("b.munoz15@hotmail.com"));
    }

    /**
     * Test para revisar que esEmail() no acepta emails no válidos
     */
    @Test
    public void esEmail2() {
        assertFalse(Validador.esEmail("0.#$s.213"));
        assertFalse(Validador.esEmail("..."));
        assertFalse(Validador.esEmail("holamundo"));
    }

    /**
     * Test para revisar que esEmail() no acepta entrada nula
     */
    @Test
    public void esEmail3() {
        assertFalse(Validador.esEmail(null));
    }
}