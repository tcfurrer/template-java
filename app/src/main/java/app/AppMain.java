package app;

import java.io.*;
import javafx.application.*;
import javafx.fxml.*;
import javafx.stage.*;
import javafx.scene.*;

public final class AppMain extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Template JavaFX Project");

        Parent root = FXMLLoader.load(getClass().getResource("AppMain.fxml"));
        var scene = new Scene(root, 600, 400);
        scene.getStylesheets().add(getClass().getResource("AppMain.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.requestFocus();
    }
}
