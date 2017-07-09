package com.thanh.dao;

import java.util.List;

import com.thanh.model.Product;

/**
 * This DAO class provides CRUD database operations for the product table in the
 * database.
 * 
 * @author thanhtran
 *
 */
public interface ProductDAO {

    Product getProduct(int id);

    List<Product> getAllProducts();

    boolean insertProduct(Product p);

    boolean updateProduct(Product p);

    boolean deleteProduct(Product p);
}
