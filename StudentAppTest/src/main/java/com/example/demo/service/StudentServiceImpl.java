package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.Student;

@Service
public class StudentServiceImpl implements StudentService{

	private final StudentDao studentDao;
	
	
	public StudentServiceImpl(StudentDao studentDao) {
		super();
		this.studentDao = studentDao;
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentDao.findAll() ;
	}

	@Override
	public Student createStudent(Student student) {
		// TODO Auto-generated method stub
		return studentDao.save(student);
	}

	@Override
	public Optional<Student> getStudent(int theId) {
		// TODO Auto-generated method stub
		Optional<Student> student= studentDao.findById(theId);
		return student;
	}

	@Override
	public void deleteStudent(int theId) {
		// TODO Auto-generated method stub
		studentDao.deleteById(theId);
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public Optional<Student> findStudent(int theId) {
		// TODO Auto-generated method stub
		Optional<Student> student= studentDao.findById(theId);
		return student;
		}

	@Override
	public Optional<Student> findStudent(String name) {
		// TODO Auto-generated method stub
		Optional<Student> student= studentDao.findByName(name);
		return student;
	}
}