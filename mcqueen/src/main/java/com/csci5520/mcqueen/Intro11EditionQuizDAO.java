/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci5520.mcqueen;

import java.util.ArrayList;

/**
 *
 * @author sm6668
 */
public interface Intro11EditionQuizDAO {

    public ArrayList<String> findAllChapterNos();

    public ArrayList<String> findQuestionNosBy(String chapterNo);

    public ArrayList<String[]> findAllQuestionNos();

    public Intro11EditionQuiz findQuizBy(String chapterNo, String questionNo);

    public void createAll(ArrayList<Intro11EditionQuiz> intro11EQs);

}
