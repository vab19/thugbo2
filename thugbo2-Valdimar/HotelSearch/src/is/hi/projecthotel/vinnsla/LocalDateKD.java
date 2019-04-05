package is.hi.projecthotel.vinnsla;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer;

/**
 *
 * @author Nökkvi
 */
public class LocalDateKD extends StdKeyDeserializer {
        
    public final static int TYPE_BYTE_ARRAY = 18; // since 2.9
    
    LocalDateKD() {
      super(18, LocalDate.class);
    }

    /**
     * Parses String key from String to LocalDate
     * @param key   
     * @param ctxt
     * @return 
     * @throws JsonMappingException 
     */
    @Override
    public LocalDate
        _parse(String key, DeserializationContext ctxt) throws JsonMappingException {
        
        try {
            return LocalDate.parse(key);    
        }
        catch (Exception ex) {
            throw ctxt.weirdKeyException(_keyClass, key, ex.getMessage());
        }
    }
}