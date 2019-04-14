package is.hi.projecthotel.vinnsla;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Nökkvi
 */
public class CreateMockHotels {
    private static List<Hotel> hotelList = new ArrayList<>();
    private static final int MAX_HERB = 10;
    private static final int MAX_STARS = 5;
    private static final int MAX_PRICE = 100000;
    private static final String[] PRE =  {"", "Iceland ", "Glacial ", "Cozy ", "Cool ", "Nice and easy ", "Lovers' ", "Amazing ", "Unique ", "Arthouse ", "Freaky ", "Seljaland ", "Hólmfríður-", "Utangátta "};
    private static final String[] POST = {"", "Hotel", "Guesthouse", "Cabin", "Apartments", "Housing", "Flats", "Motel", "House"};
    private static final String[] PRE1 =  {"", "Báru", "Baldurs", "Ara", "Stiga", "Laxa", "Silunga", "Horna", "Hvassa"};
    private static final String[] POST1 = {"", "hlíð", "gata", "leiti", "kvísl", "vegur", "horn", "bjarg"};
    private static final String[] REGIONS = {"North","South","East","West"};
    private static final String[] RATINGS1 = {"", "If I had one thing to say about this hotel it would be that it was ", "Well I don't like to complain. My mother raised me better you see. She also taught me to appreciate the good things in life. Anyway I'd like to say the hotel was ",
                                              "I've travelled far and wide so my opinion is truly not something to be taken lightly and my opinion on this so called hotel is that it was ", "Honestly ",
                                              "It was my first time here in Iceland, lovely place, absolutely bang on my kind of spot, and I must leave this commment about the hotel- ",
                                              "The Icelanders were nice! Much to my surprise! What I think about this hotel is that it was ", "Well I've been around the block, and when I say the block I'm of course referring to the world, which I've seen quite a bit of. And I'd like to review this hotel right here which I found to be ",
                                              "I'm a man of many thoughts, my thoughts are often somewhat complex you see for my mind... It works mysteriously, however my thoughts concerning this hotel are quite simple! I found it to be "};

           
    
    private static final String[] RATINGS2 = {"", "horrifying. There were rats here! Big ones too.", "terrible. I would rather sleep in a subway station. Though I'm told Iceland doesn't have one I'd imagine it would be a better alternative if it existed.", "real bad man, real bad. Quite dirty too.", "subpar, really. Even though I wouldn't go as far as too call it horrible. Didn't enjoy it. Also it was cold outside.",
                                              "about average I'd say.",  "alright I suppose.",
                                              "well... not the worst place I've been to, to be quite honest.", "pretty damn good.", "so good I would highly recommend it",  "truly amazing" };
            
    public static int randomNum(int val) {
        return ThreadLocalRandom.current().nextInt(1, val + 1);
    }
    
    public static String randomName() {
        return PRE[randomNum(PRE.length-1)] + POST[randomNum(POST.length-1)];
    }
    
     public static String randomName2() {
        return PRE1[randomNum(PRE1.length-1)] + POST1[randomNum(POST1.length-1)];
    }
    
    public static String randomRegion() {
        return REGIONS[ThreadLocalRandom.current().nextInt(0, REGIONS.length)];
    }
    
    public static Hotel randomHotel(int id) {
        Hotel h = new Hotel(randomNum(MAX_HERB));
        h.setHotelId(id);
        h.setHotelName(randomName());
        String adr = randomName2() + " " + randomNum(MAX_HERB);
        h.setAddress(adr);
        h.setRegion(randomRegion());
        //þannig að verðið er aldrei undir 10000
        h.setPricePernight(ThreadLocalRandom.current().nextInt(10000, MAX_PRICE-1));
        int rate = randomNum(10);
        h.setRating(rate);
        h.addReview(RATINGS1[randomNum(RATINGS1.length-1)]+RATINGS2[rate], rate, id*5, id);
        h.setStars(randomNum(MAX_STARS));
           hotelList.add(id,h);
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
