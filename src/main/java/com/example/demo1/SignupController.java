package com.example.demo1;

import Controller.AccountController;
import Model.Exception.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
import java.util.Objects;

public class SignupController {
    @FXML
    private TextField tfPhoneNumber;

    @FXML
    private TextField tfPassword;

    @FXML
    private Label lbSighup;

    @FXML
    private Label lbPassword;

    @FXML
    private TextField tfUsername;

    @FXML
    private ImageView exitImage;

    @FXML
    private Button btSignup;

    @FXML
    private TextField tfEmail;

    @FXML
    private Label lbPhone;

    @FXML
    private Label lbEmail;

    @FXML
    private Label lbUsername;
    @FXML
    private Button btExit;

    @FXML
    void btSignup(MouseEvent event) throws IOException {
        AccountController accountController = new AccountController();
        try {
            accountController.signup(tfUsername.getText(),tfPassword.getText(),tfPhoneNumber.getText(),tfEmail.getText());
        } catch (InvalidInput e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
        }catch (SendRequest e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText(e.getMessage());
            alert.show();
            Parent parent= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));
            Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene=new Scene(parent,800,450);
            stage.setScene(scene);
            stage.setTitle("login");
            stage.show();
        }
    }
    @FXML
    void btExit(MouseEvent event) throws IOException {
        Parent parent= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(parent,800,450);
        stage.setScene(scene);
        stage.setTitle("login");
        stage.show();
    }
}
