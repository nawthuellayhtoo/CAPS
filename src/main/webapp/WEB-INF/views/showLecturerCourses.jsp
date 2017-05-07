<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<link rel="stylesheet"
		href="${pageContext.request.contextPath}/css/external.css">
		<!-- navigation bar -->
<jsp:include page='nav1.jsp'>
	<jsp:param name="articleId" value="" />
</jsp:include>
<!-- end navigation -->
<br />
<br />
<div class="container-fluid">
	<div class="row content">
		<div class="col-sm-2 sidenav">

			<ul class="nav nav-pills nav-stacked">
				<jsp:include page='Site.jsp'>
					<jsp:param name="articleId" value="" />
				</jsp:include>
			</ul>
		</div>

		<div class="col-sm-9">
			<h1>COURSE LIST</h1>
			<c:set var="pageListHolder" value="${courseList}" scope="session" />
			<table class="table table-hover">
				<thead>
					<tr class="listHeading">
						<th><spring:message code="fieldLabel.courseId" /></th>
						<th><spring:message code="fieldLabel.CourseName" /></th>
						<th><spring:message code="fieldLabel.Size" /></th>
						<th><spring:message code="fieldLabel.Credit" /></th>
						<th><spring:message code="fieldLabel.StartDate" /></th>
						<th><spring:message code="fieldLabel.enrolment" /></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="course" items="${pageListHolder.pageList}">
						<tr class="listRecord">
							<td>${course.courseid}</td>
							<td>${course.coursename}</td>
							<td>${course.size}</td>
							<td>${course.credit}</td>
							<td>${course.startdate}</td>
							<td><a class="btn btn-success btn-sm"
								href="${pageContext.request.contextPath}/lecturer/course/enrol/${course.courseid}.html"><spring:message
										code="caption.enrolment" /></a></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
			<div>
				<c:choose>
					<c:when test="${pageListHolder.firstPage}">Prev</c:when>
					<c:otherwise>
						<a href="${pageurl}/prev">Prev</a>
					</c:otherwise>
				</c:choose>
				<c:forEach begin="0" end="${pageListHolder.pageCount-1}"
					varStatus="loop">
    &nbsp;&nbsp;
    <c:choose>
						<c:when test="${loop.index == pageListHolder.page}">${loop.index+1}</c:when>
						<c:otherwise>
							<a href="${pageurl}/${loop.index}">${loop.index+1}</a>
						</c:otherwise>
					</c:choose>
    &nbsp;&nbsp;
    </c:forEach>
				<c:choose>
					<c:when test="${pageListHolder.lastPage}">Next</c:when>
					<c:otherwise>
						<a href="${pageurl}/next">Next</a>
					</c:otherwise>
				</c:choose>

			</div>
		</div>
	</div>
</div>
</html>
