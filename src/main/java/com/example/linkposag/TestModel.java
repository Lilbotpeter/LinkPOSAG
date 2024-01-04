package com.example.linkposag;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TestModel {
    public StringProperty bank_name;
    public StringProperty bank_code;
    public StringProperty pro_installment;
    public StringProperty pro_redemption;
    public BooleanProperty isInstallment;
    public BooleanProperty isRedemption;



    public TestModel(String bankname,String bankcode,String pro_in,String pro_red,Boolean is_in,Boolean is_red){
        this.bank_name = new SimpleStringProperty(bankname);
        this.bank_code = new SimpleStringProperty(bankcode);
        this.pro_installment = new SimpleStringProperty(pro_in);
        this.pro_redemption = new SimpleStringProperty(pro_red);
        this.isInstallment = new SimpleBooleanProperty(is_in);
        this.isRedemption = new SimpleBooleanProperty(is_red);


    }

    public String getBank_name() {
        return bank_name.get();
    }

    public String getBank_code() {
        return bank_code.get();
    }

    public String getPro_installment() {
        return pro_installment.get();
    }

    public String getPro_redemption() {
        return pro_redemption.get();
    }


}

