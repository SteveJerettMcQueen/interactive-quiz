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
public class DAOTest {

    public static void main(String[] args) {
        ChaptersContent content = new ChaptersContent();
        ArrayList<Intro11EditionQuiz> intro11EQs = content.getChaptersContent();

        DAOFactory daoFactory = new DAOFactory();
        Intro11EditionQuizDAO intro11EQDAO = daoFactory.getIntro11EditionQuizDAO();
        intro11EQDAO.createAll(intro11EQs);

//        Intro11EditionQuiz intro11eq = intro11EQDAO.find("1", "3");
//        System.out.println(intro11eq);
//        Intro11EditionDAO intro11EDAO = daoFactory.getIntro11EditionDAO();
//        Intro11Edition intro11e = new Intro11Edition();
//        intro11e.setChapterNo(1);
//        intro11e.setQuestionNo(1);
//        intro11e.setIsCorrect(1);
//        intro11e.setUsername("Steve");
//        intro11e.setAnswerA(1);
//        intro11e.setAnswerB(1);
//        intro11e.setAnswerC(1);
//        intro11e.setAnswerD(1);
//        intro11e.setAnswerE(1);
//        intro11EDAO.create(intro11e);
    }

}
