package com.example.demo1;

import Controller.ProductController;
import Model.SystemController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class FilterStationary {
    @FXML
    private TextField tfCountryName;

    @FXML
    private Button btPencil;

    @FXML
    private Button btCountryName;

    @FXML
    private Button btPrice;

    @FXML
    private Button btNoteBook;

    @FXML
    private ImageView exitImage;

    @FXML
    private TextField tfPrice;

    @FXML
    private TextField tfInventory;

    @FXML
    private Button btExit;

    @FXML
    private Button btPen;

    @FXML
    private Button btInventory;

    @FXML
    void btPencil(MouseEvent event) throws IOException {
        ProductController productController = new ProductController();
        SystemController.setProducts(productController.filterPencil(SystemController.getProducts()));
        Parent parent= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("search.fxml")));
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(parent,800,450);
        stage.setScene(scene);
        stage.setTitle("Products");
        stage.show();
    }

    @FXML
    void btNoteBook(MouseEvent event) throws IOException {
        ProductController productController = new ProductController();
        SystemController.setProducts(productController.filterNoteBook(SystemController.getProducts()));
        Parent parent= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("search.fxml")));
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(parent,800,450);
        stage.setScene(scene);
        stage.setTitle("Products");
        stage.show();
    }

    @FXML
    void btPen(MouseEvent event) throws IOException {
        ProductController productController = new ProductController();
        SystemController.setProducts(productController.filterPen(SystemController.getProducts()));
        Parent parent= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("search.fxml")));
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(parent,800,450);
        stage.setScene(scene);
        stage.setTitle("Products");
        stage.show();
    }

    @FXML
    void btCountryName(MouseEvent event) throws IOException {
        try{
            ProductController productController = new ProductController();
            SystemController.setProducts(productController.filterCountry(SystemController.getProducts(),tfCountryName.getText()));
            Parent parent= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("search.fxml")));
            Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene=new Scene(parent,800,450);
            stage.setScene(scene);
            stage.setTitle("Products");
            stage.show();
        }catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("please inter value");
            alert.show();
        }

    }
    @FXML
    void btInventory(MouseEvent event) throws IOException {
        try{
            ProductController productController = new ProductController();
            SystemController.setProducts(productController.filterInventoryStatus(SystemController.getProducts(),Integer.parseInt(tfInventory.getText())));
            Parent parent= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("search.fxml")));
            Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene=new Scene(parent,800,450);
            stage.setScene(scene);
            stage.setTitle("Products");
            stage.show();
        }catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("please inter value");
            alert.show();
        }

    }

    @FXML
    void btPrice(MouseEvent event) throws IOException {
        try{
            String[] price=tfPrice.getText().split("-");
            ProductController productController = new ProductController();
            SystemController.setProducts(productController.filterPrice(SystemController.getProducts(),Double.parseDouble(price[0]),Double.parseDouble(price[1])));
            Parent parent= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("search.fxml")));
            Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene=new Scene(parent,800,450);
            stage.setScene(scene);
            stage.setTitle("Products");
            stage.show();
        }catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("please inter value");
            alert.show();
        }

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
}
