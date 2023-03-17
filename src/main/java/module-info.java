module com.example.final_tmge {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.datatransfer;
    requires java.desktop;

    opens com.example.final_tmge to javafx.fxml;
    exports com.example.final_tmge;
}