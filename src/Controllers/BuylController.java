
package Controllers;

import connection.PriceCalculator;
import connection.buys;
import connection.userstore;
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
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;


public class BuylController implements Initializable
{

    @FXML
    private ComboBox < String > departure;
    @FXML
    private ComboBox < String > destination;
    @FXML
    private ComboBox < String > selectseat;
    @FXML
    DatePicker date;
    @FXML
    private Button back;

    @FXML
    private Button confirm;
    @FXML
    private Button cancel;
    @FXML
    private Label unameu;
    @FXML
    private Label pnou;
    @FXML
    private Label lnameu;
    @FXML
    private Label fnameu;
    @FXML
    private ProgressBar prog;
/* initilize and declare global variable ---------------------------------------*/
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
   
    private String selectedseat, selecteddepart, selecteddestination, firstName, lastName, phone, selectedgender,Fnameu, Addu, Lnameu, Uname, genderu, Pnou;
    char[] called = new char[5];
    double progress;

    LocalDate Date, Today;
    
    DateTimeFormatter dateForm = DateTimeFormatter.ofPattern("dd");
    DateTimeFormatter dMForm = DateTimeFormatter.ofPattern("ddMM");
    
    

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
        reciev();
        progress = 0.52;
        prog.setProgress(progress);

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
        Switcher.changeToScene(getClass(), event, "/online/user.fxml");
    }

    @FXML
    private void confbtn(ActionEvent event)
    {
        try
        {
            if(filled())
            {
                String validdate = dateForm.format(Date);
                int validate = Integer.parseInt(validdate);
                String Validdate = dMForm.format(Date);
                int Validate = Integer.parseInt(Validdate);

                if (validate % 2 != Validator() || validate == 31 || Validate == 2902)
                {
                    JOptionPane.showMessageDialog(null,
                        "there is no availabale train at this day please checke availabale page and choose correct date",
                        "Blank", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    int price = PriceCalculator.calculator(selectedseat, selecteddepart, selecteddestination);
                    int action = JOptionPane.showConfirmDialog(null, "Are you sure you Want to book this ticket its fee:" + (price -
                        30));
                    if (action == 0)
                    {
                        book.save(selectedseat, selecteddepart, selecteddestination, Date, firstName, lastName, phone,
                            selectedgender);
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

        Date = null;
        selectedseat = null;
        selecteddepart = null;
        selecteddestination = null;
        prog.setProgress(0.5);


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
    private void seat(ActionEvent event)
    {

        if (called[1] != 's')
        {
            progress = progress + 0.12;
            prog.setProgress(progress);
            called[1] = 's';
        }
    }

    //   
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
/* Additional methods ----------------------------------------------------------------------------*/
    private void reciev()
    {
        Lnameu = userstore.LName;
        Fnameu = userstore.FName;
        Pnou = userstore.Phone;
        Uname = userstore.UName;
        fnameu.setText(Fnameu);
        lnameu.setText(Lnameu);
        pnou.setText(Pnou);
        unameu.setText(Uname);
       
    }
    private boolean filled()
    {
        Today = java.time.LocalDate.now();
            Date = date.getValue();
            firstName = userstore.FName;
            lastName = userstore.LName;
            phone = userstore.Phone;
            selectedgender = userstore.Gender;
            selectedseat = selectseat.getSelectionModel().getSelectedItem();
            selecteddepart = departure.getSelectionModel().getSelectedItem();
            selecteddestination = destination.getSelectionModel().getSelectedItem();


            if (selectedseat == null || selecteddepart == null || selecteddestination == null || Date == null)
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
            else
            {
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