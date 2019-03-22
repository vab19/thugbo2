
package is.hi.projecthotel.vidmot;

import is.hi.projecthotel.vinnsla.KlukkustundirModel;
import is.hi.projecthotel.vinnsla.Root;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.TextField;

public class LeitOgAfmorkunController implements Initializable {
     private static final String ALLAN_DAGINN = "allan daginn";
    
     

    @FXML
    private TextField leit;
    @FXML
    private ComboBox<String> afmarkaTima;

    private DagskraController dagskraController;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


     /***
     * Frumstillir gögn og val-handler fyrir klukkustundar afmörkun
     * @param d dagskrárcontroller til að hægt sé að hafa samband
     * við aðalglugga 
     */
   public void frumstillaGognHandlerTimaAfmorkun(DagskraController d) {
        dagskraController = d;
        SingleSelectionModel tsl = afmarkaTima.getSelectionModel();
        tsl.selectedItemProperty().addListener(new ChangeListener<String> () {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                 leit.setText("");
                 ObservableList<Root.Results> obl = dagskraController.heildarListi();
                 ObservableList<Root.Results> valdirLidir;
                 if (newValue == null) {
                    return;
                }
                if (newValue.equals(ALLAN_DAGINN))  {
                    valdirLidir = obl;
                } else {
                    valdirLidir = veljaLidiKl(obl, newValue);
                }
                dagskraController.uppfaeraLista(valdirLidir);
            }
        });
        setjaKlukkustundir();
        afmarkaTima.getSelectionModel().selectFirst();
    }

   /***
    * Setur viðeigandi klukkustundir í combobox 
    */
    public void setjaKlukkustundir() {
        KlukkustundirModel kls = new KlukkustundirModel(dagskraController.heildarListi());
        afmarkaTima.getSelectionModel().select(null);
        afmarkaTima.setItems(kls.getItems());
    }

    
      /**
     * Velur þá dagskrárliði sem hafa titill streng sem hluta af titli dagskrárliðar
     * @param titill   
     * 
     * */
    @FXML
    private void leitaHandler(ActionEvent event) {
        String leitarstrengur = ((TextField)event.getSource()).getText();
        ObservableList<Root.Results> nyrListi;
        ObservableList<Root.Results> h = dagskraController.heildarListi();
        if (leitarstrengur.equals("")) {
            nyrListi = h;
        } else {
            nyrListi = veljaLidiTitill(h, leitarstrengur);
        }
        dagskraController.uppfaeraLista(nyrListi);
    }
    
    /***
     * Hjálparaðferð sem leitar að strengnum leit í titlum 
     * dagskrárliða og skilar þeim 
     * 
     * @param dagskra Listi af dagsrkárliðum 
     * @param leit Leitarstrengur
     * @return Listi af dagskrárliðum sem hafa leit í titli 
     */
     private ObservableList<Root.Results> veljaLidiTitill(ObservableList<Root.Results> dagskra, String leit) {
        ObservableList<Root.Results> nyrVektor = FXCollections.observableArrayList();
        for (Root.Results s : dagskra) {
            if (s.getTitle().contains(leit)) {
                nyrVektor.add(s);
            }
        }
        return nyrVektor;
    }

   /**
     * Velur dagskrárliði sem byrja á ákveðinni klukkustund kl
     * Valið úr heildarlista
     * @param kl klukkustund 
     * @return listi af dagskrárliðum 
     */
    private ObservableList<Root.Results> veljaLidiKl(ObservableList<Root.Results> dagskra, String kl) {
        ObservableList<Root.Results> nyrVektor = FXCollections.observableArrayList();
        
        for (Root.Results s:dagskra) {
            if ( Klukkustund(s.getStartTime()).equals(kl))
                nyrVektor.add(s);
        }
        return nyrVektor;
    }
      /**
     * Skilar klukkustund úr dagsetningar- og tímastreng
     * @param startTime
     * @return klukkustund sem tveggja stafa tölu 
     */
    public static String Klukkustund(String startTime) {
        return startTime.substring(11,13);
    }
}
