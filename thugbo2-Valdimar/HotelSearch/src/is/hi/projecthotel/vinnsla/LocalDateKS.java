package is.hi.projecthotel.vinnsla;

import java.time.LocalDate;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;


/**
 *
 * @author nokkv
 */
/*public class LocalDateKS extends StdSerializer<LocalDate> {
    
    LocalDateKS() {
        super(LocalDate.class);
    }
    
    @Override
    public void serialize(LocalDate value, JsonGenerator jgen, SerializerProvider provider) 
            throws JsonGenerationException, IOException {
        
        ObjectMapper mapper = new ObjectMapper();
        jgen.writeFieldName(mapper.writeValueAsString(value));
    }
}
*/