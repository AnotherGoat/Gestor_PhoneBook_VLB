package com.vlb.phonebook;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

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
     * Test para revisar que la entrada mantiene el int ingresado
     */
    @Test
    public void tryCatchInt1() {
        v.simularInput("1");
        assertEquals(1, v.tryCatchInt(""));
        v.simularInput("100");
        assertEquals(100, v.tryCatchInt(""));
        v.simularInput("-256");
        assertEquals(-256, v.tryCatchInt(""));
    }

    /**
     * Test para revisar que al ingresar símbolos el programa sigue funcionando
     */
    @Test
    public void tryCatchInt2() {
        v.simularInput("a");
        assertEquals(-1, v.tryCatchInt(""));
        v.simularInput(" ");
        assertEquals(-1, v.tryCatchInt(""));
        v.simularInput("asdasda");
        assertEquals(-1, v.tryCatchInt(""));
    }

    /**
     * Test para revisar que al ingresar un número demasiado grande el programa sigue funcionando
     */
    @Test
    public void tryCatchInt3() {
        v.simularInput("23172617381238");
        assertEquals(-1, v.tryCatchInt(""));
        v.simularInput("-92347821332912");
        assertEquals(-1, v.tryCatchInt(""));
    }

    /**
     * Test para revisar que al ingresar un String su valor no cambia
     */
    @Test
    public void recibirString1() {
        v.simularInput("Hola mundo");
        assertEquals("Hola mundo", v.recibirString(""));
    }

    /**
     * Test para revisar que el email se valida correctamente
     */
    @Test
    public void esEmailValido1() {
        assertFalse(v.esEmailValido("0.#$s.213"));
        assertFalse(v.esEmailValido("..."));
        assertFalse(v.esEmailValido("holamundo"));
        assertTrue(v.esEmailValido("v.mardones04@ufromail.cl"));
        assertTrue(v.esEmailValido("l.burgos02@ufromail.cl"));
        assertTrue(v.esEmailValido("b.munoz15@ufromail.cl"));
    }

    /**
     * Test para revisar qué ocurre si el String email es null
     */
    @Test
    public void esEmailValido2(){
        assertFalse(v.esEmailValido(null));
    }
}