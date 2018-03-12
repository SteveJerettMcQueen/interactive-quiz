/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global hljs */

$(document).ready(function () {

    // Load Highlighting
    $('pre code').each(function (i, block) {
        hljs.highlightBlock(block);
    });

    // Ready Submit Button
    $('#submitBtn').click(function () {
        if ($('input:checkbox[name=answers]:checked').length > 0 ||
                $('input:radio[name=answers]').is(':checked')) {
            callServlet();
        } else {
            alert("Please choose answer before submitting!");
        }
    });

});

function callServlet() {

    var data = {
        answers: getAnswers(),
        chapterNo: $('#chapNo').val(),
        questionNo: $('#questNo').val(),
        choiceType: $('#choiceType').val(),
        answerKey: $('#answerKey').val(),
        hint: $('#hint').val(),
        checkMyAnswer: $('#submitBtn').val()
    };

    function onSuccess(response) {
        var feedBack = response[0];
        var message = response[1];
        var hint = response[2];
        var answerKey = response[3];

        function showExplanation() {
            $('#feedBack').append("<hr>");
            $('#feedBack').append("<h6 class='alert-heading'>Answer:</h6>");
            $('#feedBack').append("<p>" + answerKey + "</p>");
            $('#feedBack').append("<hr>");
            $('#feedBack').append("<h6 class='alert-heading'>Explanation:</h6>");
            $('#feedBack').append("<p>" + hint + "</p>");
            $('#message').unbind('click');
        }

        $('#feedBackBox').append("<div id='feedBack' role='alert'></div>");
        $('#feedBack').append("<h6 class='alert-heading'>Feed Back:</h6>");
        $('#feedBack').append("<p id='message'>\n\
                <a href='#' class='alert-link'>" + message + "</a>\n\
                <i id='messageIcon' class='fa' aria-hidden='true'></i>\n\</p>");

        switch (feedBack) {
            case "correct":
                $('#feedBack').addClass("alert alert-success");
                $('#messageIcon').addClass("fa-check");
                break;
            case "incorrect":
                $('#feedBack').addClass("alert alert-danger");
                $('#messageIcon').addClass("fa-close");
                break;
            default:
                break;
        }

        $('#message').click(showExplanation);
        $("#questionForm input").prop("disabled", true);
        $("#submitBtn").prop("disabled", true);
        $('#submitHelpBlock').remove();
    }

    function onError(response) {
        alert("Error sending feed back!");
    }

    $.ajax({
        type: 'POST',
        url: 'QuestionForm',
        data: data,
        dataType: 'json',
        success: onSuccess,
        error: onError
    });

}

function getAnswers() {
    if ($('#choiceType').val() === 'checkbox') {
        var answers = [];
        $('input:checkbox[name=answers]').each(function () {
            if ($(this).prop('checked')) {
                answers.push($(this).val());
            }
        });
        return answers.join("");
    } else {
        return $('input:radio[name=answers]:checked').val();
    }

}

