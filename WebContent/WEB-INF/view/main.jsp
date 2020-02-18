<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/WEB-INF/view/jspf/pageHeader.jsp" %>
<title>Insert title here</title>
</head>
<body>
<h1>메인 페이지</h1>

<div>
<c:url value="/member/signup" var="signupUrl"/>
<a href="${signupUrl }">회원가입</a>

</div>
</body>
</html>






