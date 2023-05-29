package com.example.demo1;

import Model.User.Admin;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 450);
            stage.setTitle("Home");
            stage.setScene(scene);
            stage.show();
        } finally {
            System.out.println("Good luck");
        }

    }

    public static void main(String[] args) {
        launch();
    }
}