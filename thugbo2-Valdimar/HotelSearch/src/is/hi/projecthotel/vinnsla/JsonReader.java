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


public class JsonReader {
    
    private static final String PATH = "src/is/hi/projecthotel/gagnagrunnur/HotelList.json";
    private static ArrayList<Hotel> hotelList;
    
    public static ArrayList<Hotel> getHotelListJson() {
        ObjectMapper objectMapper = new ObjectMapper();
    
        try {
            hotelList = objectMapper.readValue(new File(PATH), ArrayList.class);
        } catch (IOException ex) {
            Logger.getLogger(JsonReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return hotelList;
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Hotel> h = getHotelListJson();
        Hotel hotel1 = h.get(0);
        hotel1.printHotel();
    }
    
}