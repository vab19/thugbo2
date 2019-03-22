package is.hi.projecthotel.vinnsla;

import java.util.LinkedHashSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Heldur utan um klukkustundir sem notandi getur valið úr
 * Klukkustundir eru fengnar úr gögnum um dagskrá
 * 
 * @author Ebba Þóra Hvannberg ebba@hi.is
 * @date mars 2018
 */
public class KlukkustundirModel  {
    private ObservableList<String> klsItems;
    
    /**
     * Smiður fyrir KlukkustundirModel. Tekur inn alla dagskrárliði 
     * Síar út mengi af klukkustundum sem dagskrárliðir í dLidir byrja á 
     * @param dLidir fylki af dagskrárliðum 
     */
    public KlukkustundirModel(ObservableList<Root.Results> dLidir) {
        
        // Náum í klukkustundir 
        LinkedHashSet timar = new LinkedHashSet();
        final int BIL = 11; 
        timar.add("allan daginn");
        for (Root.Results r:dLidir) {
           String u = r.getStartTime().substring(BIL,BIL+2);
           timar.add(u);
        }
   
        klsItems = FXCollections.observableArrayList();
        // Setjum klukkustundir í módelið 
        for (Object t:timar)
            klsItems.add(t.toString());
    }

    public ObservableList<String> getItems() {
       return klsItems;
    }
    
    public void setItems(ObservableList<String> o) {
       klsItems = o;
    }
    
}
