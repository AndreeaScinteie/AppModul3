package com.application.modul3.course.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.application.modul3.course.Course;
import com.application.modul3.course.dto.CourseCreateDTO;
import com.application.modul3.course.dto.CourseDTO;

@Service
public class CourseMapper {
	
	public Course CourseCreateDTO2Course(CourseCreateDTO courseCreateDTO) {
		Course course = new Course();
		course.setName(courseCreateDTO.getName());
		course.setDurationInHours(courseCreateDTO.getDurationInHours());
		return course;
	}

	public CourseDTO course2CourseDTO(Course course) {
		CourseDTO courseDTO = new CourseDTO();
		courseDTO.setId(course.getId());
		courseDTO.setName(course.getName());
		courseDTO.setDurationInHours(course.getDurationInHours());
		return courseDTO;
	}

	public List<CourseDTO> courseList2CourseListDTO(List<Course> allCourses) {
		return allCourses.stream().map(course -> course2CourseDTO(course)).collect(Collectors.toList());
		
	}

}
