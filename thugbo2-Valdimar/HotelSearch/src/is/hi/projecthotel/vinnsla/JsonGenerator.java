package is.hi.projecthotel.vinnsla;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.ArrayList;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonGenerator {

    private static final String PATH = "src/is/hi/projecthotel/gagnagrunnur/HotelList.json";
    
    public static void setHotelListJson(List<Hotel> a) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {   
            objectMapper.writeValue(new File(PATH), a);
        } catch (IOException ex) {
            Logger.getLogger(JsonGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) throws IOException {
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
        List<Hotel> hotelList = new ArrayList<>();
        hotelList.add(h);
        hotelList.get(0).printHotel();
        setHotelListJson(hotelList);
    }
}