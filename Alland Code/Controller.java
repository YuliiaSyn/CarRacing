import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.Node;
import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controller implements Initializable{
    @FXML
    private Button start_Button, exit_Button;
    @FXML
    private Circle car_1, car_2, car_3, car_4;
    
    Path path;

    private Stage stage;
    private Scene scene;
    private Parent root;


    public void swapToScene1(ActionEvent ae) throws IOException{
        root = FXMLLoader.load(getClass().getResource("scene1.fxml"));
        stage = (Stage)((Node)ae.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void swapToScene2(ActionEvent ae) throws IOException{
        root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
        stage = (Stage)((Node)ae.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        path = new Path();
        path.getElements().add(new MoveTo(0, 0));
        path.getElements().add(new LineTo(550, 0));
        path.getElements().add(new LineTo(550, -265));
        path.getElements().add(new LineTo(0, -265));
        path.getElements().add(new LineTo(0, 0));
        PathTransition translate = new PathTransition();
        translate.setNode(car_1);

        translate.setDuration(Duration.millis(5000));
        translate.setCycleCount(1);
        translate.setPath(path);
        translate.play();
    }
}
