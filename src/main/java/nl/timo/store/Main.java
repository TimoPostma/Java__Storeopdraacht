package nl.timo.store;/**
 * @author Timo Postma
 * @version 1.0
 * @since feb 2020
 * MIT License
 * Copyright 2020 Voornaam Achternaam
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("store.fxml"));

        primaryStage.setTitle("Store Front");
        primaryStage.setScene(new Scene(root));

        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}

