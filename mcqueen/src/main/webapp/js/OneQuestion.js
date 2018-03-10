$(document).ready(function () {

    // Load Highlighting
    $('pre code').each(function (i, block) {
        hljs.highlightBlock(block);
    });

    // Read Submit Button
    $('#submitBtn').click(function () {
        if ($('input:checkbox[name=answers]:checked').length > 0 ||
                $('input:radio[name=answers]').is(':checked')) {
            callServlet();
        } else {
//            getError();
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
        var responses = response.split("\n");
        var feedBack = responses[0];
        var message = responses[1];
        var hint = responses[2];
        var answerKey = responses[3];

        function showExplanation() {
            $('#feedBack').append("<hr>");
            $('#feedBack').append("<h6 class='alert-heading'>Answer:</h6>");
            $('#feedBack').append("<p>" + answerKey + "</p>");
            $('#feedBack').append("<hr>");
            $('#feedBack').append("<h6 class='alert-heading'>Explanation:</h6>");
            $('#feedBack').append("<p>" + hint + "</p>");
            $('#message').unbind('click');
        }

        $('#feedBackBox').append("<p id='feedBack' role='alert'></p>");
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
        url: 'OneQuestion',
        data: data,
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

function getError() {
//    $('#errorBox').append("<div id='error' role='alert'><p id='errorMessage'></p></div>");
//    $('#error').addClass("alert alert-info");
//    $('#error').append("<a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a>");
//    $('#errorMessage').html("Please answer the question!");
//    window.setTimeout(function () {
//        $("#error").fadeTo(500, 0).slideUp(500, function () {
//            $(this).remove();
//        });
//    }, 2000);
}
