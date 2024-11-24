
package Controllers;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Switcher
{
//    public static String style;

    public static void changeToScene(Class getClass, Event getevent, String getscene) throws Exception
    {
        File file = new File("src/online/IMAGE/style.txt");
        Scanner myReader = new Scanner(file);
        String style = myReader.nextLine();
        Parent root = FXMLLoader.load(getClass.getResource(getscene));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node) getevent.getSource()).getScene().getWindow();
        scene.getStylesheets().add(getClass.getResource("/online/IMAGE/"+style+"Style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

  public static void styler(String Colour) 
  {        
      String Color = Colour;
      FileOutputStream fout = null;
        try {
            byte[] color=Color.getBytes();
            File file = new File("src/online/IMAGE/style.txt");
            fout = new FileOutputStream(file);
            fout.write(color);
            fout.close();
        } catch (FileNotFoundException ex) {
            System.out.println("flntfnd  "+ex);
        }  catch (IOException ex) {
                System.out.println("filIO  "+ex);
            }  
}
}