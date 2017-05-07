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

		<div class="col-sm-3">
			<h1>NEW STUDENT</h1>
			<hr>
			<form:form method="POST"
				action="${pageContext.request.contextPath}/admin/student/add">
				<div class="form-group">
					<spring:message code="fieldLabel.studentId" />
					<form:input path="studentid" class="form-control" required="true"/>
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
					<spring:message code="fieldLabel.studentEmail" />
					<form:input type="email" path="email" class="form-control" required="true" />
				</div>
				<div class="form-group">
					<input type="submit" value="Add" class="btn btn-success btn-sm" />
				</div>
			</form:form>
		</div>
	</div>
</div>
</html>


