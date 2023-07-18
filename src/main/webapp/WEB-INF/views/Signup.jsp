<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Signup</title>
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
	<s:form action="saveuser" method="post" enctype="multipart/form-data" modelAttribute="user">
	
		FirstName: <s:input path="firstName" />
		<s:errors path="firstName" cssClass="error"></s:errors>
		<br>
		<br>
		Email: <s:input path="email" />
		<s:errors path="email"></s:errors>

		<br>
		<br>
		Password: <s:password path="password" />
		<s:errors path="password"></s:errors>

		<br>
		<br>
		
		Profile : <input type="file" name="profile" />
		<br><br>
		
		<input type="submit" value="Signup" />


	</s:form>


</body>
</html>