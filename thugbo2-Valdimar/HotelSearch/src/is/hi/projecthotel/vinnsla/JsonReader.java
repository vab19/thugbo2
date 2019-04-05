package is.hi.projecthotel.vinnsla;

import java.io.IOException;
import java.io.File;

import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * 
 * @author Nökkvi
 */
public class JsonReader {
    
    // database of hotels in package
    private static final String PATH = "src/is/hi/projecthotel/gagnagrunnur/HotelList.json";

    /**
     * 
     * @return      List<Hotel> from the json database of hotels 
     */
    public static List<Hotel> getHotelListJson() {  
                
        ObjectMapper objectMapper = new ObjectMapper();
        
        
        try {
            List<Hotel> hotelList = objectMapper.readValue(new File(PATH), new TypeReference<List<Hotel>>(){});
            return hotelList;
        } catch (IOException ex) {
            Logger.getLogger(JsonReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Hotel> h = new ArrayList<>();
        return h;
    }
    
    public static void main(String[] args) {
        List<Hotel> l = getHotelListJson();
    }
}