/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci5520.mcqueen;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author sm6668
 */
public class SQLFactory {

    private static final String PROPERTY_FILE = "/sql.xml";
    private static final Properties PROPERTIES = new Properties();

    static {
        try {
            InputStream in = SQLFactory.class.getResourceAsStream(PROPERTY_FILE);
            PROPERTIES.loadFromXML(in);
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }

    public static String insertIntro11EQuiz() {
        return PROPERTIES.getProperty("insert.intro11equiz");
    }

    public static void main(String[] args) {
        System.out.println(SQLFactory.insertIntro11EQuiz());
    }

}
