package is.hi.projecthotel.vinnsla;

import java.time.LocalDate;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


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
    
    /**
     * Initializer for Hotel class from Json.
     * @param hotelId
     * @param hotelName
     * @param address
     * @param region
     * @param pricePerNight
     * @param stars
     * @param rating
     * @param reviews
     * @param reviewsLength
     * @param roomsAvailable
     * @param initRooms
     * @param bookingList 
     */
    @JsonCreator
    private Hotel(@JsonProperty("hotelId") int hotelId,
                @JsonProperty("hotelName") String hotelName, @JsonProperty("address") String address,
                @JsonProperty("region") String region, @JsonProperty("pricePerNight") int pricePerNight,
                @JsonProperty("stars") int stars, @JsonProperty("rating") double rating,
                @JsonProperty("reviews") ArrayList<Review> reviews, @JsonProperty("reviewsLength") int reviewsLength,
                @JsonProperty("roomsAvailable") RoomsAvailable roomsAvailable, 
                @JsonProperty("initRooms") int initRooms,
                @JsonProperty("bookingList") ArrayList<Booking> bookingList) {
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
        this.bookingList = bookingList;
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
        initBookingList();
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
     * Initializes roomsAvailable for 2019
     * with value initRooms
     */
    private void initRooms() {     
        String startDate = "2019-01-01";
        LocalDate l = LocalDate.parse(startDate);
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
    
    /**
     * 
     * @param dateIn
     * @param dateOut
     * @param customerId 
     */
    public void book(String dateIn, String dateOut, int customerId) {
        LocalDate i = LocalDate.parse(dateIn);
        LocalDate o = LocalDate.parse(dateOut);
        if (!isAvailable(i,o)) {
            System.out.println("EKKI LAUST!");
        }
        else {
            
        Booking temp = new Booking();
        temp.setHotelId(getHotelId());
        temp.setCustomerId(customerId);
        temp.setDateIn(dateIn);
        temp.setDateOut(dateOut);
        temp.setPriceOverall(totalDays(i,o)*getPricePerNight());
           
        bookingList.add(temp);
            
        setRooms(i, o, true);
        }
    }
    
    /**
     * Removes Booking from bookingList if there is a booking 
     * that matches the parameters. If the booking exists adds one day
     * to roomsAvailable for every day between dateIn and dateOut.
     * @param dateIn    
     * @param dateOut
     * @param customerId 
     */
    public void unBook(String dateIn, String dateOut, int customerId) {
        LocalDate i = LocalDate.parse(dateIn);
        LocalDate o = LocalDate.parse(dateOut);
        
        Booking temp = new Booking();
        temp.setHotelId(getHotelId());
        temp.setCustomerId(customerId);
        temp.setDateIn(dateIn);
        temp.setDateOut(dateOut);
        temp.setPriceOverall(totalDays(i,o)*getPricePerNight());
        if (bookingList.contains(temp)) {
            bookingList.remove(bookingList.indexOf(temp));
            setRooms(i, o, false);
        }
    }
    
    /**
     * 
     * @param i     Date in 
     * @param o     Date out
     * @return      nr of days between Date i and Date o
     */
    private int totalDays(LocalDate i, LocalDate o) {
        int days = 0;
        while (i.compareTo(o) < 1) {
            days++;
            i.plusDays(1);
        }
        return days;
    }
    
    /**
     * return whether there is a room available on 
     * LocalDate i through o.
     * @param i     Date in
     * @param o     Date out
     * @return true if Available
     */
    public boolean isAvailable(LocalDate i, LocalDate o) {
        while (i.compareTo(o) < 1) {
            if (!roomsAvailable.isAvailable(i)) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * 
     * @param i     Date in
     * @param o     Date out
     * @param book if true removes 1 room of specified dates
     *             else adds 1 room on specified dates
     */
    private void setRooms(LocalDate i, LocalDate o, boolean book) {
        while (i.compareTo(o) < 1) {
            if (book) roomsAvailable.book(i);
            else roomsAvailable.unBook(i);
            i.plusDays(1);
        }
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
}