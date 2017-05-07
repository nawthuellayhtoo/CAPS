<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/external.css">
<spring:url value="/admin/lecturer/load" var="pageurl" />
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
		<h1>&nbsp;Edit Student Grade page</h1>
		<div class="col-sm-4">
			<c:if test="${fn:length(studentList) gt 0}">


				<table class="table table-hover">
					<c:forEach var="std" items="${studentList}">

						<tbody>
							<tr>
								<td><spring:message code="fieldLabel.courseId" /></td>
								<td>${cid}</td>

							</tr>
							<tr>
								<td><spring:message code="fieldLabel.studentId" /></td>
								<td>${std[0]}</td>

							</tr>
							<tr>
								<td><spring:message code="fieldLabel.firstName" /></td>
								<td>${std[1]}</td>
							</tr>
							<tr>
								<td><spring:message code="fieldLabel.lastName" /></td>
								<td>${std[2]}</td>
							</tr>
							<tr>
								<td><spring:message code="fieldLabel.gpa" /></td>
								<td>${std[3]}</td>
							</tr>
					</c:forEach>

					<form:form method="POST" modelAttribute="enrolment"
						action="${pageContext.request.contextPath}/lecturer/student/gradeupdate/${enrolment.enrolmentid}.html">
						<tr>
							<td><spring:message code="fieldLabel.grade" /></td>
							<%-- <td><form:input path="grade" /></td> --%>

							<td><form:select path="grade">
									<form:option value="" label="...." />
									<form:options items="${gradeList}" />
								</form:select></td>

							<td><form:errors path="grade" cssStyle="color: red;" /></td>
						</tr>

						<tr>
							<td></td>
							<td><input type="submit" value="Update" class="btn btn-success btn-sm" /></td>


						</tr>
						</tbody>
					</form:form>
				</table>

			</c:if>
		</div>
	</div>
</div>
</html>



