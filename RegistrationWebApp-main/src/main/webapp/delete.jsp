<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
 <div align="center">
  <h1>Employee Delete Form</h1>
  <form action="<%= request.getContextPath() %>/delete" method="post">
   <table style="with: 80%">
   <tr>
     <td>Id</td>
     <td><input type="number" name="id" /></td>
    </tr>
   </table>
   <h3>Make sure you want to hit delete before you hit submit!</h3>
   <input type="submit" value="Delete" />
  </form>
 </div>
</body>