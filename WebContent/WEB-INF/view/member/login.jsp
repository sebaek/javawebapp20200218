<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/WEB-INF/view/jspf/pageHeader.jsp" %>
<title>로그인</title>
</head>
<body>
<h1>로그인</h1>
<div>
<form method="post">
<input name="memberId" placeholder="아이디"><br>
<input name="password" placeholder="패스워드" type="password"><br>
<input type="submit" value="로그인">
</form>
</div>
<div>
${message }
</div>

</body>
</html>






