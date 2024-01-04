package com.example.linkposag;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class PaymentController implements Initializable {

    @FXML
    Button bank_save_button;

    @FXML
    Pane header;

    @FXML
    Text text;


    @FXML
    ToggleGroup payment_tog = new ToggleGroup();

    @FXML
    VBox installBox,redBox;



    @FXML
    RadioButton installment_ra,redemption_ra,credit_full_ra,wallet_full_ra,wallet_alipay_ra,wallet_wechat_ra,wallet_qrc_ra;

    @FXML
    ToggleGroup red_tog,install_tog;

    @FXML
    ListView<String> listview;

    //private String[] items = {"Bank A","Bank B","Bank C","Bank D","Bank E","Bank F","Bank G"};
    //private static final String API_URL = "https://jsonplaceholder.typicode.com/todos";

    public void StatusRadioButtonInstallment() throws Exception{
        installBox.disableProperty().set(true);



        //Check Status Installment RadioButton
        installment_ra.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {

                if (t1){
                    installBox.disableProperty().set(false);}
                else installBox.disableProperty().set(true);
            }
        });
       payment_tog.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
           @Override
           public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {

               if (install_tog.getSelectedToggle() != null && payment_tog.getSelectedToggle() != null) {
                   if (install_tog.getSelectedToggle().equals(installment_ra) && payment_tog.getSelectedToggle().equals(installment_ra)) {
                       installment_ra.setSelected(true);

                   }else if(install_tog.getSelectedToggle() != null) install_tog.getSelectedToggle().setSelected(false);
                   else installment_ra.setSelected(false);
                   installBox.disableProperty().set(true);
               }
           }
       });
        install_tog.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                if (installment_ra.isSelected()){
                    installment_ra.setSelected(true);


                }

            }
        });
    }

    public void StatusRadioButtonRedemption() throws Exception{
        redBox.disableProperty().set(true);



        //Check Status Installment RadioButton
        redemption_ra.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if (t1){
                redBox.disableProperty().set(false);}
                else redBox.disableProperty().set(true);
            }
        });
        payment_tog.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {

                if (red_tog.getSelectedToggle() != null && payment_tog.getSelectedToggle() != null) {
                    if (red_tog.getSelectedToggle().equals(redemption_ra) && payment_tog.getSelectedToggle().equals(redemption_ra)) {
                        redemption_ra.setSelected(true);

                    }else if(red_tog.getSelectedToggle() != null) red_tog.getSelectedToggle().setSelected(false);
                    else redemption_ra.setSelected(false);
                    redBox.disableProperty().set(true);

                }
            }
        });
        red_tog.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                if (redemption_ra.isSelected()){
                    redemption_ra.setSelected(true);


                }

            }
        });
    }


    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);

       alert.initStyle(StageStyle.UTILITY);


        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                System.out.println("OK button clicked");

            } else if (response == ButtonType.CANCEL) {
                System.out.println("Cancel button clicked");

            }

        });
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {

//            ObservableList<Item> itemList = FXCollections.observableArrayList(APIHandle.fetchDataFromApi(API_URL));
//            ObservableList<String> observableItemList = FXCollections.observableArrayList();
//
//
//            System.out.println(itemList);

            StatusRadioButtonInstallment();
            StatusRadioButtonRedemption();

            bank_save_button.setOnAction(event -> {
                showAlert(Alert.AlertType.CONFIRMATION, "Save", "Test");

            });


        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Someting Wrong is " + e.getMessage());
        }


    }


}
