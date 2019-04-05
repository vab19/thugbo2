package is.hi.projecthotel.vinnsla;


import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Valdimar Björnsson vab19@hi.is 
 * @date
 * Háskóli Íslands
 */

public class Booking {
    private int hotelId;
    private int customerId;
    private String dateIn;
    private String dateOut;
    private int priveOverall;
    
    public Booking(){
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int val) {
        hotelId = val;
    }
    
    public int getCustomerId() {
        return customerId;
    }
    
    public void setCustomerId(int val) {
        customerId = val;
    }

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String str) {
        dateIn = str;
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setDateOut(String str) {
        dateOut = str;
    }
}