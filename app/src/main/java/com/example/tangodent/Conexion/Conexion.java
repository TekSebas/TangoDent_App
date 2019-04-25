package com.example.tangodent.Conexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    
    private static final String URL = "jdbc:mysql://localhost:3306/tangodentdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static Connection connection = null;

    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
           connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Conexion realizada con exito");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Conexion fallida");
        }
        return connection;
    }
    public static void closeConnection(){
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}