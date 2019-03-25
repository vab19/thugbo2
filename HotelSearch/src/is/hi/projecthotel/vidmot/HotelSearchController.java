package is.hi.projecthotel.vidmot;

import is.hi.projecthotel.vinnsla.Root;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;

public class HotelSearchController implements Initializable {
 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Root.Results.roomsAvailable bakdfds = new Root.Results.roomsAvailable();
    }
    
}
