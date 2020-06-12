package com.vlb.phonebook;

import com.vlb.phonebook.Menu;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class MenuTest {

    ArrayList<String> op = new ArrayList<>();
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
        simularInput("1");
        assertFalse(m.salir());
        System.out.println("");
        simularInput("0");
        assertTrue(m.salir());
    }
}