package is.hi.projecthotel.vinnsla;


import java.time.LocalDate;
import java.io.IOException;

import java.io.IOException;
import java.util.TreeMap;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer;
import java.io.IOException;
import java.util.TreeMap;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

/**
 *
 * @author Nökkvi
 */
public class LocalDateKD extends StdKeyDeserializer {
        
    public final static int TYPE_BYTE_ARRAY = 18; // since 2.9

    
    LocalDateKD() {
      super(18, LocalDate.class);
    }
    
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