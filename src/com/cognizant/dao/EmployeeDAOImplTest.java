
/**
 * 
 */

/**
 * @author 770106
 *
 */

package com.cognizant.dao;

import static org.mockito.Mockito.when;

import org.hibernate.HibernateException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.cognizant.entity.Employee;
import com.cognizant.exception.EmployeeException;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeDAOImplTest {
	private Employee employee;

	@Mock
	private EmployeeDAOImpl employeeDAOImpl;

	@Before
	public void setUp() {
		employee = new Employee();
		employee.setEmpId(3);
		employee.setUsername("user111");
		employee.setPassword("pass345");
	}

	@Test
	public void testValidateEmployeePositive() {

		try {
			when(employeeDAOImpl.validateEmployee("user111", "pass345")).thenReturn(employee);
			// when(employeeDAOImpl.insert(employee)).thenReturn(1);
		} catch (EmployeeException e) {
			e.printStackTrace();
		}
	}

	/*
	 * @Test(expected=HibernateException.class) public void
	 * testValidateEmployeeNegative() {
	 * 
	 * try { Assert.assertTrue(employeeDAOImpl.validateEmployee("user111",
	 * "pass356") == employee); } catch (Exception e) {
	 * System.out.println(e.getMessage()); } }
	 */
}
