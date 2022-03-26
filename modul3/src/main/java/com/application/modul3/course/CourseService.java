package com.application.modul3.course;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public Course createCourse(Course course) {
		return courseRepository.saveAndFlush(course);
	}
	
	public Course getCourseById(Integer id) {
		Optional<Course> courseOpt = courseRepository.findById(id);
		if (courseOpt.isPresent()) {
			return courseOpt.get();
		}
		return null;
	}
	
	public List<Course> getAllCourses(){
		return courseRepository.findAll();
	}
	
	public Course updateCourseById(Course course, Integer courseId) {
		Course updateCourse = getCourseById(courseId);
		updateCourse.setName(course.getName());
		updateCourse.setDurationInHours(course.getDurationInHours());
		courseRepository.flush();
		return updateCourse;
	}

	public void deleteCourseById(Integer courseId) {
		courseRepository.deleteById(courseId);	
	}


}
