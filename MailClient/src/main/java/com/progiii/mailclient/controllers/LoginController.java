package com.progiii.mailclient.controllers;

import com.progiii.mailclient.controllers.client.ClientController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import javafx.stage.Stage;
import com.progiii.mailclient.models.User;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LoginController {


    public ListView accSelector;
    public Button loginButton;

    @FXML
    public void initialize() {
        loadUser();
    }

    private void loadUser() {

        try {
            String data = new String(Files.readAllBytes(Paths.get("./MailClient/login.json")));

            JSONArray jsonArray = new JSONArray(data);

            for (int i = 0; i < jsonArray.length(); i++) {
                String str = jsonArray.get(i).toString();

                JSONObject user = new JSONObject(str);
                String email = user.getString("email");


                users.add(email);

            }
            accSelector.setItems(users);

        } catch (IOException e) {
            System.out.println(e.getMessage() + " ERRORE LOAD USER");
            throw new RuntimeException(e);
        }
    }

    public void login(MouseEvent e) throws IOException {
        Stage stage = (Stage) loginBtn.getScene().getWindow();
        System.out.println(stage.getScene().getWindow().toString());
        Parent root =  FXMLLoader.load(getClass().getResource("client.fxml"));
        stage.setTitle("NerdMail");
        stage.setScene(new Scene(root));
        ClientController user = new ClientController();
        user.initializeClient(userSelected.getSelectionModel().getSelectedItem().toString());
        stage.show();


}
