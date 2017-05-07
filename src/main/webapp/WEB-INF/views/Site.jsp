<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:choose>
		<c:when
			test="${sessionScope.USERSESSION.login.role eq 'administrator' }">
			<li><spring:url value="/admin/student/load" var="managestudent"
					htmlEscape="true" /> <a href="${managestudent}"> <spring:message
						code="menu.managestudent" /></a></li>

			<li><spring:url value="/admin/lecturer/load"
					var="managelecturer" htmlEscape="true" /> <a
				href="${managelecturer}"> <spring:message
						code="menu.managelecturer" /></a></li>

			<li><spring:url value="/admin/course/load" var="managecourse"
					htmlEscape="true" /> <a href="${managecourse}"> <spring:message
						code="menu.managecourse" /></a></li>
						
			<li><spring:url value="/admin/enrolment/load" var="manageenrolment"
					htmlEscape="true" /> <a href="${manageenrolment}"> <spring:message
						code="menu.manageenrolment" /></a></li>

			<li><spring:url value="/admin/login/load" var="managelogin"
					htmlEscape="true" /> <a href="${managelogin}"> <spring:message
						code="menu.managelogin" /></a></li>

			<li><spring:url value="/home/logout" var="logout"
					htmlEscape="true" /> <a href="${logout}"> <spring:message
						code="menu.logout" /></a></li>
		</c:when>

		<c:when test="${sessionScope.USERSESSION.login.role eq 'lecturer' }">
			<li><spring:url value="/lecturer/courselist" var="courselist"
					htmlEscape="true" /> <a href="${courselist}"> <spring:message
						code="menu.lecturer.mycourse" />
			</a></li>
			<li><spring:url value="/home/logout" var="logout"
					htmlEscape="true" /> <a href="${logout}"> <spring:message
						code="menu.logout" /></a></li>
		</c:when>

		<c:when test="${sessionScope.USERSESSION.login.role eq 'student' }">
			<li><spring:url value="/student/list" var="list"
					htmlEscape="true" /> <a href="${list}"> <spring:message
						code="menu.listcourses" />
			</a></li>
			<li><spring:url value="/student/grade" var="grade"
					htmlEscape="true" /> <a href="${grade}"> <spring:message
						code="menu.viewgrades" />
			</a></li>

			<li><spring:url value="/home/logout" var="logout"
					htmlEscape="true" /> <a href="${logout}"> <spring:message
						code="menu.logout" /></a></li>
		</c:when>

	</c:choose>
<%-- <c:choose>

	<c:when
		test="${sessionScope.USERSESSION.login.role eq 'administrator' }">
		<li><spring:url value="/home/logout" var="logout"
				htmlEscape="true" /> <a href="${logout}"> <spring:message
					code="menu.logout" /></a></li>
	</c:when>



	<c:when test="${sessionScope.USERSESSION.login.role eq 'lecturer' }">
		<li><spring:url value="/lecturer/courselist" var="courselist"
				htmlEscape="true" /> <a href="${courselist}"> <spring:message
					code="menu.lecturer.mycourse" />
		</a></li>
		<li><spring:url value="/home/logout" var="logout"
				htmlEscape="true" /> <a href="${logout}"> <spring:message
					code="menu.logout" /></a></li>
	</c:when>


	<c:when test="${sessionScope.USERSESSION.login.role eq 'student' }">
		<li><spring:url value="/student/list" var="list"
				htmlEscape="true" /> <a href="${list}"> <spring:message
					code="menu.listcourses" />
		</a></li>
		<li><spring:url value="/student/grade" var="grade"
				htmlEscape="true" /> <a href="${grade}"> <spring:message
					code="menu.viewgrades" />
		</a></li>

		<li><spring:url value="/home/logout" var="logout"
				htmlEscape="true" /> <a href="${logout}"> <spring:message
					code="menu.logout" /></a></li>
	</c:when>

</c:choose> --%>
