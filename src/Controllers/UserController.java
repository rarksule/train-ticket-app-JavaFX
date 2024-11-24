
package Controllers;

import connection.userstore;
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


public class UserController implements Initializable
{
/*initializing fx-ids -------------------------------------------------------------------*/

    @FXML
    private Label fnameu;
    @FXML
    private Label unameu;
    @FXML
    private Label addu;
    @FXML
    private Label accu;
    @FXML
    private Button manage;
    @FXML
    private Button home;
    @FXML
    private Button buy;
    @FXML
    private Label pnou;

/*initializing global variables-----------------------------------------------------------*/ 
    private String Fnameu, Addu, Lnameu, Uname, genderu, Pnou;
    private int Acc;


/*** Initializes the controller class.-------------------------------------------------------*/
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        recive();
       
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
    private void developers(ActionEvent event) throws Exception {
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
    private void homebtn(ActionEvent event) throws Exception
    {
        Switcher.changeToScene(getClass(), event, "/online/home.fxml");
    }
    @FXML
    void buybtn(ActionEvent event) throws Exception
    {
        Switcher.changeToScene(getClass(), event, "/online/buyl.fxml");

    }


    @FXML
    void managebtn(ActionEvent event) throws Exception
    {
        if (Acc == 1)
        {
            Switcher.changeToScene(getClass(), event, "/online/preview.fxml");
        }
        else
        {
            Switcher.changeToScene(getClass(), event, "/online/upreview.fxml");
        }
    }
/*additional methods---------------------------------------------------------------------------------------*/
      public void recive()
    {
        Lnameu = userstore.LName;
        Fnameu = userstore.FName;
        Pnou = userstore.Phone;
        Acc = userstore.Acctype;
        Addu = userstore.Address;
        Uname = userstore.UName;
        genderu = userstore.Gender;
        fnameu.setText(Fnameu + "  " + Lnameu);
        addu.setText(Addu);
        pnou.setText(Pnou);
        unameu.setText(Uname);
        if (Acc == 1)
            accu.setText("Manager");
        else
            accu.setText("Utility");
        
    }
      
}