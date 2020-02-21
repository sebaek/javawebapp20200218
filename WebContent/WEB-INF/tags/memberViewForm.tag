<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
.member-delete-btn-container {
	margin-top: 30px;
	padding: 10px;
	font-size: 12px;
}

.member-delete-btn:link, .member-delete-btn:visited {
	background-color: #f44336;
	color: white;
	padding: 2px 4px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
}

.member-delete-btn:hover, .member-delete-btn:active {
	background-color: red;
}
</style>


<div>
	<c:url value="/member/modify" var="memberModifyUrl" />
	<form method="post" action="${memberModifyUrl}">
		<label><b>아이디</b></label> <input class="form-element-full-width"
			name="memberId" value="${loginUser.memberId }" placeholder="아이디"><br>
		<label><b>패스워드</b></label> <input class="form-element-full-width"
			id="pw1" name="password" type="password" placeholder="패스워드"><br>
		<label><b>패스워드 확인</b></label> <input class="form-element-full-width"
			id="pw2" type="password" placeholder="패스워드확인"><br> <label><b>이메일</b></label>
		<input class="form-element-full-width" name="email"
			value="${loginUser.email }" type="email" placeholder="이메일"><br>
		<label><b>별명</b></label> <input class="form-element-full-width"
			name="nickName" value="${loginUser.nickName }" placeholder="별명"><br>
		<input class="form-btn" type="submit" value="수정">
	</form>
</div>
<div class="member-delete-btn-container">
	<c:url value="/member/delete" var="memberDeleteUrl" />
	<a class="member-delete-btn" href="${memberDeleteUrl }">회원 탈퇴</a>
</div>