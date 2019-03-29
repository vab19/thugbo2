package is.hi.projecthotel.vinnsla;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.json.*;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;


public class HotelJsonReader{
    public static final String JSON_FILE="HotelList.json";
    
    public static init() {
        InputStream fis = new FileInputStream(FILE_NAME);

        JsonReader jsonReader = Json.createReader(fis);
        /**
         * TODO
         * Lesa json og parsa í HotelList
         * með Hotel Objectum
         */
    }
}