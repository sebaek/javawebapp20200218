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
<script>
$(function() {
	$("#board-delete-button").click(function() {
		$("#board-delete-form").toggle();
	});
	
	$(".reply-form-toggle-btn").click(function() {
		$(this).parent().next(".reply-form").toggle();
	});
});

</script>


</head>
<body>
<my:navbar />
<h1>게시물 보기</h1>
<div>
${board.id } : ${board.title } 
: ${board.inserted } : ${board.memberId }

<div>
<img src="/static/<%= request.getContextPath() %>/${board.id}/${board.fileName}">
</div>

<textarea rows="5" cols="20" readonly>
${board.body }
</textarea>
</div>
<c:if test="${loginUser.memberId eq board.memberId }">
<div>
<a href="modify?id=${board.id }">수정</a>
</div>
<div>
	<button id="board-delete-button">삭제</button>
	<div id="board-delete-form" style="display:none;">
		<form action="delete" method="post">
			<input name="id" value="${board.id }" type="hidden">
			<input name="password" type="password" placeholder="패스워드">
			<input type="submit" value="확인">
		</form>
	</div>

</div>
</c:if>

<c:if test="${not empty loginUser }">
<c:url value="/reply/add" var="replyAddUrl" />
<div>
<form action="${replyAddUrl }" method="post">
<input type="hidden" name="boardId" value="${board.id }">
<input name="body" >
<input type="submit" value="댓글">
</form>

</div>
</c:if>

<div>
<c:forEach items="${replyList }" var="reply">
	<span>${reply.body }</span>
	|
	<span>${reply.memberId }</span>
	|
	<span>${reply.inserted }</span><br>
	
	<c:if test="${loginUser.memberId eq reply.memberId }">
	<div>
	<button class="reply-form-toggle-btn">수정</button>
	</div>
	<div class="reply-form" style="display:none; ">
		<form onsubmit="return confirm('수정하시겠습니까?')" action="../reply/modify" method="post">
			<input name="boardId" value="${reply.boardId }" type="hidden">
			<input name="replyId" value="${reply.id }" type="hidden">
			<input name="body" value="${reply.body }">
			<input value="수정" type="submit">
		</form>
	</div>
	
	
	<div>
		<form onsubmit="return confirm('삭제하시겠습니까?')" action="../reply/delete" method="post">
			<input name="boardId" value="${reply.boardId }" type="hidden">
			<input name="replyId" value="${reply.id }" type="hidden">
			<input value="삭제" type="submit">
		</form>
	</div>
	</c:if>


</c:forEach>
</div>


</body>
</html>











