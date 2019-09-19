/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//import com.sun.prism.paint.Color;
import static java.lang.System.gc;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

/**
 *
 * @author user
 */
public class NewFXMain extends Application {

    @Override
    public void start(Stage primaryStage) {
        //paper to draw on
        Canvas canvas = new Canvas(800, 500);
        //brush tool or pencil
        GraphicsContext gc;
        StackPane root = new StackPane();

        Scene scene = new Scene(root, 300, 250);
        try {
            gc = canvas.getGraphicsContext2D();
            gc.setStroke(Color.BLUE);
            gc.setLineWidth(1);

            scene.setOnMousePressed(e -> {
                gc.beginPath();
                gc.lineTo(e.getSceneX(), e.getSceneY());
                gc.stroke();

            });

            scene.setOnMouseDragged(e -> {
                gc.lineTo(e.getSceneX(), e.getSceneY());
                gc.stroke();

            });

            root.getChildren().add(canvas);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
