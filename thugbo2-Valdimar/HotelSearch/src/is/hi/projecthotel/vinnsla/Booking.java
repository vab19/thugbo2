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
    private String dateIn;
    private String dateOut;
    private RoomsAvailable roomsAvailable;
    
    //private int priceOverall;
    //private int customerId;
    
    public Booking(int id, RoomsAvailable rooms){
        hotelId = id;
        roomsAvailable = rooms;
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
