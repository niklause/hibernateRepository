package com.cognizant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.entity.Employee;
import com.cognizant.exception.EmployeeException;
import com.cognizant.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/secure")
public class SecureController {

	@Autowired
	private EmployeeServiceImpl empService;

	@RequestMapping("/user/")
	public String loginSuccess() {
		return "Login Successful!";
	}

	@RequestMapping(value = "/user/username", method = RequestMethod.POST)
	public Employee findByUserName(@RequestBody String username,@RequestBody String password) throws EmployeeException {
		return empService.validateEmployee(username, password);
	}

	/*@RequestMapping(value = "/user/update", method = RequestMethod.POST)
	public Employee updateUser(@RequestBody Employee user) {
		return empService.(user);
	}*/
}
