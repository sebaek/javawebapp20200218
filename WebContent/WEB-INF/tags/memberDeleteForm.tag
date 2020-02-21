<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>
	<c:url value="/member/delete" var="deleteUrl" />
	<form method="post" action="${deleteUrl }">
		<label><b>아이디</b></label>
		<input class="form-element-full-width" readonly value="${loginUser.memberId }">
		<label><b>패스워드</b></label>
		<input class="form-element-full-width" type="password" name="password" placeholder="패스워드">
		<input class="form-btn" type="submit" value="탈퇴">
	</form>
</div>