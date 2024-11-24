
package Controllers;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;


public class AvailableController implements Initializable
{
    @FXML
    private Button back;
    @FXML
    private Label train;
    @FXML
    private DatePicker date;
    
    
 /*--declaring global variables--------------------------------------------------------*/
    LocalDate Date;
    DateTimeFormatter dateForm = DateTimeFormatter.ofPattern("dd");
    DateTimeFormatter dMForm = DateTimeFormatter.ofPattern("ddMM");
    int check;
    String DATE, DM;
    @FXML
    private AnchorPane side;
    @FXML
    private AnchorPane topmain;
    @FXML
    private MenuBar menubar;
    

/** Initializes the controller class.-------------------------------------------------------*/
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
    private void loginbtn(ActionEvent event) throws Exception
    {
        Switcher.changeToScene(getClass(), event, "/online/login.fxml");
    }
    @FXML
    private void chkbtn(ActionEvent event)
    {
        Date = date.getValue();
        DATE = dateForm.format(Date);
        DM = dMForm.format(Date);
        check = Integer.parseInt(DATE);
        if (DATE == null)
        {
            JOptionPane.showMessageDialog(null, "Please choose Date to be checked first!", "Blank", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            if (check % 2 == 1)
            {
                if (DM.equals("2902") || check == 31)
                {
                    train.setText("there will be No Train Availabale at this day!");
                }
                else
                {
                    train.setText("train will be from Addis Ababa to Dire Dawa");
                }
            }
            else
            {
                train.setText("train will be from Dire Dawa to Addis Ababa");
            }
        }

    }
    @FXML
    private void buybtn(ActionEvent event) throws Exception
    {
        Switcher.changeToScene(getClass(), event, "/online/buy.fxml");
    }

    @FXML
    private void backbtn(ActionEvent event) throws Exception
    {
        Switcher.changeToScene(getClass(), event, "/online/home.fxml");
    }
    @FXML
    private void chktbtn(ActionEvent event) throws Exception
    {
        Switcher.changeToScene(getClass(), event, "/online/CheckTicket.fxml");
    }



    


}