package is.hi.projecthotel.vinnsla;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HotelTest {
    
    public HotelTest() {
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

    @Test
    public void testGetHotelId() {
        System.out.println("getHotelId");
        Hotel instance = null;
        int expResult = 0;
        int result = instance.getHotelId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetHotelId() {
        System.out.println("setHotelId");
        int val = 0;
        Hotel instance = null;
        instance.setHotelId(val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetHotelName() {
        System.out.println("getHotelName");
        Hotel instance = null;
        String expResult = "";
        String result = instance.getHotelName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetHotelName() {
        System.out.println("setHotelName");
        String str = "";
        Hotel instance = null;
        instance.setHotelName(str);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        Hotel instance = null;
        String expResult = "";
        String result = instance.getAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetAddress() {
        System.out.println("setAddress");
        String str = "";
        Hotel instance = null;
        instance.setAddress(str);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetRegion() {
        System.out.println("getRegion");
        Hotel instance = null;
        String expResult = "";
        String result = instance.getRegion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetRegion() {
        System.out.println("setRegion");
        String str = "";
        Hotel instance = null;
        instance.setRegion(str);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetPricePerNight() {
        System.out.println("getPricePerNight");
        Hotel instance = null;
        int expResult = 0;
        int result = instance.getPricePerNight();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetPricePernight() {
        System.out.println("setPricePernight");
        int val = 0;
        Hotel instance = null;
        instance.setPricePernight(val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetStars() {
        System.out.println("getStars");
        Hotel instance = null;
        int expResult = 0;
        int result = instance.getStars();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetStars() {
        System.out.println("setStars");
        int val = 0;
        Hotel instance = null;
        instance.setStars(val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetRating() {
        System.out.println("getRating");
        Hotel instance = null;
        double expResult = 0.0;
        double result = instance.getRating();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetRating() {
        System.out.println("setRating");
        double val = 0.0;
        Hotel instance = null;
        instance.setRating(val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetReviews() {
        System.out.println("getReviews");
        Hotel instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.getReviews();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testAddReview() {
        System.out.println("addReview");
        String str = "";
        int r = 0;
        int c = 0;
        int h = 0;
        Hotel instance = null;
        instance.addReview(str, r, c, h);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testCalculateRating() {
        System.out.println("calculateRating");
        double r = 0.0;
        Hotel instance = null;
        instance.calculateRating(r);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testPrintHotel() {
        System.out.println("printHotel");
        Hotel instance = null;
        instance.printHotel();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Hotel.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
