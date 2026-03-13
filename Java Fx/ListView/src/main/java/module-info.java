module com.example.listview {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens com.example.listview to javafx.fxml;
    opens com.example.listview.controllers to javafx.fxml;
    opens com.example.listview.services to javafx.fxml;
    opens com.example.listview.repositories to javafx.fxml;

    exports com.example.listview;
    exports com.example.listview.services;
    exports com.example.listview.repositories;
    exports com.example.listview.controllers;
}