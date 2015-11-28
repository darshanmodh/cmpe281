<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Page</title>
<% String isLoggedIn = (String)session.getAttribute("isLoggedIn"); 
 if(isLoggedIn != "user")
 	response.sendRedirect("login.jsp");
%>
</head>
<body>
	<h3>Login successful!!!</h3>  
    <h4>  
        Hello,  
        <%=session.getAttribute("username")%></h4>
        <a href="sensorlist">Sensor List</a>  
        <a href="logout">Logout</a>
</body>
</html>