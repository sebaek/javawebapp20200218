<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags/reply" prefix="re" %>
<style>
.board-view-title {
	font-weight: bold;
}

.board-view-inserted {
	font-size: 12px;
	color: grey;
	display: inline-block;
}

.board-view-memberId {
	display: inline-block;
}

.board-view-memberId::after {
	content: "님";
}

.board-view-header-container {
	margin-bottom: 20px;
	border-top: 1px solid grey;
	border-bottom: 1px solid grey;
}

.board-view-image-container {
	height: 200px;
}

.board-view-image-container img {
	max-height: 200px;
}

.board-view-body-container {
	border-bottom: 1px solid grey;
	margin-bottom: 20px;
}

.board-view-body-container pre {
	font-family: "Malgun Gothic", sans-serif;
}

.board-view-button-wrapper {
	display: inline-block;
}

.board-view-button-container {
	padding-bottom: 5px;
	margin-bottom: 5px;
	border-bottom: 1px solid grey;
}
#board-delete-form {
	display: inline-block;
}
</style>

<!-- start board header, body -->
<div>
	<div class="board-view-header-container">
		<div class="board-view-title">${board.title }</div>
		<div>
			<div class="board-view-memberId">${board.memberId }</div>
			<div class="board-view-inserted">${board.inserted }</div>
		</div>
	</div>
	<c:if test="${not empty board.fileName  }">
		<div class="board-view-image-container">
			<img
				src="/static<%= request.getContextPath() %>/${board.id}/${board.fileName}">
		</div>
	</c:if>

	<div class="board-view-body-container">
		<pre>
<c:out value="${board.body }" />
</pre>
	</div>
</div>
<!-- end board header, body -->


<!-- start modify, delete -->
<c:if test="${loginUser.memberId eq board.memberId }">
	<div class="board-view-button-container">

		<div class="board-view-button-wrapper">
			<a class="w3-button w3-blue" href="modify?id=${board.id }">수정</a>
		</div>
		<div class="board-view-button-wrapper">
			<button class="w3-button w3-red" id="board-delete-button">삭제</button>
			<div id="board-delete-form" style="display: none;">
				<form action="delete" method="post">
					<input name="id" value="${board.id }" type="hidden"> <input
						name="password" type="password" placeholder="패스워드"> <input
						type="submit" value="확인">
				</form>
			</div>

		</div>
	</div>
</c:if>
<!-- end modify, delete -->


<!-- start reply container -->
<re:replyContainer />


<!-- end reply container -->