<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
.board-list-item-container {
	padding-top: 5px;
	padding-bottom: 5px;
	border-bottom: 1px solid grey;
}

.board-list-item-container:hover {
	background-color: #ccc;
}

.board-list-item-container a {
	color: black;
	text-decoration: none;
	display: block;
}

.board-item-wrapper {
	display: flex;
}

.board-list-item-col {
	padding-left: 15px;
	width: 40px;
}

.board-list-item-col-full {
	flex: 1;
}

.board-list-item-col-member-id {
	width: 70px;
}

.board-item-inserted {
	color: grey;
	font-size: 10px;
}



</style>

<div id="board-list-container">

	<c:forEach items="${boardList }" var="board">
		<c:url value="/board/view" var="link">
			<c:param name="id" value="${board.id }" />
		</c:url>
		<div class="board-list-item-container">
			<a href="${link }">
				<div class="board-item-wrapper">
					<div class="board-list-item-col">${board.id }</div>
					<div class="board-list-item-col board-list-item-col-full">
						<div>${board.title }</div>
						<div class="board-item-inserted">${board.inserted }</div>
					</div>
					<div class="board-list-item-col board-list-item-col-member-id">${board.memberId }</div>
				</div>
			</a>
		</div>
	</c:forEach>

</div>