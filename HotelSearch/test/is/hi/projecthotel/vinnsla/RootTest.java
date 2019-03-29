/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.hi.projecthotel.vinnsla;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Nökkvi
 */
public class RootTest {
    
    public RootTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getResults method, of class Root.
     */
    @Test
    public void testGetResults() {
        System.out.println("getResults");
        Root instance = new Root();
        List<Root.Results> expResult = null;
        List<Root.Results> result = instance.getResults();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
