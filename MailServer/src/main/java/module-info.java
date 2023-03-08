module com.example.mailserver {
    requires javafx.controls;
    requires javafx.fxml;


    opens mailclient.example.mailserver to javafx.fxml;
    exports mailclient.example.mailserver;
}