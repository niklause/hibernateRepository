/**
 * 
 */
package com.cognizant.dao;

import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.entity.Course;

/**
 * @author Admin
 *
 */
@Repository
public interface CourseDao extends CrudRepository<Course, Serializable> {
	Course findById(long id);

	Course findByTitle(String title);

	void deleteById(long id);
	Iterable<Course> findAll();

}
