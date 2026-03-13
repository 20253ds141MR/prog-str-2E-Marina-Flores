package com.example.demo_javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        URL fxml = HelloApplication.class.getResource("/com/example/demo_javafx/home-view.fxml");
        if (fxml == null) {
            throw new IllegalStateException("No se encontró /com/example/demo_javafx/home-view.fxml en el classpath");
        }

        FXMLLoader loader = new FXMLLoader(fxml);
        Scene scene = new Scene(loader.load(), 320, 240);
        stage.setTitle("Demo Form");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
