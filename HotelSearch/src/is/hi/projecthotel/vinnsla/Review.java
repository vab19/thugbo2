package is.hi.projecthotel.vinnsla;

/**
 * @author Nökkvi
 */
public class Review {
   
    private String comment;    // review frá notenda
    private int rating;        // rating frá notenda
    private int customerId;    // Identification fyrir notendan
    private int hotelId;       // Identification fyrir hotelið
    
    /**
     * Initializes Review
     */
    public Review() {}
    
    public String getComment() { return comment; }
    
    public void setComment(String str) { comment = str; }
    
    public int getRating() { return rating; }
    
    public void setRating(int val) { rating = val; }
    
    public int getCustomerId() { return customerId; }
    
    public void setCustomerId(int val) { customerId = val; }
    
    public int getHotelId() { return hotelId; }
    
    public void setHotelId(int val) { hotelId = val; }
}