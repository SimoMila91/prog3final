package com.progiii.mailclient.controllers.client;

import com.progiii.mailclient.models.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import com.progiii.mailclient.models.Email;

import java.util.List;

public class ClientController {

    @FXML
    private Label lblFrom;

    @FXML
    private Label lblTo;

    @FXML
    private Label lblUsername;

    @FXML
    private Label lblSubject;

    @FXML
    private TextArea txtEmail;

    @FXML
    private ListView<Email> listEmails;

    private User model;
    private Email selectedEmail;
    private Email emptyEmail;

    @FXML
    public void initializeClient(String usr) {
        if (this.model != null) {
            throw new IllegalStateException("Model can only be initialized once");
        }
        System.out.println(usr);
        // new user
        model = new User(usr);
        model.generateRandomEmails(10);


        selectedEmail = null;

        //binding tra lstEmails e inboxProperty
        listEmails.itemsProperty().bind(model.inboxProperty());
        listEmails.setOnMouseClicked(this::showSelectedEmail);
        lblUsername.textProperty().bind(model.emailAddressProperty());

        emptyEmail = new Email("", List.of(""), "", "");

        updateDetailView(emptyEmail);
    }

    /**
     * Elimina la mail selezionata
     */
    @FXML
    protected void onDeleteButtonClick() {
        model.deleteEmail(selectedEmail);
        updateDetailView(emptyEmail);
    }

    /**
     * Mostra la mail selezionata nella vista
     */
    protected void showSelectedEmail(MouseEvent mouseEvent) {
        Email email = listEmails.getSelectionModel().getSelectedItem();

        selectedEmail = email;
        updateDetailView(email);
    }

    /**
     * Aggiorna la vista con la mail selezionata
     */
    protected void updateDetailView(Email email) {
        if(email != null) {
            lblFrom.setText(email.getSender());
            lblTo.setText(String.join(", ", email.getReceivers()));
            lblSubject.setText(email.getSubject());
            txtEmail.setText(email.getText());
        }
    }

}
