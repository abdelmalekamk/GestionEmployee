<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>
	<c:choose>
		<c:when test="${not empty employee.id}">Edit Employee ${employee.firstName}</c:when>
		<c:otherwise>Add new employee</c:otherwise>
	</c:choose>
</title>
</head>
<body>
	<form method="POST" action='EmployeeController?action=create_or_update' name="createOrUpdateEmployee">
		ID : ${employee.id} <input type="hidden" name="id" 
			value="${employee.id}" /> <br>
		<br /> First Name : <input type="text" name="firstName"
			value="${employee.firstName}" maxlength="100"/> <br>
		<br /> Last Name : <input type="text" name="lastName"
			value="${employee.lastName}" maxlength="100"/> <br>
		<br /> <input type="submit" value="Submit" />
	</form>
	<p><a href="EmployeeController?action=findall">Annuler</a></p>
</body>
</html>

