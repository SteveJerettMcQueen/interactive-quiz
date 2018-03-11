/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    //Set selected question number
    $('#questNoSelect').val($('#questNo').val());

    //Set selected question number on change from chapter numbre
    $('#chapNoSelect').change(function () {

        var data = {
            chapterNo: $(this).find('option:selected').attr('value')
        };

        function onSuccess(response) {
            $('#questNoSelect').empty();
            for (var i = 0; i < response.length; i++) {
                var questNo = response[i];
                $('#questNoSelect').append(
                        "<option value='" + questNo + "'>" + questNo + "</option>");
            }
        }

        function onError(response) {
            alert("Error occured on server side!");
        }

        $.ajax({
            type: 'POST',
            url: 'QuestionChooser',
            data: data,
            dataType: 'json',
            success: onSuccess,
            error: onError
        });

    });

});
