package com.cognizant.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.cognizant.entity.Employee;
import com.cognizant.service.EmployeeService;
import com.cognizant.service.EmployeeServiceImpl;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * Servlet Filter implementation class ValidatorFilter
 */
public class ValidatorFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ValidatorFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String jwtToken = "";

		String username = request.getParameter("empId");
		String password = request.getParameter("password");

		EmployeeService empService = new EmployeeServiceImpl();
		
		if (username == null || password == null) {
			throw new ServletException("Please fill in username and password");
		}

		Employee user = empService.validateEmployee(username, password);

		if (user == null) {
			throw new ServletException("Invalid Login");
		}

		String pwd = user.getPassword();

		if (!password.equals(pwd) && !username.equals(user.getUsername())) {
			throw new ServletException("Invalid login. Please check your username and password.");
		}

		jwtToken = Jwts.builder().setSubject(username).claim("roles", "user").setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS256, "secretkey").compact();
		request.setAttribute("token", jwtToken);
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
