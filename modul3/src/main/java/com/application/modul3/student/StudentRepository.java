package com.application.modul3.student;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	public Set<Student> findByIdIn(Set<Integer> studentIds);

}
