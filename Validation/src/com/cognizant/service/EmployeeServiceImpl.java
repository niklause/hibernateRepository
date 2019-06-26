/**
 * 
 */

/**
 * @author 770106
 *
 */

package com.cognizant.service;

import com.cognizant.dao.EmployeeDAOImpl;
import com.cognizant.entity.Employee;
import com.cognizant.exception.EmployeeException;

public class EmployeeServiceImpl implements EmployeeService {

	private Employee Employee = null;

	public int insert(final Employee employee)  {
		return 0;
	}

	public int update(final Employee employee)  {
		return 0;
	}

	public Employee viewSalary(final int empId)  {
		return null;
	}

	public Employee validateEmployee(final String username, final String password)  {
		EmployeeDAOImpl dao = new EmployeeDAOImpl();
		Employee employee = null;
		try {
			employee = dao.validateEmployee(username, password);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employee;

	}

}