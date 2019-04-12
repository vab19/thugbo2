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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    @FXML
    private Label Title;
    @FXML
    private TextField fName;
    
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
        
        book.setDisable(false);
        dateInYear.getItems().add("2019");
        dateOutYear.getItems().add("2019");
        dateInYear.setValue("2019");
        dateOutYear.setValue("2019");
         
        for(int i = 1; i < 13; i++){
             if(i>=10){
                dateInMonth.getItems().add(""+i);
                dateOutMonth.getItems().add(""+i);
            }
            else{
                dateInMonth.getItems().add("0"+i);
                dateOutMonth.getItems().add("0"+i);
            }
         }
         
        for(int i = 1; i < 32; i++){
            if(i>=10){
                dateInDay.getItems().add(""+i);
                dateOutDay.getItems().add(""+i);
            }
            else{
                dateInDay.getItems().add("0"+i);
                dateOutDay.getItems().add("0"+i);
            }
        }
    }   

    @FXML
    private void BookPressedEvent(ActionEvent event) {
       String completeDateIn = dateInYear.getValue() +"-"+ dateInMonth.getValue() +"-"+ dateInDay.getValue();
       String completeDateOut = dateOutYear.getValue() +"-"+ dateOutMonth.getValue() +"-"+ dateOutDay.getValue();
       System.out.println(completeDateIn);
       LocalDate CDO = LocalDate.parse(completeDateIn);
       LocalDate CDI = LocalDate.parse(completeDateOut);
       
       
       if(CDO.isAfter(CDI)){
           book.setText("Please correct date");
                   }
       //if(hotel.isAvailable(CDI,CDO))book.setDisable(false);
        else if(hotel.isAvailable(CDI,CDO)){
            book.setText("Booking is Available");
            hotel.book(completeDateOut, completeDateIn, hotel.getHotelId()); 
            book.setDisable(true);
              try {
         FXMLLoader loader = new FXMLLoader(getClass().getResource(
               "Review.fxml"));
         Parent root = (Parent) loader.load();
         ReviewController ctrl = loader.getController();
         ctrl.setName(fName.getText());
         ctrl.setHotel(hotel);

         Scene newScene = new Scene(root);
         Stage newStage = new Stage();
         newScene.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
         newStage.setScene(newScene);
         newStage.show();
         
         Stage stage = (Stage) book.getScene().getWindow();
         stage.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
            
             
         }
       else book.setText("Booking is not Available");
    }
    
    public  void setHotel(Hotel hotel){
        this.hotel = hotel;
        this.roomsAvailable = hotel.getroomsAvailable();
        Title.setText(hotel.getHotelName()+"");
    }


    private void dateOutEvent(ActionEvent event) {
        if(date1 == "" || date2 == "")book.setDisable(true);
    }
}
