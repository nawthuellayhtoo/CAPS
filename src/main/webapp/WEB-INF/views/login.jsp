<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/external.css">
<style>
.modal-header, h4, .close {
	border-color: transparent;
	background: black;
	opacity: 0.8;
	color: white !important;
	text-align: center;
	font-size: 30px;
}
</style>
<!-- navigation bar -->
<jsp:include page='Menu.jsp'>
	<jsp:param name="articleId" value="" />
</jsp:include>
<!-- end navigation -->

<header class="intro-header"
	style="background-image: url('../image/NUS.jpg')">
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
				<div class="site-heading">

					<h1 style="opacity: 0.5">NUS</h1>
					<span class="subheading" style="opacity: 0.5">National
						University of Singapore</span><br />
				</div>

			</div>
		</div>
	</div>
</header>
<div id="login" class="container text-center">


		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header" style="padding: 35px 50px">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h2>LOGIN</h2>
			</div>
			<div class="modal-body" style="padding: 40px 50px">

				<form:form modelAttribute="login" role="form" method="POST"
					action="${pageContext.request.contextPath}/home/authenticate">
					<div class="form-group">
						<spring:message code="fieldLabel.loginid" />
						<form:input path="loginid" class="form-control" id="usrname"
							placeholder="Login Id" size="30" required="true" />
						<form:errors path="loginid" cssStyle="color: red;" />

					</div>
					<div class="form-group">
						<spring:message code="fieldLabel.password" />
						<form:password path="password" class="form-control"
							id="usrpassword" placeholder="Password" size="30" required="true"/>
						<form:errors path="password" cssStyle="color: red;" />
						<form:hidden path="role" size="30" />

					</div>
					<div class="form-group">
						<button name="submit" type="submit"
							class="btn btn-primary btn-block">Login</button>
					</div>

				</form:form>
			

	</div>
</div>
</div>
<!-- Container (The Band Section) -->
<div id="band" class="container text-center">
	<h1>ABOUT CAPS</h1>
	<p>
		<em>We love CAPS!</em>
	</p>
	<p>
		The Course Application Processing System (CAPS) is one of the
		management system for the university. There are three user roles:
		System Administrator, Lecturer and Student.<br />
		<br /> Please refer to the README for more information.
	</p>
	<br>

	<div class="container-fluid bg-3 text-center">

		<div class="col-sm-4">
			<p class="text-center">
				<strong>Administrator</strong>
			</p>
			<a href="#demo" data-toggle="collapse"> <img
				src="../image/admin.png" class="img-responsive" style="width: 100%"
				alt="Image"></a>
			<div id="demo" class="collapse">
				<p>Ms. MEGAN WONG</p>
				<p>Course Administrator (Graduate Studies)</p>
				<p>Since 2001</p>
			</div>

		</div>
		<div class="col-sm-4">
			<p class="text-center">
				<strong>Lecturer</strong>
			</p>
			<a href="#demo2" data-toggle="collapse"> <img
				src="../image/lecturer.jpg" class="img-responsive"
				style="width: 100%" alt="Image"></a>
			<div id="demo2" class="collapse">
				<p>Dr. ROBERT</p>
				<p>Software Engineering & Design</p>
				<p>Since 1986</p>
			</div>
		</div>
		<div class="col-sm-4">
			<p class="text-center">
				<strong>Student</strong>
			</p>
			<a href="#demo3" data-toggle="collapse"> <img
				src="../image/student.jpg" class="img-responsive"
				style="width: 100%" alt="Image"></a>

			<div id="demo3" class="collapse">
				<p>Mr. David Beckham</p>
				<p>Graduate Student</p>
				<p>From SA 43</p>
			</div>
		</div>
	</div>
</div>
<!-- end -->
<!-- LoginPortion -->


<!-- end login -->
<!-- Start Contact Section -->
<div id="contact" class="container">
	<h1 class="text-center">CONTACT</h1>

	<div class="row" align="center">


		<p>
			<img src="../image/phone.png" height="30px" width="30px" /> <br />
			+(65) 6516 2006
		</p>
		<p>
			<img src="../image/email2.png" height="30px" width="30px" /> <br />
			isspostgrad@nus.edu.sg
		</p>
		<p>
			<img src="../image/address.png" height="30px" width="30px" /> <br />Institute
			of Systems Science 25<br />Heng Mui Keng Terrace<br />Singapore
			119615
		</p>

	</div>

</div>
<!-- end contact session -->

<footer class="text-center">
	<a href="#myPage" title="TO TOP"> <img src="../image/up.png"
		height="25px" width="25px" />
	</a><br> <br>
	<p>
		Made By SA 43 > Team 2 <br /> <a href="mailto:sa43team2@gmail.com"
			data-toggle="tooltip">sa43team2@gmail.com</a>
	</p>
</footer>

</html>