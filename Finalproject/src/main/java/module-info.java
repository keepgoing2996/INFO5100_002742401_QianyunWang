module com.example.finalproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.tensorflow.core.api;
    requires org.tensorflow.core.platform;
    requires org.tensorflow.ndarray;
    requires javaxt.core;
    requires java.desktop;


    opens com.example.finalproject to javafx.fxml;
    exports com.example.finalproject;
}