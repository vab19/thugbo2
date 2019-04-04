package is.hi.projecthotel.vinnsla;

import java.io.IOException;
import java.io.File;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Nökkvi
 */
public class JsonGenerator {
    
    // database of hotels in package
    private static final String PATH = "src/is/hi/projecthotel/gagnagrunnur/HotelList.json";
    
    /**
     * Saves a List of Hotel objects as json
     * @param a     Listi af hotelum  
     */
    public static void setHotelListJson(List<Hotel> a) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {   
            objectMapper.writeValue(new File(PATH), a);
        } catch (IOException ex) {
            Logger.getLogger(JsonGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}