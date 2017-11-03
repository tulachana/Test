<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
      <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
       <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>

 <link type="text/css"
    rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css" >
    
 <link type="text/css"
    rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/css/home.css" >
  <link type="text/css"
    rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/font-awesome-4.7.0/css/font-awesome.min.css" >
</head>
<body>
<!-- java variables -->
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">DevOps</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Support <span class="sr-only">(current)</span></a></li>
        <li><a href="#">Contact</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class=
            "divider"></li>
            <li><a href="#">Separated link</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li>
      </ul>
      <form class="navbar-form navbar-left">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
      <c:url value="/logout" var="logoutUrl" />
     <sec:authorize access="!isAuthenticated()">
       <li><a href="${contextPath}/user/signUp">Sign Up <i class="fa fa-user-plus" aria-hidden="true"></i></a></li> 
       <li><a href="${contextPath}/user/login">Login <i class="fa fa-sign-in" aria-hidden="true"></i></a></li>
      </sec:authorize>
       <sec:authorize access="hasRole('ROLE_ADMIN')">
       <li><a href="${contextPath}/admin">Admin<i class="fa fa-cog" aria-hidden="true"></i></a></li> 
       </sec:authorize>
       
        <sec:authorize access="isAuthenticated()">
        <sec:authentication var="profile" property="principal.username" />
       <li><a href="${contextPath}/user/profile">${profile}<i class="fa fa-user-circle-o" aria-hidden="true"></i></a></li> 
       </sec:authorize>
       <sec:authorize access="isAuthenticated()">
       <li><a href="${logoutUrl}">Log Out <i class="fa fa-sign-out" aria-hidden="true"></i></a></li> 
      </sec:authorize >
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<div class="container">
   <div class="jumbotron">
	   <img class="manImg" src="${pageContext.request.contextPath}/resources/images/devops/devops_process.png" alt="devops_logo"></img>
	   <h1> DevOps and CI/CD</h1>
	   <p>DevOps Culture and Support Various Toolss!!</p>
   </div>
	
	
 <div class="row flex">
    <div class="col-lg-4 col-md-6">
       <div class="thumbnail">
    	<img class="image" src="${pageContext.request.contextPath}/resources/images/github/github_logo.jpg">
    	<div class="caption">
        <h3>GitHub</h3>
        <p>Distributed Version Control for Code Sharing and Review.</p>
        <p><a href="#" class="btn btn-primary" role="button">More</a> <a href="#" class="btn btn-default" role="button">CICD</a></p>
      </div>
       </div>
     </div>

   <div class="col-lg-4 col-md-6">
     <div class="thumbnail">
	    <img class="image" src="${pageContext.request.contextPath}/resources/images/jenkins/jenkins.jpg">
	    <div class="caption">
        <h3>Jenkins</h3>
        <p>Continous Integration Server to automate builds and deployments.</p>
        <p><a href="${contextPath}/jenkins" class="btn btn-primary" role="button">More</a> <a href="#" class="btn btn-default" role="button">CICD</a></p>
      </div>
     </div>
   </div>
   
  <div class="col-lg-4 col-md-6">
      <div class="thumbnail">
    	<img src="${pageContext.request.contextPath}/resources/images/jenkins/jenkins.jpg">
      </div>
  </div>

   <div class="col-lg-4 col-md-6">
      <div class="thumbnail">
    	<img src="${pageContext.request.contextPath}/resources/images/jenkins/jenkins.jpg">
      </div>
  </div>
   <div class="col-lg-4 col-md-6">
      <div class="thumbnail">
    	<img src="${pageContext.request.contextPath}/resources/images/jenkins/jenkins.jpg">
      </div>
  </div>
   <div class="col-lg-4 col-md-6">
      <div class="thumbnail">
    <img src="${pageContext.request.contextPath}/resources/images/jenkins/jenkins.jpg">
      </div>
  </div>
  </div>
    
</div> <!-- Div end of container -->


<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>