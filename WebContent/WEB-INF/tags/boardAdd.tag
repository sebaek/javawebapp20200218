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

<div id="board-add-container">

	<form class="board-add-form" method="post"
		enctype="multipart/form-data">
		<div class="board-add-title-wrapper">
			<input class="board-add-title" name="title" placeholder="제목"
				value="${title }">
		</div>
		<textarea class="board-add-textarea" name="body">
${body }
</textarea>
		<br> <input type="file" accept="image/*" name="file"><br>
		<input class="w3-button w3-blue board-add-button" type="submit" value="등록">
	</form>
</div>