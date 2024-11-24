
package Controllers;

import connection.buys;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
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
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class IDController implements Initializable
{

    @FXML
    private Button login;
    @FXML
    private Button signup;
    @FXML
    private Button buy;
    @FXML
    private Button save;
    @FXML
    private Label Id;
    FileChooser fileChooser = new FileChooser();
    @FXML
    private Button copy;
    @FXML
    private Button back;
    @FXML
    private Label seatno;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        String seatnumber = Integer.toString(buys.SeatNo);
        Id.setText(buys.ID);
        seatno.setText(seatnumber);
        fileChooser.setInitialDirectory(new File("C:\\Users"));
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
    private void signupbtn(ActionEvent event) throws Exception
    {
        Switcher.changeToScene(getClass(), event, "/online/signup.fxml");
    }

    @FXML
    private void buybtn(ActionEvent event) throws Exception
    {
        Switcher.changeToScene(getClass(), event, "/online/buy.fxml");
    }

    @FXML
    private void save(ActionEvent event) throws Exception
    {

        File file = new File("C:\\Users\\Suleyman\\Desktop\\text");
        file = fileChooser.showSaveDialog(new Stage());
        if (file != null)
        {
            saveSystem(file, Id.getText());
        }
        
        save.setText(("Saved"));

    }
    @FXML
    private void copy(ActionEvent event) throws Exception
    {

        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        content.putString(Id.getText());
        clipboard.setContent(content);
        copy.setText("Copied");
    }

    public void saveSystem(File file, String content)
    {
        try
        {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.write(content);
            printWriter.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("filenot found " + e);
        }

    }
    @FXML
    void backbtn(ActionEvent event) throws Exception
    {
        Switcher.changeToScene(getClass(), event, "/online/home.fxml");
    }

}