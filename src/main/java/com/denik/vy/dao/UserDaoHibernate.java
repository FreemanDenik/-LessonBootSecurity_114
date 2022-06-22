package com.denik.vy.dao;

import com.denik.vy.models.User;
import com.denik.vy.utils.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserDaoHibernate implements UserDao {
    private SessionFactory sessionFactory = null;
    private Session session = null;

    public UserDaoHibernate() {
        this.sessionFactory = Util.DbConnect();
        session = sessionFactory.openSession();
    }

    @Override
    public void createTable() throws SQLException{
        if (sessionFactory.isClosed() || !session.isOpen()) {
            sessionFactory = Util.DbConnect();
            session = sessionFactory.openSession();
        }
    }

    @Override
    public void dropTable() throws SQLException{
        if (Objects.nonNull(session) && session.isOpen()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.createNativeQuery("DROP TABLE IF EXISTS users").executeUpdate();

                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
            }
            session.close();
        }
    }

    @Override

    public void addUser(User user) throws SQLException {
        Transaction transaction = session.beginTransaction();
        try {
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    @Override

    public List<User> getAllUsers() throws SQLException {
        return session.createQuery("SELECT u FROM User u", User.class).stream().collect(Collectors.toList());
    }

    @Override
    public void removeUser(long userId) throws SQLException {
        User user = session.load(User.class, userId);
        Transaction transaction = session.beginTransaction();
        try {
            session.remove(user);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }

    }

    @Override
    public void cleanTable() throws SQLException {

        Transaction transaction = session.beginTransaction();
        try {
            //session.createQuery("DELETE FROM User").executeUpdate();
            session.createNativeQuery("TRUNCATE TABLE users").executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }


    }
}
