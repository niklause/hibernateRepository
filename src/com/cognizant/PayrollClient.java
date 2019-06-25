/**
 * 
 */

/**
 * @author 770106
 *
 */
package com.cognizant;

import org.springframework.boot.SpringApplication;
import com.cognizant.config.JwtFilter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PayrollClient {

	@Bean
	public FilterRegistrationBean jwtFilter() {
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/secure/*");

		return registrationBean;
	}



	public static void main(String[] args) {
		SpringApplication.run(PayrollClient.class, args);
	}

}