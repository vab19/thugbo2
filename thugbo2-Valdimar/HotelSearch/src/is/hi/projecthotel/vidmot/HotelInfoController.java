/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.hi.projecthotel.vidmot;

import is.hi.projecthotel.vinnsla.Hotel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

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
    
    //private OpenScene openScene;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void displayHotelInfo(Hotel h) {
        
    }

    @FXML
    private void BookRoomEvent(ActionEvent event) {
    }

    @FXML
    private void CancelEvent(ActionEvent event) {
    }
    
}
