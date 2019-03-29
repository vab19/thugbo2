package is.hi.projecthotel.vinnsla;

import java.time.LocalDate;
import java.util.TreeMap;

public class RoomsAvailable extends TreeMap<LocalDate,Integer> {
    public void book(String key) {
        LocalDate l = LocalDate.parse(key);
        this.put(l,this.get(l)-1);
    }

    public void unBook(String key) {
        LocalDate l = LocalDate.parse(key);
        if (this.containsKey(l)) {
            this.put(l,this.get(l)+1);
        }
    }

    public boolean isAvailable(LocalDate l) {
        return get(l)!=0;
    }
    public static void main (String[] args) {
        RoomsAvailable r = new RoomsAvailable();
        LocalDate l = LocalDate.now();
        r.put(l, 10);

    }
}