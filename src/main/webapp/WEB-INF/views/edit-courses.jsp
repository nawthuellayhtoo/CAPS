<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
		<h1>&nbsp;Edit Course Information</h1>
		<div class="col-sm-3">

			<form:form method="POST"
				action="${pageContext.request.contextPath}/admin/course/details/editsave">
				<div class="form-group">
					<spring:message code="fieldLabel.courseId" />
					<form:input path="courseid" readonly="true" class="form-control" />
				</div>

				<div class="form-group">
					<spring:message code="fieldLabel.courseName" />
					<form:input path="coursename" class="form-control" required="true"/>
				</div>

				<div class="form-group">
					<spring:message code="fieldLabel.classSize" />
					<form:input type="number" path="size" class="form-control" required="true"/>
				</div>

				<div class="form-group">
					<spring:message code="fieldLabel.courseCredit" />
					<form:input path="credit" type="number" class="form-control" required="true"/>
				</div>

				<div class="form-group">
					<spring:message code="fieldLabel.startDate" />
					<form:input path="startdate" type="text" id="datepicker"
						class="form-control" required="true" />
				</div>

				<div class="form-group">
					<spring:message code="fieldLabel.lecturerId" />
					<form:select path="lecturerid.lecturerid" items="${lidlist}"
						class="form-control" required="true" />
				</div>

				<div class="form-group">
					<input class="btn btn-success btn-sm" type="submit"
						value="Save Changes" />
				</div>
			</form:form>
		</div>
	</div>
</div>
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.js"></script>
<script>
	$(document).ready(function() {
		$('#datepicker').datepicker();

	});
</script>
</html>

