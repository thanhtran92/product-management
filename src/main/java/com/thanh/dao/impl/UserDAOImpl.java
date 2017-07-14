package com.thanh.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.thanh.dao.ConnectionFactory;
import com.thanh.dao.UserDAO;
import com.thanh.model.User;

public class UserDAOImpl implements UserDAO {

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        User user = null;
        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
        Connection connection = ConnectionFactory.connect();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String _user = resultSet.getString("username");
                String _pass = resultSet.getString("password");
                user = new User(_user, _pass);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

}
