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
import javafx.scene.control.Button;
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
    
    private Hotel hotel;
    @FXML
    private Button BOOKBUTTON;
    @FXML
    private Button CANCELBUTTON;
    
    //private OpenScene openScene;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void displayHotelInfo(Hotel h){
      
    }
    
        
    

    @FXML
    private void BookRoomEvent(ActionEvent event) {
       
            
            try {
         FXMLLoader loader = new FXMLLoader(getClass().getResource(
               "Booking.fxml"));
         Parent root = (Parent) loader.load();
         BookingController ctrl = loader.getController();
         ctrl.setHotel(hotel);

         Scene newScene = new Scene(root);
         Stage newStage = new Stage();
         newScene.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
         newStage.setScene(newScene);
         newStage.show();
      } catch (Exception e) {
         e.printStackTrace();
      }
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
        this.hotel = h;
        
        
        
    }
    
    
    
     
    
    
    
}
