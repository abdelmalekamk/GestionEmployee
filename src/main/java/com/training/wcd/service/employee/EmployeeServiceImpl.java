package com.training.wcd.service.employee;

import com.training.wcd.dao.employee.EmployeeDao;
import com.training.wcd.dao.employee.EmployeeDaoImpl;
import com.training.wcd.domain.Employee;
import com.training.wcd.service.common.BaseServiceImpl;

public class EmployeeServiceImpl extends BaseServiceImpl<Employee> implements EmployeeService {

	private static EmployeeServiceImpl userService;

	private EmployeeServiceImpl() {
		this.dao = new EmployeeDaoImpl();
	}

	public static EmployeeServiceImpl getInstance() {
		if (userService == null) {
			userService = new EmployeeServiceImpl();
		}
		return userService;
	}
	
	public Employee findByName(String employeeName) {
		return ((EmployeeDao)dao).findByName(employeeName);
	}

}

