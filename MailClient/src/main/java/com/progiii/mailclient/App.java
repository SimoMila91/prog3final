package com.progiii.mailclient;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader root = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
        Scene scene = new Scene(root.load());
        stage.setScene(scene);
        stage.show();

    }
}
