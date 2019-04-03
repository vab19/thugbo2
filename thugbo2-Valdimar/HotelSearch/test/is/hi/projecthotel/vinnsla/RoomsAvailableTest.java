package is.hi.projecthotel.vinnsla;

import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RoomsAvailableTest {
    
    private final int initRooms = 3;
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
        r = new RoomsAvailable();
        for (int i = 0; i < 400; i++) {
            r.put(l.plusDays(i), initRooms);
        }
    }
    
    @After
    public void tearDown() {
        r = null;
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
        tearDown();
    }

    /**
     * Test of unBook method, of class RoomsAvailable.
     */
    @Test
    public void testUnBook() {
        setUp();
        System.out.println("unBook");
        String key = "2019-04-08";
        LocalDate k = LocalDate.parse(key);
        assertEquals(3, (int)(r.get(k)));
        r.unBook(key);
        assertEquals(4, (int)(r.get(k)));
        tearDown();
    }

    /**
     * Test of isAvailable method, of class RoomsAvailable.
     */
    @Test
    public void testIsAvailable() {
        setUp();
        System.out.println("isAvailable");
        String key = "2019-04-08";
        boolean expResult = true;
        boolean result = r.isAvailable(key);
        assertEquals(expResult, result);
        for (int i = 0; i < 3; i++) {
            r.book(key);
        }
        assertEquals(false, r.isAvailable(key));
        tearDown();
    }
}