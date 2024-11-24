
package Controllers;

import connection.signups;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;


public class SignupController implements Initializable
{

    @FXML
    private TextField FName_fld;
    @FXML
    private TextField LName_fld;
    @FXML
    private TextField UName_fld;
    @FXML
    private TextField Email_fld;
    @FXML
    private PasswordField Passwd_fld;
    @FXML
    private PasswordField rePasswd_fld;
    @FXML
    private TextField phone_fld;
    @FXML
    private TextField Address_fld;
    @FXML
    private DatePicker Dob;
    @FXML
    private RadioButton maler;
    @FXML
    private RadioButton femaler;
    @FXML
    private ToggleGroup gendert;    
    @FXML
    private Button login;
    @FXML
    private Button SIGNUP;
    @FXML
    private Button home;
    
/*declaring global variables-------------------------------------------------------------*/
    public String Emailx, FNamex, LNamex, UNamex, rePasswdx, Passwdx, Addx, phonex,Genderx;
    public boolean Check2;
    public LocalDate Dobx,validdob;
/*initializer method--------------------------------------------------------------------*/
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
    void loginbtn(ActionEvent event) throws Exception
    {
        Switcher.changeToScene(getClass(), event, "/online/login.fxml");

    }
     @FXML
    private void homebtn(ActionEvent event) throws Exception
    {
     Switcher.changeToScene(getClass(), event, "/online/home.fxml");   
    }
    @FXML
    private void genselect(ActionEvent event)
    {

        if (maler.isSelected())
        {
            Genderx = "M";
        }
        else
        {
            Genderx = "F";
        }

    }

    @FXML
    public void SIGNbtn(ActionEvent event) throws Exception
    {


        if (signupSupporter() == true)
        {
            signups sig = new signups();
            if (sig.SIGNUP() == 1)
            {
                JOptionPane.showMessageDialog(null, "you have signed up successfully for security measurment now try login", "login",
                    JOptionPane.INFORMATION_MESSAGE);
                Switcher.changeToScene(getClass(), event, "/online/login.fxml");
            }

            else
            {

                JOptionPane.showMessageDialog(null, "signup faild try login", "login", JOptionPane.INFORMATION_MESSAGE);
                Switcher.changeToScene(getClass(), event, "/online/login.fxml");
            }
        }

    }
/* additional methods----------------------------------------------------------*/   
      public boolean signupSupporter()
    {

        validdob = LocalDate.of(2005, 1, 1);           
        Dobx = Dob.getValue();
        Emailx = Email_fld.getText();
        FNamex = FName_fld.getText();
        phonex = phone_fld.getText();
        LNamex = LName_fld.getText();
        UNamex = UName_fld.getText();
        rePasswdx = rePasswd_fld.getText();
        Passwdx = Passwd_fld.getText();
        Addx = Address_fld.getText();

        if (Addx == null || Dobx == null || phonex == null || Emailx == null || FNamex == null || LNamex == null || UNamex == null ||
            rePasswdx == null || Passwdx == null || Genderx == null)
        {
            JOptionPane.showMessageDialog(null, "Please fill the blanks", "Blank", JOptionPane.ERROR_MESSAGE);
            Check2 = false;
        }
        else if(Dobx.isAfter(validdob))
        {
            JOptionPane.showMessageDialog(null, "Signing Up and having account requires to be age above 18",
                    "Age incorrect", JOptionPane.ERROR_MESSAGE);
        }
        else if(!isEmail(Emailx))
        {
             JOptionPane.showMessageDialog(null, "Enter Correct Email Address : hint- email must contain @",
                    "Email not valid", JOptionPane.ERROR_MESSAGE);
        }
        else if(!isNumeric(phonex))
        {
             JOptionPane.showMessageDialog(null, "Enter Correct phone number only 09 format",
                    "phone not valid", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            if (!(rePasswdx.equals(Passwdx)))
            {
                JOptionPane.showMessageDialog(null, "repeate the exact password that you enetred on  repassword fields",
                    "password mismatch", JOptionPane.ERROR_MESSAGE);

                Check2 = false;
            }
            else
            {
                signups.save(Addx, Emailx, FNamex, Dobx, phonex, LNamex, UNamex, Passwdx, Genderx);

                Check2 = true;
            }
        }

        return Check2;


    }
public static boolean isEmail(String email) {
    return Pattern.compile("^(.+)@(\\S+)$")
      .matcher(email)
      .matches();
}
public static boolean isNumeric(String strNum) {
    try {
        double d = Double.parseDouble(strNum);
    } catch (NumberFormatException e) {
        return false;
    }
    return true;
}


}