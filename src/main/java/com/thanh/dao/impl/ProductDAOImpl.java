package com.thanh.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.StringUtils;
import com.thanh.dao.ConnectionFactory;
import com.thanh.dao.ProductDAO;
import com.thanh.model.Product;

/**
 * This class implements CRUD database operations for the product table in the
 * database.
 * 
 * @author thanhtran
 *
 */
public class ProductDAOImpl implements ProductDAO {

    @Override
    public Product getProduct(int id) {
        Product product = null;
        String sql = "SELECT * FROM product WHERE id = ?";
        Connection connection = ConnectionFactory.connect();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String price = resultSet.getString("price");
                String category = resultSet.getString("category");
                String description = resultSet.getString("description");
                product = new Product(id, name, price, category, description);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product";
        Connection connection = ConnectionFactory.connect();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String price = resultSet.getString("price");
                String category = resultSet.getString("category");
                String description = resultSet.getString("description");
                Product product = new Product(id, name, price, category, description);
                products.add(product);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    @Override
    public boolean insertProduct(Product p) {
        boolean rowInserted = false;
        String sql = "INSERT INTO product (name, price, category, description) VALUES (?, ?, ?, ?)";
        Connection connection = ConnectionFactory.connect();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, p.getName());
            statement.setString(2, p.getPrice());
            statement.setString(3, p.getCategory());
            statement.setString(4, p.getDescription());

            rowInserted = statement.executeUpdate() > 0;

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowInserted;
    }

    @Override
    public boolean updateProduct(Product p) {
        boolean rowUpdated = false;
        String sql = "UPDATE product SET name = ?, price = ?, category = ?, description = ? WHERE id = ?";
        Connection connection = ConnectionFactory.connect();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, p.getName());
            statement.setString(2, p.getPrice());
            statement.setString(3, p.getCategory());
            statement.setString(4, p.getDescription());
            statement.setInt(5, p.getId());

            rowUpdated = statement.executeUpdate() > 0;

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowUpdated;
    }

    @Override
    public boolean deleteProduct(Product p) {
        boolean rowDeleted = false;
        String sql = "DELETE FROM product WHERE id = ?";
        Connection connection = ConnectionFactory.connect();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, p.getId());

            rowDeleted = statement.executeUpdate() > 0;

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowDeleted;
    }

    @Override
    public List<Product> getProduct(String searchName, String searchCategory, String searchMinPrice, String searchMaxPrice) {
        List<String> params = new ArrayList<String>();
        StringBuilder sqlBuilder = new StringBuilder()
            .append("SELECT * ")
            .append("FROM product ")
            .append("WHERE 1=1 ");

        if (!StringUtils.isNullOrEmpty(searchName)) {
            sqlBuilder.append("AND name LIKE ? ");
            params.add("%" + searchName + "%");
        }

        if (!StringUtils.isNullOrEmpty(searchCategory)) {
            sqlBuilder.append("AND category = ? ");
            params.add(searchCategory);
        }

        if (!StringUtils.isNullOrEmpty(searchMinPrice) && !StringUtils.isNullOrEmpty(searchMaxPrice)) {
            sqlBuilder.append("AND price BETWEEN ? AND ?");
            params.add(searchMinPrice);
            params.add(searchMaxPrice);
        }

        String sql = sqlBuilder.toString() + " ORDER BY name, price";

        List<Product> products = new ArrayList<>();
        Connection connection = ConnectionFactory.connect();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            for (int i = 0; i < params.size(); i++) {
                statement.setString(i + 1, params.get(i));
            }
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int ProductId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String price = resultSet.getString("price");
                String category = resultSet.getString("category");
                String description = resultSet.getString("description");
                Product product = new Product(ProductId, name, price, category, description);
                products.add(product);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

}
