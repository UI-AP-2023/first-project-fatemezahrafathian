package com.example.demo1;

import Controller.AccountController;
import Controller.PurchaserController;
import Model.SystemController;
import Model.User.Purchaser;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class AddComment {
    @FXML
    private Button btBack;

    @FXML
    private TextArea tfComment;

    @FXML
    private Button btSend;

    @FXML
    void btBack(MouseEvent event) throws IOException {
        Parent parent= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("search.fxml")));
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(parent,800,450);
        stage.setScene(scene);
        stage.setTitle("Search");
        stage.show();
    }

    @FXML
    void btSend(MouseEvent event) throws IOException {
        PurchaserController purchaserController = new PurchaserController();
        purchaserController.addComment(SystemController.getProduct(),(Purchaser) AccountController.getAccount(),tfComment.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("request has send to admin");
        alert.show();
        Parent parent= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("search.fxml")));
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(parent,800,450);
        stage.setScene(scene);
        stage.setTitle("Search");
        stage.show();

    }
}
