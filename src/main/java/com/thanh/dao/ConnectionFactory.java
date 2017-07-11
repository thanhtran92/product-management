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

    private static final String URL = "jdbc:mysql://192.168.1.2:3306/product_management";
    private static final String USER = "root";
    private static final String PASS = "888888";
    private static Connection jdbcConnection;

    public static Connection connect() {
        try {
            if (jdbcConnection == null || jdbcConnection.isClosed()) {
                DriverManager.registerDriver(new Driver());
                jdbcConnection = DriverManager.getConnection(URL, USER, PASS);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
        return jdbcConnection;
    }

}
