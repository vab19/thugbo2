

package is.hi.projecthotel.vinnsla;



import java.time.LocalDate;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.TimeZone;


/**
 *
 * @author Valdimar Björnsson vab19@hi.is 
 * @date
 * Háskóli Íslands
 */



public class Search
{
    private String from;                  // Hvaðan er flogið? Sjá mögulegar staðsetningar(fromArray) að neðan.
    private String to;                    // Hvert er flogið? Sjá mögulegar staðsetningar(toArray) að neðan.
    private String date;                  // Dagsetning flugs.
    private LocalDate localDate;          // Dagsetning flugs sem LocalDate hlutur. Höfum þetta því DatePicker skilar dagsetningu á þessu formi.
    private Integer numTickets;           // Fjöldi farþega/miða.
    private Integer minPrice;             // Lágmark á verðbili.
    private Integer maxPrice;             // Hámark á verðbili.
    private ArrayList<String> airlines;   // Listi af flugfélögum sem notandi vill fljúga með. Sjá möguleg flugfélög(airlinesArray) að neðan.
    
    private final static String[] fromArray = {"Reykjavík", "Keflavík", "Akureyri", "Egilsstaðir", "Ísafjörður", "Bíldudalur", "Grímsey", "Hornafjörður", "Húsavík", "Vopnafjörður", "Vestmannaeyjar", "Þórshöfn"};
    private final static String[] toArray = {"Take me anywhere!" , "Reykjavík", "Keflavík", "Akureyri", "Egilsstaðir", "Ísafjörður", "Bíldudalur", "Grímsey", "Hornafjörður", "Húsavík", "Vopnafjörður", "Vestmannaeyjar", "Þórshöfn"};
    private final static String[] airlinesArray = {"Air Iceland Connect", "Icelandair", "WOW air", "Eagle Air"};
    
    
    public Search(String from, String to, LocalDate date, int numTickets) 
    {
        this.from = from;
        this.to = to;
        this.numTickets = numTickets;
        
        setDate(date);
    }
    
    private void setDate(LocalDate date) 
    {        
        localDate = date;
        
        SimpleDateFormat sdf;
        sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        
        this.date = sdf.format(java.sql.Date.valueOf(date));
    }

    public void setMinPrice(int minPrice) 
    {
        this.minPrice = minPrice;
    }

    public void setMaxPrice(int maxPrice) 
    {
        this.maxPrice = maxPrice;
    }

    public void setAirlines(ArrayList<String> airlines) 
    {
        this.airlines = airlines;
    }    

    public String getFrom() 
    {
        return from;
    }

    public String getTo() 
    {
        return to;
    }

    public String getDate()
    {
        return date;
    }

    public LocalDate getLocalDate()
    {
        return localDate;
    }   
    
    public Integer getNumTickets() 
    {
        return numTickets;
    }

    public Integer getMinPrice() 
    {
        return minPrice;
    }

    public Integer getMaxPrice() 
    {
        return maxPrice;
    }

    public ArrayList<String> getAirlines()
    {
        return airlines;
    } 
}

