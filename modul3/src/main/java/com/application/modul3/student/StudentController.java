package com.application.modul3.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.modul3.student.dto.StudentDTO;
import com.application.modul3.student.mapper.StudentMapper;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private StudentMapper studentMapper;
	
	@PostMapping
	public StudentDTO createStudent(@RequestBody StudentDTO studentDTO) {
		Student student = studentService.createStudent(studentMapper.studentDTO2Student(studentDTO));
		return studentMapper.student2StudentDTO(student);
	}
	
	@GetMapping("/list")
	public List<StudentDTO> getAllStudent() {
		return studentMapper.studentList2StudentListDTO(studentService.getAllStudent());
	}
	
	@GetMapping("/{studentId}")
	public StudentDTO getStudentById(@PathVariable Integer studentId) {
		return studentMapper.student2StudentDTO(studentService.getStudentById(studentId));
	}
	
	@GetMapping("/add-course/{studentId}/{courseId}")
	public void addCourseToStudent(@PathVariable Integer studentId, @PathVariable Integer courseId) {
		studentService.addCourseToStudent(studentId, courseId);
	}
	
	@GetMapping("/remove-course/{studentId}/{courseId}")
	public void removeStudentAndCourse(@PathVariable Integer studentId, @PathVariable Integer courseId) {
		studentService.removeStudentAndCourse(studentId, courseId);

	}
	
	@PutMapping("/{studentId}")
	public StudentDTO updateStudent(@RequestBody StudentDTO studentDTO, @PathVariable Integer studentId) {
		Student student = studentService.updateStudentById(studentMapper.studentDTO2Student(studentDTO), studentId);
		return studentMapper.student2StudentDTO(student);
	}
	
	@DeleteMapping("/{studentId}")
	public void deleteStudentById(@PathVariable Integer studentId) {
		studentService.deleteStudentById(studentId);
	}

}
