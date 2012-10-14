package Trietree;

import java.util.ArrayList;
import junit.framework.TestCase;

public class TrietreeTest extends TestCase {

    private Trietree trietree;

    public TrietreeTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        trietree = new Trietree();
        trietree.add("sukka");
        trietree.add("aita");
        trietree.add("aasi");
        trietree.add("susi");
        trietree.add("s");
    }

    /**
     * Test of add method, of class Trietree.
     */
    public void testAdd() {
        System.out.println(trietree.getRoot().size());
        assertEquals('a', trietree.getRoot().get(0).getName());
        assertEquals('s', trietree.getRoot().get(1).getName());
    }

    /**
     * Test of remove method, of class Trietree.
     */
    public void testRemove() {
        trietree.remove("aasi");
        // Kun aasi on poistettu, a:n tilalle tulee i
        assertEquals("jos poistettiin esim a, pitäisi sen tilalle tulla siitä seuraava kirjain",
                'i', trietree.getRoot().get(0).getRoot().get(0).getName());
        trietree.remove("s");
        // Kun s on poistettu, jäljellä pitäisi vielä olla 2 s kirjainta sanoista sukka ja susi
        assertEquals("jos kirjaimia on useampi, vain yhden pitäisi poistua puusta",
                's', trietree.getRoot().get(1).getName());
    }

    /**
     * Test of etsiSana method, of class Trietree.
     */
    public void testEtsiSana() {
        assertEquals(true, trietree.etsiSana("sukka"));
        assertEquals("sanan substring ei pitäisi löytyä puusta, vain kokonaiset lisätyt sanat", 
                false, trietree.etsiSana("sukk"));
        assertEquals(true, trietree.etsiSana("s"));
        assertEquals("sanoja joissa on ylimääräisiä kirjaimia, ei kuuluisi löytyä puusta", 
                false, trietree.etsiSana("sukkaa"));
    }

    /**
     * Test of getRoot method, of class Trietree.
     */
    public void testGetRoot() {
        // Juurella lapset a ja s
        assertEquals("juurta ei palautettu oikein", 2, trietree.getRoot().size());
        assertEquals("juurta ei palautettu oikein", false, trietree.getRoot().isEmpty());
    }

    /**
     * Test of compareTo method, of class Trietree.
     */
    public void testCompareTo() {
        Node testattava = new Node();
        testattava.setName('b');
        int paikka = trietree.compareTo(testattava);
        // B:n paikka arraylistissä on 1 eli a:n ja s:n välissä
        assertEquals(1, paikka);
    }
}
