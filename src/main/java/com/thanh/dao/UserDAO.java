package com.thanh.dao;

import com.thanh.model.User;

/**
 * This DAO interface provides CRUD database operations for the user table in
 * the database.
 * 
 * @author thanhtran
 *
 */
public interface UserDAO {

    User findByUsernameAndPassword(String username, String password);

}
