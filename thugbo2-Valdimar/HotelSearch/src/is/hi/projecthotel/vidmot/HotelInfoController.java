/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.hi.projecthotel.vidmot;

import is.hi.projecthotel.vinnsla.Hotel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;




/**
 * FXML Controller class
 *
 * @author Notandi
 */
public class HotelInfoController implements Initializable {

    @FXML
    private Label NameLabel;
    @FXML
    private Label RatingLabel;
    @FXML
    private Label StarsLabel;
    @FXML
    private Label RegionLabel;
    @FXML
    private Label AddressLabel;
    @FXML
    private Label RoomsAvailableLabel;
    @FXML
    private Label PriceLabel;
    @FXML
    private AnchorPane nDialog;
    
    //private OpenScene openScene;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void displayHotelInfo(Hotel h){
        
         // Innihald dialogs búið til 
        //DialogPane p = new DialogPane();
        //nDialog.setVisible(true);
        /*
        // Búa námskeið niður og setja í label hluti 
        setInfo(h);
        
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
        d.showAndWait();*/
    }
    
        
    

    @FXML
    private void BookRoomEvent(ActionEvent event) {
    }

    @FXML
    private void CancelEvent(ActionEvent event) {
    }
    
    public void setInfo(Hotel h){
        NameLabel.setText(h.getHotelName());
        StarsLabel.setText(""+h.getStars());
        RatingLabel.setText(""+h.getRating());
        RegionLabel.setText(""+h.getRegion());
        AddressLabel.setText(""+h.getAddress());
        RoomsAvailableLabel.setText(""+h.getroomsAvailable().lastEntry().getValue());
        PriceLabel.setText(""+h.getPricePerNight()+" kr.");
        
        
        
    }
    
    
    
     
    
    
    
}
