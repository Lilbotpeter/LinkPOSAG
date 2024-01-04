package com.example.linkposag;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;
import org.kordamp.bootstrapfx.scene.layout.Panel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BanksController  implements Initializable {


    @FXML
    Pane newbank_pane;

    @FXML
    Text bankCode;

    @FXML
    Label bankName;

    @FXML
    GridPane grid1;

    ObservableList<Pane> observableList = FXCollections.observableArrayList();

    public Stage newBank() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("bank-insert-card.fxml"));
        Pane cardPane = FXMLLoader.load(getClass().getResource("card-bank.fxml"));

        Stage bankstage = new Stage();
        bankstage.setWidth(800 );
        bankstage.setHeight(480);
        bankstage.centerOnScreen();

        Scene scene = new Scene(root);
        JMetro jMetro = new JMetro(Style.LIGHT);
        jMetro.setScene(scene);
        bankstage.initStyle(StageStyle.UNDECORATED);
        bankstage.setScene(scene);


        Pane pane = new Pane();
        pane.getChildren().add(cardPane);
        grid1.add(pane,2,0);




        return bankstage;
    }

    public void showNewBankDialog() throws IOException {
        Stage bankStage = newBank();
        bankStage.initModality(Modality.APPLICATION_MODAL);
        bankStage.initOwner(newbank_pane.getScene().getWindow());
        bankStage.showAndWait();
    }

//    public void addCardBank (GridPane gridPane,Pane cardPane){
//        int col = 2;
//        int row = 0;
//
//        while (hasNode(grid1,col,row)){
//            col ++ ;
//            if (col == gridPane.getColumnCount()){
//                if (col == gridPane.getColumnCount()){
//                    col =0;
//                    row++;
//                }
//            }
//        }
//
//
//
//
//    }
//
//    private boolean hasNode(GridPane grid1,int col,int row){
//        for (int i = 0; i < grid1.getChildren().size();i++){
//            if (GridPane.getColumnIndex(grid1.getChildren().get(i)) == col &&
//                GridPane.getColumnIndex(grid1.getChildren().get(i)) == row
//            ){
//                return true;
//            }
//        }
//
//        return false;
//    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TestModel model = new TestModel("Kbank","K123456","KI123456","KP123456",true,true);
        String bankname = model.getBank_name();
        String bankcode = model.getBank_code();

        bankName.setText(bankname);
        bankCode.setText(bankcode);





    }


}
