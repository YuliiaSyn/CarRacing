
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Class which creates main frame for the application.
 * @author Yuliia Synytska
 */

public class Main extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Racing Game");
        BorderPane bp = new BorderPane();
        bp.setPadding(new Insets(10, 20, 10, 20));

        Button start = new Button("Start Race");
        start.setOnAction(new EventHandler() {

            @Override
            public void handle(Event event) {
                
            }
        });
        
        Button stop = new Button("Stop Race");
        stop.setOnAction(new EventHandler() {

            @Override
            public void handle(Event event) {
                
            }
        });
        
        Button end = new Button("End Race");
        end.setOnAction(new EventHandler() {

            @Override
            public void handle(Event event) {
                
            }
        });
        
        Button restart = new Button("Restart Race");
        restart.setOnAction(new EventHandler() {

            @Override
            public void handle(Event event) {
                
            }
        });
        
        HBox hbox = new HBox(50);
        hbox.getChildren().addAll(start, stop, end, restart);
        
        bp.setBottom(hbox);
        
        Scene scene = new Scene(bp, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
