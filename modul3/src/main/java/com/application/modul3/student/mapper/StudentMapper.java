package com.application.modul3.student.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.application.modul3.student.Student;
import com.application.modul3.student.dto.StudentCreateDTO;
import com.application.modul3.student.dto.StudentDTO;

@Service
public class StudentMapper {

	public Student studentCreateDTO2Student(StudentCreateDTO studentCreateDTO) {
		Student student = new Student();
		student.setLastName(studentCreateDTO.getLastName());
		student.setFirstName(studentCreateDTO.getLastName());
		student.setAge(studentCreateDTO.getAge());
		return student;
	}

	
	public StudentDTO student2StudentDTO(Student student) {
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(student.getId());
		studentDTO.setLastName(student.getLastName());
		studentDTO.setFirstName(student.getFirstName());
		studentDTO.setAge(student.getAge());
		return studentDTO;
	}

	public Student studentDTO2Student(StudentDTO studentDTO) {
		Student student = new Student();
		student.setId(studentDTO.getId());
		student.setLastName(studentDTO.getLastName());
		student.setFirstName(studentDTO.getFirstName());
		student.setAge(studentDTO.getAge());
		return student;
	}
	
	public List<StudentDTO> studentList2StudentListDTO(List<Student> list) {

		return list.stream().map(student -> student2StudentDTO(student)).collect(Collectors.toList());
	}
	
	public List<Student> studentListDTO2StudentList(List<StudentDTO> studentListDTO) {
		return studentListDTO.stream().map(studentDTO -> studentDTO2Student(studentDTO)).collect(Collectors.toList());
	}
}
