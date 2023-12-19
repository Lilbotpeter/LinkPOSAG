package com.example.linkposag;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PaymentController extends Application  {

    @FXML
    Button payment_button,banks_button,connectio_button,admin_button;

    public void toBanksPage() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("bank-pg.fxml"));

        Stage window = (Stage)banks_button.getScene().getWindow() ;
        final Scene scene = new Scene(root,1266,767);
        window.setFullScreen(false);

        window.setScene(scene);
    }


    @Override
    public void start(Stage stage) throws Exception {

    }
}
