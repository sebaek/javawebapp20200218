<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>


</style>

<div id="signup-form-container">
	<form method="post">
		<label><b>아이디</b></label>
		<input class="form-element-full-width" name="memberId" placeholder="아이디">
		<label><b>패스워드</b></label>
		<input class="form-element-full-width" id="pw1" name="password" type="password" placeholder="패스워드">
		<label><b>패스워드 확인</b></label>
		<input class="form-element-full-width" id="pw2" type="password" placeholder="패스워드확인">
		<label><b>이메일</b></label>
		<input class="form-element-full-width" name="email" type="email" placeholder="이메일">
		<label><b>별명</b></label>
		<input class="form-element-full-width" name="nickName" placeholder="별명">
		<input class="form-btn" type="submit" value="가입">
	</form>
</div>