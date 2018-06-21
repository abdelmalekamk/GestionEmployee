package com.training.wcd.dao.employee;

import com.training.wcd.domain.Employee;

public interface EmployeeDao {
	
	/**
	 * Find an Employee by name by using a NamedQuey
	 * 
	 * @param employeeName
	 * @return
	 */
	Employee findByName(String employeeName);

}
