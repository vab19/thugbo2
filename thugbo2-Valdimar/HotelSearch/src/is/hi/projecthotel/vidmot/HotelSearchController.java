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
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class HotelSearchController implements Initializable {
    List<Hotel> hotelList;
    @FXML
    private ScrollPane hotelListId;
    @FXML
    private AnchorPane scrollPaneContent;
    @FXML
    private VBox vboxdude;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Hotel hotel = CreateMockHotels.randomHotel(100);
        
        for(int i=0;i<3;i++) {
            HBox element = new HBox();
            element.getChildren().add(new Text(hotel.getHotelName()));
            element.getChildren().add(new Text(" "+hotel.getStars()));
            element.getChildren().add(new Text(" "+hotel.getRegion()));
            element.getChildren().add(new Text(" "+hotel.getPricePerNight()));
            element.getChildren().add(new Text(" "+hotel.getRating()));
            
            vboxdude.getChildren().add(element);
            
        }
    }
    
    ObservableList<Hotel> heildarListi() {
            ObservableList<Hotel> obl = FXCollections.observableArrayList(JsonReader.getHotelListJson());
            return obl;
    }
}
