package is.hi.projecthotel.vinnsla;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.json.*;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;



public class HotelJsonReader {

	public static final String JSON_FILE="HotelList.json";
	
	public static void main(String[] args) throws IOException {
		InputStream fis = new FileInputStream(JSON_FILE);
		
		//create JsonReader object
		JsonReader jsonReader = Json.createReader(fis);
		
		/**
		 * We can create JsonReader from Factory also
		JsonReaderFactory factory = Json.createReaderFactory(null);
		jsonReader = factory.createReader(fis);
		*/
		
		//get JsonObject from JsonReader
		JsonObject jsonObject = jsonReader.readObject();
		
		//we can close IO resource and JsonReader now
		jsonReader.close();
		fis.close();
		
		//Retrieve data from JsonObject and create Employee bean
		Hotel hot = new Hotel();
		
		hot.setHotelId(jsonObject.getInt("hotelId"));
		hot.setHotelName(jsonObject.getString("hotelName"));
		hot.setAddress(jsonObject.getString("address"));
		hot.setRegion(jsonObject.getString("region"));
                hot.setPricePernight(jsonObject.getInt("pricePerNight"));
                hot.setStars(jsonObject.getInt("stars"));
                hot.setRating(jsonObject.getInt("rating"));
                
		
		
		//print employee bean information
		System.out.println(hot);
		
	}

}
