package com.csci5520.mcqueen;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
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
public class LoadQuestion extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private String initChapterNo, initQuestionNo;
    private DAOFactory daoFactory;
    private Intro11EditionQuizDAO intro11EQDAO;
    private Intro11EditionQuiz intro11EQ;

    @Override
    public void init() {
        initChapterNo = this.getInitParameter("CHAPTER_NO");
        initQuestionNo = this.getInitParameter("QUESTION_NO");
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
        String chapterNo = request.getParameter("chapterNo");
        String questionNo = request.getParameter("questionNo");
        String submission = request.getParameter("getQuestion");
        if (submission != null && chapterNo != null && questionNo != null) {
            if (submission.equals("Get Question")) {
                loadQuestion(request, response, chapterNo, questionNo);
            }
        } else if (initChapterNo != null && initQuestionNo != null) {
            loadQuestion(request, response, initChapterNo, initQuestionNo);
        } else {
            request.setAttribute("error", "Chapter and question number does not exist!");
            request.getRequestDispatcher("LoadError.jsp").forward(request, response);
        }
    }

    private void loadQuestion(HttpServletRequest request, HttpServletResponse response,
            String chapterNo, String questionNo) throws ServletException, IOException {

        List<String> chapterNos = intro11EQDAO.findAllChapterNos();
        List<String> questionNos = intro11EQDAO.findQuestionNosBy(chapterNo);
        intro11EQ = intro11EQDAO.findQuizBy(chapterNo, questionNo);
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

        request.setAttribute("chapterNos", chapterNos);
        request.setAttribute("questionNos", questionNos);
        request.setAttribute("intro11EQ", intro11EQ);
        request.setAttribute("questionPart", questPart[0]);
        request.setAttribute("questionPart2", questPart2Str);
        request.setAttribute("choices", choices);
        request.setAttribute("choiceType", choiceType);
        request.getRequestDispatcher("OneQuestion.jsp").forward(request, response);

    }

}
