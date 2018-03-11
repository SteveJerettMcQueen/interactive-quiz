/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci5520.mcqueen;

import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Steve
 */
public class QuestionForm extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private DAOFactory daoFactory;
    private Intro11EditionDAO intro11EDAO;
    private Intro11Edition intro11E;

    @Override
    public void init() {
        daoFactory = new DAOFactory();
        intro11EDAO = daoFactory.getIntro11EditionDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String chapterNo = request.getParameter("chapterNo");
        String questionNo = request.getParameter("questionNo");
        String answerKey = request.getParameter("answerKey");
        String hint = request.getParameter("hint");
        String answers = request.getParameter("answers");
        String submission = request.getParameter("checkMyAnswer");
        if (submission != null && answers != null) {
            if (submission.equals("Check My Answer")) {
                recordAnswer(chapterNo, questionNo, answers, answerKey);
                sendFeedBack(response, answers, answerKey, hint);
            }
        }

    }

    private void recordAnswer(String chapterNo, String questionNo,
            String answers, String answerKey) {

        intro11E = new Intro11Edition();
        intro11E.setChapterNo(Integer.parseInt(chapterNo));
        intro11E.setQuestionNo(Integer.parseInt(questionNo));
        intro11E.setIsCorrect(answers.equals(answerKey) ? 1 : 0);
        for (int i = 0; i < answers.length(); i++) {
            switch (answers.charAt(i)) {
                case 'a':
                    intro11E.setAnswerA(1);
                    break;
                case 'b':
                    intro11E.setAnswerB(1);
                    break;
                case 'c':
                    intro11E.setAnswerC(1);
                    break;
                case 'd':
                    intro11E.setAnswerD(1);
                    break;
                case 'e':
                    intro11E.setAnswerE(1);
                    break;
                default:
                    System.out.println("Unknown answer!");
                    break;
            }
        }

        //Store in database
        intro11EDAO.create(intro11E);
    }

    private void sendFeedBack(HttpServletResponse response, String answers, String answerKey, String hint)
            throws ServletException, IOException {

        response.setContentType("application/json;charset=UTF-8");
        String[] feedBack = new String[4];
        feedBack[2] = hint;
        feedBack[3] = answerKey;
        if (answers.equals(answerKey)) {
            feedBack[0] = "correct";
            feedBack[1] = "Your answer is correct!";
        } else {
            feedBack[0] = "incorrect";
            feedBack[1] = "Your answer " + answers + " is incorrect!";
        }
        response.getWriter().write(new Gson().toJson(feedBack));
    }

}
