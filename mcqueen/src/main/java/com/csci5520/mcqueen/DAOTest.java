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

        Intro11EditionQuizDAO dao = new Intro11EditionQuizDAOImpl();
        dao.createAll(intro11EQs);

    }

}
