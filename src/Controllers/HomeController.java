
package Controllers;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


public class HomeController implements Initializable
{

    @FXML
    private Button buy;
    @FXML
    private Button av;
    @FXML
    private Button chk;
    @FXML
    private Button login;
    @FXML
    private Button signup;
    @FXML
    private AnchorPane anch;
    @FXML
    private AnchorPane side;
    @FXML
    private AnchorPane topmain;
    @FXML
    private Label textarea;
    @FXML
    private MenuBar menubar;
    


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }
/*---methods from menu bar------------------------------------------------------------------------*/
     @FXML
    private void Quitbtn(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void contact(ActionEvent event) throws IOException {
        try {
            Desktop.getDesktop().browse(new URI("https://rartek.blogspot.com/"));
        } catch (URISyntaxException ex) {
            System.out.println("uri   " +ex);
        }
    }

    @FXML
    private void developers(MouseEvent event) throws Exception {
        Switcher.changeToScene(getClass(), event, "/online/About.fxml");
    }
    @FXML
     private void def(ActionEvent event) throws Exception {
        Switcher.styler("blue");
        
    }

    @FXML
    private void gre(ActionEvent event) throws Exception {
        Switcher.styler("green");
        
    }

    @FXML
    private void red(ActionEvent event) {
        Switcher.styler("red");
    }

    @FXML
    private void dark(ActionEvent event) {
        Switcher.styler("black");
    }
    private void self(ActionEvent event) throws Exception {
       Switcher.changeToScene(getClass(), event, "/online/buy.fxml"); 
    }
    
/*---methods from Anchor pane--------------------------------------------------------------------------*/

    @FXML
    private void buybtn(ActionEvent event) throws Exception
    {
        Switcher.changeToScene(getClass(), event, "/online/buy.fxml");

    }


    @FXML
    private void chkbtn(ActionEvent event) throws Exception
    {
        Switcher.changeToScene(getClass(), event, "/online/CheckTicket.fxml");
    }

    @FXML
    void loginbtn(ActionEvent event) throws Exception
    {
        Switcher.changeToScene(getClass(), event, "/online/ID.fxml");

    }

    @FXML
    void signupbtn(ActionEvent event) throws Exception
    {
        Switcher.changeToScene(getClass(), event, "/online/signup.fxml");

    }

    @FXML
    private void avbtn(ActionEvent event) throws Exception
    {
        Switcher.changeToScene(getClass(), event, "/online/Available.fxml");
    }

}