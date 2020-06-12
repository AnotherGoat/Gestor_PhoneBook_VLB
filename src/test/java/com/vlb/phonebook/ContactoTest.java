package com.vlb.phonebook;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContactoTest {

    Contacto c;

    @Before
    public void setUp() throws Exception {
        c = new Contacto(); // Crea una nueva instancia
    }

    @After
    public void tearDown() throws Exception {
        c = null; // Liberar memoria
    }

    /**
     * Test para asegurarse de que el toString no muestra los datos del contacto que todavía no existen
     */
    @Test
    public void testToString1() {
        c.setNombre("Juan Perez");
        assertEquals("Nombre: Juan Perez", c.toString());
        c.setTelefonoCelular(123456789);
        assertEquals("Nombre: Juan Perez\nTeléfono Celular: 123456789", c.toString());
        c.setEmail("ejemplo@correo.com");
        assertEquals("Nombre: Juan Perez\nTeléfono Celular: 123456789\nE-mail: ejemplo@correo.com", c.toString());
    }
}