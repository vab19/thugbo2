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
    private ListView<String> list;
    
    
    private MultipleSelectionModel msl;
    
    private int index = 0;
    private int indexer = 0;
    @FXML
    private VBox vBoxdude;
    @FXML
    private TextField SearchParam;
    @FXML
    private AnchorPane Anchory;
    @FXML
    private Button SEARCHBUTTON;
    @FXML
    private Label sorter;
    
    
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
        
       
        //list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        vBoxdude.getChildren().addAll(list);
         
       
        
        
    
    }
    
    ObservableList<Hotel> heildarListi() {
            ObservableList<Hotel> obl = FXCollections.observableArrayList(JsonReader.getHotelListJson());
            return obl;
    }

    @FXML
    private void OPENHOTELINFO(MouseEvent event) throws IOException {
        int indexer = list.getSelectionModel().getSelectedIndex();
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
        //NAME, REGI, PRIC, RATI, 10-14
        
        int length = hotels.length;
        String buttonType = event.getSource().toString().substring(10, 14);
        String[] listItemsPre = new String[length];
        String[] listItemsPost = new String[length];
        int j;
        if("NAME".equals(buttonType)) {
            for(int i=0;i<length;i++) {
                listItemsPost[i] = listItems[i];
            }
            Arrays.sort(listItemsPost);
            list = new ListView<String>();
            for(int i=0;i<40;i++) {
                    list.getItems().addAll(listItemsPost[i]);
            }
            
            
        } else if("REGI".equals(buttonType)) {
            for(int i=0;i<length;i++) {
                j = listItems[i].indexOf("|");
                listItemsPre[i] = listItems[i].substring(0, j-1);
                listItemsPost[i] = listItems[i].substring(j);
            }
            Arrays.sort(listItemsPost);
            list = new ListView<String>();
            for(int i=0;i<40;i++) {
                    list.getItems().addAll(listItemsPre[i]+listItemsPost[i]);
            }
        } else if("PRIC".equals(buttonType)) {
            for(int i=0;i<length;i++) {
                j = listItems[i].indexOf("|");
                j = listItems[i].indexOf("|", j+1);
                listItemsPre[i] = listItems[i].substring(0, j-1);
                listItemsPost[i] = listItems[i].substring(j);
            }
            Arrays.sort(listItemsPost);
            list = new ListView<String>();
            for(int i=0;i<40;i++) {
                    list.getItems().addAll(listItemsPre[i]+listItemsPost[i]);
            }
        
        } else if("RATI".equals(buttonType)) {
            for(int i=0;i<length;i++) {
                //finnur þriðja instancið af |
                j = listItems[i].indexOf("|");
                j = listItems[i].indexOf("|", j+1);
                j = listItems[i].indexOf("|", j+1);
                listItemsPre[i] = listItems[i].substring(0, j-1);
                listItemsPost[i] = listItems[i].substring(j);
            }
            Arrays.sort(listItemsPost);
            list = new ListView<String>();
            for(int i=0;i<40;i++) {
                    list.getItems().addAll(listItemsPre[i]+listItemsPost[i]);
            }
        } else {
            System.out.println("no button found");
        }
        
        
        vBoxdude.getChildren().remove(0);
        vBoxdude.getChildren().addAll(list);
    }
     private void frumstillaGognHandlerListi() {
        msl = list.getSelectionModel();
        msl.selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                index = msl.getSelectedIndex();
            }
        });
    }
    
    private void buttonClicked(){
        
        
}

    @FXML
    private void SearchForEvent(ActionEvent event) {
        String param = SearchParam.getText();
        System.out.println(param);
        String item = "";
        
        list = new ListView<String>();
        for(int i=0;i<40;i++) {
            System.out.println(listItems[i].contains(param));
            if(listItems[i].contains(param)) {
                list.getItems().addAll(listItems[i]);
                System.out.println(listItems[i]);
            }
        }
        //vBoxdude = new VBox();
        
        vBoxdude.getChildren().remove(0);
        vBoxdude.getChildren().addAll(list);
    }
}