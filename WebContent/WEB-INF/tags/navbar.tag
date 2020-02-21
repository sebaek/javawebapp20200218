<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
#navbar-container {
	display: flex;
	background-color: black;
}

#navbar-gap-full {
	flex-grow: 1;
}

#navbar-container .navbar-link {
	padding: 15px;
	background-color: black;
	color: white;
}

.navbar-link:hover a {
	color: grey;
}

.navbar-link a {
	text-decoration: none;
	color: white;
	
}


</style>

<div id="navbar-container">

<div class="navbar-link" id="navbar-logo">
중앙프로젝트
</div>

<div class="navbar-link" id="navbar-gap-full"></div>

<div class="navbar-link">
<c:url value="/" var="mainUrl" />
<a href="${mainUrl }">메인</a>
</div>


<c:if test="${empty loginUser }">
	<div class="navbar-link">
	<c:url value="/member/signup" var="signupUrl"/>
	<a href="${signupUrl }">회원가입</a>
	</div>
	
	<div class="navbar-link">
	<c:url value="/member/login" var="loginUrl"/>
	<a href="${loginUrl }">로그인</a>
	</div>
</c:if>

<c:if test="${not empty loginUser }">
	<div class="navbar-link">
	<c:url value="/board/add" var="boardAddUrl" />
	<a href="${boardAddUrl }">글쓰기</a>
	</div>

	<div class="navbar-link">
	<c:url value="/member/view" var="memberViewUrl" />
	<a href="${memberViewUrl }">내정보</a>
	</div>
	
	<div class="navbar-link">
	<c:url value="/member/logout" var="logoutUrl"/>
	<a href="${logoutUrl }">로그아웃</a>
	</div>
</c:if>


</div>