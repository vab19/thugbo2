package is.hi.projecthotel.vidmot;

import is.hi.projecthotel.vinnsla.*;
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
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class HotelSearchController implements Initializable {
    List<Hotel> hotelList;
    private VBox vboxdude;
    @FXML
    private Button HOTELPAGEBUTTON;
    @FXML
    private Button NAMEbuTTON;
    @FXML
    private Button STARSBUTTON;
    @FXML
    private Button REGIONBUTTON;
    @FXML
    private Button PRICEBUTTON;
    @FXML
    private Button RATINGBUTTON;
    private ListView<String> list;
    
    
    private MultipleSelectionModel msl;
    
    private int index = 0;
    @FXML
    private ListView<?> LISTELEMENT;
    @FXML
    private VBox vBoxdude;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Hotel hotels [] = new Hotel [40];
      
        
        //ObservableList<String> items = FXCollections.observableArrayList("test1", "test2");
        list = new ListView<String>();
        for(int i=0;i<40;i++) {
            
            //HBox element = new HBox();
           /* vboxdude.getChildren().add(new Text(hotel.getHotelName()+" |"+hotel.getStars()
            +" |"+hotel.getRegion()+" |"+hotel.getPricePerNight()+" |"+hotel.getRating()));
            */
           
            hotels[i] = CreateMockHotels.randomHotel(i);
            list.getItems().addAll(""+hotels[i].getHotelName()+"      |    "+hotels[i].getStars()
            +"    |    "+hotels[i].getRegion()+"    |    "+hotels[i].getPricePerNight()+"    |    "+hotels[i].getRating());
           
        }
        
       
        list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        vBoxdude.getChildren().addAll(list);
       
        
        
    
    }
    
    ObservableList<Hotel> heildarListi() {
            ObservableList<Hotel> obl = FXCollections.observableArrayList(JsonReader.getHotelListJson());
            return obl;
    }

    @FXML
    private void OPENHOTELINFO(MouseEvent event) {
        String message = "";
        ObservableList<String> hotelz;
        hotelz = list.getSelectionModel().getSelectedItems();
        
        for(String h: hotelz ){
            message += h;
        }
        System.out.println("message");
    }
    
        
    

    @FXML
    private void FILTEREVENT(ActionEvent event) {
        int length = 40;
        System.out.println("" + length);
        String[] elements = new String[length];
        for(int i=0;i<length;i++) {
            
        }
        System.out.println("" + index);
    }
     private void frumstillaGognHandlerListi() {
        msl = list.getSelectionModel();
        msl.selectedItemProperty().addListener(new ChangeListener<Hotel>() {
            @Override
            public void changed(ObservableValue<? extends Hotel> observable, Hotel oldValue, Hotel newValue) {
                index = msl.getSelectedIndex();
            }
        });
    }
    
    private void buttonClicked(){
        
}
}