package com.example.demo1;

import Controller.ProductController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class FilterVehicle {
    @FXML
    private Button btPrice;

    @FXML
    private ImageView exitImage;

    @FXML
    private TextField tfPrice;

    @FXML
    private TextField tfInventory;

    @FXML
    private Button btExit;

    @FXML
    private Button btInventory;
    @FXML
    private TextField tfCompanyName;
    @FXML
    void btInventory(MouseEvent event) throws IOException {
        ProductController productController = new ProductController();
        HomeController.setProducts(productController.filterInventoryStatus(HomeController.getProducts(),Integer.parseInt(tfInventory.getText())));
        Parent parent= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("search.fxml")));
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(parent,800,450);
        stage.setScene(scene);
        stage.setTitle("Products");
        stage.show();
    }

    @FXML
    void btCar(MouseEvent event) throws IOException {
        ProductController productController = new ProductController();
        HomeController.setProducts(productController.filterCar(HomeController.getProducts()));
        Parent parent= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("search.fxml")));
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(parent,800,450);
        stage.setScene(scene);
        stage.setTitle("Products");
        stage.show();
    }

    @FXML
    void btBike(MouseEvent event) throws IOException {
        ProductController productController = new ProductController();
        HomeController.setProducts(productController.filterBike(HomeController.getProducts()));
        Parent parent= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("search.fxml")));
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(parent,800,450);
        stage.setScene(scene);
        stage.setTitle("Products");
        stage.show();
    }

    @FXML
    void btCompanyName(MouseEvent event) throws IOException {
        ProductController productController = new ProductController();
        HomeController.setProducts(productController.filterCompanyName(HomeController.getProducts(),tfCompanyName.getText()));
        Parent parent= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("search.fxml")));
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(parent,800,450);
        stage.setScene(scene);
        stage.setTitle("Products");
        stage.show();
    }

    @FXML
    void btPrice(MouseEvent event) throws IOException {
        String[] price=tfPrice.getText().split("-");
        ProductController productController = new ProductController();
        HomeController.setProducts(productController.filterPrice(HomeController.getProducts(),Double.parseDouble(price[0]),Double.parseDouble(price[1])));
        Parent parent= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("search.fxml")));
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(parent,800,450);
        stage.setScene(scene);
        stage.setTitle("Products");
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
}
