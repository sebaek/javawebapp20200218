<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div>

<div>
<c:url value="/" var="mainUrl" />
<a href="${mainUrl }">메인</a>
</div>


<c:if test="${empty loginUser }">
	<div>
	<c:url value="/member/signup" var="signupUrl"/>
	<a href="${signupUrl }">회원가입</a>
	</div>
	
	<div>
	<c:url value="/member/login" var="loginUrl"/>
	<a href="${loginUrl }">로그인</a>
	</div>
</c:if>

<c:if test="${not empty loginUser }">
	<div>
	<c:url value="/board/add" var="boardAddUrl" />
	<a href="${boardAddUrl }">글쓰기</a>
	</div>

	<div>
	<c:url value="/member/view" var="memberViewUrl" />
	<a href="${memberViewUrl }">내정보</a>
	</div>
	
	<div>
	<c:url value="/member/logout" var="logoutUrl"/>
	<a href="${logoutUrl }">로그아웃</a>
	</div>
</c:if>


</div>