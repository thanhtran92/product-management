package com.thanh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

/**
 * This class is used to get the connection from database
 * 
 * @author thanhtran
 *
 */
public class ConnectionFactory {

    public static final String URL = "jdbc:mysql://192.168.1.2:3306/product_management";
    public static final String USER = "root";
    public static final String PASS = "888888";

    public Connection getConnection() {
        try {
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }
}
