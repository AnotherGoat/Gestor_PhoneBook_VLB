package phonebook;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class MenuTest {

    Validador v;
    List<String> op;
    Menu m = new Menu(op);

    @Before
    public void setUp() throws Exception {
        v = new Validador();
        op = new ArrayList<>();
        m = new Menu(op);
    }

    @After
    public void tearDown() throws Exception {
        v = null;
        op = null;
        m = null;
    }

    /**
     * Test para verificar que el método salir funciona
     */
    @Test
    public void salir1() {
        m.nombreMenu="";

        v.simularInput("1");
        assertTrue(m.salir());

        System.out.println("");

        v.simularInput("0");
        assertFalse(m.salir());
    }
}