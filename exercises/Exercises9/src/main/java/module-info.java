module com.example.exercises9 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.exercises9 to javafx.fxml;
    exports com.example.exercises9;
}