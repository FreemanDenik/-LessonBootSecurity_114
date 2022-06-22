package com.denik.vy.services;

import com.denik.vy.dao.UserDao;
import com.denik.vy.dao.UserDaoHibernate;
import com.denik.vy.models.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImp implements UserService {
    private static final UserDao dao = new UserDaoHibernate();
    @Override
    public void createTable() throws SQLException {
        dao.createTable();
    }

    @Override
    public void dropTable() throws SQLException {
        dao.dropTable();
    }

    @Override
    public void addUser(User user) throws SQLException {
        dao.addUser(user);

        System.out.printf("User %s добалвен в базу\n", user.getName());
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        return dao.getAllUsers();
    }

    @Override
    public void removeUser(int userId) throws SQLException {
        dao.removeUser(userId);
    }

    @Override
    public void cleanTable() throws SQLException {
        dao.cleanTable();
    }
}
