/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Rostro
 */
public class DatabaseConfig {
    
    private static Connection connection;
    private static String url;
    private static String username;
    private static String password;
    private static String propfileDB = "propfileDB.properties";
    
    public static Connection getConnection() throws IOException {
        try {
            
            Properties prop = new Properties();
            prop.load(new FileInputStream(propfileDB));
            username = prop.getProperty("username");
            password = prop.getProperty("password");
            url = prop.getProperty("url");
            
            if(connection == null)
                return initializeConnection();
            return connection;
        } catch (FileNotFoundException ex) {
            return null;
        }
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
