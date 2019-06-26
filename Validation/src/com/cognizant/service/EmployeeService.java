/**
 * 
 */

/**
 * @author 770106
 *
 */

package com.cognizant.service;

import com.cognizant.entity.Employee;
import com.cognizant.exception.EmployeeException;

public interface EmployeeService {
	public int insert(final Employee employee);

	public int update(final Employee employee);

	public Employee viewSalary(final int empId) ;

	public Employee validateEmployee(final String username, final String password);
}