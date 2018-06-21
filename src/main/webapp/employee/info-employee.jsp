<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Info Employee</title>
</head>
<body>

	ID : ${employee.id}
	<br>
	<br /> First Name ${employee.firstName}
	<br>
	<br /> Last Name : ${employee.lastName}
	<br>
	<br />
	<p><a href="EmployeeController?action=findall">Retour vers la liste</a></p>
</body>
</html>

