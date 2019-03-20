
package is.hi.torg.vidmot;

import is.hi.torg.vinnsla.DagskraKatalogur;
import is.hi.torg.vinnsla.Root;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;


/**
 *
 * @author Ebba Þóra Hvannberg ebba@hi.is
 */
public class DagskraController implements Initializable {
 
    
    private DagskraKatalogur minnKatalogur;     // Tenging við vinnslu
        
    private int virkurIndex=0;                  // Núverandi index í listann
    private MultipleSelectionModel msl;         // Val-módel fyrir listann
    @FXML
    private ListView<Root.Results> listiDagskra;
    @FXML
    private SkodaDagskraController skodaDagskraController;
    @FXML
    private LeitOgAfmorkunController leitaDagskraController;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            minnKatalogur = new DagskraKatalogur();
            // Búum til hlut til að við getum náð í gögnin
            listiDagskra.setItems(heildarListi());
            // Birtum alla dagskrárliði
            minnKatalogur.birtaDagskrarlid();

            frumstillaGognHandlerListi();
            leitaDagskraController.frumstillaGognHandlerTimaAfmorkun(this);
    
    }

   
    /***
     * Frumstillir gögn og atburðahandler fyrir lista af sjónvarps-
     * dagskrárliðum 
     */
    private void frumstillaGognHandlerListi() {
        msl = listiDagskra.getSelectionModel();
        msl.selectedItemProperty().addListener(new ChangeListener<Root.Results>() {
            @Override
            public void changed(ObservableValue<? extends Root.Results> observable, Root.Results oldValue, Root.Results newValue) {
                virkurIndex = msl.getSelectedIndex();
            }
        });
    }

   
    /***
     * Dæmi um hvernig hægt er að ná í gögn úr einum dagskrárlið
     * @param r einn dagskrárliður með nokkrum eiginleikum 
     */
    private void birtaGogn(Root.Results r) {
        System.out.println ("Dagskrárliður er:");
        System.out.println ("Titill er "+r.getTitle());
        System.out.println ("Lýsing er "+r.getDescription());
        // skilar hlut af klasanum XMLGregorianCalendar sem er lýst hér:
        // https://docs.oracle.com/javase/7/docs/api/javax/xml/datatype/XMLGregorianCalendar.html

        System.out.println ("Lengd dagskrárliðs er "+r.getDuration().getHour()+":"+
                r.getDuration().getMinute());
        // getSeries() skilar hlut af klasanum Root.Results.Series
        System.out.println ("Serían er "+    r.getSeries().getSeries());
    }

    /***
     * Handler fyrir að skoða dagskrárlið nánar 
     * @param event 
     */
    @FXML
    private void skodaHandler(ActionEvent event) {
        if (virkurIndex != -1)
            skodaDagskraController
                    .dagskrarlidurBirta(listiDagskra.getItems().get(virkurIndex));
    }

    /***
     * Handler fyrir að eyða dagskrárlið 
     * @param event 
     */
    @FXML
    private void eydaHandler(ActionEvent event) {
        if (virkurIndex != -1) {
            ObservableList<Root.Results> o = listiDagskra.getItems();
            // Hér er ekki nóg að eyða úr ListView þar 
            // sem hann gæti haft afmarkaðan lista 
            Root.Results r = o.get(virkurIndex);
            o.remove(virkurIndex);

            // Finna hlutinn í sjónvarpsdagskránni óafmarkaðri 
            int indexDagskra = minnKatalogur.getDagskrarLidir().indexOf(r);
            // og eyða í sjónvarpsdagskrá ef það er ekki 
            // þegar búið að eyða honum 
            if (indexDagskra != -1) {
                minnKatalogur.eydaDagskralid(indexDagskra);
            }
         // uppfæra klukkustundir ef einhverjar skyldu hafa fallið úr
         leitaDagskraController.setjaKlukkustundir();
        }
    }

    /***
     * Uppfærir listView samkvæmt lista
     * @param valdirLidir listinn sem á að uppfæra með
     */
    void uppfaeraLista(ObservableList<Root.Results> valdirLidir) {
        listiDagskra.setItems(valdirLidir);
    }

    /**
     * Nær í sjónvarpdagskrána úr katalognum
     * @return 
     */
    ObservableList<Root.Results> heildarListi() {
            ObservableList<Root.Results> obl = FXCollections.observableArrayList(minnKatalogur.getDagskrarLidir());
            return obl;
    }
  
   
}
