package com.example.demo.service;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.Student;
public interface StudentService {
public List<Student> getAllStudents();
	
	public Student createStudent(Student customer);
	
	public Optional<Student> getStudent(int theId);

	public void deleteStudent(int theId);
	public Optional<Student> findStudent(int theId);
	public Optional<Student> findStudent(String name);
}
