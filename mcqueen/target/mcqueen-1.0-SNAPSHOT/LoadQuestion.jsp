<%-- 
    Document   : LoadQuestion
    Created on : Mar 6, 2018, 8:20:27 AM
    Author     : sm6668
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean 
    id    = "intro11e" 
    class = "com.csci5520.mcqueen.Intro11Edition" 
    scope = "page">
</jsp:useBean>
<jsp:setProperty name="intro11e" property="*"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Load Question</title>
    </head>
    <body>
        <h1>Multiple-Choice Question</h1>
        <div>
            <form method="POST" action="LoadQuestionController">
                <div>
                    <!--Start of question-->
                    <div>
                        <c:forEach items="${question}" var="line">
                            <p>${line}</p>
                        </c:forEach> 
                    </div>
                    <!--Start of choices-->
                    <div>
                        <div>
                            <c:forEach items="${choices}" var="choice">
                                <input type="${choiceType}" name="choices" value="${choice.key}"/>
                                <span>${choice.key}.</span> 
                                <span>${choice.value}</span><br>
                            </c:forEach>  
                        </div>
                        <!--Responses-->
                        <div>
                            <p>${feedBack}</p>
                        </div>
                        <div>
                            <input type="submit" name="checkMyAnswer" value="Check My Answer"> 
                        </div>
                    </div>
                </div>
                <!--Hidden Values--> 
                <input type="hidden" name="chapterNo" value="${chapterNo}"/>
                <input type="hidden" name="questionNo"value="${questionNo}"/>
                <input type="hidden" name="choiceType" value="${choiceType}"/>
                <input type="hidden" name="key" value="${key}"/>
                <input type="hidden" name="hint" value="${hint}"/>
            </form>
        </div>
    </body>
</html>
