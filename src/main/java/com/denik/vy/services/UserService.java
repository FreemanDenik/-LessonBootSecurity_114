package com.denik.vy.services;

import com.denik.vy.models.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    void createTable() throws SQLException;

    void dropTable() throws SQLException;

    void addUser(User user) throws SQLException;

    List<User> getAllUsers() throws SQLException;

    void removeUser(int userId) throws SQLException;

    void cleanTable() throws SQLException;
}
