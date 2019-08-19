/**
 * 
 */
package com.cognizant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.dao.CourseDao;
import com.cognizant.entity.Course;

/**
 * @author Admin
 *
 */
@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	CourseDao coursedao;

	@Override
	public Course save(Course course) {

		return coursedao.save(course);
	}

	@Override
	public Course findCourse(long id) {
		return coursedao.findById(id);
	}

	@Override
	public Course findByCourseName(String title) {
		return coursedao.findByTitle(title);
	}

	@Override
	public void deleteById(long id) {
		coursedao.delete(id);
	}

	@Override
	public Iterable<Course> findAll() {

		return coursedao.findAll();
	}

}
