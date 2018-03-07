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

            String chNo = Integer.toString(intro11e.getChapterNo());
            String qNo = Integer.toString(intro11e.getQuestionNo());
            String isCorrect = Integer.toString(intro11e.isCorrect());
            String ansA = Integer.toString(intro11e.getAnswerA());
            String ansB = Integer.toString(intro11e.getAnswerB());
            String ansC = Integer.toString(intro11e.getAnswerC());
            String ansD = Integer.toString(intro11e.getAnswerD());
            String ansE = Integer.toString(intro11e.getAnswerE());

            statement.setString(1, chNo);
            statement.setString(2, qNo);
            statement.setString(3, isCorrect);
            statement.setString(4, ansA);
            statement.setString(5, ansB);
            statement.setString(6, ansC);
            statement.setString(7, ansD);
            statement.setString(8, ansE);
            statement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);

        }
    }
}
