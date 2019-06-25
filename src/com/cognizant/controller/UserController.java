package com.cognizant.controller;

import java.util.Date;

import javax.servlet.ServletException;
import javax.validation.constraints.Null;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.entity.Employee;
import com.cognizant.service.EmployeeServiceImpl;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@CrossOrigin(origins = "http://localhost", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private EmployeeServiceImpl empService;
	private Employee emp;

	/*@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Employee registerUser(@RequestBody Employee user) {
		return empService.save(user);
	}*/

	@RequestMapping(value = "/login", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String login( Employee login) throws ServletException {

		String jwtToken = "";

		if (login.getUsername() == null || login.getPassword() == null) {
			throw new ServletException("Please fill in username and password");
		}

		String username = login.getUsername();
		String password = login.getPassword();

		Employee user = empService.validateEmployee(username, password);

		if (user == null) {
			throw new ServletException("Invalid Login");
		}

		String pwd = user.getPassword();

		if (!password.equals(pwd)) {
			throw new ServletException("Invalid login. Please check your name and password.");
		}

		jwtToken = Jwts.builder().setSubject(username).claim("roles", "user").setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS256, "secretkey").compact();
if(jwtToken.equalsIgnoreCase(""))
{
		return "Invalid";
	}
	else
	{
		return "Welcome to Mypay "+username;
	}
}
}
