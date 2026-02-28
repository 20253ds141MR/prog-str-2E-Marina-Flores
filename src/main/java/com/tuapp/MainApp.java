package com.tuapp;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

    public class MainApp extends Application {

        @Override
        public void start(Stage stage) throws Exception {
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/com/tuapp/login.fxml"));
            Scene scene = new Scene(loader.load(), 420, 300);
            scene.getStylesheets().add(MainApp.class.getResource("/com/tuapp/styles.css").toExternalForm());
            stage.setTitle("Login - JavaFX");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }

        public static void main(String[] args) {
            launch(args);
        }
    }

