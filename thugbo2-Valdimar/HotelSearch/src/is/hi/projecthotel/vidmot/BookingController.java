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
import javafx.scene.control.ChoiceBox;
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
    @FXML
    private ChoiceBox<String> dateInYear;
    @FXML
    private ChoiceBox<String> dateInDay;
    @FXML
    private ChoiceBox<String> dateInMonth;
    @FXML
    private ChoiceBox<String> dateOutYear;
    @FXML
    private ChoiceBox<String> dateOutDay;
    @FXML
    private ChoiceBox<String> dateOutMonth;
    
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         //book.setDisable(true);
         
         dateInYear.getItems().add("2019");
         dateOutYear.getItems().add("2019");
         
         for(int i = 1; i < 13; i++){
         dateInMonth.getItems().add(""+i);
         dateOutMonth.getItems().add(""+i);
         }
         
         for(int i = 1; i < 32; i++){
        dateInDay.getItems().add(""+i);
        dateOutDay.getItems().add(""+i);
             
         }
           
    }    

    @FXML
    private void BookPressedEvent(ActionEvent event) {
       String completeDateIn = dateInYear.getValue() +"-"+ dateInDay.getValue() +"-"+ dateInMonth.getValue();
       String completeDateOut = dateOutYear.getValue() +"-"+ dateOutDay.getValue() +"-"+ dateOutMonth.getValue();
       LocalDate CDI = LocalDate.parse(completeDateIn);
       LocalDate CDO = LocalDate.parse(completeDateOut);
       //if(hotel.isAvailable(CDI,CDO))book.setDisable(false);
       if(hotel.isAvailable(CDI,CDO))book.setText("Booking is Available");
       else book.setText("Booking is not Available");
       
       
  
    }
    
    public  void setHotel(Hotel hotel){
        this.hotel = hotel;
        this.roomsAvailable = hotel.getroomsAvailable();
        
       
       
        
    }


    private void dateOutEvent(ActionEvent event) {
        if(date1 == "" || date2 == "")book.setDisable(true);
        
    }
    
}
