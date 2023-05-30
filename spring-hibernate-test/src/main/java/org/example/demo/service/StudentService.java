package org.example.demo.service;

import java.util.List;

import org.example.demo.model.Student;

public interface StudentService {
	 public  List<Student> getAll();
	    public Student createStudent(Student student);
	    public void deleteAll();
	    public void deleteById(int id);
	    public List<Student> findById(int id);
	    public Student findByName(String name);
	    public void findByDate(String date);

	    public void findStudentByName(String name);
	    public Student updateById(int id,Student student);
	    public Student updateByName(String name,Student student);

}
