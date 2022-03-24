import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.Node;
import javafx.animation.PathTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;
/**
 * @author Alland Timas
 * Controller class to add functionality to buttons and animate car objects
 * Car objects are represented using circle objects
 */
public class Controller{

    @FXML
    private Button start_Button, exit_Button, begin_Button;
    @FXML
    private Circle car_1, car_2, car_3, car_4;
    @FXML 
    Label carDetails;
    Path path;
    RacingVenue venue = new RacingVenue();
    ArrayList<Car> cars = new ArrayList<>();
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Alert alert; 

    //Starts the race and clears out the previous race's car's information
    public void startSimulation() {
        venue.carList.clear();
        moveCar1();
        moveCar2();
        moveCar3();
        moveCar4();
    }
    //-------------------------------Swaps to specified scene or alert-------------------------------------------------------
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
    public void swapToScene3(ActionEvent ae) throws IOException{
        alert = new Alert(AlertType.INFORMATION);
        alert.setContentText(venue.getCars().toString() + "\n\nWinner: " + venue.determineWinner());
        alert.show();
    }
    //-----------------------------------------------------------------------------------------------------------
    //---------Creates car object and associates it with Circle object. Aswell as defines path for object--------
    //Path draws "invisible" lines that determine when and where the path diverges
    public void moveCar1(){
        path = new Path();
        venue.generateCar();
        this.venue.car.setColor("Red");
        path.getElements().add(new MoveTo(0, 0));
        path.getElements().add(new LineTo(550, 0));
        path.getElements().add(new LineTo(550, -265));
        path.getElements().add(new LineTo(0, -265));
        path.getElements().add(new LineTo(0, 0));
        PathTransition transition = new PathTransition();
        transition.setNode(car_1);
        transition.setDuration(Duration.seconds(10 - this.venue.returnLapSpeed()));
        transition.setPath(path);
        transition.play();
    }
    public void moveCar2(){
        path = new Path();
        venue.generateCar();
        this.venue.car.setColor("Yellow");
        path.getElements().add(new MoveTo(0, 0));
        path.getElements().add(new LineTo(0, -265));
        path.getElements().add(new LineTo(-550, -265));
        path.getElements().add(new LineTo(-550, 5));
        path.getElements().add(new LineTo(0, 0));
        PathTransition transition = new PathTransition();
        transition.setNode(car_2);
        transition.setDuration(Duration.seconds(10 - this.venue.returnLapSpeed()));
        transition.setPath(path);
        transition.play();
    }
    public void moveCar3(){
        path = new Path();
        venue.generateCar();
        this.venue.car.setColor("Orange");
        path.getElements().add(new MoveTo(0, 0));
        path.getElements().add(new LineTo(-550, 0));
        path.getElements().add(new LineTo(-550, 265));
        path.getElements().add(new LineTo(0, 265));
        path.getElements().add(new LineTo(0, 0));
        PathTransition transition = new PathTransition();
        transition.setNode(car_3);
        transition.setDuration(Duration.seconds(10 - this.venue.returnLapSpeed()));
        transition.setPath(path);
        transition.play();
    }
    public void moveCar4(){
        path = new Path();
        venue.generateCar();
        this.venue.car.setColor("Blue");
        path.getElements().add(new MoveTo(0, 0));
        path.getElements().add(new LineTo(0, 265));
        path.getElements().add(new LineTo(550, 265));
        path.getElements().add(new LineTo(550, 0));
        path.getElements().add(new LineTo(0, 0));
        PathTransition transition = new PathTransition();
        transition.setNode(car_4);
        transition.setDuration(Duration.seconds(10 - this.venue.returnLapSpeed()));
        transition.setPath(path);
        transition.play();
    }
    //----------------------------------------------------------------------------------------------------------
    public void returnCarDetails(){
        carDetails.setText(venue.getCars().toString());
    }
    public void exitApplication(){
        Platform.exit();
    }
}
