package Trietree;

import junit.framework.TestCase;

public class TrietreeTest extends TestCase {

    private Trietree trietree;

    public TrietreeTest(String testName) {
        super(testName);

    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        trietree.add("kameli");
        trietree.add("c");
        trietree.add("k");
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testAdd() {
        trietree.add("kameli");
        trietree.add("c");
        trietree.add("k");
        assertEquals("search ei toiminut oikein", trietree.etsiSana("kameli"), "kameli");
    }

    public void testEtsiSana() {
        trietree.add("kameli");
        trietree.add("c");
        trietree.add("k");
        assertEquals("search ei toiminut oikein", trietree.etsiSana("kameli"), "kameli");
    }

    public void testGetChild() {
        System.out.println("getChild");
        char c = ' ';
        Trietree instance = new Trietree();
        Node expResult = null;
        Node result = instance.getChild(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
