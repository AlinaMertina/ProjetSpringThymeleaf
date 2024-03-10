
package com.pack.senderMail.Work;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionPostgres{

 public ConnectionPostgres(){}

 public Connection getconnexion(){
    try {
        String url = "jdbc:postgresql://localhost:5432/gestionvehiculeevaluation";
        String username = "mertina";
        String password = "root";
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    return null;
    
 }

}