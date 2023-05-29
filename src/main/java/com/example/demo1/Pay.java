package com.example.demo1;

import Controller.AccountController;
import Controller.PurchaserController;
import Model.Exception.InvalidCcv2;
import Model.Exception.InvalidInput;
import Model.Exception.InvalidNumberOfCart;
import Model.Exception.InvalidPassword;
import Model.User.Purchaser;
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

public class Pay {
    @FXML
    private TextField tfPassword;

    @FXML
    private Label lbCvv2;

    @FXML
    private Label lbNumberCard;

    @FXML
    private ImageView exitImage;

    @FXML
    private TextField tfAmount;

    @FXML
    private Label lbPassword2;

    @FXML
    private Button btPay;

    @FXML
    private TextField tfNumberOfCard;

    @FXML
    private Label lbAmount;

    @FXML
    private TextField tfCvv2;

    @FXML
    private Button btExit;

    @FXML
    void btPay(MouseEvent event) throws IOException {
        PurchaserController purchaserController = new PurchaserController();
        try {
            purchaserController.topOfUserAccountCredit((Purchaser) (AccountController.getAccount()),tfNumberOfCard.getText(),tfPassword.getText(),tfCvv2.getText(),Double.valueOf(tfAmount.getText()));
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("pay is successful");
            alert.show();
        } catch (InvalidInput e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
        }
        Parent parent= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("profile.fxml")));
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(parent,800,450);
        stage.setScene(scene);
        stage.setTitle("Profile");
        stage.show();
    }
    @FXML
    void btExit(MouseEvent event) throws IOException {
        Parent parent= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("profile.fxml")));
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(parent,800,450);
        stage.setScene(scene);
        stage.setTitle("Profile");
        stage.show();
    }
}
