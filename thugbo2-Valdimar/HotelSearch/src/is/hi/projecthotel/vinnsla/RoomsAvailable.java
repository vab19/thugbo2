package is.hi.projecthotel.vinnsla;

import java.time.LocalDate;
import java.util.TreeMap;

/**
 * RoomsAvailable extends TreeMap<LocalDate, Integer>
 * LocalDate is key for Map to retrieve Integer the number of rooms 
 * available on that Date.
 * @author Nökkvi
 */
public class RoomsAvailable extends TreeMap<LocalDate,Integer> {
    
    /**
     * Subtracts 1 from value on key LocalDate
     * 
     * Books 1 room on LocalDate parsed from Key
     * if there is a room Available on that date
     * @param key     String on form "yyyy-mm-dd"
     */
    public void book(String key) {
        LocalDate l = LocalDate.parse(key);
        book(l);
    }
    
    
    public void book(LocalDate l) {
        if (isAvailable(l))
            this.put(l,this.get(l)-1);
    }

    /**
     * Adds 1 to value on key LocalDate
     * @param key 
     */
    public void unBook(String key) {
        LocalDate l = LocalDate.parse(key);
        unBook(l);
    }
    
    public void unBook(LocalDate l) {
        if (this.containsKey(l)) {
            this.put(l,this.get(l)+1);
        }
    }

    /**
     * Checks if room is available on key parses to LocalDate
     * @param key
     * @return True if value on LocalDate l > 0
     */
    public boolean isAvailable(String key) {
        LocalDate l = LocalDate.parse(key);
        return get(l)>0;
    }
    
    public boolean isAvailable(LocalDate l) {
        return get(l)>0;
    }
}