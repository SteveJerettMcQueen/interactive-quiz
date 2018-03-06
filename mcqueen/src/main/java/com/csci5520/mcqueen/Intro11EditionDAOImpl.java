/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci5520.mcqueen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author sm6668
 */
public class Intro11EditionDAOImpl implements Intro11EditionDAO {

    private final SQL sql;
    private final DAOFactory daoFactory;

    public Intro11EditionDAOImpl(DAOFactory daoFactory) {
        sql = new SQL();
        this.daoFactory = daoFactory;
    }

    @Override
    public void create(Intro11Edition intro11e) {

        try {
            String insertSQL = sql.insertIntro11E();
            Connection conn = daoFactory.getConnection();
            PreparedStatement statement = conn.prepareStatement(insertSQL);
//            statement.setString(1, intro11e.getChapterNo());
//            statement.setString(2, intro11e.getQuestionNo());
//            statement.setString(3, intro11e.isCorrect());
//            statement.setString(4, intro11e.getAnswerA());
//            statement.setString(5, intro11e.getAnswerB());
//            statement.setString(6, intro11e.getAnswerC());
//            statement.setString(7, intro11e.getAnswerD());
//            statement.setString(8, intro11e.getAnswerE());

        } catch (SQLException ex) {

        }
    }
}
