/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci5520.mcqueen;

import java.util.LinkedHashMap;

/**
 *
 * @author sm6668
 */
public class Intro11EditionQuiz {

    private String chapterNo, questionNo;
    private String question;
    private LinkedHashMap<String, String> choices;
    private String answerKey;
    private String hint;

    public String getChapterNo() {
        return chapterNo;
    }

    public void setChapterNo(String chapterNo) {
        this.chapterNo = chapterNo;
    }

    public String getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(String questionNo) {
        this.questionNo = questionNo;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public LinkedHashMap<String, String> getChoices() {
        return choices;
    }

    public void setChoices(LinkedHashMap<String, String> choices) {
        this.choices = choices;
    }

    public String getAnswerKey() {
        return answerKey;
    }

    public void setAnswerKey(String answerKey) {
        this.answerKey = answerKey;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    @Override
    public String toString() {
        return "chapterNo: " + chapterNo
                + "\nquestionNo: " + questionNo
                + "\nquestion: " + question
                + "\nchoices: " + choices
                + "\nanswerKey: " + answerKey
                + "\nhint: " + hint;
    }

}
