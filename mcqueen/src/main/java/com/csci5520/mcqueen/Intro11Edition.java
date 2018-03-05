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
public class Intro11Edition {

    private int chapterNo, questionNo;
    private boolean isCorrect;
    private String hostname;
    private ArrayList<Boolean> answers;

    public int getChapterNo() {
        return chapterNo;
    }

    public void setChapterNo(int chapterNo) {
        this.chapterNo = chapterNo;
    }

    public int getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(int questionNo) {
        this.questionNo = questionNo;
    }

    public boolean isIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public ArrayList<Boolean> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Boolean> answers) {
        this.answers = answers;
    }

}
