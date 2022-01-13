<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Customer Here</title>
</head>
<body>
	<center>
		<h2>Add new Customer</h2>
		<form:form action="processForm" modelAttribute="customer"
			method="POST">
			<form:hidden path="id"/>
			First Name: <form:input path="firstName"/><br><br>
			Last Name: <form:input path="lastName"/><br><br>
			Email: <form:input path="email"/><br><br>
			<input type="submit" value="Save"/>
		</form:form>
	</center>
<br><br>
<a href="${pageContext.request.contextPath}/customer/list"> Return to list.</a>

</body>
</html>