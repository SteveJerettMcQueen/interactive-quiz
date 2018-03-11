<%-- 
    Document   : QuestionForm
    Created on : Mar 10, 2018, 6:03:32 PM
    Author     : Steve
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Question Form</title>
    </head>

    <!--Body-->
    <body>
        <!--Title-->
        <div class="row"><h5>Single & Multiple-Choice Questions</h5></div>
        <hr>

        <!--Start of question-->
        <div class="row"><p>${questionPart}</p></div>
        <div class="row"><pre class="java"><code>${questionPart2}</code></pre></div>

        <!--Form Section-->
        <div class="row">
            <form id="questionForm"class="form-group" >
                <fieldset>
                    <!--Start of choices-->
                    <div id="choices" class="form-check">
                        <c:forEach items="${choices}" var="choice">
                            <input id="answerInput${choice.key}" 
                                   class="form-check-input" 
                                   name="answers" 
                                   value="${choice.key}"
                                   type="${choiceType}"/>
                            <label class="form-check-label" 
                                   for="answerInput${choice.key}">
                                ${choice.key}. ${choice.value}
                            </label>
                            <br/> 
                        </c:forEach>  
                    </div>
                </fieldset>
            </form>
        </div>
        <hr>

        <!--Responses-->
        <div class="row">
            <div id="feedBackBox" class="row"></div>
        </div>

        <!--Controls-->
        <div class="row">
            <button id="submitBtn" 
                    class="btn btn-sm btn-primary" 
                    name="checkMyAnswer" 
                    value="Check My Answer"
                    type="button">Check My Answer</button> 
            <p>&emsp;</p>   
            <small id="submitHelpBlock" class="form-text text-muted">
                You must choose at least one answer!
            </small>
        </div>
    </body>
</html>
