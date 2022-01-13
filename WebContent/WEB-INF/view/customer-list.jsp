<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer List</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<br>
	<input type="button" value="Add Customer"
		onClick="window.location.href='showFormForAdd'" />
	<br>
	<br>
	<form:form action="search" method="GET">
	Search Customer: <input type="text" name="customerName" />
		<input type="submit" value="Search" />
	</form:form>

	<div id="container">
		<div id="content">
			<table>
				<c:url var="sortFirstName" value="/customer/list">
				<c:param name="sort" value="1"/>
				</c:url>
				<c:url var="sortLastName" value="/customer/list">
				<c:param name="sort" value="2"/>
				</c:url>
				<c:url var="sortEmail" value="/customer/list">
				<c:param name="sort" value="3"/>
				</c:url>
							
				<tr>
				
					<th><a href="${sortFirstName}">First Name</a></th>
					<th><a href="${sortLastName}">Last Name</a></th>
					<th><a href="${sortEmail}">Email</a></th>
					<th>Action</th>
				</tr>

				<c:forEach var="temp" items="${customers}">

					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${temp.id}" />
					</c:url>

					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${temp.id}" />
					</c:url>
					<tr>
						<td>${temp.firstName}</td>
						<td>${temp.lastName}</td>
						<td>${temp.email}</td>
						<td><a href="${updateLink}">Update</a> | <a
							href="${deleteLink}"
							onclick="if(!(confirm('Are you sure you want to delete the Customer?')))return false">Delete</a></td>

					</tr>

				</c:forEach>

			</table>
		</div>
	</div>


</body>
</html>