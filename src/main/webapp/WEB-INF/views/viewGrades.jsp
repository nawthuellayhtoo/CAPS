<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


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
		<h1>&nbsp;View GPA!</h1>
		<div class="col-sm-6">
			<form:form method="POST" commandName="student"
				action="${pageContext.request.contextPath}/student/grade/${Login.loginid}e.html">
				<table class="table table-hover">
					<thead>
						<tr>
							<th><spring:message code="fieldLabel.courseId" /></th>
							<th><spring:message code="fieldLabel.courseName" /></th>
							<th><spring:message code="fieldLabel.grade" /></th>

						</tr>
					</thead>
					<tbody>
						<c:forEach var="grades" items="${gradesList}">
							<tr>
								<td>${grades[1]}</td>
								<td>${grades[2]}</td>
								<td>${grades[3]}</td>
							</tr>
							<tr></tr>
						</c:forEach>
					</tbody>
				</table>
				<br />
				<hr>
				<center>
					<h1>GPA=${gpa}</h1>
				</center>

			</form:form>
		</div>
	</div>
</div>
</html>