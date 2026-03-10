<<<<<<< HEAD
module com.example.demolistview {
=======
module com.tuapp {
>>>>>>> cc019a5a14d260cf3deb3383d29e7919218eb9b7
    requires javafx.controls;
    requires javafx.fxml;


<<<<<<< HEAD
    opens com.example.demolistview to javafx.fxml;
    opens com.example.demolistview.controllers to javafx.fxml;
    opens com.example.demolistview.services to javafx.fxml;
    opens com.example.demolistview.repositories to javafx.fxml;

    exports com.example.demolistview;
    exports com.example.demolistview.services;
    exports com.example.demolistview.repositories;
    exports com.example.demolistview.controllers;
=======
    opens com.tuapp to javafx.fxml;
    exports com.tuapp;
>>>>>>> cc019a5a14d260cf3deb3383d29e7919218eb9b7
}