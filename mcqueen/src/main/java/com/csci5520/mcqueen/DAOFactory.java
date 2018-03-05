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

    private static Connection CONN = null;
    private static final String PROPERTY_FILE = "/dao.xml";
    private static final String PROPERTY_URL = "mysql.jdbc.url";
    private static final String PROPERTY_DRIVER = "mysql.jdbc.driver";
    private static final String PROPERTY_USERNAME = "mysql.jdbc.username";
    private static final String PROPERTY_PASSWORD = "mysql.jdbc.password";

    static {
        try {
            Properties prop = new Properties();
            InputStream in = DAOFactory.class.getResourceAsStream(PROPERTY_FILE);
            prop.loadFromXML(in);

            String url = prop.getProperty(PROPERTY_URL);
            String driver = prop.getProperty(PROPERTY_DRIVER);
            String username = prop.getProperty(PROPERTY_USERNAME);
            String password = prop.getProperty(PROPERTY_PASSWORD);

            Class.forName(driver);
            CONN = DriverManager.getConnection(url, username, password);
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }

    }

    public static Connection getConnection() {
        return CONN;
    }

    public static void main(String[] args) {
        System.out.println(DAOFactory.getConnection());
    }
}
