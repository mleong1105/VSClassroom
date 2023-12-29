package function.mainfx;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MultiClassroomApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL resourceUrl = getClass().getResource("/function/mainfx/resources/mainfx/VirtualClassroom.fxml");
        System.out.println("Resource URL: " + resourceUrl);
        Parent root = FXMLLoader.load(resourceUrl);

        Scene scene = new Scene(root);

        primaryStage.setTitle("Virtual Classroom App");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
