package com.example.linkposag;

import javafx.application.Application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;

import java.io.IOException;

public class LinkPOSApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main-pg.fxml"));



        Screen screen = Screen.getPrimary();
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        // Create JMetro instance with Light Style
        JMetro jMetro = new JMetro(Style.LIGHT);
        jMetro.setScene(scene);

        stage.setTitle("LinkPOS Agent");
        stage.setMaximized(true);
        stage.setX(screen.getBounds().getMaxX());
        stage.setY(screen.getBounds().getMinY());
        stage.setWidth(screen.getBounds().getWidth());
        stage.setHeight(screen.getBounds().getHeight());
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}