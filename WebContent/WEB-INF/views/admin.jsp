<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrator Page</title>
 <link type="text/css"
    rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css" >
</head>
<link type="text/css"
    rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/font-awesome-4.7.0/css/font-awesome.min.css" >
<body>
<div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading">Users List Management</div>
  <div class="panel-body">
    <p>This is just visible for admins Only. It lists all the users.</p>
  </div>

  <!-- Table -->

  <table class="table table-bordered table-hover table-condensed">
       <tr>
          <th>Id</th>
         <th>First Name</th>
            <th>Last Name </th>
            <th><i class="fa fa-envelope-o" aria-hidden="true"></i> Email</th>
            <th><i class="fa fa-user" aria-hidden="true"></i> UserName</th>
            <th><i class="fa fa-check" aria-hidden="true"></i> Enabled</th>
            <th><i class="fa fa-users" aria-hidden="true"></i> Role </th>
            <th><i class="fa fa-th" aria-hidden="true"></i> Action</th>
         </tr>
       <c:set var="count" value="0" scope="page"/>
       <c:forEach var="tempUser" items="${users}">
   
       <c:forEach var="tempRole" items="${tempUser.userRole}">
       <c:set var="count" value="${count + 1}" scope="page"/>
      
      
       <!-- Construct update link with username -->
         <c:url var="updateLink"  value="/admin/editUser">
           <c:param name="username" value="${tempUser.userName}" />
         </c:url>
         
         <!--  Delete link with user name -->
         
          <c:url var="deleteLink"  value="/admin/deleteUser">
           <c:param name="username" value="${tempUser.userName}" />
         </c:url> 
         
         
         	<tr>
         	   <td>${count}</td>
         		<td>${tempUser.firstName}</td>
         		<td>${tempUser.lastName}</td>
         		<td>${tempUser.emailAddress}</td>
         		<td>${tempUser.userName}</td>
         		<td>${tempUser.enabled}</td>
         		<td>${tempRole.role}</td>
         		<td>
         		<a href="${updateLink}">EDIT <i class="fa fa-pencil-square-o" aria-hidden="true"></i></a> 
         		 |
         		 <a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to Delete?')))return false" >DELETE <i class="fa fa-trash" aria-hidden="true"></i> </a>
         		 </td> 
         	</tr>
         </c:forEach>
        </c:forEach>
  </table>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
 <script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>