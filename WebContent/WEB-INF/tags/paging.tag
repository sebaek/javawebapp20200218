<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
.page-container-wrapper {
	margin-top: 50px;
	display: flex;
	justify-content: center;
}

/* Pagination links */
.page-container a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
	transition: background-color .3s;
}

/* Style the active/current link */
.page-container a.page-active {
	background-color: dodgerblue;
	color: white;
}

/* Add a grey background color on mouse-over */
.page-container a:hover:not (.page-active ) {
	background-color: #ddd;
}
</style>

<div class="page-container-wrapper">

	<div class="page-container">
		<c:url value="/" var="curl" />
		<a href="${curl }">&laquo;</a>
		<c:forEach begin="${beginPage }" end="${endPage }" var="page">
			<c:url value="/" var="curl">
				<c:param name="page" value="${page }" />
			</c:url>

			<c:if test="${page eq curPage }">
				<c:set value="page-active" var="pageActiveClass" />
			</c:if>
			<a href="${curl}" class="${pageActiveClass }">${page }</a>

			<c:remove var="pageActiveClass" />
		</c:forEach>

	</div>
</div>