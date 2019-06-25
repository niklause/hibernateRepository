/**
 * 
 */

/**
 * @author 770106
 *
 */

package com.cognizant.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5119716330336646593L;

	@Id
	private int empId;
	/*
	 * private private String lastName; private String
	 * dateOfBirth; private String dateOfJoining; private String emailId;
	 * private String phoneNumber; private String designation;
	 */
	 String firstName;
	private String username;
	private String password;
	/*
	 * private boolean isAdmin; private float salary;
	 */

	public Employee() {

	}

	public Employee(int empId,String firstName, String username, String password) {
		super();
		this.empId = empId;
		this.firstName=firstName;
		this.username = username;
		this.password = password;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}