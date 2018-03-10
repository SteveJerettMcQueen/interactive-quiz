/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci5520.mcqueen;

import com.csci5520.mcqueen.DAOFactory;
import com.csci5520.mcqueen.Intro11EditionQuiz;
import com.csci5520.mcqueen.SQL;
import com.csci5520.mcqueen.Intro11EditionQuizDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 *
 * @author sm6668
 */
public class Intro11EditionQuizDAOImpl implements Intro11EditionQuizDAO {

    private final SQL sql;
    private final DAOFactory daoFactory;

    public Intro11EditionQuizDAOImpl(DAOFactory daoFactory) {
        sql = new SQL();
        this.daoFactory = daoFactory;
    }

    @Override
    public Intro11EditionQuiz find(String chapterNo, String questionNo) {
        Intro11EditionQuiz intro11EQ = null;

        try {
            String findSQL = sql.findIntro11EQ();
            Connection conn = daoFactory.getConnection();
            PreparedStatement statement = conn.prepareStatement(findSQL);

            statement.setString(1, chapterNo);
            statement.setString(2, questionNo);
            ResultSet rs = statement.executeQuery();

            intro11EQ = new Intro11EditionQuiz();
            LinkedHashMap<String, String> choices;
            if (rs.next()) {
                intro11EQ.setChapterNo(rs.getString("chapterNo"));
                intro11EQ.setQuestionNo(rs.getString("questionNo"));
                intro11EQ.setQuestion(rs.getString("question"));
                choices = new LinkedHashMap();
                choices.put("a", rs.getString("choiceA"));
                choices.put("b", rs.getString("choiceB"));
                choices.put("c", rs.getString("choiceC"));
                choices.put("d", rs.getString("choiceD"));
                choices.put("e", rs.getString("choiceE"));
                intro11EQ.setChoices(choices);
                intro11EQ.setAnswerKey(rs.getString("answerKey"));
                intro11EQ.setHint(rs.getString("hint"));
            }
            return intro11EQ;

        } catch (SQLException ex) {
            System.out.println(ex);
            return intro11EQ;
        }
    }

    @Override
    public void createAll(ArrayList<Intro11EditionQuiz> intro11EQs) {

        try {
            String insertSQL = sql.insertIntro11EQ();
            Connection conn = daoFactory.getConnection();
            PreparedStatement statement = conn.prepareStatement(insertSQL);

            String[] choices = {null, null, null, null, null};
            ArrayList<Entry<String, String>> choicesEntry;
            for (int i = 0; i < intro11EQs.size(); i++) {
                Intro11EditionQuiz intro11eq = intro11EQs.get(i);
                statement.setString(1, intro11eq.getChapterNo());
                statement.setString(2, intro11eq.getQuestionNo());
                statement.setString(3, intro11eq.getQuestion());

                choicesEntry = new ArrayList(intro11eq.getChoices().entrySet());
                for (int j = 0; j < choicesEntry.size(); j++) {
                    choices[j] = choicesEntry.get(j).getValue();
                }
                statement.setString(4, choices[0]);
                statement.setString(5, choices[1]);
                statement.setString(6, choices[2]);
                statement.setString(7, choices[3]);
                statement.setString(8, choices[4]);
                statement.setString(9, intro11eq.getAnswerKey());
                statement.setString(10, intro11eq.getHint());
                statement.executeUpdate();
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

}
