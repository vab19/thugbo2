package is.hi.projecthotel.vinnsla;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * 
 */
public class Hotel {
    
    private int hotelId;
    private String hotelName;
    private String address;
    private String region;
    private int pricePerNight;
    private int stars;
    private double rating;
    private ArrayList<Review> reviews;
    private int reviewsLength;
    @JsonDeserialize(keyUsing=LocalDateKD.class)
    private RoomsAvailable roomsAvailable;
    private int initRooms;
    private ArrayList<Booking> bookingList;
     @JsonCreator // constructor can be public, private, whatever
    private Hotel(@JsonProperty("hotelId") int hotelId,
                @JsonProperty("hotelName") String hotelName, @JsonProperty("address") String address,
                @JsonProperty("region") String region, @JsonProperty("pricePerNight") int pricePerNight,
                @JsonProperty("stars") int stars, @JsonProperty("rating") double rating,
                @JsonProperty("reviews") ArrayList<Review> reviews, @JsonProperty("reviewsLength") int reviewsLength,
                @JsonProperty("roomsAvailable") RoomsAvailable roomsAvailable, 
                @JsonProperty("initRooms") int initRooms) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.address = address;
        this.stars = stars;
        this.region = region;
        this.pricePerNight = pricePerNight;
        this.rating = rating;
        this.reviews = reviews;
        this.reviewsLength = reviewsLength;
        this.roomsAvailable = roomsAvailable;
        this.initRooms = initRooms;
    }
    
    /**
     * Initializes Hotel and calls initRooms that initializes 
     * roomsAvailable with initRooms
     * @param r     Total number of rooms in hotel
     */
    public Hotel (int r) {
        initRooms = r;
        initRooms();
        initReviews();
        reviewsLength = 0;
    }
    
    public int getHotelId() { return hotelId; }
    
    public void setHotelId(int val) { hotelId = val; }
    
    public String getHotelName() { return hotelName; }
    
    public void setHotelName(String str) { hotelName = str; }
    
    public String getAddress() { return address; }
    
    public void setAddress(String str) { address = str; }
    
    public String getRegion() { return region; }
    
    public void setRegion(String str) { region = str; }
    
    public int getPricePerNight() { return pricePerNight; }
    
    public void setPricePernight(int val) { this.pricePerNight = val; }
    
    public int getStars() { return stars; }
    
    public void setStars(int val) { this.stars = val; }
    
    public double getRating() { return rating; }
    
    public void setRating(double val) { this.rating = val; }
    
    public RoomsAvailable getroomsAvailable() {
        return roomsAvailable;
    }
    
    public ArrayList<Review> getReviews() {
        return reviews;
    }
    
    public ArrayList<Booking> getBookingList() {
        return bookingList;
    }

    /**
     * Initializes reviews with an empty ArrayList
     */
    private void initReviews() {
        reviews = new ArrayList<>();
    }
    
     /**
     * Initializes roomsAvailable for the next 400 days
     * with value initRooms
     */
    private void initRooms() {      
        LocalDate l = LocalDate.now();
        roomsAvailable = new RoomsAvailable();
        for (int i = 0; i < 400; i++) {
            roomsAvailable.put(l.plusDays(i), initRooms);
        }
    }
    
    private void initBookingList() {
        bookingList = new ArrayList<>();
    }
       
    /**
     * Creates Review object and adds it to reviews ArrayList
     * @param str     review
     * @param r       rating
     * @param c       customerId
     * @param h       hotelId
     */
    public void addReview(String str, int r, int c, int h) {
        Review temp = new Review();
        temp.setComment(str);
        temp.setRating(r);
        temp.setCustomerId(c);
        temp.setHotelId(h);
        reviews.add(temp);
        reviewsLength++;
        calculateRating((double)(r));
    }
    
    public void book(String dateIn, String dateOut, int customerId) {
        LocalDate i = LocalDate.parse(dateIn);
        LocalDate i = LocalDate.parse(dateIn);
        Booking temp = new Booking();
        temp.setHotelId(getHotelId());
        temp.setCustomerId(customerId);
        temp.setDateIn(dateIn);
        temp.setDateOut(dateOut);
        temp
    }
    
    /**
     * Adds new rating to current average rating and calculates
     * new average
     * @param r     Rating from new review
     */
    public void calculateRating(double r) {
        double temp = rating*(reviewsLength-1);
        rating = (temp+r)/reviewsLength;
    }
    
    public void printHotel() {
        System.out.println("HotelId: " + hotelId);
        System.out.println("hotelName: " + hotelName);
        System.out.println("address: " + address);
        System.out.println("region: " + region);
        System.out.println("pricePerNight: " + pricePerNight);
        System.out.println("stars: " + stars);
        System.out.println("rating: " + rating);
        System.out.println("roomsAvailable: " + roomsAvailable);
        System.out.println("initRooms: " + initRooms);
        System.out.println("Reviews: " + reviews);
    }

    public static void main(String[] args) {
        int herb = 10;
        Hotel h = new Hotel(herb);
        h.setHotelId(12);
        h.setHotelName("Hótel Hafnafjörðut");
        h.setAddress("Eyravegur 22");
        h.setRegion("Suðurland");
        h.setPricePernight(10000);
        h.setStars(4);
        String rev = "Geggjað gott";
        int rat = 10;
        int cust = 55;
        h.addReview(rev, rat, cust, 12);
        h.printHotel();

    }
    
}