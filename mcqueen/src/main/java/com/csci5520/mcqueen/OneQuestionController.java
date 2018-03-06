/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci5520.mcqueen;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sm6668
 */
public class OneQuestionController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private DAOFactory daoFactory;
    private Intro11EditionQuizDAO intro11EQDAO;

    @Override
    public void init() {
        daoFactory = new DAOFactory();
        intro11EQDAO = daoFactory.getIntro11EditionQuizDAO();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Intro11EditionQuiz intro11eq = null;
        try {

            String chapterNo = request.getParameter("chapterNo");
            String questionNo = request.getParameter("questionNo");
            intro11eq = intro11EQDAO.find(chapterNo, questionNo);
            request.setAttribute("intro11eq", intro11eq);
            request.getRequestDispatcher("OneQuestion.jsp").forward(request, response);

        } catch (IOException | ServletException ex) {
            System.out.println(ex);
        }
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

}
