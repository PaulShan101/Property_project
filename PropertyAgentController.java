package PropertyAgents;

import Home.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import Home.MyList;

//import java.util.ArrayList;

public class PropertyAgentController {


    protected static PropertyAgentModel agent = new PropertyAgentModel();
    protected static PropertyAgent agentToBeUpdated;

    //ListView lstAllPropertyAgents;

    @FXML
    private Button save;
    @FXML
    private Button load;
    @FXML
    private Button update;
    @FXML
    private Button create;
    @FXML
    private Button read;
    @FXML
    private TextArea txtAreaAgent;
    @FXML
    TextField txtName, txtPhone, txtNameUpdate;
     @FXML
    TableView tableView, name, phone;


    public void handleReadBtn(ActionEvent e) {
        MyList tempProp = agent.getPropAgents();
        tableView.getItems().clear();
        for (int i = 0; i < agent.getSize(); i++) {
            tableView.getItems().add(tempProp.get(i).toString());


            txtAreaAgent.setText("Reading Product ");

        }
        txtAreaAgent.setText("Product Read");


    }

    public void handleUpdateBtn(ActionEvent e) throws Exception {

          // PropertyAgent editAgent = agent.getPropAgents().get(id);
        int id = tableView.getSelectionModel().getSelectedIndex();
        agentToBeUpdated = (PropertyAgent)agent.getPropAgents().get(id);
        txtNameUpdate.setVisible(true);
        txtNameUpdate.setText(agentToBeUpdated.getName());

    }

    public void applyChanges(ActionEvent e) throws Exception {

        agentToBeUpdated.setName(txtNameUpdate.getText());
    }


    public void handleAddBtn(ActionEvent e) throws Exception {


        String name = txtName.getText();

        int num = Integer.parseInt(txtPhone.getText());


        agent.addProp(name, num); //Notice category and SubCategory are static

        txtAreaAgent.setText("Product Added");

    }

    public void handleHomeBtn(ActionEvent e) throws Exception {
        Main.set_pane(0);
    }


    public void handleDeleteBtn(ActionEvent e) throws Exception {


        PropertyAgent temp = (PropertyAgent)agent.getProp().get(tableView.getSelectionModel().getSelectedIndex());
        agent.removeProperty(temp.getId());
        // shop.removePropertyByPosition(lstAllProperty.getSelectionModel().getSelectedIndex());
        loadPropAgentList();


        MyList tempPropAgent = agent.getPropAgents();
        tableView.getItems().clear();
        for (int i = 0; i < agent.getSize(); i++) {
            tableView.getItems().add(tempPropAgent.get(i).toString());
        }
    }



    public void loadPropAgentList(){
        MyList tempProp=  agent.getProp();
        tableView.getItems().clear();
        for(int i = 0; i<agent.getSize();i++){
            tableView.getItems().add(tempProp.get(i).toString());
        }
    }





    public void handleSaveBtn(ActionEvent e) throws Exception {

        agent.saveProperties();
        txtAreaAgent.setText("Property Saved");
    }

    public void handleLoadBtn(ActionEvent e) throws Exception {

        agent.loadProperties();
        txtAreaAgent.setText("Property loaded");
    }

public void initialize(){
    txtNameUpdate.setVisible(false);
}
}
