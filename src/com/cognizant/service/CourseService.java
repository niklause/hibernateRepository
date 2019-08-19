/**
 * 
 */
package com.cognizant.service;

import org.springframework.stereotype.Service;

import com.cognizant.entity.Course;

/**
 * @author Admin
 *
 */
@Service
public interface CourseService {

	Course save(Course course);

	Course findCourse(long id);

	Course findByCourseName(String title);

	void deleteById(long id);

	Iterable<Course> findAll();
}
