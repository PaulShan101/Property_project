package Properties;

import Home.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

public class ViewAllPropsController {

    @FXML
    ListView lstAllProperty;
    @FXML
    private ComboBox<String> areaId = new ComboBox<>();
    @FXML
    private ComboBox<String> priceId = new ComboBox<>();
    @FXML
    private ComboBox<String> bedroomId = new ComboBox<>();
    @FXML
    private ComboBox<String> typeId = new ComboBox<>();

    public void initialize() {



        areaId.getItems().addAll("Waterford", "Cork", "Tipperary", "Wexford");
        priceId.getItems().addAll("100000", "200000", "300000");
        bedroomId.getItems().addAll("1", "2", "3", "4", "5");
        typeId.getItems().addAll("House", "Appartment", "Semi-Detached", "Terrace");
    }
 public void getHousePrice(){
     double thePrice = Double.parseDouble(priceId.getSelectionModel().getSelectedItem());
     PropertyController.shop.filterPrice(lstAllProperty,thePrice );
        }

    public void getRooms() {
        double theRooms = Double.parseDouble(bedroomId.getSelectionModel().getSelectedItem());
        PropertyController.shop.filterRoom(lstAllProperty,theRooms );
    }
    public void getLocation() {
        String theLocation = (areaId.getSelectionModel().getSelectedItem());
        PropertyController.shop.filterLocation(lstAllProperty, theLocation);
    }
    public void getType() {
        String theType = (typeId.getSelectionModel().getSelectedItem());
        PropertyController.shop.filterType(lstAllProperty, theType);
    }


    public void handleHomeBtn(ActionEvent e) throws Exception {
        Main.set_pane(0);
    }





}
