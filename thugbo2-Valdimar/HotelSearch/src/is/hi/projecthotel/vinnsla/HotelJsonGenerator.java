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
import java.util.List;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class HotelJsonGenerator {

    public void generate() {
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
     
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("Hotel.json"), h);
    }
}