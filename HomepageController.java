package Home;

import javafx.event.ActionEvent;

public class HomepageController {

    public void handleAdminBtn(ActionEvent e) throws Exception {
        Main.set_pane(2);
    }
    public void handleAgentBtn(ActionEvent e) throws Exception {
        Main.set_pane(1);
    }
    public void handleViewBtn(ActionEvent e) throws Exception {
        Main.set_pane(5);
    }
    public void handleHomeBtn(ActionEvent e) throws Exception {
        Main.set_pane(0);
    }
}
