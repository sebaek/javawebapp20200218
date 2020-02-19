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
<h1>글 작성</h1>
<div>
<form method="post">
<input name="title" placeholder="제목" value="${title }"><br>
<textarea rows="5" cols="20" name="body">
${body }
</textarea><br>
<input type="submit" value="등록">
</form>

</div>
</body>
</html>









