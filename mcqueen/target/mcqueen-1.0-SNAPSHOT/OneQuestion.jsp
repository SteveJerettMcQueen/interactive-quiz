<%-- 
    Document   : OneQuestion
    Created on : Mar 7, 2018, 10:42:51 AM
    Author     : sm6668
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>One Question</title>
    </head>    
    <!--Bootstrap CSS-->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" 
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" 
          crossorigin="anonymous">

    <!--Font Awesome CSS-->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" 
          integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" 
          crossorigin="anonymous">

    <!--Highlight JS CSS-->
    <link rel="stylesheet" href="css/xcode.css">

    <body>
        <!--Page Content-->
        <div class="container">
            <!--Title-->
            <div class="row"><h5>Single & Multiple-Choice Questions</h5></div>
            <hr>

            <!--Start of question-->
            <div class="row"><p>${questionPart}</p></div>
            <div class="row"><pre class="java"><code>${questionPart2}</code></pre></div>

            <!--Form Section-->
            <div class="row">
                <form id="questionForm" >
                    <fieldset class="form-group">
                        <!--Start of choices-->
                        <div id="choices" class="form-check">
                            <c:forEach items="${choices}" var="choice">
                                <input id="answerInput${choice.key}" 
                                       class="form-check-input" 
                                       name="answers" 
                                       value="${choice.key}"
                                       type="${choiceType}"/>
                                <label class="form-check-label" for="answerInput${choice.key}">${choice.key}. ${choice.value}</label>
                                <br/> 
                            </c:forEach>  
                        </div>
                    </fieldset>
                </form>
            </div>

            <!--Responses-->
            <div class="row">
                <div id="feedBackBox" class="row"></div>
            </div>

            <!--Controls-->
            <div class="form-group row">
                <button id="submitBtn" 
                        class="btn btn-sm btn-primary" 
                        name="checkMyAnswer" 
                        value="Check My Answer"
                        type="button">Check My Answer</button> 
                <p>&nbsp;&nbsp;&nbsp;</p>
                <small id="submitHelpBlock" class="alert alert-warning form-text text-muted">
                    You must choose at least one answer!
                </small>
            </div>
        </div>   

        <!--Hidden Values--> 
        <input id="chapNo" name="chapterNo" value="${intro11EQ.chapterNo}" type="hidden"/>
        <input id="questNo" name="questionNo"value="${intro11EQ.questionNo}" type="hidden"/>
        <input id="choiceType" name="choiceType" value="${choiceType}" type="hidden"/>
        <input id="answerKey" name="answerKey" value="${intro11EQ.answerKey}"type="hidden"/>
        <input id="hint" name="hint" value="${intro11EQ.hint}" type="hidden"/>

        <!--JQuery-->
        <script
            src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
            crossorigin="anonymous">
        </script>

        <!--Bootstrap-->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" 
                integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
                crossorigin="anonymous">
        </script>

        <!--Highlight JS-->
        <script type="text/javascript" src="js/highlight.pack.js"></script>

        <!--One Question JS-->
        <script type="text/javascript" src="js/OneQuestion.js"></script>
    </body>
</html>
