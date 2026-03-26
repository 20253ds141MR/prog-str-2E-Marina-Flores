module com.example.repertoriocanciones {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.repertoriocanciones to javafx.fxml;
    opens com.example.repertoriocanciones.model to javafx.fxml;
    opens com.example.repertoriocanciones.controller to javafx.fxml;
    opens com.example.repertoriocanciones.service to javafx.fxml;

    exports com.example.repertoriocanciones;
    exports com.example.repertoriocanciones.model;
    exports com.example.repertoriocanciones.controller;
    exports com.example.repertoriocanciones.service;
}