<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN PAGE</title>
</head>
<body>
<% 
String message= (String) session.getAttribute("message");
if(message != null)
out.println("<b>" + message + "</b>");
session.removeAttribute("message");
 %>
	<form method="post" action="login.check">

		Enter username <input type="text" name="username"> 
		Password <input type="password" name="password">

		<button type="submit">Login</button>
		 <input type="checkbox" checked="checked" name="remember"> Remember me
	
		<button type="button" class="cancelbtn">Cancel</button>
		<span class="psw">Forgot <a href="#">password?</a></span>
	</form>
</body>
</html>