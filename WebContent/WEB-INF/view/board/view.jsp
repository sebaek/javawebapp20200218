<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/WEB-INF/view/jspf/pageHeader.jsp"%>
<title>Insert title here</title>
<script>
	$(function() {
		$("#board-delete-button").click(function() {
			$("#board-delete-form").toggle();
		});

		$(".reply-form-toggle-btn").click(function() {
			$(this).parent().nextAll(".reply-form").toggle();
		});
	});
</script>


</head>
<body>
	<my:navbar />

	<div class="main-container">

		<h1>게시물 보기</h1>
		<my:boardView />

	</div>
</body>
</html>











