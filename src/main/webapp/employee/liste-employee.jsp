<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show All Employees</title>
</head>
<body>
    <table border=1>
        <thead>
            <tr>
                <th>Employee Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${employees}" var="employee">
                <tr>
                    <td><a href="EmployeeController?action=read&id=${employee.id}">${employee.id}</a></td>
                    <td>${employee.firstName}</td>
  <td>${employee.lastName}</td>
                    <td><a href="EmployeeController?action=edit&id=${employee.id}">Update</a></td>
                    <td>
                    	<form action="EmployeeController?action=delete" method="post" name="deleteEmployee">
                    		<input type="hidden" name="id" value="${employee.id}" />
						    <input type="submit" value="Delete" />
						</form>	
                   	</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="EmployeeController?action=insert">Add Employee</a></p>
</body>
                    