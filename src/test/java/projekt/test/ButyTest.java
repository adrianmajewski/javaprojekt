
package projekt.test;

import projekt.model.Sklep;
import projekt.model.Buty;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class ButyTest {
    
    private Buty buty;
    
    @Before
    public void setUp() {
        buty = new Buty();
    }
    
    @Test
    public void testId() {
        buty.setId(new Long(1));
        assertEquals(new Long(1), buty.getId());
    }
    
    @Test
    public void testNazwa() {
        buty.setNazwa("Nike");
        assertEquals("Nike", buty.getNazwa());
    }
    
    @Test
    public void testRozmiar() {
        buty.setRozmiar(12.5f);
        assertEquals(new Float(12.5), buty.getRozmiar());
        assertTrue(12.5f == buty.getRozmiar());
    }
    
    @Test
    public void testKolor() {
        buty.setKolor("białe");
        assertEquals("białe", buty.getKolor());
    }
    
    @Test
    public void testSklep() {
        Sklep sklep = new Sklep();
        buty.setSklep(sklep);
        assertSame(sklep, buty.getSklep());
    }
}
