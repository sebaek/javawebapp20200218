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
<h1>메인 페이지</h1>

<my:navbar />

<h1>게시물 목록</h1>
<div>
<table>
<tr>
	<th>id</th>
	<th>제목</th>
	<th>작성자</th>
	<th>작성일시</th>
</tr>
<c:forEach items="${boardList }" var="board">
  <c:url value="/board/view" var="link">
  	<c:param name="id" value="${board.id }" />
  </c:url>
<tr>
	<td>${board.id }</td>
	<td><a href="${link }">${board.title }</a></td>
	<td>${board.memberId }</td>
	<td>${board.inserted }</td>
</tr>
</c:forEach>

</table>
</div>


</body>
</html>











