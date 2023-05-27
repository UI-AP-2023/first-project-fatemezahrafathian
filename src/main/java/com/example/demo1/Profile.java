package com.example.demo1;

import Controller.AccountController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Profile implements Initializable {
    @FXML
    private Button btExit;
    @FXML
    private Button btEdit;
    @FXML
    private Button btCart;
    @FXML
    private ImageView exitImage;

    @FXML
    private Rectangle box;

    @FXML
    private Label information;
    @FXML
    private Button btPay;
    @FXML
    private Button btDiscounts;

    @FXML
    private Button btHistory;
    @FXML
    private Button btExitAccount;
    @FXML
    void btExitAccount(MouseEvent event) throws IOException {
//        Parent parent= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("pay.fxml")));
//        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
//        Scene scene=new Scene(parent,800,450);
//        stage.setScene(scene);
//        stage.setTitle("Pay");
//        stage.show();
    }
    @FXML
    void btHistory(MouseEvent event) throws IOException {
        Parent parent= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("history.fxml")));
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(parent,800,450);
        stage.setScene(scene);
        stage.setTitle("History");
        stage.show();
    }
    @FXML
    void btDiscounts(MouseEvent event) throws IOException {
        Parent parent= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("discounts.fxml")));
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(parent,800,450);
        stage.setScene(scene);
        stage.setTitle("Discounts");
        stage.show();
    }
    @FXML
    void btPay(MouseEvent event) throws IOException {
        Parent parent= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("pay.fxml")));
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(parent,800,450);
        stage.setScene(scene);
        stage.setTitle("Pay");
        stage.show();
    }

    @FXML
    void btExit(MouseEvent event) throws IOException {
        Parent parent= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("home.fxml")));
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(parent,800,450);
        stage.setScene(scene);
        stage.setTitle("Home");
        stage.show();
    }
    @FXML
    void btEdit(MouseEvent event) throws IOException {
        Parent parent= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("edit.fxml")));
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(parent,800,450);
        stage.setScene(scene);
        stage.setTitle("Edit");
        stage.show();
    }
    @FXML
    void btCart(MouseEvent event) throws IOException {
        Parent parent= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("cart.fxml")));
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(parent,800,450);
        stage.setScene(scene);
        stage.setTitle("Cart");
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        information.setText(AccountController.getAccount().toString());
    }
}
