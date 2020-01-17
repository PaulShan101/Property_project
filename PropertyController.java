package Properties;

import Home.Main;
import Home.MyList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PropertyController {

    protected static PropertyModel shop;
    protected static Property propertyToBeUpdated;


    @FXML  ListView lstAllProperty;


    @FXML
    private TextField PropertyId;
    @FXML
    private TextField Description;
    @FXML
    private TextField Address;
    @FXML
    private TextField ber;
    @FXML
    private TextField eircode;
    @FXML
    private TextField areaId;
    @FXML
    private TextField priceId;
    @FXML
    private TextField bedroomId;
    @FXML
    private TextField typeId;
    @FXML
    private TextArea txtAreaPropertyInfo;
    @FXML
    private TextField price;
    @FXML
    private TextField area;
    @FXML
    private Button save;
    @FXML
    private Button load;
    @FXML
    private Button create;
    @FXML
    private Button read;
    @FXML
    private Button update;




    public void handleLoginBtn(ActionEvent e) throws Exception
    {
        Main.set_pane(3);

    }

    public void handleHomeBtn(ActionEvent e) throws Exception {
        Main.set_pane(0);
    }

    public void handleUpdateBtn(ActionEvent e) throws Exception {

        // PropertyAgent editAgent = agent.getPropAgents().get(id);
        int id = lstAllProperty.getSelectionModel().getSelectedIndex();
        propertyToBeUpdated = (Property)shop.getProp().get(id);
        price.setVisible(true);
        price.setText(String.valueOf((double)propertyToBeUpdated.getPrice()));
        area.setVisible(true);
        area.setText(propertyToBeUpdated.getAreaId());


    }

    public void applyChanges(ActionEvent e) throws Exception {

        //propertyToBeUpdated.setPrice( price.getText());
        propertyToBeUpdated.setAreaId(area.getText());
    }

    public void loadPropList(){
    MyList tempProp=  shop.getProp();
    lstAllProperty.getItems().clear();
    for(int i = 0; i<shop.getSize();i++){
        lstAllProperty.getItems().add(tempProp.get(i).toString());
    }
}
    public void handleReadBtn(ActionEvent e) {
        loadPropList();

        txtAreaPropertyInfo.setText("Reading Product ");

        String id = PropertyId.getText();

        Property propertyDetails = shop.getPropDetails(id);

        if (propertyDetails == null) // checking for null return otherwise you will get a null pointer error

            txtAreaPropertyInfo.setText("Invalid Product- Not Read");

        else {  //setting the TextFields



            Description.setText(propertyDetails.getDescription());

            Address.setText("" + propertyDetails.getAddress());

            ber.setText("" + propertyDetails.getBer());

            eircode.setText("" + propertyDetails.getEircode());
            areaId.setText("" + propertyDetails.getAreaId());
            priceId.setText(""  + propertyDetails.getPrice());
            bedroomId.setText("" + propertyDetails.getBedroomId());
            typeId.setText("" + propertyDetails.getTypeId());

            txtAreaPropertyInfo.setText("Product Read");

        }

    }

    public void handleAddBtn(ActionEvent e) throws Exception {



        String desc = String.valueOf(Description.getText());

        String Add = String.valueOf(Address.getText()); //Using the Wrapper class to convert String to double

        String be = String.valueOf(ber.getText());


        String eir = String.valueOf(eircode.getText());
        String area = String.valueOf(areaId.getText());

        double pre = Double.valueOf(priceId.getText());
        double bed = Double.valueOf(bedroomId.getText());
        String type = String.valueOf(typeId.getText());



        shop.addProduct(desc, Add, be, eir, area, pre, bed, type); //Notice category and SubCategory are static

        txtAreaPropertyInfo.setText("Product Added");

    }

    public void handleSaveBtn(ActionEvent e) throws Exception {

        shop.saveProperties();
        txtAreaPropertyInfo.setText("Property Saved");
    }

    public void handleLoadBtn(ActionEvent e) throws Exception {

        shop.loadProperties();
        txtAreaPropertyInfo.setText("Property loaded");
    }


  public void handleDeleteBtn (ActionEvent e) throws Exception {
       Property temp = (Property) shop.getProp().get(lstAllProperty.getSelectionModel().getSelectedIndex());
      shop.removeProperty(temp.getId());
       // shop.removePropertyByPosition(lstAllProperty.getSelectionModel().getSelectedIndex());
      loadPropList();

      }





    public void initialize() {

        shop = new PropertyModel();
            price.setVisible(false);
            area.setVisible(false);

        }




    }

