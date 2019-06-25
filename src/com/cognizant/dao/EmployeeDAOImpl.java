/**
 * 
 */

/**
 * @author 770106
 *
 */

package com.cognizant.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cognizant.entity.Employee;
import com.cognizant.exception.EmployeeException;

@RequestMapping("/")
public class EmployeeDAOImpl implements EmployeeDAO {
	Employee employee = null;
	private static final long serialVersionUID = 1L;

	public EmployeeDAOImpl() {
		super();
	}

	public int insert(Employee employee) throws EmployeeException {
		SessionFactory sfEmployee = new Configuration().configure()
				.addAnnotatedClass(com.cognizant.entity.Employee.class).buildSessionFactory();

		Session sessionEmployee = sfEmployee.openSession();
		sessionEmployee.beginTransaction();

		// Add new Employee object
		/*
		 * employee = new Employee(); employee.setEmpId(1);
		 * employee.setName("vinayak"); employee.setUsername("Mah");
		 * employee.setPassword("1234");
		 */

		// Save the employee in database
		sessionEmployee.save(employee);

		// Commit the transaction
		sessionEmployee.getTransaction().commit();
		return 1;

	}

	public int update(final Employee employee) throws EmployeeException {

		return 0;
	}

	public Employee viewSalary(final int empId) throws EmployeeException {
		return null;
	}

	public Employee validateEmployee(final String username, final String password) throws EmployeeException {

		SessionFactory sfEmployee = new Configuration().configure()
				.addAnnotatedClass(com.cognizant.entity.Employee.class).buildSessionFactory();

		Session sessionEmployee = sfEmployee.openSession();

		try {
			Criteria criteriaEmployee = sessionEmployee.createCriteria(Employee.class);

			criteriaEmployee.add(Restrictions.eq("username", username)).add(Restrictions.eq("password", password));
			List<Employee> employeeList = (List<Employee>) criteriaEmployee.list();

			if (employeeList.size() > 0) {
				employee = employeeList.get(0);
			} else {
				throw new EmployeeException("No such Employee");
			}
		} catch (HibernateException e) {
			throw new EmployeeException("No such Employee");
		}

		return employee;
	}
}