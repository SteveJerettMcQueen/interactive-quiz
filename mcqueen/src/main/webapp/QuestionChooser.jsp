<%-- 
    Document   : QuestionChooser
    Created on : Mar 10, 2018, 3:50:56 PM
    Author     : Steve
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Question Chooser</title>
    </head>

    <!--Body-->
    <body>
        <!--Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="row">
                <!--Form-->
                <form class="form-inline" method="GET" action="LoadQuestion">
                    <label>Choose Question:</label>
                    <p>&emsp;</p>
                    <div class="form-group mr-sm-2">
                        <label for="chapNoSelect">Chapter:</label>
                        <p>&nbsp;&nbsp;</p>
                        <select id="chapNoSelect" class="form-control form-control-sm" name="chapterNo">
                            <c:forEach items="${chapterNos}" var="chapterNo">
                                <option value="${chapterNo}">${chapterNo}</option>
                            </c:forEach>  
                        </select>
                    </div>
                    <div class="form-group mr-sm-2">
                        <label for="questNoSelect">Question:</label>
                        <p>&nbsp;&nbsp;</p>
                        <select id="questNoSelect" class="form-control form-control-sm" name="questionNo">
                            <c:forEach items="${questionNos}" var="questionNo">
                                <option value="${questionNo}">${questionNo}</option>
                            </c:forEach>  
                        </select>
                    </div>
                    <input id="questBtn" class="btn btn-sm btn-primary" 
                           name="getQuestion" value="Get Question" type="submit"/>
                </form>
            </div>
        </nav>
    </body>
</html>
