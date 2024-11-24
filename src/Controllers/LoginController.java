
package Controllers;

import connection.Logins;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;


public class LoginController implements Initializable
{

    @FXML
    private Button back;
    @FXML
    private Button login;
    @FXML
    private PasswordField pass;
    @FXML
    private Button signup;
    @FXML
    private TextField uname;
/* initialize global variable-----------*/
    public String UName = null;
    public String Passwd = null;
    Logins logt = new Logins();

/***- Initializes the controller class.--------------------------------------------------*/
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
   
/*---methods from Anchor pane--------------------------------------------------------------------------*/
 
    @FXML
    void backbtn(ActionEvent event) throws Exception
    {
        Switcher.changeToScene(getClass(), event, "/online/home.fxml");

    }


    @FXML
    public void loginbtn(ActionEvent event)
    {

        UName = uname.getText();
        Passwd = pass.getText();
        if (UName.isEmpty() || Passwd.isEmpty())
        {

            JOptionPane.showMessageDialog(null, "Please fill the blanks", "Blank", JOptionPane.ERROR_MESSAGE);

        }
        else
        {



            if (logt.LOGIN(UName, Passwd) == 1)
            {
                try
                {
                    JOptionPane.showMessageDialog(null, "You have sucessfully loged in", "success", JOptionPane
                        .INFORMATION_MESSAGE);

                    Switcher.changeToScene(getClass(), event, "/online/user.fxml");


                }
                catch (Exception ex)
                {
                    System.out.println("error lgnbtn  " + ex);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Login faild! signup if you are new", "password / username !error..", JOptionPane
                    .ERROR_MESSAGE);
            }


        }
    }

    @FXML
    void signbtn(ActionEvent event) throws Exception
    {
        Switcher.changeToScene(getClass(), event, "/online/signup.fxml");

    }
}