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
public class SQL {

    private static final String PROPERTY_FILE = "/sql.xml";
    private static final Properties PROPERTIES = new Properties();

    public SQL() {
        try {
            InputStream in = SQL.class.getResourceAsStream(PROPERTY_FILE);
            PROPERTIES.loadFromXML(in);
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }

    public String insertIntro11E() {
        return PROPERTIES.getProperty("insert.intro11e");
    }

    public String findAllChapterNos() {
        return PROPERTIES.getProperty("findAll.chapter.nos");
    }

    public String findQuestionNos() {
        return PROPERTIES.getProperty("find.question.nos");
    }

    public String findAllQuestionNos() {
        return PROPERTIES.getProperty("findAll.question.nos");
    }

    public String findIntro11EQ() {
        return PROPERTIES.getProperty("find.intro11eq");
    }

    public String insertIntro11EQ() {
        return PROPERTIES.getProperty("insert.intro11eq");
    }

    public static void main(String[] args) {
        SQL sql = new SQL();
        System.out.println(sql.findIntro11EQ());
        System.out.println(sql.insertIntro11EQ());
    }

}
