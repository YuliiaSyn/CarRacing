import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
/**
 * @author Alland Timas
 * initializes the gui and launches it
 */
public class BuildGui extends Application {
 
 @Override
 public void start(Stage stage) {
  try {
   
   Parent root = FXMLLoader.load(getClass().getResource("scene1.fxml"));
   Scene scene = new Scene(root);
   stage.setScene(scene);
   stage.setResizable(false);
   stage.show();
   
  } catch(Exception e) {
   e.printStackTrace();
  }
 } 

    public static void main(String[] args) {
        launch(args);
    }
}