package com.denik.vy.utils;

import com.denik.vy.models.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.mapping.Property;

import java.util.Properties;

public class Util {
    private static final String HOSTNAME = "localhost";
    private static final String DB_NAME = "denik_db";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "12345";
    private static final String CONNECTION_URL = "jdbc:mysql://" + HOSTNAME + ":3306/" + DB_NAME;
    public static SessionFactory DbConnect(){
        Configuration configuration = new Configuration();
        Properties property = new Properties();
        property.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        property.put(Environment.URL, CONNECTION_URL + "?useSSL=false");
        property.put(Environment.USER, USER_NAME);
        property.put(Environment.PASS, PASSWORD);
        property.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
        property.put(Environment.SHOW_SQL, "false");
        property.put(Environment.HBM2DDL_AUTO, "create-drop");
        property.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        configuration.setProperties(property);
        configuration.addAnnotatedClass(User.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        return configuration.buildSessionFactory(builder.build());

    }
}
