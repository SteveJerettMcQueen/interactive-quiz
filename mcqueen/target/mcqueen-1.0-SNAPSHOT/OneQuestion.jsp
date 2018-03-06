<%-- 
    Document   : OneQuestion
    Created on : Mar 5, 2018, 1:00:38 PM
    Author     : sm6668
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id = "intro11EId" class = "com.csci5520.mcqueen.Intro11Edition" scope = "page"></jsp:useBean>
<jsp:setProperty name = "intro11EId" property = "*" />
<html>
    <head>
        <title>Multiple-Choice Question by Steve McQueen</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta content="Introduction to Java Programming, Java Multiple-choice questions" name="description">
        <meta content="Java Multiple-choice questions, Test, Java, Steve McQueen, Introduction to Java Programming, Brief, Comprehensive" name="keywords">
        <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
        <style type = "text/css">
            body {font-family: "Courier New", sans-serif; font-size: 100%; color: black}
            .keyword {color: #000080; font-weight: normal}
            .comment {color: gray}
            .literal {font-weight: normal; color: #3366FF}
        </style>
        <link rel="stylesheet" type="text/css" href="js/intro6e.css" />
        <link rel="stylesheet" type="text/css" href="js/intro6eselftest.css" />
        <style> 
            #question {font-family: "Courier New", Courier, Verdana, Helvetica, sans-serif; font-size: 100%; 
                       color: #8000f0; color: black; margin-left: 0.5em}
            #questionstatement {font-family: 
                                    Times New Roman, monospace, Courier, Verdana, Helvetica, sans-serif; font-size: 100%; color: #8000f0; 
                                color: black; margin-left:1.8em; margin-top:0.5em; margin-bottom:0.5em; }
            #choices {font-family: Times New Roman, Helvetica, sans-serif; font-size: 100%; 
                      color: #8000f0; color: black; margin-left:25.0pt; margin-left:0.5em; margin-bottom:0.5em; }
            #choicemargin {font-family: Times New Roman, Helvetica, sans-serif; font-size: 100%; }
            #choicestatement {font-family: Times New Roman, Helvetica, sans-serif; font-size: 100%; 
                              color: #8000f0; color: black; margin-left:25.0pt; margin-left:0.5em; margin-bottom:0.5em; }
            .preBlock {margin-left:0px;text-indent:0.0px; font-family:monospace; font-size: 120%}
            .keyword {color: green;}
            .comment {color: darkred;  }
            .literal {color: darkblue}
            .constant {color: teal}
            #h3style {color: white; font-family: Helvetica, sans-serif;  font-size: 100%; border-color: #6193cb; text-align: center;margin-bottom: 0.5em; background-color: #6193cb;}  
        </style>
        <!-- Global Site Tag (gtag.js) - Google Analytics -->
        <script async="async" src="https://www.googletagmanager.com/gtag/js?id=UA-89940905-27"></script>
        <script>
            window.dataLayer = window.dataLayer || [];
            function gtag() {
                dataLayer.push(arguments)
            }
            ;
            gtag('js', new Date());
            gtag('config', 'UA-89940905-27');
        </script>
        <script type="text/javascript" src="js/logging.js"></script>
    </head>
    <body>
        <h3 id="h3style" style = " width: 500px auto; max-width: 620px; margin: 0 auto; ">Multiple-Choice Question 5.2.1)</h3>
        <div>
            <form method="GET" action="OneQuestionController">
                <div id="question">
                    <!--Start of question-->
                    <div id="questionstatement"><span>&nbsp;&nbsp;</span>&nbsp; ________ is the physical aspect of the computer that can be seen.
                        <div class = "preBlock"> <br></div>
                    </div>
                    <!--Start of choices-->
                    <div id="choices">
                        <div id = "choicemargin">
                            <input type="radio" value="A" name="choiceA"> 
                            <span id="choicelabel">A.</span> 
                            <span id="choicestatement"> Hardware</span><br>
                        </div>
                        <div id = "choicemargin">
                            <input type="radio" value="B" name="choiceA"> 
                            <span id="choicelabel">B.</span> 
                            <span id="choicestatement"> Software</span><br>
                        </div>
                        <div id = "choicemargin">
                            <input type="radio" value="C" name="choiceA"> 
                            <span id="choicelabel">C.</span> 
                            <span id="choicestatement"> Operating system</span><br>
                        </div>
                        <div id = "choicemargin">
                            <input type="radio" value="D" name="choiceA">
                            <span id="choicelabel">D.</span> 
                            <span id="choicestatement"> Application program</span><br>
                        </div>
                        <div style="text-align: left; margin-right: 1em; ">
                            <input type="submit" name="buttonName" value="Check My Answer" style = "margin-bottom: 0px; margin-top: 10px; margin-left: 5px;border: 0px; font-family: Helvetica, monospace; font-size: 85%;background-color: rgba(0, 128, 0, 0.7); border-radius: 0px; color:black;"> 
                        </div>
                        <!--                        <input type="hidden" name="title" value=5.2.1 />-->
                        <input type="hidden" name="chapterNo" value="1"/>
                        <input type="hidden" name="questionNo" value="2"/>
                        <!--                        <input type="hidden" name="intro11equiz" value="intro10equiz"/>-->
                        <!--                        <input type="hidden" value=name="username" />
                                                <input type="hidden" value=500 name="width" />
                                                <input type="hidden" value=620 name="maxwidth" />-->
                    </div>
                    <div>
                        <p>${intro11eq.chapterNo}</p>
                        <p>${intro11eq.questionNo}</p>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
