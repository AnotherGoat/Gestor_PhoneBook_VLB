package phonebook;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utilidades.Validador;

public class MenuEditorTest {

    Validador v;
    Contacto c;
    MenuEditor me;

    @Before
    public void setUp() throws Exception {
        v = new Validador();
        c = new Contacto();
        me = new MenuEditor(0);
    }

    @After
    public void tearDown() throws Exception {
        v = null;
        c = null;
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
    public void switchFijo() {
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