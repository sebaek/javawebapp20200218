<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/WEB-INF/view/jspf/pageHeader.jsp" %>
<title>Insert title here</title>
<script>
$(function() {
	$("#pw1, #pw2").keyup(function() {
		var pw1Value = $("#pw1").val();
		var pw2Value = $("#pw2").val();
		
		if (pw1Value != pw2Value) {
			$("#message").text("패스워드가 일치하지 않습니다.");
		} else {
			$("#message").text("패스워드가 일치합니다.");
		}
	});
});

</script>
</head>
<body>
<h1>회원 가입</h1>
<div>
<form method="post">
<input name="memberId" placeholder="아이디"><br>
<input id="pw1" name="password" type="password" placeholder="패스워드"><br>
<input id="pw2" type="password" placeholder="패스워드확인"><br>
<input name="email" type="email" placeholder="이메일"><br>
<input name="nickName" placeholder="별명"><br>
<input type="submit" value="가입">
</form>
</div>

<div id="message">

</div>
</body>
</html>






