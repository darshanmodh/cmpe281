<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register New User</title>
 
<link rel="stylesheet" href="css/pwd_strength.css" type="text/css"/>

<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="js/jquery.pwstrength.js"></script>
<% String isLoggedIn = (String)session.getAttribute("isLoggedIn"); 
 if(isLoggedIn == "user")
 	response.sendRedirect("welcome.jsp");
 else if (isLoggedIn == "admin")
 	response.sendRedirect("admin.jsp");
%>

<script type="text/javascript">
	function validateForm() {
		var x = document.forms["login"]["username"].value;
		var y = document.getElementById('actual').value;

		if (y == "taken") {
			return false;
		} else {
		}
	}
</script>
<script type="text/javascript">

jQuery(function($) { $('#password').pwstrength(); });

	function loadXMLDoc() {
		var xmlhttp;
		var k = document.getElementById("username").value;
		var urls = "checkusername.jsp?ver=" + k;

		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4) {
				document.getElementById("err").innerHTML = xmlhttp.responseText;
			}
		}
		xmlhttp.open("GET", urls, true);
		xmlhttp.send();
	}
	
	function formSubmission() {
			var y = document.getElementById('actual').value;
			if (y == "taken") {
				returnToPreviousPage();
				return false;
			}
	}
</script>
</head>
<body onsubmit="formSubmission()">

	<form name="login" method="post" action="register"
		onsubmit="return validateForm();">

		<h1>User Registration</h1>

		<fieldset id="inputs">
			
			User Name: 
			<input type="text" name="username" id="username" required onkeyup="loadXMLDoc()"> 
			<span id="err"> </span><br>
			
			Password:
			<input type="password" class="password" name="password" id="password" data-indicator="pwindicator" required/>
            <div id="pwindicator">
                <div class="bar"></div><br>
                <div class="label"></div>
            </div><br>
            
            Confirm Password:
            <input type="password" class="password" name="cpassword" id="cpassword" required /><br>
            
            Name:
            <input name="name" id="name" type="text" required >  <br>
            
            Email:
            <input name="email" id="email" type="text" required >  <br>
            
            Mobile:
            <input name="mobile" id="mobile" type="text" required ><br>
            
            Alert Value:
            <input name="alertvalue" id="alertvalue" type="text" required > <br><br>
			
		</fieldset>
		
		<fieldset id="actions">
			<input type="submit" id="submit" value="Register" name="submit" />
            <input type="reset" id="reset" value="Reset" name="reset" />
        </fieldset>

	</form>


</body>
</html>