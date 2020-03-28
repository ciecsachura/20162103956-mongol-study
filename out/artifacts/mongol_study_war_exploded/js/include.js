$(function () {
    $.get("admin.html",function (data) {
        $("#adminTop").html(data);
    });

});