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
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

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
    private Booking booking;
    @FXML
    private ChoiceBox<String> rating;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for(int i = 0; i < 10; i++){
               rating.getItems().add(i+"");
    }    
    rating.setValue("5");
    }

   
    public  void setHotel(Hotel hotel){
        this.hotel = hotel;
       
    }
    
    public void setName(String name){
        custName.setText(name);
        
    }

    @FXML
    private void ReviewACTION(ActionEvent event) {
          hotel.addReview(textField.getText(), Integer.parseInt(rating.getValue()), 5, hotel.getHotelId());
          Stage stage = (Stage) textField.getScene().getWindow();
          stage.close();
    }
}
