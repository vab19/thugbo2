/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.hi.projecthotel.vinnsla;

import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nokkv
 */
public class RoomsAvailableTest {
    
    private int initRooms = 3;
    private RoomsAvailable r;
    
    public RoomsAvailableTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        LocalDate l = LocalDate.now();
        roomsr = new RoomsAvailable();
        for (int i = 0; i < 400; i++) {
            r.put(l.plusDays(i), initRooms);
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of book method, of class RoomsAvailable.
     */
    @Test
    public void testBook() {
        setUp();
        System.out.println("book");
        String key = "2019-04-04";
        LocalDate k = LocalDate.parse(key);
        assertEquals(3, (int)(r.get(k)));
        r.book(key);
        assertEquals(2, (int)(r.get(k)));
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of unBook method, of class RoomsAvailable.
     */
    @Test
    public void testUnBook() {
        setUp();
        System.out.println("unBook");
        String key = "2019-04-08";
        instance.unBook(key);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isAvailable method, of class RoomsAvailable.
     */
    @Test
    public void testIsAvailable() {
        System.out.println("isAvailable");
        LocalDate l = null;
        RoomsAvailable instance = new RoomsAvailable();
        boolean expResult = false;
        boolean result = instance.isAvailable(l);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class RoomsAvailable.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        RoomsAvailable.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
