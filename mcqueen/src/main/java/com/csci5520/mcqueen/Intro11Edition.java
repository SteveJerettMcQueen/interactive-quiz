/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci5520.mcqueen;

/**
 *
 * @author sm6668
 */
public class Intro11Edition {

    private int chapterNo, questionNo;
    private int isCorrect;
    private String hostname, username;
    private int answerA, answerB, answerC,
            answerD, answerE;

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

    public int isCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(int isCorrect) {
        this.isCorrect = isCorrect;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAnswerA() {
        return answerA;
    }

    public void setAnswerA(int answerA) {
        this.answerA = answerA;
    }

    public int getAnswerB() {
        return answerB;
    }

    public void setAnswerB(int answerB) {
        this.answerB = answerB;
    }

    public int getAnswerC() {
        return answerC;
    }

    public void setAnswerC(int answerC) {
        this.answerC = answerC;
    }

    public int getAnswerD() {
        return answerD;
    }

    public void setAnswerD(int answerD) {
        this.answerD = answerD;
    }

    public int getAnswerE() {
        return answerE;
    }

    public void setAnswerE(int answerE) {
        this.answerE = answerE;
    }

    @Override
    public String toString() {
        return "chapterNo: " + chapterNo
                + "\nquestionNo: " + questionNo
                + "\nisCorrect: " + isCorrect
                + "\nanswerA: " + answerA
                + "\nanswerB: " + answerB
                + "\nanswerC: " + answerC
                + "\nanswerD: " + answerD
                + "\nanswerE: " + answerE;

    }
}
