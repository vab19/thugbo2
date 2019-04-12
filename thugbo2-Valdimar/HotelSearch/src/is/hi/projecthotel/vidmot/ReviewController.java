/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.hi.projecthotel.vidmot;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import is.hi.projecthotel.vinnsla.*;

/**
 * FXML Controller class
 *
 * @author Valdimar Björnsson vab19@hi.is
 */
public class ReviewController implements Initializable {
    private String name;
    @FXML
    private Label custName;
    @FXML
    private TextField textField;
    
    private Hotel hotel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ReviewACTION(ActionEvent event) {
        hotel.addReview(textField.getText(), 0, hotel.getHotelId(), 0);
        
        
    }
    public  void setHotel(Hotel hotel){
        this.hotel = hotel;
       
    }
    
    public void setName(String name){
        custName.setText(name);
        
    }
}
