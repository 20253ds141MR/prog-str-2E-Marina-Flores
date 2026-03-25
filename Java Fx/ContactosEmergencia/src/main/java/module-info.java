module com.example.contactosemergencia {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.contactosemergencia to javafx.fxml;
    opens com.example.contactosemergencia.services to javafx.fxml;
    opens com.example.contactosemergencia.controllers to javafx.fxml;
    opens com.example.contactosemergencia.model to javafx.fxml;

    exports com.example.contactosemergencia;
    exports com.example.contactosemergencia.services;
    exports com.example.contactosemergencia.model;
    exports com.example.contactosemergencia.controllers;
}