/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci5520.mcqueen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map.Entry;

/**
 *
 * @author sm6668
 */
public class Intro11EditionQuizDAOImpl implements Intro11EditionQuizDAO {

    @Override
    public void find(int chapterNo, int questionNo) {
        
        
        
    }

    @Override
    public void createAll(ArrayList<Intro11EditionQuiz> intro11EQs) {

        try {
            String insert_sql = SQLFactory.insertIntro11EQuiz();
            Connection conn = DAOFactory.getConnection();
            PreparedStatement statement = conn.prepareStatement(insert_sql);

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
