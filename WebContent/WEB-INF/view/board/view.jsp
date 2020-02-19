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
<h1>게시물 보기</h1>
<div>
${board.id } : ${board.title } 
: ${board.inserted } : ${board.memberId }

<br>
<textarea rows="5" cols="20" readonly>
${board.body }
</textarea>

</div>
</body>
</html>











