package com.csci5520.mcqueen;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sm6668
 */
public class LoadQuestion extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private DAOFactory daoFactory;
    private Intro11EditionQuizDAO intro11EQDAO;
    private Intro11EditionQuiz intro11EQ;

    @Override
    public void init() {
        daoFactory = new DAOFactory();
        intro11EQDAO = daoFactory.getIntro11EditionQuizDAO();
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
        ServletContext config = this.getServletContext();
        String chapterNo = config.getInitParameter("CHAPTER_NO");
        String questionNo = config.getInitParameter("QUESTION_NO");

        if (chapterNo != null && questionNo != null) {
            intro11EQ = intro11EQDAO.find(chapterNo, questionNo);
            String[] question = intro11EQ.getQuestion().split("\n");
            String[] questPart = Arrays.copyOfRange(question, 0, 1);
            String[] questPart2 = Arrays.copyOfRange(question, 1, question.length);
            StringBuilder builder = new StringBuilder();
            for (String s : questPart2) {
                builder.append(s);
                builder.append("\n");
            }
            String questPart2Str = builder.toString();

            Map<String, String> choices = intro11EQ.getChoices();
            choices.values().removeIf(Objects::isNull);
            String choiceType = intro11EQ.getAnswerKey().length() == 1 ? "radio" : "checkbox";

            request.setAttribute("intro11EQ", intro11EQ);
            request.setAttribute("questionPart", questPart[0]);
            request.setAttribute("questionPart2", questPart2Str);
            request.setAttribute("choices", choices);
            request.setAttribute("choiceType", choiceType);
            request.getRequestDispatcher("OneQuestion.jsp").forward(request, response);

        }
    }

}
