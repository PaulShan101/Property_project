package Login;

import Home.Main;
import Home.User;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class AgentLoginController {
    @FXML private TextField username;
    @FXML private PasswordField password;
    @FXML private TextArea txtAreaFeedback;
    @FXML private ImageView imageView;

    public void handleLoginBtn(ActionEvent e) throws Exception {
        if (username.getText().contains("agent") || password.getText().contains("password")) {
            txtAreaFeedback.setText("Successful Login");
            Main.set_pane(3);
        }


        //Main.set_pane(0);   //If you use this line of code, successful login will automatically return to the home scen
        else  {
            txtAreaFeedback.setText("Un-Successful Login");
            password.clear();
        }
    }


    public void handleLoadImage(ActionEvent e) throws Exception{

        Image image = new Image("default.png");
        imageView.setImage(image);
   }

    private boolean login(String username, String password) {
        ArrayList<User> users = null;
        XStream xstream = new XStream(new DomDriver());
        try {
            ObjectInputStream is = xstream.createObjectInputStream(new FileReader("users.xml"));
            users = (ArrayList<User>) is.readObject();
            is.close();
        }
        catch(FileNotFoundException e) {
            users =  new ArrayList<User>();
            txtAreaFeedback.setText("Password File not located");
            return false;

        }
        catch (Exception e) {
            txtAreaFeedback.setText("Error accessing Password File");
            return false;
        }

        for (User user: users) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password))
                return true;
        }
        return false;
    }

    public void handleHomeBtn(ActionEvent e) throws Exception {
        Main.set_pane(0);
    }


}
