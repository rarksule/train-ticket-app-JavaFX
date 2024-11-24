package online;



import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Online_Ticket extends Application
{

        @Override
        public void start(Stage primaryStage)
        {

                try
                {
                    
                        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
                        Scene scene = new Scene(root);
                        Image myIcon = new Image("online/IMAGE/ICON.png");
                        primaryStage.getIcons().add(myIcon);
                        primaryStage.setTitle("Online_Train_Ticket_system");
                        primaryStage.setScene(scene);
                        File file = new File("src/online/IMAGE/style.txt");
                        Scanner myReader = new Scanner(file);
                        String style = myReader.nextLine();
                        scene.getStylesheets().add(getClass().getResource("IMAGE/"+style+"Style.css").toExternalForm());
                        primaryStage.setX(500.0);
                        primaryStage.setY(10.0);
                        primaryStage.setResizable(false);
                        primaryStage.show();
                }
                catch (IOException ex)
                {
                        System.out.print("main " + ex);
                }
        }
       

        /**
         * @param args the command line arguments
         */
        public static void main(String[] args)
        {
                launch(args);
        }

}