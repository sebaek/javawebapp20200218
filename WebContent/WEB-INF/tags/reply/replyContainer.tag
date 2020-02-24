<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
.reply-body-input {
	width: 90%;
}

.reply-form-container {
	text-align: center;
}

.reply-button-wrapper {
	display: inline-block;
}

.reply-member-id::after {
	content: "님";
}

.reply-inserted {
	font-size: 10px;
	color: grey;
}
.reply-container {
	border-top: 1px solid grey;
}
</style>
<div>
	<h5><b>댓글</b></h5>
	<c:if test="${not empty loginUser }">
		<c:url value="/reply/add" var="replyAddUrl" />
		<div class="reply-form-container">
			<form action="${replyAddUrl }" method="post">
				<input type="hidden" name="boardId" value="${board.id }"> <input
					class="reply-body-input" name="body">
				<button>
					<i class="fas fa-comment"></i>
				</button>
			</form>

		</div>
	</c:if>

	<div>
		<c:forEach items="${replyList }" var="reply">
			<div class="reply-container">
				<span class="reply-member-id">${reply.memberId }</span> <span
					class="reply-inserted">${reply.inserted }</span>
				<div>
					<c:out value="${reply.body }" />
				</div>

				<c:if test="${loginUser.memberId eq reply.memberId }">

					<div class="reply-button-wrapper">
						<button class="reply-form-toggle-btn">
							<i class="fas fa-pen"></i>
						</button>
					</div>
					<div class="reply-button-wrapper">
						<form onsubmit="return confirm('삭제하시겠습니까?')"
							action="../reply/delete" method="post">
							<input name="boardId" value="${reply.boardId }" type="hidden">
							<input name="replyId" value="${reply.id }" type="hidden">
							<button>
								<i class="fas fa-trash"></i>
							</button>
						</form>
					</div>
					<div class="reply-form reply-form-container" style="display: none;">
						<form onsubmit="return confirm('수정하시겠습니까?')"
							action="../reply/modify" method="post">
							<input name="boardId" value="${reply.boardId }" type="hidden">
							<input name="replyId" value="${reply.id }" type="hidden">
							<input class="reply-body-input" name="body"
								value="${reply.body }">
							<button>
								<i class="fas fa-save"></i>
							</button>
						</form>
					</div>

				</c:if>

			</div>
		</c:forEach>
	</div>
</div>