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
		<h1>&nbsp;Edit Student Details</h1>
		<div class="col-sm-3">

			<form:form method="POST"
				action="${pageContext.request.contextPath}/admin/student/details/editsave">


				<div class="form-group">
					<spring:message code="fieldLabel.studentId" />
					<form:input path="studentid" readonly="true"
						class="form-control-static mb-0 form-control" />
				</div>

				<div class="form-group">
					<spring:message code="fieldLabel.studentFirstName" />
					<form:input path="firstname" class="form-control" required="true" />
				</div>

				<div class="form-group">
					<spring:message code="fieldLabel.studentLastName" />
					<form:input path="lastname" class="form-control" required="true" />
				</div>

				<div class="form-group">
					<spring:message code="fieldLabel.studentGpa" />
					<form:input path="gpa" class="form-control" readonly="true" />
				</div>

				<div class="form-group">
					<spring:message code="fieldLabel.studentEmail" />
					<form:input type="email" path="email" class="form-control"
						required="true" />
				</div>

				<div class="form-group">
					<input type="submit" value="Save Changes"
						class="btn btn-success btn-sm" />
				</div>

			</form:form>
		</div>
	</div>
</div>
</html>


















