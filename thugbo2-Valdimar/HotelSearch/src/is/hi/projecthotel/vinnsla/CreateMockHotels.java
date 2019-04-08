package is.hi.projecthotel.vinnsla;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Nökkvi
 */
public class CreateMockHotels {
    
    private static final int MAX_HERB = 10;
    private static final int MAX_STARS = 5;
    private static final int MAX_PRICE = 100000;
    private static final String[] ALPHABET = {"A","B","C","D","E","F","G","H","J","K","L",
                                                "M","N","O","P","Q","R","S","T","U","V",
                                                "W","Y","X","Z"};
    private static final String[] REGIONS = {"North","South","East","West"};
    
    public static int randomNum(int val) {
        return ThreadLocalRandom.current().nextInt(1, val + 1);
    }
    
    public static String randomName() {
        return ALPHABET[ThreadLocalRandom.current().nextInt(0, ALPHABET.length)];
    }
    
    public static String randomRegion() {
        return REGIONS[ThreadLocalRandom.current().nextInt(0, REGIONS.length)];
    }
    
    public static Hotel randomHotel(int id) {
        Hotel h = new Hotel(randomNum(MAX_HERB));
        h.setHotelId(id);
        h.setHotelName(randomName());
        String adr = randomName() + " " + randomNum(MAX_HERB);
        h.setAddress(adr);
        h.setRegion(randomRegion());
        h.setPricePernight(randomNum(MAX_PRICE));
        h.setRating(randomNum(10));
        h.setStars(randomNum(MAX_STARS));
          List<Hotel> hotelList = new ArrayList<>();
           JsonGenerator.setHotelListJson(hotelList);
        return h;
    }
            
    public static void main(String[] args) {
        List<Hotel> hotelList = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            hotelList.add(randomHotel(i));
        }
        
        JsonGenerator.setHotelListJson(hotelList);
    }
}
