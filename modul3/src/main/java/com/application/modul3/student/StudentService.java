package com.application.modul3.student;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.modul3.course.Course;
import com.application.modul3.course.CourseService;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private CourseService courseService;
	
	
	public Student createStudent(Student student) {
		return studentRepository.saveAndFlush(student);
	}
	
	public List<Student> getAllStudent(){
		return studentRepository.findAll();
	}
	
	public Student getStudentById(Integer id) {
		Optional<Student> studentOpt = studentRepository.findById(id);
		if (studentOpt.isPresent()) {
			return studentOpt.get();
		}
		return null;
	}
	
	public Student updateStudentById(Student student, Integer id) {
		Student updateStudent = getStudentById(id);
		updateStudent.setLastName(student.getLastName());
		updateStudent.setFirstName(student.getFirstName());
		updateStudent.setAge(student.getAge());
		studentRepository.flush();
		return updateStudent;
	}
	
	public void deleteStudentById(Integer id) {
		studentRepository.deleteById(id);
	}
	
	public Set<Student> getStudents(Set<Integer> studentIds) {
		return studentRepository.findByIdIn(studentIds);
	}
	
	public void addCourseToStudent(Integer studentId, Integer courseId) {
		Student student = getStudentById(studentId);
		Course course = courseService.getCourseById(courseId);
		student.addCourse(course);
		studentRepository.save(student);
		
		
	}
	
	public void removeStudentAndCourse(Integer studentId, Integer courseId) {
		Student student = getStudentById(studentId);
		Course course = courseService.getCourseById(courseId);
		student.removeCourse(course);
		studentRepository.save(student);
	}

}
