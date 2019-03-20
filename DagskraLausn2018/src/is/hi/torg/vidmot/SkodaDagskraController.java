
package is.hi.torg.vidmot;

import is.hi.torg.vinnsla.Root;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 * Birtir dialog fyrir dagskrárlið 
 * @author Ebba Þóra Hvannberg ebba@hi.is
 */
public class SkodaDagskraController implements Initializable {

    @FXML
    private AnchorPane nDialog;
    @FXML
    private TextField titill;
    @FXML
    private TextArea lysing;
    @FXML
    private TextField byrjar;
    @FXML
    private TextField lengd;
    @FXML
    private TextField seria;
    @FXML
    private TextField ibeinni;
    @FXML
    private TextField episode;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     /***
     * Birtir dialog dagskrárlið í 
     * @param r dagskrárliður 
     */
    public void dagskrarlidurBirta(Root.Results r) {
        // Innihald dialogs búið til 
        DialogPane p = new DialogPane();
        nDialog.setVisible(true);
        
        // Búa námskeið niður og setja í label hluti 
        setjaGogn(r);
        
        // Innihald sett sem Pane sem fengið er úr Scene builder 
        p.setContent(nDialog);
        
        // Umgjörðin búin til - Dialog sem gefur niðurstöðu í Leikmenn klasann
        Dialog<ButtonType> d = new Dialog();
        
        // og innihaldið sett í umgjörðina 
        d.setDialogPane(p);
        // Haus, titill og mynd ef vill 
        d.setTitle("Skoða dagskrárlið");
  
        // Hnapparnir Í lagi og hætta við búnir til og bætt við 
        ButtonType iLagi = new ButtonType("Í lagi", 
                ButtonBar.ButtonData.OK_DONE);
        d.getDialogPane().getButtonTypes().add(iLagi);       
        
        ButtonType haettaVid = new ButtonType("Hætta við", 
                ButtonBar.ButtonData.CANCEL_CLOSE);
        d.getDialogPane().getButtonTypes().add(haettaVid);
        
        // Dialog birtur - svarið ekki notað 
        d.showAndWait();
    }
    
    /**
     * Setja gögn í samtalsgluggann. Kóði og nafn á námskeiði 
     * @param r dagskrá sem á að birta  
     */
    public void setjaGogn(Root.Results r) {

        titill.setText(r.getTitle());
        lysing.setText(r.getDescription());
        byrjar.setText(r.getStartTime().substring(11,16));
        lengd.setText(r.getDuration().getHour()+":"+r.getDuration()
        .getMinute());
        seria.setText(String.valueOf(r.getSeries().getSeries()));
        episode.setText(String.valueOf(r.getSeries().getEpisode()));
        ibeinni.setText(r.getLive().equals("true") ? "Já": "Nei");
    }
}
