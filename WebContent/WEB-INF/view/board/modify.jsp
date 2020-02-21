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
<h1>게시물 수정</h1>
<div>
<form method="post">
<input name="id" value="${board.id }" type="hidden">
<input name="title" placeholder="제목" value="${board.title }"><br>
<textarea rows="5" cols="20" name="body">
${board.body }
</textarea><br>
<input type="submit" value="수정">
</form>

</div>
</body>
</html>