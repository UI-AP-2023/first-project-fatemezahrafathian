package com.example.demo1;

import Controller.AdminController;
import Model.User.Admin;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AdminPage {
    @FXML
    private Button ok;
    @FXML
    private Button exit;
    @FXML
    private Button addProduct;
    @FXML
    void addProduct(MouseEvent event) {
        Admin admin = Admin.getAdmin();
        admin.addProducts();
    }
    @FXML
    private TextField command;

    @FXML
    void ok(MouseEvent event) {
        AdminController adminController = new AdminController();
        adminController.adminController(command.getText());
    }
    @FXML
    void exit(MouseEvent event) throws IOException {
        Parent parent= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(parent,800,450);
        stage.setScene(scene);
        stage.setTitle("login");
        stage.show();
    }
}
