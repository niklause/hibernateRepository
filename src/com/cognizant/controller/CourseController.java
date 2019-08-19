/**
 * 
 */
package com.cognizant.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.entity.Course;
import com.cognizant.service.CourseService;

/**
 * @author Admin
 *
 */
@RestController
@RequestMapping("/Course/Operations")
public class CourseController {
	@Autowired
	CourseService courseService;

	@RequestMapping(value = "/Add/Course", method = RequestMethod.POST)
	public Course addCourse(@RequestBody Course course) {
		return courseService.save(course);

	}

	@RequestMapping(value = "/Update/Course", method = RequestMethod.POST)
	public Course updateCourse(@RequestBody Course course) {
		return courseService.save(course);

	}

	@RequestMapping(value = "/Search/Course/id", method = RequestMethod.POST)
	public Course searchCourse(@RequestBody Course course) {
		long id = course.getId();
		return courseService.findCourse(id);

	}

	@RequestMapping(value = "/Search/Course/Title", method = RequestMethod.POST)
	public Course searchCoursebyTitle(@RequestBody Course course) {
		String title = course.getTitle();
		return courseService.findByCourseName(title);

	}

	@RequestMapping(value = "/Delete/Course/Title", method = RequestMethod.POST)
	public String deleteCoursebyId(@RequestParam long id) {
		courseService.deleteById(id);
		return "Course Deleted";

	}
	@RequestMapping(value = "/Fetch/Courses", method = RequestMethod.POST)
	public List<Course> findAll()
	{
		Iterable<Course> courseItr=courseService.findAll();
		Iterator<Course> courses=courseItr.iterator();
		List<Course> listofCourses=new ArrayList<Course>();
		while(courses.hasNext())
		{
			listofCourses.add(courses.next());
		}
		return listofCourses;
	}
	
}
