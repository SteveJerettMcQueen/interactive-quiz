/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci5520.mcqueen;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sm6668
 */
public class LoadQuestionController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private DAOFactory daoFactory;
    private Intro11EditionDAO intro11EDAO;
    private Intro11EditionQuizDAO intro11EQDAO;

    @Override
    public void init() {
        daoFactory = new DAOFactory();
        intro11EQDAO = daoFactory.getIntro11EditionQuizDAO();
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

        response.setContentType("text/html;charset=UTF-8");
        try {

            // Load the question
            String chapterNo = request.getParameter("chapterNo");
            String questionNo = request.getParameter("questionNo");
            if (chapterNo != null && questionNo != null) {
                loadQuestion(request, response, chapterNo, questionNo);
            } else {
                loadQuestion(request, response, "1", "37");
            }

            // Check submitted answer
            String submission = request.getParameter("checkMyAnswer");
            String[] answers = request.getParameterValues("choices");
            String choiceType = request.getParameter("choiceType");
            if (submission != null && answers != null) {
                if (submission.equals("Check My Answer")) {
                    switch (choiceType) {
                        case "radio":
                            recordAnswer(request, answers);
//                            sendFeedBack(request, response, answers);
                            break;
                        case "checkbox":
                            recordAnswer(request, answers);
//                            sendFeedBack(request, response, answers);
                            break;
                        default:
                            System.out.println("Unknown choice type!");
                            break;
                    }
                }
            } else {
                //Send response to answer question before submission

            }

        } catch (IOException | ServletException ex) {
            System.out.println(ex);
            //Send dispacter to error page Loading question wasn't successful

        }
    }

    private void loadQuestion(HttpServletRequest request, HttpServletResponse response,
            String chapterNo, String questionNo) throws ServletException, IOException {

        Intro11EditionQuiz intro11eq = intro11EQDAO.find(chapterNo, questionNo);
        String[] question = intro11eq.getQuestion().split("\n");
        Map<String, String> choices = intro11eq.getChoices();
        choices.values().removeIf(Objects::isNull);
        String key = intro11eq.getAnswerKey();
        String hint = intro11eq.getHint();
        String choiceType = key.length() == 1 ? "radio" : "checkbox";

        request.setAttribute("chapterNo", chapterNo);
        request.setAttribute("questionNo", questionNo);
        request.setAttribute("question", question);
        request.setAttribute("choices", choices);
        request.setAttribute("choiceType", choiceType);
        request.setAttribute("key", key);
        request.setAttribute("hint", hint);
        request.getRequestDispatcher("LoadQuestion.jsp").forward(request, response);
    }

    private void recordAnswer(HttpServletRequest request, String[] answers)
            throws ServletException, IOException {
        
        int chNo = Integer.parseInt(request.getParameter("chapterNo"));
        int qNo = Integer.parseInt(request.getParameter("questionNo"));
        String key = request.getParameter("key");

        Intro11Edition intro11e = new Intro11Edition();
        intro11e.setChapterNo(chNo);
        intro11e.setQuestionNo(qNo);
        for (String answer : answers) {
            switch (answer) {
                case "a":
                    intro11e.setAnswerA(1);
                    break;
                case "b":
                    intro11e.setAnswerB(1);
                    break;
                case "c":
                    intro11e.setAnswerC(1);
                    break;
                case "d":
                    intro11e.setAnswerD(1);
                    break;
                case "e":
                    intro11e.setAnswerE(1);
                    break;
                default:
                    System.out.println("Unknown answer!");
                    break;
            }
        }

        if (String.join("", answers).equals(key)) {
            intro11e.setIsCorrect(1);
        } else {
            intro11e.setIsCorrect(0);
        }

        //Store in database
        intro11EDAO.create(intro11e);
    }

    private void sendFeedBack(HttpServletRequest request, HttpServletResponse response, String[] answers)
            throws ServletException, IOException {
//        
//        String key = request.getParameter("key");
//        String ans = String.join("", answers);
//        if (ans.equals(key)) {
//            request.setAttribute("feedBack", "Your answer is correct!");
//            request.getRequestDispatcher("LoadQuestion.jsp").forward(request, null);
//        } else {
//            request.setAttribute("feedBack", "Your answer " + ans + " is incorrect!");
//            request.getRequestDispatcher("LoadQuestion.jsp").forward(request, null);
//        }
    }

}
