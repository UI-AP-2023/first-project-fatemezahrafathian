package com.example.demo1;

import Controller.AccountController;
import Controller.PurchaserController;
import Model.Exception.InvalidEmail;
import Model.Exception.InvalidInput;
import Model.Exception.InvalidPassword;
import Model.Exception.InvalidPhone;
import Model.User.Purchaser;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Edit implements Initializable {
    @FXML
    private Label lbEdit;

    @FXML
    private TextField tfPassword;

    @FXML
    private Button btEdit;

    @FXML
    private Label lbPassword;

    @FXML
    private TextField tfPhone;

    @FXML
    private TextField tfUsernameValue;

    @FXML
    private TextField tfEmail;

    @FXML
    private Label lbUsername;

    @FXML
    private Label lbEmail;

    @FXML
    private Button btExit;

    @FXML
    private ImageView exitImage1;

    @FXML
    private Label lbPhone;
    @FXML
    void btExit(MouseEvent event) throws IOException {
        Parent parent= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("profile.fxml")));
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(parent,800,450);
        stage.setScene(scene);
        stage.setTitle("Profile");
        stage.show();
    }
    @FXML
    void btEdit(MouseEvent event) {
        PurchaserController purchaserController = new PurchaserController();
        try {
            purchaserController.editInformation((Purchaser) AccountController.getAccount(),tfPassword.getText(),tfEmail.getText(),tfPhone.getText());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("edit is successful");
            alert.show();
        } catch (InvalidInput e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tfUsernameValue.setText(AccountController.getAccount().getUserName());
        tfPassword.setText(AccountController.getAccount().getPassword());
        tfPhone.setText(AccountController.getAccount().getPhoneNumber());
        tfEmail.setText(AccountController.getAccount().getEmail());
    }
}
