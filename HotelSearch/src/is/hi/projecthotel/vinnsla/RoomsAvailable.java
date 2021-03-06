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
     * @param key     String on form "27-12-03"
     */
    public void book(String key) {
        LocalDate l = LocalDate.parse(key);
        if (isAvailable(l))
            this.put(l,this.get(l)-1);
    }

    /**
     * Adds 1 to value on key LocalDate
     * @param key 
     */
    public void unBook(String key) {
        LocalDate l = LocalDate.parse(key);
        if (this.containsKey(l)) {
            this.put(l,this.get(l)+1);
        }
    }

    /**
     * Checks if room is available on LocalDate l
     * @param l
     * @return True if value on LocalDate l > 0
     */
    public boolean isAvailable(LocalDate l) {
        return get(l)>0;
    }
    
    public static void main (String[] args) {
        RoomsAvailable r = new RoomsAvailable();
        LocalDate l = LocalDate.now();
        r.put(l, 10);

    }
}