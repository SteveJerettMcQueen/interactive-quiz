/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci5520.mcqueen;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author sm6668
 */
public class DAOFactory {

    private Connection conn = null;
    private static final String PROPERTY_FILE = "/dao.xml";
    private static final String PROPERTY_URL = "mysql.jdbc.url";
    private static final String PROPERTY_DRIVER = "mysql.jdbc.driver";
    private static final String PROPERTY_USERNAME = "mysql.jdbc.username";
    private static final String PROPERTY_PASSWORD = "mysql.jdbc.password";

    public DAOFactory() {
        try {
            Properties prop = new Properties();
            InputStream in = DAOFactory.class.getResourceAsStream(PROPERTY_FILE);
            prop.loadFromXML(in);

            String url = prop.getProperty(PROPERTY_URL);
            String driver = prop.getProperty(PROPERTY_DRIVER);
            String username = prop.getProperty(PROPERTY_USERNAME);
            String password = prop.getProperty(PROPERTY_PASSWORD);

            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }

    }

    public Connection getConnection() {
        return conn;
    }

    public Intro11EditionDAO getIntro11EditionDAO() {
        return new Intro11EditionDAOImpl(this);
    }

    public Intro11EditionQuizDAO getIntro11EditionQuizDAO() {
        return new Intro11EditionQuizDAOImpl(this);
    }

    public static void main(String[] args) {
        DAOFactory daoFactory = new DAOFactory();
        System.out.println(daoFactory.getConnection());
    }
}
