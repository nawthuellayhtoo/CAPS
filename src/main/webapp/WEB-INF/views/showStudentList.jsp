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

			<c:if test="${fn:length(studentList) gt 0}">
				<h1>Student list of ${course.courseid}</h1>
				<table class="table table-hover">
					<thead>
						<tr class="listHeading">
							<th><spring:message code="fieldLabel.studentId" /></th>
							<th><spring:message code="fieldLabel.firstName" /></th>
							<th><spring:message code="fieldLabel.lastName" /></th>
							<th><spring:message code="fieldLabel.gpa" /></th>
							<th><spring:message code="fieldLabel.grade" /></th>
							<th><spring:message code="fieldLabel.edit" /></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="std" items="${studentList}">
							<tr class="listRecord">
								<td>${std[0]}</td>
								<td>${std[1]}</td>
								<td>${std[2]}</td>
								<td>${std[3]}</td>
								<td>${std[4]}</td>
								<td><a class="btn btn-success btn-sm"
									href="${pageContext.request.contextPath}/lecturer/student/edit/${std[0]}/${course.courseid}.html"><spring:message
											code="caption.edit" /></a></td>
							<tr>
						</c:forEach>
					</tbody>
				</table>

			</c:if>

		</div>
	</div>
</div>
<html>