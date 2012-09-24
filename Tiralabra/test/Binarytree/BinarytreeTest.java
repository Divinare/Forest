/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Binarytree;

import Binarytree.Binarytree;
import DataStructures.Node;
import junit.framework.TestCase;

/**
 *
 * @author joeniemi
 */
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
        assertEquals("juuri ei ollut 7 ",7, binarytree.getRoot().getKey());
        assertEquals(5, binarytree.getRoot().getLeft().getKey());
        assertEquals(8, binarytree.getRoot().getRight().getKey());
        assertEquals(3, binarytree.getRoot().getLeft().getLeft().getKey());
        assertEquals(2, binarytree.getRoot().getLeft().getLeft().getLeft().getKey());
        assertEquals(null, binarytree.getRoot().getRight().getLeft());
        assertEquals(null, binarytree.getRoot().getLeft().getRight());
        assertEquals(null, binarytree.getRoot().getLeft().getLeft().getRight());
    }

    public void testDelete() {
//        System.out.println("delete");
//        Node poistettava = null;
//        Binarytree instance = null;
//        Node expResult = null;
//        Node result = instance.delete(poistettava);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
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
        
    }
}
