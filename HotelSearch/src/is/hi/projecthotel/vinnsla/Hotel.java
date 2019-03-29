package is.hi.projecthotel.vinnsla;

import java.time.LocalDate;

public class Hotel {

    private int hotelId;
    private String hotelName;
    private String address;
    private String region;
    private int pricePerNight;
    private int stars;
    private int rating;
    //private Review reviews;
    private RoomsAvailable roomsAvailable;
    private int initRooms;
    
    /**
     * Býr til Hótel og initilizer Fjölda herbergja
     * @param r     Fjöldi herbergja á hótelinu
     */
    public Hotel (int r) {
        initRooms = r;
        initRooms();
    }
    
    public int getHotelId() {
        return hotelId;
    }
    
    public void setHotelId(int val) {
        hotelId = val;
    }
    
    public String getHotelName() {
        return hotelName;
    }
    
    public void setHotelName(String str) {
        hotelName = str;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String str) {
        address = str;
    }
    
    public String getRegion() {
        return region;
    }
    
    public void setRegion(String str) {
        region = str;
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

    public void initRooms() {      
        LocalDate l = LocalDate.now();
        roomsAvailable = new RoomsAvailable();
        for (int i = 0; i < 400; i++) {
            roomsAvailable.put(l.plusDays(i), initRooms);
        }
    }
    
    public void printHotel() {
        System.out.println("HotelId: " + hotelId);
        System.out.println("hotelName: " + hotelName);
        System.out.println("address: " + address);
        System.out.println("region: " + region);
        System.out.println("pricePerNight: " + pricePerNight);
        System.out.println("stars: " + stars);
        System.out.println("rating: " + rating);
        System.out.println("roomsAvailable " + roomsAvailable);
        System.out.println("initRooms" + initRooms);
    }

    public static void main(String[] args) {
        //private int hotelId;
        //private String hotelName;
        //private String address;
        //private String region;
        //private int pricePerNight;
        //private int stars;
        //private int rating;
        //private Review review;
        //private RoomsAvailable roomsAvailable;
        //private int initRooms;
        int herb = 10;
        Hotel h = new Hotel(herb);
        h.setHotelId(12);
        h.setHotelName("Hótel Hafnafjörðut");
        h.setAddress("Eyravegur 22");
        h.setRegion("Suðurland");
        h.setPricePernight(10000);
        h.setStars(4);
        h.printHotel();
    }
}