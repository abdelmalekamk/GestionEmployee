package com.training.wcd.service.employee;

import com.training.wcd.domain.Employee;

public interface EmployeeService {
	
	Employee findByName(String employeeName);

}
