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
    }

    @After
    public void tearDown() {
    }

    @Test
    public void insert() {
        binarytree = new Binarytree(7);
        binarytree.insert(5);
        binarytree.insert(8);
        binarytree.insert(3);
        binarytree.insert(2);
        assertEquals(7, binarytree.getRoot().getKey());
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
    }

    @Test
    public void max() {
    }
    
    @Test
    public void printInOrder() {
        
    }
    
    @Test
    public void printPreOrder() {
        
    }
}
