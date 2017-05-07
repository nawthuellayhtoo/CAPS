<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
			<h1>Enrollment Details</h1>

			<c:if test="${fn:length(eList) gt 0}">
				<table class="table table-hover">
					<thead>
						<tr class="listHeading">
							<th><spring:message code="fieldLabel.enrolmentId" /></th>
							<th><spring:message code="fieldLabel.studentId" /></th>
							<th><spring:message code="fieldLabel.studentName" /></th>
							<th><spring:message code="fieldLabel.enrolmentDate" /></th>
							<th><spring:message code="fieldLabel.grade" /></th>
							<th><spring:message code="fieldLabel.courseId" /></th>
							<th><spring:message code="fieldLabel.courseName" /></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="erol" items="${eList}">
							<tr class="listHeading">
								<td>${erol[0]}</td>
								<td>${erol[1]}</td>
								<td>${erol[2].concat(" ").concat(erol[3])}</td>
								<td>${erol[4]}</td>
								<td>${erol[5]}</td>
								<td>${erol[6]}</td>
								<td>${erol[7]}</td>
								<td><c:url value="/admin/enrolment/delete/${erol[0]}.html"
										var="deleteurl" /> <a class="btn btn-danger"
									href="${deleteurl}"
									onclick=" return confirm('Do you wish to delete?');"><spring:message
											code="caption.delete" /></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
	</div>
</div>
</html>