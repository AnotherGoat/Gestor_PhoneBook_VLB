package com.vlb.phonebook;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class MenuTest {

    List<String> op = new ArrayList<>();
    Menu m = new Menu(op);

    /**
     * Método para simular entrada de usuario en los tests
     * @param entrada String que representa la entrada del usuario
     */
    public void simularInput(String entrada){
        if(entrada!=null) {
            ByteArrayInputStream in = new ByteArrayInputStream(entrada.getBytes());
            System.setIn(in);
        }
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test para verificar que el método salir funciona
     */
    @Test
    public void salir1() {
        m.nombreMenu="";

        simularInput("1");
        assertTrue(m.salir());

        System.out.println("");

        simularInput("0");
        assertFalse(m.salir());
    }
}