package com.example.linkposag;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getDatabaseLink(){
        String databaseName = "";
        String databaseUsername = "";
        String databasePassword = "";
        String url = "--URL---"+databaseName;

        try {
            Class.forName("com.example.linkposag");
            databaseLink = DriverManager.getConnection(url,databaseUsername,databasePassword);


        }catch (Exception e){
            e.printStackTrace();
        }
        return databaseLink;
    }

}
