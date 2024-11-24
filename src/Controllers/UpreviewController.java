
package Controllers;

import connection.ConnectionClass;
import connection.table;
import connection.userstore;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;


public class UpreviewController implements Initializable
{

    @FXML
    private TableView < table > tablev;   
    @FXML
    private TableColumn < table, String > seatp;//
    @FXML
    private TableColumn < table, String > destp;
    @FXML
    private TableColumn < table, String > departp;
    @FXML
    private TableColumn < table, Integer > nop;
    @FXML
    private TableColumn < table, Date > datep;
    @FXML
    private TableColumn<table,String> idp;
    @FXML
    private Button back;
    @FXML
    private Button back2;
    @FXML
    private Button reload;
 // declaring and initializing global variables  
    
    ConnectionClass connect;
    Connection Connect;
    ConnectionClass conclass = new ConnectionClass();
    String Queryp = "SELECT * From book where (FName=? and LName=?)";
    PreparedStatement statp;
    ResultSet restp;
    table Table = null;
    
 /**Initializes the controller class.**/
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        nop.setCellValueFactory(new PropertyValueFactory < > ("SeatNo"));
        seatp.setCellValueFactory(new PropertyValueFactory < > ("Seat"));
        destp.setCellValueFactory(new PropertyValueFactory < > ("DestinationCity"));
        departp.setCellValueFactory(new PropertyValueFactory < > ("DepartingCity"));
        datep.setCellValueFactory(new PropertyValueFactory < > ("Date"));
        idp.setCellValueFactory(new PropertyValueFactory < > ("ID"));
        tablev.setItems(TableData());
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

    public ObservableList < table > TableData()
    {

        ObservableList < table > list = FXCollections.observableArrayList();
        try
        {
            Connect = conclass.connector();
            statp = Connect.prepareStatement(Queryp);
            statp.setString(1, userstore.FName);
            statp.setString(2,userstore.LName);
            restp = statp.executeQuery();

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
        tablev.setItems(TableData());
    }

    @FXML
    private void remove(ActionEvent event)
    {

        Connect = conclass.connector();

        int action = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record this can't be undone?");
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
            catch (Exception ex)
            {
                System.out.println("remove in user preview  " + ex);
            }
        }
    }
}