<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style type="text/css">
.error{
	color: red;
}
</style>
</head>
<body>
	<%-- <form action="saveuser" method="post">
		FirstName: <input type="text" name="firstName" />  <br><br>
		Email: <input type="text" name="email"/><br><br>
		Password: <input type="password" name="password"/><br><br>
		<input type="submit" value="Signup"/>
	</form> --%>
	<h2>Signup</h2>
	<s:form action="authenticate" method="post" modelAttribute="user">
	 
	  	Email: <s:input path="email" />
		<s:errors path="email"></s:errors>

		<br>
		<br>
		Password: <s:password path="password" />
		<s:errors path="password"></s:errors>

		<br>
		<br>
		<input type="submit" value="Login" />


	</s:form>


</body>
</html>