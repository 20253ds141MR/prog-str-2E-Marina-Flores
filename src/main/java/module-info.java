module com.tuapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tuapp to javafx.fxml;
    exports com.tuapp;
}