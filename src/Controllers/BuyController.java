
package Controllers;

import connection.PriceCalculator;
import connection.buys;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;


public class BuyController implements Initializable
{


    @FXML
    private ComboBox < String > departure;
    @FXML
    private ComboBox < String > destination;
    @FXML
    private ComboBox < String > selectseat;
     @FXML
    private Button back;
    @FXML
    private Button cancel;
    @FXML
    private TextField fname_txt;
    @FXML
    private TextField lname_txt;
    @FXML
    private TextField pno_txt;
    @FXML
    private RadioButton mlradio;
    @FXML
    private ToggleGroup gender;
    @FXML
    private RadioButton fmlradio;
    @FXML
    private Button confirm1;
    @FXML
    private ProgressBar prog;
    @FXML
    private DatePicker date;
/*declare and intialize global variable------------------------------------------------*/
    buys book = new buys();
    private final String[] seats = {
        "Hard seat",
        "UpperHard sleeper",
        "MiddleHard sleeper",
        "lowerHard sleeper",
        "Uppersoft sleeper",
        "Lowersoft sleeper"
    };
    private final String[] places = {
        "Addis Ababa",
        "Adama",
        "Dire Dawa"
    };
    public String selectedseat, selecteddepart, selecteddestination, firstName, lastName, phone, selectedgender;
    LocalDate Date, Today, ValidDate;
    char[] called = new char[9];
    DateTimeFormatter dateForm = DateTimeFormatter.ofPattern("dd");
    DateTimeFormatter dMForm = DateTimeFormatter.ofPattern("ddMM");
    double progress;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
        departure.getItems().addAll(places);
        destination.getItems().addAll(places);
        selectseat.getItems().addAll(seats);
        prog.setProgress(0.0);

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
    private void backbtn(ActionEvent event) throws Exception
    {
        Switcher.changeToScene(getClass(), event, "/online/home.fxml");
    }
    @FXML
    private void Rselected(ActionEvent event)
    {
        
        if (mlradio.isSelected())
        {
            selectedgender = "M";

        }
        else
        {

            selectedgender = "F";

        }
        if (called[8] != 'g')
        {
            progress = progress + 0.16;
            prog.setProgress(progress);
            called[8] = 'g';
        }
    }

    @FXML
    private void confbtn(ActionEvent event)
    {


        try
        {
           if(filled())
            {
                String validdate = dateForm.format(ValidDate);
                int validate = Integer.parseInt(validdate);
                String Validdate = dMForm.format(ValidDate);
                int Validate = Integer.parseInt(Validdate);


                if (validate % 2 != Validator() || validate == 31 || Validate == 2902)
                {
                    JOptionPane.showMessageDialog(null,
                        "there is no availabale train at this day please check availabale page and choose correct date",
                        "Blank", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    int price = PriceCalculator.calculator(selectedseat, selecteddepart, selecteddestination);
                    int action = JOptionPane.showConfirmDialog(null, "Are you sure you Want to book this ticket its fee:  " +
                        price);
                    if (action == 0)
                    {
                        book.save(selectedseat, selecteddepart, selecteddestination, Date, firstName, lastName, phone,selectedgender);
                        selectseat.setValue(selectedseat);
                        departure.setValue(selecteddepart);
                        destination.setValue(selecteddestination);
                        if (book.Save())
                        {
                            JOptionPane.showMessageDialog(null, "YOU have booked ticket suucessfully be there at time!",
                                "Blank", JOptionPane.INFORMATION_MESSAGE);
                            Switcher.changeToScene(getClass(), event, "/online/ID.fxml");

                        }
                        else
                        {
                            System.out.println("system error");
                        }
                    }
                }
            }
        }
        catch (Exception ex)
        {
            System.out.println("confirm " + ex);
        }


    }

    @FXML
    private void resetbtn(ActionEvent event)
    {

        fname_txt.setText("");
        lname_txt.setText("");
        pno_txt.setText("");
        gender.selectToggle(null);
        firstName = null;
        lastName = null;
        phone = null;
        selectedseat = null;
        selecteddepart = null;
        selecteddestination = null;
        selectedgender = null;
        prog.setProgress(0.0);
        System.out.println(Date);

    }
   

    @FXML
    private void LOGIN(MouseEvent event)
    {
        try
        {
            Switcher.changeToScene(getClass(), event, "/online/login.fxml");
        }
        catch (Exception ex)
        {
            System.out.println("login " + ex);
        }

    }
    @FXML
    private void seat(ActionEvent event)
    {

        if (called[1] != 's')
        {
            progress = progress + 0.12;
            prog.setProgress(progress);
            called[1] = 's';
        }
    }
    
    @FXML
    private void depar(ActionEvent event)
    {
        if (called[2] != 'd')
        {
            progress = progress + 0.12;
            prog.setProgress(progress);
            called[2] = 'd';
        }

    }

    @FXML
    private void dest(ActionEvent event)
    {

        if (called[3] != 'D')
        {
            progress = progress + 0.12;
            prog.setProgress(progress);

            called[3] = 'D';
        }
    }

  
    @FXML
    private void caland(ActionEvent event)
    {
        if (called[4] != 'c')
        {
            progress = progress + 0.12;
            prog.setProgress(progress);
            called[4] = 'c';
        }
        

    }

    @FXML
    private void fwritten(KeyEvent event)
    {
        if (called[5] != 'f')
        {
            progress = progress + 0.12;
            prog.setProgress(progress);
            called[5] = 'f';
        }

    }
    @FXML
    private void lwritten(KeyEvent event)
    {
        if (called[6] != 'l')
        {
            progress = progress + 0.12;
            prog.setProgress(progress);
            called[6] = 'l';
        }

    }
    @FXML
    private void pwritten(KeyEvent event)
    {
        if (called[7] != 'p')
        {
            progress = progress + 0.12;
            prog.setProgress(progress);
            called[7] = 'p';
        }

    }

/*additonal methods--------------------------------------------------------------------- */
    private boolean filled()
    {
         Today = java.time.LocalDate.now();
            Date = date.getValue();
            ValidDate = Date;
            firstName = fname_txt.getText();
            lastName = lname_txt.getText();
            phone = pno_txt.getText();
            selectedseat = selectseat.getSelectionModel().getSelectedItem();
            selecteddepart = departure.getSelectionModel().getSelectedItem();
            selecteddestination = destination.getSelectionModel().getSelectedItem();
            

            if (selectedseat == null || selecteddepart == null || selecteddestination == null || selectedgender ==null || firstName
                .isEmpty() || lastName.isEmpty() || phone.isEmpty() || Date == null)
            {
                JOptionPane.showMessageDialog(null, "Please fill all the blanks!! ", "Blank", JOptionPane.ERROR_MESSAGE);
            }
            else if (selecteddepart.equals(selecteddestination))
            {
                JOptionPane.showMessageDialog(null, "Please choose correct Departing and DestinationCity!", "Blank", JOptionPane
                    .ERROR_MESSAGE);
            }
            else if (Date.isBefore(Today))
            {
                JOptionPane.showMessageDialog(null, "Please choose correct Date!", "Blank", JOptionPane.ERROR_MESSAGE);
            }
            else if(isnum(phone))
            {
                JOptionPane.showMessageDialog(null, "Please Enter Number only", "Blank", JOptionPane.ERROR_MESSAGE); 
            }
            else {
                return true;
            }
        return false;
        
    }
    private boolean isnum(String num)
    {
        try{
           int Num = Integer.parseInt(num); 
        }catch(NumberFormatException e){
        return true;
        }     
        return false;
        
    }
     private int Validator()
    {
        int traveldate;
        if (selecteddepart.equals("Addis Ababa"))
        {
            traveldate = 1;
        }
        else if (selecteddepart.equals("Dire Dawa"))
        {
            traveldate = 0;
        }
        else
        {
            if (selecteddestination.equals("Addis Ababa"))
            {
                traveldate = 0;
            }
            else
            {
                traveldate = 1;
            }
        }
        return traveldate;

    }

}