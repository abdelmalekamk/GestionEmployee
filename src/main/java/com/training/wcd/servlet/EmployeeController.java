package com.training.wcd.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.training.wcd.domain.Employee;
import com.training.wcd.service.employee.EmployeeServiceImpl;

enum RequestAction {
	FINDALL, INSERT, CREATE_OR_UPDATE, READ, EDIT, DELETE
}

public class EmployeeController extends HttpServlet {
private static final long serialVersionUID = 1L;

	private static final String CREATE_OR_EDIT_EMPLOYEE = "/employee/edit-employee.jsp";
	private static final String LIST_EMPLOYEE = "/employee/list-employee.jsp";
	private static final String INFO_EMPLOYEE = "/employee/info-employee.jsp";

	private EmployeeServiceImpl employeeServiceImpl = EmployeeServiceImpl.getInstance();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String forward = StringUtils.EMPTY;

		String action = request.getParameter("action").toUpperCase();

		RequestAction actionEnum = RequestAction.valueOf(action);
		switch (actionEnum) {
		case FINDALL: {
			List<Employee> employeeList = employeeServiceImpl.findAll();
			request.setAttribute("employees", employeeList);
			forward = LIST_EMPLOYEE;
			break;
		}
		case READ: {
			Integer employeeId = Integer.parseInt(request.getParameter("id"));
			Employee employee = employeeServiceImpl.find(employeeId);
			request.setAttribute("employee", employee);
			forward = INFO_EMPLOYEE;
			break;
		}
		case INSERT: {
			request.setAttribute("employee", new Employee());
			forward = CREATE_OR_EDIT_EMPLOYEE;
			break;
		}
		case EDIT: {
			Integer employeeId = Integer.parseInt(request.getParameter("id"));
			Employee employee = employeeServiceImpl.find(employeeId);
			request.setAttribute("employee", employee);
			forward = CREATE_OR_EDIT_EMPLOYEE;
			break;
		}
		default: {
			List<Employee> employeeList = employeeServiceImpl.findAll();
			request.setAttribute("employees", employeeList);
			forward = LIST_EMPLOYEE;
			break;
		}
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action").toUpperCase();

		RequestAction actionEnum = RequestAction.valueOf(action);

		switch (actionEnum) {
		case CREATE_OR_UPDATE: {
			Employee employee = new Employee();
			employee.setFirstName(request.getParameter("firstName"));
			employee.setLastName(request.getParameter("lastName"));
			String id = request.getParameter("id");
			if(StringUtils.isNotBlank(id)) {
				employee.setId(Integer.valueOf(id));
			}
			
			employeeServiceImpl.save(employee);
			break;
		}
		case DELETE: {
			Integer employeeId = Integer.valueOf(request.getParameter("id"));
			employeeServiceImpl.delete(employeeId);
			break;
		}
		default: {
			break;
		}
		}

		List<Employee> employeeList = employeeServiceImpl.findAll();
		request.setAttribute("employees", employeeList);	
		response.sendRedirect("EmployeeController?action=findAll");
	}
}
