
package Controllers;

import connection.checker;
import connection.userstore;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;


public class CheckTicketController implements Initializable
{

    @FXML
    private Button buy;
    @FXML
    private Button login;
    @FXML
    private Button signup;
    @FXML
    private Button chk;
    @FXML
    private Button back;
    @FXML
    private TextField idfld;
    @FXML
    private Label fullname;
    @FXML
    private Label phon;
    @FXML
    private Label fromto;
    @FXML
    private Label inval;
    @FXML
    private Label val;
    @FXML
    private Label traveldate;
/*declare Global variables-------------------------------------*/
    public String IDN, vali, invali;
    checker chkr = new checker();
    LocalDate date,Today;
    @FXML
    private Label seatno;

    

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
   
/*---methods from Anchor pane--------------------------------------------------------------------------*/

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
    private void loginbtn(ActionEvent event) throws Exception
    {
        Switcher.changeToScene(getClass(), event, "/online/login.fxml");
    }

    @FXML
    private void signupbtn(ActionEvent event) throws Exception
    {
        Switcher.changeToScene(getClass(), event, "/online/signup.fxml");
    }

    @FXML
    private void chkbtn(ActionEvent event)
    {
        IDN = idfld.getText();
        if (IDN.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please Enter your Identification code", "Blank", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            if (chkr.check(IDN) == 1)
            {
                Today = java.time.LocalDate.now();
                date = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(userstore.DATE));
                phon.setText("phone : " + userstore.phone);
                fullname.setText("name : " + userstore.fname + "  " + userstore.lname);
                fromto.setText("travel : from " + userstore.DepartingCity + " to " + userstore.DestinationCity);
                seatno.setText("Seat: " + userstore.Seat + "  num_: "+ userstore.SeatNo);
                traveldate.setText("Date:   "+ date.toString() );
                if (date.isAfter(Today))
                {
                    val.setText("☑ VALID");
                    inval.setText("");
                }
                else
                {
                    val.setText("");
                    inval.setText("[X] Invalid");
                }


            }
            else
            {
                JOptionPane.showMessageDialog(null, "Unknown Identification code", "Blank", JOptionPane.ERROR_MESSAGE);

            }
        }


    }
}