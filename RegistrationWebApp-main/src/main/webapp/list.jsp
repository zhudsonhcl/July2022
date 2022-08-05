<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
  <h1>List All Employees Tool</h1>
  <form action="<%= request.getContextPath() %>/list" method="post">
   <input type="submit" value="List" />
  </form>
 </div>
</body>