<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
.board-add-title-wrapper {
	margin-top: 20px;
	margin-bottom: 15px;
}
.board-add-title-wrapper input {
	width: 100%;
}
.board-add-textarea {
	overflow: hidden;
	word-wrap: break-word;
	resize: none;
	width: 100%;
	height: 160px;
}
</style>


<div>
	<form method="post">
		<input name="id" value="${board.id }" type="hidden">
		<div class="board-add-title-wrapper">
			<input name="title" placeholder="제목" value="${board.title }"><br>
		</div>
		<textarea class="board-add-textarea" name="body">
${board.body }
</textarea>
		<br> <input class="w3-button w3-blue board-add-button" type="submit" value="수정">
	</form>

</div>