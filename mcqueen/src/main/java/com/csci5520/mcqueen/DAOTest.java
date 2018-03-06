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

    }

}
