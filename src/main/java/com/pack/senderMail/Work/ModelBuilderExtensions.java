package com.pack.senderMail.Work;

import java.sql.*;

public class ModelBuilderExtensions {
    public static String useCustomSequence(String word) {
        long number=0L;
        try {
           
                ConnectionPostgres con = new ConnectionPostgres();
                Connection connection = con.getconnexion();
                    Statement statement = connection.createStatement();
                    String query = "SELECT nextval('"+word+"_sequence') as id";
                    ResultSet resultSet = statement.executeQuery(query);
                    while (resultSet.next()) {
                      number=resultSet.getLong("id");
                    }
                    resultSet.close();
                    statement.close();
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        String chiffre = "0000000";
        String sequenceName = word.substring(0, Math.min(word.length(), 4)).toUpperCase();
        String valueNumber = String.valueOf(number);
        System.out.println(valueNumber.length());
        String value = chiffre.substring(0, chiffre.length()-valueNumber.length()).toUpperCase();
        System.out.println(sequenceName + chiffre + valueNumber);
        return sequenceName + value + valueNumber;
    }
    public ModelBuilderExtensions(){

    }
}
