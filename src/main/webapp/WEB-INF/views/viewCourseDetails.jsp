<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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
<h1>&nbsp;Enrollment</h1>
		<div class="col-sm-3">
			<form:form method="POST" modelAttribute="course"
				action="${pageContext.request.contextPath}/student/view/${course.courseid}.html">

				<div class="form-group">
					<spring:message code="fieldLabel.courseId" />
					<form:input path="courseid" readonly="true" class="form-control" />
				</div>

				<div class="form-group">
					<spring:message code="fieldLabel.courseName" />
					<form:input path="coursename" readonly="true" class="form-control" />
				</div>

				<div class="form-group">
					<spring:message code="fieldLabel.credit" />
					<form:input path="credit" readonly="true" class="form-control" />
				</div>

				<div class="form-group">
					<spring:message code="fieldLabel.startDate" />
					<form:input path="startdate" readonly="true" class="form-control" />
				</div>

				<div class="form-group">
					<input type="submit" value="Enrol" class="btn btn-success btn-sm" />
				</div>



			</form:form>

			<div></div>
		</div>
	</div>
</div>
<html>