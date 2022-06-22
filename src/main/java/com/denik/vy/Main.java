package com.denik.vy;
import com.denik.vy.dao.UserDao;
import com.denik.vy.models.User;
import com.denik.vy.services.UserService;
import com.denik.vy.services.UserServiceImp;
import com.denik.vy.utils.Util;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserService service = new UserServiceImp();

        service.dropTable();
        service.createTable();
        service.addUser(new User("join1", "lastjoin1", (byte) 20));
        service.addUser(new User("join2", "lastjoin2", (byte) 30));
        service.addUser(new User("join3", "lastjoin3", (byte) 40));

        System.out.println();

        service.getAllUsers().forEach(System.out::println);
        service.cleanTable();
        service.dropTable();
    }
}