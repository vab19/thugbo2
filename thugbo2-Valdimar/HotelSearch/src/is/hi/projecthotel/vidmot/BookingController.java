/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.hi.projecthotel.vidmot;

import is.hi.projecthotel.vinnsla.Hotel;
import is.hi.projecthotel.vinnsla.RoomsAvailable;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Valdimar Björnsson vab19@hi.is
 */
public class BookingController implements Initializable {

    @FXML
    private Button book;
    
    private Hotel hotel;
    
    private RoomsAvailable roomsAvailable;
    
    String date1 = "";
    String date2 = "";
    
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         if(date1 == "" || date2 == "")book.setDisable(true);
    }    

    @FXML
    private void BookPressedEvent(ActionEvent event) {
       
       
       
       
       
    }
    
    public  void setHotel(Hotel hotel){
        this.hotel = hotel;
        this.roomsAvailable = hotel.getroomsAvailable();
        
       
       
        
    }


    private void dateOutEvent(ActionEvent event) {
        if(date1 == "" || date2 == "")book.setDisable(true);
        
    }
    
}
