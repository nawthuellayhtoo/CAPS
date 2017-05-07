<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<link rel="stylesheet"
		href="${pageContext.request.contextPath}/css/external.css">
<spring:url value="/resources/css/style.css" var="style" />
<spring:url value="/student/list" var="pageurl" />
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
<h1>&nbsp;View Course</h1>
		<div class="col-sm-9">
			<div>
				<c:set var="pageListHolder" value="${coursesLists}" scope="session" />
				<table class="table table-hover">
					<thead>
						<tr>
							<th><spring:message code="fieldLabel.courseId" /></th>
							<th><spring:message code="fieldLabel.courseName" /></th>
							<th><spring:message code="fieldLabel.details" /></th>

						</tr>
					</thead>
					<tbody>
						<c:forEach var="course" items="${pageListHolder.pageList}">
							<tr>
								<td>${course.courseid}</td>
								<td>${course.coursename}</td>
								<td><a class="btn btn-success btn-sm"
									href="${pageContext.request.contextPath}/student/view/${course.courseid}.html" />VIEW</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

			<div>
				<span style="float: left;"> <c:choose>
						<c:when test="${pageListHolder.firstPage}">Prev</c:when>
						<c:otherwise>
							<a href="${pageurl}/prev">Prev</a>
						</c:otherwise>
					</c:choose>
				</span> <span> <c:forEach begin="0"
						end="${pageListHolder.pageCount-1}" varStatus="loop">
    &nbsp;&nbsp;
    <c:choose>
							<c:when test="${loop.index == pageListHolder.page}">${loop.index+1}</c:when>
							<c:otherwise>
								<a href="${pageurl}/${loop.index}">${loop.index+1}</a>
							</c:otherwise>
						</c:choose>
    &nbsp;&nbsp;
    </c:forEach>
				</span> <span> <c:choose>
						<c:when test="${pageListHolder.lastPage}">Next</c:when>
						<c:otherwise>
							<a href="${pageurl}/next">Next</a>
						</c:otherwise>
					</c:choose>
				</span>
			</div>

		</div>
	</div>
</div>
<html>