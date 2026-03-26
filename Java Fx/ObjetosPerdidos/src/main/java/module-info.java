module com.example.objetosperdidos {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.objetosperdidos to javafx.fxml;
    exports com.example.objetosperdidos;
}