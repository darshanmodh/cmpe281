<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Page</title>
<% String isLoggedIn = (String)session.getAttribute("isLoggedIn"); 
 if (isLoggedIn != "admin")
 	response.sendRedirect("login.jsp");
%>
</head>
<body>
<h1>Hello Admin</h1>
<a href="logout">Logout</a>
</body>
</html>