
package Controllers;



import connection.ConnectionClass;
import connection.table;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.*;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;


public class PreviewController implements Initializable
{ 
    @FXML
    private TableView < table > tablev;
    @FXML
    private TableColumn < table, String > fnamep;
    @FXML
    private TableColumn < table, String > lnamep;
    @FXML
    private TableColumn < table, Integer > phonep;
    @FXML
    private TableColumn < table, String > genderp;
    @FXML
    private TableColumn < table, String > seatp;
    @FXML
    private TableColumn < table, String > destp;
    @FXML
    private TableColumn < table, String > departp;
    @FXML
    private TableColumn < table, Integer > nop;
    @FXML
    private TableColumn < table, Date > datep;
    @FXML
    private TableColumn< table, String > seatno;
    @FXML
    private TextField searchfld;
    @FXML
    private ComboBox < String > Sort;
// declaring and initializing global variables 
    ConnectionClass connect;
    Connection Connect;
    ConnectionClass conclass = new ConnectionClass();
    String Queryp = "SELECT * From book";
    private final String[] sorts = {"Date","Seat","DepartingCity","DestinationCity","Name"};
    Statement statp;
    ResultSet restp;
    table Table = null;
 

/*** Initializes the controller class.--------------------------------------------*/
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        Sort.getItems().addAll(sorts);
        nop.setCellValueFactory(new PropertyValueFactory < > ("No"));
        fnamep.setCellValueFactory(new PropertyValueFactory < > ("FName"));
        lnamep.setCellValueFactory(new PropertyValueFactory < > ("LName"));
        phonep.setCellValueFactory(new PropertyValueFactory < > ("PNo"));
        seatp.setCellValueFactory(new PropertyValueFactory < > ("Seat"));
        destp.setCellValueFactory(new PropertyValueFactory < > ("DestinationCity"));
        departp.setCellValueFactory(new PropertyValueFactory < > ("DepartingCity"));
        genderp.setCellValueFactory(new PropertyValueFactory < > ("Gender"));
        datep.setCellValueFactory(new PropertyValueFactory < > ("Date"));
        seatno.setCellValueFactory(new PropertyValueFactory < > ("SeatNo"));
        tablev.setItems(TableData(Queryp));
        // TODO
    }

/*---methods from menu bar-------------------------------------------------------------------------*/
    
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
    
/*---methods from Anchor pane----------------------------------------------------------------------*/

    @FXML
    void backbtn(ActionEvent event) throws Exception
    {
        Switcher.changeToScene(getClass(), event, "/online/user.fxml");

    }
    @FXML
    private void sortby(ActionEvent event) {
        String Query;
       String sort = Sort.getSelectionModel().getSelectedItem();
       if(sort.equals("Name"))
       {           
       Query = "SELECT * FROM `book` ORDER BY `FName` ASC";//`book`.
       }  
       else if(sort.equals("Date"))
       {
         Query = "SELECT * FROM `book` ORDER BY `Date` ASC";   
       }
       else if(sort.equals("DepartingCity"))
       {
         Query = "SELECT * FROM `book` ORDER BY `DepartingCity` ASC";   
       }
       else if(sort.equals("DestinationCity"))
       {
         Query = "SELECT * FROM `book` ORDER BY `DestinationCity` ASC";   
       }
       else
       {
          Query = "SELECT * FROM `book` ORDER BY `Seat` ASC,`SeatNO` ASC"; 
       }
       reload(Query);
        
    }

    public ObservableList < table > TableData(String query)
    {

        ObservableList < table > list = FXCollections.observableArrayList();
        try
        {
            Connect = conclass.connector();
            statp = Connect.createStatement();
            restp = statp.executeQuery(query);


            while (restp.next())
            {
                list.add(
                    new table(
                             restp.getInt(1),
                          restp.getInt(2),
                           restp.getString(3),
                           restp.getString(4),
                             restp.getInt(5),
                            restp.getString(6),
                    restp.getString(7), 
                     restp.getString(8),
                          restp.getString(9),
                            restp.getDate(10),
                             restp.getString(11)
                    )
                );

            }

        }
        catch (SQLException ex)
        {
            System.out.println("tablev   " + ex);
        }

        return list;
    }

    @FXML
    private void update(ActionEvent event)
    {
        tablev.setItems(TableData(Queryp));
    }

    @FXML
    private void remove(ActionEvent event)
    {

        Connect = conclass.connector();

        int action = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this item?");
        if (action == 0)
        {
            try
            {
                Table = tablev.getSelectionModel().getSelectedItem();
                String query = "DELETE FROM `book` WHERE no=" + Table.getNo();
                PreparedStatement statem = Connect.prepareStatement(query);
                statem.execute();
                update(event);


            }
            catch (Exception e1)
            {
                e1.printStackTrace();
            }
        }
    }

    @FXML
    private void search(KeyEvent event) {
        String searched = searchfld.getText();
        String query;
        try{
            int serched = Integer.parseInt(searched);
            query = "SELECT * FROM `book` WHERE PNo LIKE '%"+serched+"%'";
        }
        catch(NumberFormatException e)
        {
           query = "SELECT * FROM `book` WHERE FName LIKE '%"+searchfld.getText()+"%'"; 
        }

        reload(query);
        
    }
    private void reload(String Query)
    {
       tablev.setItems(TableData(Query)); 
    }

    
  

}