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
    
    public Booking(){
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }
    
    publci int getCustomerId() {
        
    }

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }

    public RoomsAvailable getRoomsAvailable() {
        return roomsAvailable;
    }

    public void setRoomsAvailable(RoomsAvailable roomsAvailable) {
        this.roomsAvailable = roomsAvailable;
    }
    
   
    public void book(String dateIn, String dateOut){
        this.dateIn = dateIn;
        this.dateOut = dateOut;
    
        LocalDate in = LocalDate.parse(dateIn);
        LocalDate out = LocalDate.parse(dateOut);
        if(dateIn == dateOut){
            if(!roomsAvailable.isAvailable(dateOut))System.out.println("not available");
            else{
                 roomsAvailable.book(dateOut);
            }
            
        }
        else{
            roomsAvailable.book(dateOut);
            int count = 0;
            while(!in.plusDays(count).equals(dateOut)) {
                if(!roomsAvailable.isAvailable(in.plusDays(count).toString()))System.out.println("not available");
                else{
                    roomsAvailable.book(in.plusDays(count).toString());
                    count++;
                }
            }
        }
    }
}
