package AVLtree;

import DataStructures.Node;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AVLtreeTest extends TestCase {

    private AVLtree avltree;

    public AVLtreeTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        avltree = new AVLtree(5);
        avltree.AVLinsert(8);
        avltree.AVLinsert(7);
    }

    /**
     * Test of AVLinsert method, of class AVLtree.
     */
    public void testAVLinsert() {
        assertEquals("insert ei toiminut oikein ", 7, avltree.getRoot().key);
        avltree.AVLinsert(10);
        assertEquals("insert ei toiminut oikein ", 10, avltree.getRoot().right.right.key);
        avltree.AVLinsert(11);
        assertEquals("insert ei toiminut oikein ", 10, avltree.getRoot().right.key);
        assertEquals("insert ei toiminut oikein ", 8, avltree.getRoot().right.left.key);
        avltree.AVLinsert(9);
        assertEquals("insert ei toiminut oikein ", 8, avltree.getRoot().key);
        assertEquals("insert ei toiminut oikein ", 5, avltree.getRoot().left.left.key);
    }

    /**
     * Test of AVLdelete method, of class AVLtree.
     */
    public void testAVLdelete() {
        avltree.AVLinsert(10);
        avltree.AVLdelete(avltree.search(avltree.getRoot(), 7));
        assertEquals("delete ei toiminut oikein ", 8, avltree.getRoot().key);
        assertEquals("delete ei toiminut oikein ", 10, avltree.getRoot().right.key);
        avltree.AVLinsert(2);
        avltree.AVLinsert(4);
        avltree.AVLdelete(avltree.getRoot());
        assertEquals("delete ei toiminut oikein ", 5, avltree.getRoot().key);
        assertEquals("delete ei toiminut oikein ", 2, avltree.getRoot().left.left.key);
    }

    /**
     * Test of min method, of class AVLtree.
     */
    public void testMin() {
        avltree.AVLinsert(2);
        avltree.AVLinsert(4);
        avltree.AVLinsert(1);
        avltree.AVLinsert(6);
        avltree.AVLinsert(11);
        avltree.AVLinsert(9);
        assertEquals(1, avltree.min(avltree.getRoot()).key);
    }

    /**
     * Test of max method, of class AVLtree.
     */
    public void testMax() {
        avltree.AVLinsert(2);
        avltree.AVLinsert(4);
        avltree.AVLinsert(1);
        avltree.AVLinsert(6);
        avltree.AVLinsert(11);
        avltree.AVLinsert(9);
        assertEquals(11, avltree.max(avltree.getRoot()).key);
    }

    /**
     * Test of search method, of class AVLtree.
     */
    public void testSearch() {
        avltree.AVLinsert(2);
        avltree.AVLinsert(4);
        avltree.AVLinsert(1);
        avltree.AVLinsert(6);
        avltree.AVLinsert(11);
        avltree.AVLinsert(9);
        assertEquals(6, avltree.search(avltree.getRoot(), 6).key);
        assertEquals(null, avltree.search(avltree.getRoot(), 15));
    }

    /**
     * Test of laskeKorkeus method, of class AVLtree.
     */
    public void testLaskeKorkeus() {
        avltree.AVLinsert(2);
        avltree.AVLinsert(4);
        avltree.AVLinsert(1);
        avltree.AVLinsert(6);
        avltree.AVLinsert(11);
        avltree.AVLinsert(9);
        assertEquals(3, avltree.laskeKorkeus(avltree.getRoot()));
    }

    /**
     * Test of getRoot method, of class AVLtree.
     */
    public void testGetRoot() {
        assertEquals("juuren haussa vikaa", 7, avltree.getRoot().key);
    }
}
