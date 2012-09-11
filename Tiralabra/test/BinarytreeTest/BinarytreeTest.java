package BinarytreeTest;

import Binarytree.Binarytree;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class BinarytreeTest {

    private Binarytree binarytree;

    public BinarytreeTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        binarytree = new Binarytree(7);
        binarytree.insert(5);
        binarytree.insert(8);
        binarytree.insert(3);
        binarytree.insert(2);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void insert() {
//        binarytree = new Binarytree(7);
//        binarytree.insert(5);
//        binarytree.insert(8);
//        binarytree.insert(3);
//        binarytree.insert(2);
        assertEquals("juuri ei ollut 7 ",7, binarytree.getRoot().getKey());
        assertEquals(5, binarytree.getRoot().getLeft().getKey());
        assertEquals(8, binarytree.getRoot().getRight().getKey());
        assertEquals(3, binarytree.getRoot().getLeft().getLeft().getKey());
        assertEquals(2, binarytree.getRoot().getLeft().getLeft().getLeft().getKey());
        assertEquals(null, binarytree.getRoot().getRight().getLeft());
        assertEquals(null, binarytree.getRoot().getLeft().getRight());
        assertEquals(null, binarytree.getRoot().getLeft().getLeft().getRight());
        
    }

    @Test
    public void min() {
        
        int min = binarytree.min(binarytree.getRoot());
        int oletettumin = 2;
        assertEquals(oletettumin, min);
    }

    @Test
    public void max() {
//        assertEquals("fail", 1, 2);
    }
    
    @Test
    public void printInOrder() {
        assertEquals("fail", 1, 2);
    }
    
    @Test
    public void printPreOrder() {
        assertEquals("fail", 1, 2);
    }
}
