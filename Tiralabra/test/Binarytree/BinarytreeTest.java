package Binarytree;

import Binarytree.Binarytree;
import DataStructures.Node;
import junit.framework.TestCase;

public class BinarytreeTest extends TestCase {

    private Binarytree binarytree;

    public BinarytreeTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        binarytree = new Binarytree(7);
        binarytree.insert(5);
        binarytree.insert(8);
        binarytree.insert(3);
        binarytree.insert(2);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testInsert() {
        // Testataan setUpissa tehdyt insertit
        assertEquals("juuri ei ollut 7 ", 7, binarytree.getRoot().getKey());
        assertEquals(5, binarytree.getRoot().getLeft().getKey());
        assertEquals(8, binarytree.getRoot().getRight().getKey());
        assertEquals(3, binarytree.getRoot().getLeft().getLeft().getKey());
        assertEquals(2, binarytree.getRoot().getLeft().getLeft().getLeft().getKey());
        assertEquals(null, binarytree.getRoot().getRight().getLeft());
        assertEquals(null, binarytree.getRoot().getLeft().getRight());
        assertEquals(null, binarytree.getRoot().getLeft().getLeft().getRight());
    }

    public void testDelete() {
        binarytree.delete(binarytree.search(binarytree.getRoot(), 2));
        assertEquals("delete ei toimi oikein, kun ei ollut lapsia", null, binarytree.getRoot().left.left.right);
        binarytree.delete(binarytree.search(binarytree.getRoot(), 5));
        assertEquals("delete ei toimi oikein, kun lapsia oli 1", 3, binarytree.getRoot().left.key);
        binarytree.delete(binarytree.search(binarytree.getRoot(), 7));
        assertEquals("delete ei toimi oikein kun juuri poistettiin ja kun lapsia oli 2", 8, binarytree.getRoot().key);
    }

    public void testSearch() {
        int key = binarytree.search(binarytree.getRoot(), 3).key;
        assertEquals("search ei toiminut oikein", key, 3);
        assertEquals("search ei toiminut oikein", binarytree.search(binarytree.getRoot(), 4), null);
    }

    public void testMin() {
        int min = binarytree.min(binarytree.getRoot()).key;
        int oletettumin = 2;
        assertEquals("min ei toiminut oikein", oletettumin, min);
    }

    public void testMax() {
        int max = binarytree.max(binarytree.getRoot()).key;
        int oletettumax = 8;
        assertEquals("max ei toiminut oikein", oletettumax, max);
    }

    public void testLaskeKorkeus() {
        int kolmenKorkeus = binarytree.laskeKorkeus(binarytree.search(binarytree.getRoot(), 3));
        int kahdenKorkeus = binarytree.laskeKorkeus(binarytree.search(binarytree.getRoot(), 2));
        assertEquals("korkeuden laskeminen ei toiminut oikein", 1, kolmenKorkeus);
        assertEquals("korkeuden laskeminen ei toiminut oikein", 0, kahdenKorkeus);
        assertEquals("korkeuden laskeminen ei toiminut oikein", 3, binarytree.laskeKorkeus(binarytree.getRoot()));
        
    }
}
