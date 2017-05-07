<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/external.css">
<spring:url value="/admin/course/load" var="pageurl" />
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
			<h1>Course Details</h1>
			<c:set var="pageListHolder" value="${courseList}" scope="session" />
			<table class="table table-hover">
				<thead>
					<tr class="listHeading">
						<th><spring:message code="fieldLabel.courseId" /></th>
						<th><spring:message code="fieldLabel.courseName" /></th>
						<th><spring:message code="fieldLabel.classSize" /></th>
						<th><spring:message code="fieldLabel.courseCredit" /></th>
						<th><spring:message code="fieldLabel.startDate" /></th>
						<th><spring:message code="fieldLabel.lecturerId" /></th>
						<th><spring:message code="fieldLabel.lecturerName" /></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="course" items="${pageListHolder.pageList}">
						<tr class="listHeading">
							<td>${course.courseid}</td>
							<td>${course.coursename}</td>
							<td>${course.size}</td>
							<td>${course.credit}</td>
							<td>${course.startdate}</td>
							<td>${course.lecturerid.lecturerid}</td>
							<td>${course.lecturerid.firstname.concat(" ").concat(course.lecturerid.lastname)}</td>
							<td><c:url
									value="/admin/course/details/edit/${course.courseid}.html"
									var="editurl" /> <a class="btn btn-success btn-sm"
								href="${editurl}"><spring:message code="caption.edit" /></a></td>
							<td><c:url
									value="/admin/course/details/delete/${course.courseid}.html"
									var="deleteurl" /> <a class="btn btn-danger"
								href="${deleteurl}"
								onclick=" return confirm('Do you wish to delete?');"><spring:message
										code="caption.delete" /></a></td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="3"><c:url value="/admin/course/add" var="addurl" />
							<a class="btn btn-success btn-sm" href="${addurl}"><spring:message
									code="caption.add.course" /></a></td>
					</tr>
				</tbody>
			</table>


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
</html>