package com.vlb.phonebook;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MenuEditorTest {

    Contacto c;
    MenuEditor me;

    @Before
    public void setUp() throws Exception {
        c = new Contacto();
        me = new MenuEditor(c, 0);
    }

    @After
    public void tearDown() throws Exception {
        me = null;
    }

    @Test
    public void desplegarMenu() {
    }

    @Test
    public void switchMenu() {
    }

    @Test
    public void switchNombre() {
    }

    @Test
    public void switchCelular() {
    }

    @Test
    public void switchCasa() {
    }

    @Test
    public void switchTrabajo() {
    }

    @Test
    public void switchDireccion() {
    }

    @Test
    public void switchEmail() {
    }

    @Test
    public void salirConfirmarCambios() {
    }
}