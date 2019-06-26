/**
 * 
 */

/**
 * @author 770106
 *
 */

package com.cognizant.dao;

import com.cognizant.entity.Employee;
import com.cognizant.exception.EmployeeException;

public interface EmployeeDAO {
	public int insert(final Employee employee) throws EmployeeException;

	public int update(final Employee employee) throws EmployeeException;

	public Employee viewSalary(final int empId) throws EmployeeException;

	public Employee validateEmployee(final String username, final String password) throws EmployeeException;
}