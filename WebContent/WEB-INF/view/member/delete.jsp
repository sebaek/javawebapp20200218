<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/WEB-INF/view/jspf/pageHeader.jsp" %>
<title>Insert title here</title>
</head>
<body>
<my:navbar />
<h1>회원 탈퇴</h1>
<div>
<c:url value="/member/delete" var="deleteUrl" />
<form method="post" action="${deleteUrl }">
<input readonly value="${loginUser.memberId }"><br>
<input type="password" name="password" placeholder="패스워드"><br>
<input type="submit" value="탈퇴">
</form>
</div>
</body>
</html>




