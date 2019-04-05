package is.hi.projecthotel.vinnsla;

import java.time.LocalDate;

/**
 *
 * @author nokkv
 */
public class Booking {

    private int hotelId;
    private int customerId;
    private LocalDate dateIn;
    private LocalDate dateOut;
    private int totalPrice;
    
    public Booking() {}
    
    public int getHotelId() { return hotelId; }

    public void setHotelId(int val) { hotelId = val; }

    public int getCustomerId() { return customerId; }

    public void setCustomerId(int val) { customerId = val; }

    public LocalDate getDateIn() { return dateIn; }

    public void setDateIn(LocalDate val) { dateIn = val; }

    public LocalDate getDateOut() { return dateOut; }

    public void setDateOut(LocalDate val) { dateOut = val; }

    public int getTotalPrice() { return totalPrice; }

    public void setTotalPrice(int val) { totalPrice = val; }
    
    
    
}
