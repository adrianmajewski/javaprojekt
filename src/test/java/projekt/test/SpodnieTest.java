
package projekt.test;

import projekt.model.Spodnie;
import org.junit.Before;
import org.junit.Test;
import projekt.model.Sklep;
import static org.junit.Assert.*;


public class SpodnieTest {

    Spodnie spodnie;
    
    @Before
    public void setUp() {
        spodnie = new Spodnie();
    }

    @Test
    public void testId() {
        spodnie.setId(new Long(1));
        assertEquals(new Long(1), spodnie.getId());
    }
    
    @Test
    public void testMarka() {
        spodnie.setMarka("Lee");
        assertEquals("Lee", spodnie.getMarka());
    }
    
    @Test
    public void testRozmiar() {
        spodnie.setRozmiar("W33 H34");
        assertEquals("W33 H34", spodnie.getRozmiar());
    }
    
    @Test
    public void testSklep() {
        Sklep sklep = new Sklep();
        spodnie.setSklep(sklep);
        assertSame(sklep, spodnie.getSklep());
        assertNotNull(spodnie.getSklep());
    }
}
