package com.vlb.phonebook;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

public class AgendaTest {

    Agenda a;

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
        a = new Agenda(); // Crea una nueva instancia
    }

    @After
    public void tearDown() throws Exception {
        a = null; // Liberar memoria
    }

    /**
     * Prueba para verificar que el nombre de un contacto se guarda correctamente al crear uno nuevo
     */
    @Test
    public void crearContacto1() {
        simularInput("Juan Pérez");
        a.crearContacto();
        String nombreContacto = a.getContactos().get(0).getNombre();
        assertEquals("Juan Pérez", nombreContacto);

        simularInput("Pablo");
        a.crearContacto();
        nombreContacto = a.getContactos().get(1).getNombre();
        assertEquals("Pablo", nombreContacto);
    }

    @Test
    public void listarContactos() {

    }

    @Test
    public void mostrarContacto() {
    }

    @Test
    public void editarContacto() {
    }

    @Test
    public void eliminarContacto() {
    }

    @Test
    public void menuEdicion() {
    }

    @Test
    public void crearOpciones() {
    }

    @Test
    public void switchEdicion() {
    }
}