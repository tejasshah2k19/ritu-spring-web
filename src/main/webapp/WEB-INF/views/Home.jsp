<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	FirstName : ${user.firstName}
	<br> Email : ${user.email }
	<br> Password :${user.password }
	<br>
<a href="logout">Logout</a>
</body>
</html>