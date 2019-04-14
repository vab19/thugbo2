package is.hi.projecthotel.vidmot;

import is.hi.projecthotel.vinnsla.*;
import java.io.IOException;
import java.net.URL;

import java.util.ArrayList;
import java.util.List;

import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.util.Arrays;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.TextFlow;

public class HotelSearchController implements Initializable {
    private Hotel[] hotels;
    private String[] listItems;
    
    List<Hotel> hotelList;
    
    //private VBox vboxdude;
    @FXML
    private Button HOTELPAGEBUTTON;
    @FXML
    private Button NAMEBUTTON;
    @FXML
    private Button REGIONBUTTON;
    @FXML
    private Button PRICEBUTTON;
    @FXML
    private Button RATINGBUTTON;
  
    @FXML
    private VBox vBoxdude;
    @FXML
    private TextField SearchParam;
    @FXML
    private AnchorPane Anchory;
    @FXML
    private Button SEARCHBUTTON;
    
    private Hotel [] subHotels;
    @FXML
    private Label reviewField;
    @FXML
    private Button latestReviewButton;
    @FXML
    private VBox vBoxdude1;
    
    private int indexer;
    private ListView<String> list;
    private Boolean trigger = false;
    @FXML
    private Label ratingGiven;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int length = 40;
        hotels = new Hotel [length];
        listItems = new String[length];
        String item = "";
        //ObservableList<String> items = FXCollections.observableArrayList("test1", "test2");
        list = new ListView<String>();
        for(int i=0;i<length;i++) {
            
            //HBox element = new HBox();
           /* vboxdude.getChildren().add(new Text(hotel.getHotelName()+" |"+hotel.getStars()
            +" |"+hotel.getRegion()+" |"+hotel.getPricePerNight()+" |"+hotel.getRating()));
            */
            hotels[i] = CreateMockHotels.randomHotel(i);
            item = ""+hotels[i].getHotelName()
            +"    |    "+hotels[i].getRegion()+"    |    "+hotels[i].getPricePerNight()+"    |    "+hotels[i].getRating();
            listItems[i] = item;
            
            list.getItems().addAll(item);
           
        }
       
        vBoxdude.getChildren().addAll(list);
       
      
        
         
    }
    
    
    
    ObservableList<Hotel> heildarListi() {
            ObservableList<Hotel> obl = FXCollections.observableArrayList(JsonReader.getHotelListJson());
            return obl;
    }

    
    
    @FXML
    private void OPENHOTELINFO(MouseEvent event) throws IOException {
        indexer =  list.getSelectionModel().getSelectedIndex();
       
        if(indexer != -1) {
            
            try {
         FXMLLoader loader = new FXMLLoader(getClass().getResource(
               "HotelInfo.fxml"));
         Parent root = (Parent) loader.load();
         HotelInfoController ctrl = loader.getController();
         ctrl.setInfo(hotels[indexer]);

         Scene newScene = new Scene(root);
         newScene.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
         Stage newStage = new Stage();
         newStage.setScene(newScene);
         newStage.show();
      } catch (Exception e) {
         e.printStackTrace();
      }
        }
            
        
        System.out.println(""+indexer);
       
    }
    
    private void findHotel(String someHotel){
        
        
    }
    
        
    

    @FXML
    private void FILTEREVENT(ActionEvent event) {
        Hotel [] hotelz;
        if(trigger)hotelz = subHotels;
        else hotelz = hotels;
        //NAME, REGI, PRIC, RATI, 10-14
        String buttonType = event.getSource().toString().substring(10, 14);
        if("NAME".equals(buttonType)) {
            sortByName(hotelz);
        } else if("REGI".equals(buttonType)) {
            sortByRegion(hotelz);
        } else if("PRIC".equals(buttonType)) {
            sortByPrice(hotelz);
        } else if("RATI".equals(buttonType)) {
            
            sortByRating(hotelz);
        } else {
            System.out.println("no button found");
        }
        
    }
    
    
   
    
    private void sortByPrice(Hotel [] hotelz) {
        
        int n = hotelz.length;
        for(int i=0;i<n-1;i++) {
            for(int j=0;j<n-i-1;j++) {
                if(hotelz[j].getPricePerNight() > hotelz[j+1].getPricePerNight()) {
                    Hotel temp = hotelz[j];
                    hotelz[j] = hotelz[j+1];
                    hotelz[j+1] = temp;
                }
            }
        }
        displayHotels(hotelz);
    }
    
    private void sortByName(Hotel [] hotelz) {
        int n = hotelz.length;
        for(int i=0;i<n-1;i++) {
            for(int j=0;j<n-i-1;j++) {
                if(hotelz[j].getHotelName().compareTo(hotelz[j+1].getHotelName()) > 0) {
                    Hotel temp = hotelz[j];
                    hotelz[j] = hotelz[j+1];
                    hotelz[j+1] = temp;
                }
            }
        }
        displayHotels(hotelz);
    }
    
    private void sortByRegion(Hotel [] hotelz) {
        int n = hotelz.length;
        for(int i=0;i<n-1;i++) {
            for(int j=0;j<n-i-1;j++) {
                if(hotelz[j].getRegion().compareTo(hotelz[j+1].getRegion()) > 0) {
                    Hotel temp = hotelz[j];
                    hotelz[j] = hotelz[j+1];
                    hotelz[j+1] = temp;
                }
            }
        }
        displayHotels(hotelz);
    }
    
    private void displayHotels(Hotel [] hotelz) {
         int n = hotelz.length;
         list = new ListView<String>();
         for(int i=0;i<n;i++) {
            
            
            String item = ""+hotelz[i].getHotelName()
            +"    |    "+hotelz[i].getRegion()+"    |    "+hotelz[i].getPricePerNight()+"    |    "+hotelz[i].getRating();
            listItems[i] = item;
            
            list.getItems().addAll(item);
           
        }
         vBoxdude.getChildren().remove(0);
         vBoxdude.getChildren().addAll(list);
    }

    private void sortByRating(Hotel [] hotelz) {
        int n = hotelz.length;
        for(int i=0;i<n-1;i++) {
            for(int j=0;j<n-i-1;j++) {
                if(hotelz[j].getRating() < hotelz[j+1].getRating()) {
                    Hotel temp = hotelz[j];
                    hotelz[j] = hotelz[j+1];
                    hotelz[j+1] = temp;
                }
            }
        }
        displayHotels(hotelz);
    }
    
    
    @FXML
    private void SearchForEvent(ActionEvent event) {
        int count = 0;
        trigger = true;
       
        String param = SearchParam.getText().toLowerCase();
        
        String price = "";
        String rating = "";
        list = new ListView<String>();
        for(int i=0;i<hotels.length;i++) {
            price = hotels[i].getPricePerNight()+"";
            rating = hotels[i].getRating()+"";
            if(hotels[i].getHotelName().toLowerCase().contains(param)) {
                count++;
                
            } else if(hotels[i].getRegion().toLowerCase().contains(param)) {
                count++;
            } else if(price.contains(param)) {
                count++;
            } else if(rating.contains(param)) {
                count++;
                
            }
        }
        
        
       
         subHotels  = new Hotel[count];
        
         int j=0;
          for(int i=0;i<hotels.length;i++) {
            price = hotels[i].getPricePerNight()+"";
            rating = hotels[i].getRating()+"";
            if(hotels[i].getHotelName().toLowerCase().contains(param)) {
                subHotels[j] = hotels[i];
                j++;
            } else if(hotels[i].getRegion().toLowerCase().contains(param)) {
                subHotels[j] = hotels[i];
                j++;
            } else if(price.contains(param)) {
                subHotels[j] = hotels[i];
                j++;
            } else if(rating.contains(param)) {
                subHotels[j] = hotels[i];
                j++;
                
            }
        }
          
        displayHotels(subHotels);
        vBoxdude.getChildren().remove(0);
        vBoxdude.getChildren().addAll(list);
    }

    @FXML
    private void latestReview(ActionEvent event) {
       
        String comment;
        int rate;
        indexer =  list.getSelectionModel().getSelectedIndex();
   
        
        
            
        if(trigger){ 
            comment = subHotels[indexer].getReviews().get(subHotels[indexer].getReviews().size()-1).getComment();
            rate = subHotels[indexer].getReviews().get(subHotels[indexer].getReviews().size()-1).getRating();
        }
        else {
            comment = hotels[indexer].getReviews().get(hotels[indexer].getReviews().size()-1).getComment();
            rate = hotels[indexer].getReviews().get(hotels[indexer].getReviews().size()-1).getRating();
        }
        reviewField.setText(comment);
        ratingGiven.setText(rate+"");
        
        
        
    
        
    }
    
 
}