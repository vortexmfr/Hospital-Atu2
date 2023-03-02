/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Rostro
 */
public class dbConfig {
    
    private static Connection connection;
    private static String url =  "jdbc:mysql://localhost:3306/hospital2";
    private static String username = "dorime";
    private static String password = "dorime";
    
    public static Connection getConnection() {
        if(connection == null)
            return initializeConnection();
        return connection;
    }

    private static Connection initializeConnection() {
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
      public static void closeConnection() {
        try {
        connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
