import java.time.LocalDate;
import java.util.TreeMap;

public class Hotel {

    private int hotelId;
    private String hotelName;
    private String address;
    private String region;
    private int pricePerNight;
    private int stars;
    private int rating;
    private Review review;
    private RoomsAvailable roomsAvailable;
    
    private int initRooms;
    
    public int getHotelId() {
        return hotelId;
    }
    
    public String getHotelName() {
        return hotelName;
    }
    
    public String getAddress() {
        return address;
    }
    
    
    public String getRegion() {
        return region;
    }
    
    public int getPricePerNight() {
        return pricePerNight;
    }
    
    public void setPricePernight(int val) {
        this.pricePerNight = val;
    }
    
    public int getStars() {
        return stars;
    }
    
    public void setStars(int val) {
        this.stars = val;
    }
    
    public int getRating() {
        return rating;
    }
    
    public void setRating(int val) {
        this.rating = val;
    }

    public class RoomsAvailable extends TreeMap<LocalDate,Integer>{

        public void book(String key) {
            LocalDate l = LocalDate.parse(key);
            this.put(l,this.get(l)-1);
        }

        public void unBook(String key) {
            LocalDate l = LocalDate.parse(key);
            if (this.containsKey(l)) {
                this.put(l,this.get(l)+1);
            }
        }
    }

    


    public static void main(String[] args) {


    }
}