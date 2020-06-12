package com.vlb.phonebook;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

public class ValidadorTest {

    /**
     * Validador usado en ValidadorTest
     */
    Validador v;

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

    public void simularVariosInput(String[] entradas){
        if(entradas!=null){
            StringBuilder lineasIngresadas = new StringBuilder();

            for(String s : entradas){
                lineasIngresadas.append(s).append(System.getProperty("line.separator"));
            }

            String entradaSimulada = lineasIngresadas.toString();

            ByteArrayInputStream in = new ByteArrayInputStream(entradaSimulada.getBytes());
            System.setIn(in);
        }
    }

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
        simularInput("1");
        assertEquals(1, v.tryCatchInt(""));
        simularInput("100");
        assertEquals(100, v.tryCatchInt(""));
        simularInput("-256");
        assertEquals(-256, v.tryCatchInt(""));
    }

    /**
     * Test para revisar que al ingresar símbolos el programa sigue funcionando
     */
    @Test
    public void tryCatchInt2() {
        simularInput("a");
        assertEquals(-1, v.tryCatchInt(""));
        simularInput(" ");
        assertEquals(-1, v.tryCatchInt(""));
        simularInput("asdasda");
        assertEquals(-1, v.tryCatchInt(""));
    }

    /**
     * Test para revisar que al ingresar un número demasiado grande el programa sigue funcionando
     */
    @Test
    public void tryCatchInt3() {
        simularInput("23172617381238");
        assertEquals(-1, v.tryCatchInt(""));
        simularInput("-92347821332912");
        assertEquals(-1, v.tryCatchInt(""));
    }

    /**
     * Test para revisar que al ingresar un String su valor no cambia
     */
    @Test
    public void recibirString1() {
        simularInput("Hola mundo");
        assertEquals("Hola mundo", v.recibirString(""));
    }
}