package com.vlb.phonebook;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Clase que contiene las pruebas unitarias de la clase Contacto
 */
public class ContactoTest {

    Contacto c, d;

    @Before
    public void setUp() throws Exception {
        c = new Contacto(); // Crea una nueva instancia
        d = new Contacto();
    }

    @After
    public void tearDown() throws Exception {
        c = null; // Liberar memoria
        d = null;
    }

    /**
     * Test para probar el constructor que copia un contacto
     */
    @Test
    public void testCopiaConstructor1(){
        c.setNombre("Diego");
        d = new Contacto(c); // Usa el constructor para copiar los datos de c a d
        assertEquals(c.toString(), d.toString()); // Revisa si ambos toString coinciden

        // Revisa que d mantiene sus datos aunque c se haga nulo (paso por valor)
        c = null;
        assertEquals("Nombre: Diego", d.toString());
    }

    /**
     * Test para asegurarse de que el toString no muestra los datos del contacto que todavía no existen
     */
    @Test
    public void testToString1() {
        c.setNombre("Juan Perez");
        assertEquals("Nombre: Juan Perez", c.toString());
        c.getTelefonosCelular().add(123456789);
        assertEquals("Nombre: Juan Perez\nTeléfono Celular: 123456789", c.toString());
        c.setEmail("ejemplo@correo.com");
        assertEquals("Nombre: Juan Perez\nTeléfono Celular: 123456789\nE-mail: ejemplo@correo.com", c.toString());
    }
}