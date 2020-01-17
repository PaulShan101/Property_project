package Login;

import Home.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AdminController1 {
    @FXML private TextField username1;
    @FXML private PasswordField password1;

    @FXML private TextArea txtAreaFeedback1;
    @FXML private ImageView imageView;



    public void handleLoginBtn(ActionEvent e) throws Exception {
        if (username1.getText().contains("agent") || password1.getText().contains("password")) {
            txtAreaFeedback1.setText("Successful Login");
            Main.set_pane(4);
        }
        else {
            txtAreaFeedback1.setText("Un-Successful Login");
            password1.clear();
        }
    }


    public void handleLoadImage(ActionEvent e) throws Exception{

        Image image = new Image("property-agent.png");
        imageView.setImage(image);
    }

    public void handleHomeBtn(ActionEvent e) throws Exception {
        Main.set_pane(0);
    }

    public void handleLogBtn(ActionEvent e) throws Exception {
        Main.set_pane(4);
    }
}





  /*  private boolean login(String username, String password) {
        ArrayList<User> users = null;
        XStream xstream = new XStream(new DomDriver());
        try {
            ObjectInputStream is = xstream.createObjectInputStream(new FileReader("users.xml"));
            users = (ArrayList<User>) is.readObject();
            is.close();
        }
        catch(FileNotFoundException e) {
            users =  new ArrayList<User>();
            txtAreaFeedback1.setText("Password File not located");
            return false;

        }
        catch (Exception e) {
            txtAreaFeedback1.setText("Error accessing Password File");
            return false;
        }

        for (User user: users) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password))
                return true;
        }
        return false;
    }*/

