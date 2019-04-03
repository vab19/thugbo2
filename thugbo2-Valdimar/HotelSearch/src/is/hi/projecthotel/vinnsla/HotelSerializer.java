package is.hi.projecthotel.vinnsla;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;


/**
 *
 * @author nokkv
 */
/**public class HotelSerializer extends StdSerializer<Hotel> {
     
    protected HotelListSerializer(Class<Hotel> t) {
        super(t);
    }
    
    @Override
    public void serialize(Hotel hotel, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider)
            throws IOException {

        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("hotelId", hotel.getHotelId());
        jsonGenerator.writeStringField("hotelName", hotel.getHotelName());
        jsonGenerator.writeStringField("address", hotel.getAddress());
        jsonGenerator.writeStringField("region", hotel.getRegion());
        jsonGenerator.writeNumberField("pricePerNight", hotel.getPricePerNight());
        jsonGenerator.writeNumberField("stars", hotel.getStars());
        jsonGenerator.writeNumberField("rating", hotel.getRating());
        jsonGenerator.writeObject(hotel.getReviews());
        jsonGenerator.writeTree(hotel.getRoom);
        jsonGenerator.writeEndObject();
    }

}
**/