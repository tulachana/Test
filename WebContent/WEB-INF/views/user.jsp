<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Edit</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/user.css">
	 <link type="text/css"
    rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/font-awesome-4.7.0/css/font-awesome.min.css" >
</head>


<body>
<div id="title">
<h1><b>EDIT USER</b></h1>
</div>

<div id="tabs" class="tab icon-bar ">
    <button class="tablinks btn btn-primary btn-lg" onclick="openCity(event, 'Profile')">User Info</button>
  <button class="tablinks btn btn-primary btn-lg" id="defaultOpen" onclick="openCity(event, 'Credentials')">Credentials</button>
  <button class="tablinks btn btn-primary btn-lg" onclick="openCity(event, 'Other')">Role</button>
</div>
<div id="Credentials" class="tabcontent container">
<form:form action="changePassword" modelAttribute="user" method="POST" class="well form-horizontal" id="contact_form" >
<fieldset>

				<!-- Form Name -->
				<legend>
					<center>
						<h2>
							<b>Credentials Edit Form</b>
						</h2>
					</center>
				</legend>
				<br>
	<div class="form-group">
					<label class="col-md-4 control-label">Username</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">					
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span>
							<form:input path="userName" name="user_name"
								placeholder="Username" class="form-control" type="text" readonly="true" />
							<form:errors path="userName" cssClass="error" />
							
						</div>
					</div>
				</div>
		<div class="form-group">
					<label class="col-md-4 control-label">Password</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-key" aria-hidden="true"></i></span>
						<form:input path="password" name="user_password" placeholder="Password" id="password" class="form-control"  type="password"/>
   <form:errors path="password" cssClass="error" />
						
						</div>
					</div>
				</div>
					<div class="form-group">
					<label class="col-md-4 control-label">Cofirm Password</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-key" aria-hidden="true"></i></span>
		<form:input path="confirmPassword" name="confirm_password" placeholder="Confirm Password" id="confirmPassword" class="form-control"  type="password"/>
  <form:errors path="confirmPassword" cssClass="error" />
						
						</div>
					</div>
				</div>
<div class="form-group">
<label class="col-md-4 control-label"></label>
<div class="col-md-4">
<br>
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
  <button type="submit" class="btn btn-primary" >
		<span class="glyphicon glyphicon-send"></span>&nbsp&nbsp&nbspSubmit</button>
  </div>
  </div>
</fieldset>
</form:form>
</div>

<div id="Other" class="tabcontent" class="active">
<h1>This is just a test </h1>
<form>
<label>Shikha</label>
<input type="text" />
</form>
</div>

<!-- <div class="container"> -->

<div id="Profile" class="tabcontent container">
		<form:form action="updateUser" modelAttribute="user" method="POST"
			class="well form-horizontal" id="contact_form">
			<fieldset>

				<!-- Form Name -->
				<legend>
					<center>
						<h2>
							<b>User Edit Form</b>
						</h2>
					</center>
				</legend>
				<br>


				<!--  Associate this data with the customer id -->
				<form:hidden path="id" />

				<div class="form-group">
					<label class="col-md-4 control-label">Username</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span>
							<form:input path="userName" name="user_name"
								placeholder="Username" class="form-control" type="text" readonly="true" />
							<form:errors path="userName" cssClass="error" />
						</div>
					</div>
				</div>
				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label">First Name</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span>
							<!-- <input  name="first_name" placeholder="First Name" class="form-control"  type="text"> -->
							<form:input path="firstName" name="first_name"
								placeholder="First Name" class="form-control" type="text" />
							<form:errors path="firstName" cssClass="error" />

						</div>
					</div>
				</div>

				<!-- Text input-->

				<div class="form-group">
					<label class="col-md-4 control-label">Last Name</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span>
							<form:input path="lastName" name="last_name"
								placeholder="Last Name" class="form-control" type="text" />
							<form:errors path="lastName" cssClass="error" />
						</div>
					</div>
				</div>


				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label">E-Mail</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-envelope"></i></span>
							<form:input path="emailAddress" name="email"
								placeholder="E-Mail Address" class="form-control" type="text" />
							<form:errors path="emailAddress" cssClass="error" />
						</div>
					</div>
				</div>


				<!-- Text input-->

				<div class="form-group">
					<label class="col-md-4 control-label">Contact No.</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-earphone"></i></span> <input
								name="contact_no" placeholder="(639)" class="form-control"
								type="text">
						</div>
					</div>
				</div>


				<!-- Success message -->
				<div class="alert alert-success" role="alert" id="success_message">
					Success <i class="glyphicon glyphicon-thumbs-up"></i> Success!.
				</div>

				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label"></label>
					<div class="col-md-4">
						<br>
						&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
						<button type="submit" class="btn btn-warning">
							&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspSAVE <span
								class="glyphicon glyphicon-send"></span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
						</button>
					</div>
				</div>

			</fieldset>
		</form:form>

</div> <!-- User Info division -->

<!-- 	</div> -->
	
	<!-- /.container -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/jquery.validate.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/sign-up.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/user.js"></script>
</body>
</html>