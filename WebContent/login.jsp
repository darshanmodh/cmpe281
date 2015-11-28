<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Login Page</title>
        <base href="/Billing/"/>
        
        <script type="text/javascript">
<%--         var isLoggedIn = "<%= (String)session.getAttribute("isLoggedIn")%>"; --%>
//         if(isLoggedIn === "user")
//         	window.location.href="welcome.jsp";
//         else if (isLoggedIn === "admin")
//         	window.location.href="admin.jsp";
		</script>
<% String isLoggedIn = (String)session.getAttribute("isLoggedIn"); 
 if(isLoggedIn == "user")
 	response.sendRedirect("welcome.jsp");
 else if (isLoggedIn == "admin")
 	response.sendRedirect("admin.jsp");
%>

    </head>

    <body>
        <form id="login" name="loginForm" method="post" action="signin">
            <h1>Log In</h1>
            <fieldset id="inputs">
                <input name="username" id="username" type="text" placeholder="Username" autofocus required>   
                <input name="password" id="password" type="password" placeholder="Password" required>
            </fieldset>
            <fieldset id="check">
                <input type="checkbox" id="remember" name="remember" value="remember">Remember Me
                <label style="text-decoration: blink; color: red"/>  ${msg}
            </fieldset>
            <fieldset id="actions">
                <input type="submit" id="submit" value="Log in">
                <a href=""></a><a href="register.jsp">Register</a>
            </fieldset>
        </form>
    </body>
</html>
