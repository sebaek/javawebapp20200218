<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
.signup-form-element-full-width {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}

.signup-form-element-full-width:focus {
	background-color: #ddd;
	outline: none;
}

.signup-form-btn {
  background-color: #ddd;
  border: none;
  color: black;
  padding: 16px 32px;
  text-align: center;
  font-size: 16px;
  margin: 4px 2px;
  transition: 0.3s;
}

.signup-form-btn:hover {
  background-color: #3e8e41;
  color: white;
}

</style>

<div id="signup-form-container">
	<form method="post">
		<label><b>아이디</b></label>
		<input class="signup-form-element-full-width" name="memberId" placeholder="아이디">
		<label><b>패스워드</b></label>
		<input class="signup-form-element-full-width" id="pw1" name="password" type="password" placeholder="패스워드">
		<label><b>패스워드 확인</b></label>
		<input class="signup-form-element-full-width" id="pw2" type="password" placeholder="패스워드확인">
		<label><b>이메일</b></label>
		<input class="signup-form-element-full-width" name="email" type="email" placeholder="이메일">
		<label><b>별명</b></label>
		<input class="signup-form-element-full-width" name="nickName" placeholder="별명">
		<input class="signup-form-btn" type="submit" value="가입">
	</form>
</div>