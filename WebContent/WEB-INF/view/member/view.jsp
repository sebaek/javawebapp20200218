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
<h1>회원 정보</h1>
id : ${loginUser.memberId }<br>
pw : ${loginUser.password }<br>
email : ${loginUser.email }<br>
nick : ${loginUser.nickName }<br>
</body>
</html>






