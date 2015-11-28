<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Login Page</title>
        <base href="/Billing/"/>
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
                <a href="#">Forgot your password?</a><a href="#">Register</a>
            </fieldset>
        </form>
    </body>
</html>
