package Home;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    static AnchorPane root;
    static List<AnchorPane> anchor = new ArrayList<AnchorPane>();
    MyList list = new MyList();
    private static int sceneIndex = 0;

    @Override
    public void start(Stage primaryStage) throws Exception{
        root = (AnchorPane)FXMLLoader.load(getClass().getResource("../Home/Anchor.fxml"));//
        anchor.add((AnchorPane)FXMLLoader.load(getClass().getResource("../Home/Homepage.fxml")));//0
        anchor.add((AnchorPane)FXMLLoader.load(getClass().getResource("../Login/AgentLogin.fxml")));//1
        anchor.add((AnchorPane)FXMLLoader.load(getClass().getResource("../Login/AdminLogin1.fxml")));//2
        anchor.add((AnchorPane)FXMLLoader.load(getClass().getResource("../Properties/Property.fxml")));//3
        anchor.add((AnchorPane)FXMLLoader.load(getClass().getResource("../PropertyAgents/PropertyAgent.fxml")));//4
        anchor.add((AnchorPane)FXMLLoader.load(getClass().getResource("../Properties/ViewALLProps.fxml")));//5






        root.getChildren().add(anchor.get(0));

        primaryStage.setTitle("Property");
        primaryStage.setScene(new Scene(root, 600, 600));

        primaryStage.show();
    }

    private void init_app(){
        for(int i=0; i<anchor.size();i++){
            //can be used to initiate some details about each pane
        }
    }


    public static AnchorPane get_pane(int index)
    {
        return anchor.get(index);
    }

    public static void set_pane(int index){
        if(index > 0 )
        {

        }
        //TODO check that the index is valid ie. >0 and <size of ArrayList
        root.getChildren().remove(anchor.get(sceneIndex));  //remove the existing pane from the root
        root.getChildren().add(anchor.get(index));          //add the selected pane to the root
        sceneIndex=index;                                   //update the stored sceneIndex
    }

    private static User user = null;

    public static void main(String[] args) {
        launch(args);
    }
}