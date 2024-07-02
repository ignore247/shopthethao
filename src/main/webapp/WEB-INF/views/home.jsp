<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function(){
    // Khi người dùng nhấp vào liên kết, gọi AJAX để lấy nội dung từ server
    $("#changeBody").click(function(event){
        event.preventDefault(); // Ngăn chặn hành động mặc định của liên kết
        var newUrl = "/shopthethao/trangchu/test";
        $.ajax({
            url: "/shopthethao/springmvc",
            success: function(result){
                $("#bodyContent").html(result);
                window.history.pushState({path: newUrl}, '', newUrl);
            },
            error: function(xhr, status, error) {
                console.error("Error: " + error);
            }
        });
    });
});
</script>
</head>
<body>
<h1>HELLO</h1>
<h1>Xin chào</h1>
<div id="bodyContent">
    <h1>${message}</h1>
</div>
<a href="#" id="changeBody">Click to change body</a>
</body>
</html>