<%@ page import="com.hudson.model.User" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- request is an implicit jsp object
     out is an implicit object in jsp 
 -->
<%
        User u=(User)request.getAttribute("abc");
        out.println("<h1 style=color:blue>Welcome "+u.getUsername()+"</h1>");
        out.println("<h2>Which option would you like to use?</h2>");
%>

<form action="create" method="post">
<h3>Add user</h3>
User Name:<input type="text" name="un"><br>  
Password:<input type="password" name="pwd"><br>  
<input type="submit" value="Add user">  
</form>
<br><br>

<form action="update" method = "post">
<h3>Update password</h3>
User: <input type="text" name="un"><br>
Password:<input type="password" name="pwd"><br> 
<input type="submit" value = "Update password">
</form>
<br><br>

<form action="delete" method = "post">
<h3>Delete profile</h3>
Be sure you want to click this option<br>
User name: <input type="text" name="un"><br>
<input type="submit" value = "Delete user">
</form>
</body>
</html>