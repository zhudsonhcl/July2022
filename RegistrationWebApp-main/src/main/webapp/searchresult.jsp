<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
  <h1>Employee Results</h1>
  
  <table>
  	<tr>
  		<th>Id</th>
  		<th>First name</th>
  		<th>Last name</th>
  		<th>User name</th>
  		<th>Address</th>
  		<th>Contact</th>
  	</tr>
  	
  	<c:forEach items="${list}" var="emp">
  	<tr>
  		<td>${emp.id}</td>
  		<td>${emp.first_name}</td>
  		<td>${emp.last_name}</td>
  		<td>${emp.username}</td>
  		<td>${emp.address}</td>
  		<td>${emp.contact}</td>
  	</tr>
  	</c:forEach>
  </table>
  <h2><a href="main.jsp">Return to main page?</a></h2>
 </div>
</body>