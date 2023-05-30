package org.example.demo.service;

import java.util.List;

import org.example.demo.dao.StudentDao;
import org.example.demo.model.Student;
import org.springframework.stereotype.Component;
@Component(value="service")
public class StudentServiceImpl implements StudentService {
	private  StudentDao sd;
	
	

	public StudentServiceImpl(StudentDao sd) {
		super();
		this.sd = sd;
	}

	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		return sd.getAll();
	}

	@Override
	public Student createStudent(Student student) {
		// TODO Auto-generated method stub
		return sd.createStudent(student);
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		sd.deleteAll();
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		sd.deleteById(id);
	}

	@Override
	public List<Student> findById(int id) {
		// TODO Auto-generated method stub
		return sd.findById(id);
	}
	@Override
	public Student findByName(String name) {
		// TODO Auto-generated method stub
		return sd.findByName(name);
	}
	
	@Override
	public void findByDate(String date) {
		// TODO Auto-generated method stub
		sd.findByDate(date);
	}

	

	@Override
	public void findStudentByName(String name) {
		// TODO Auto-generated method stub
		sd.findStudentByName(name);
		
	}

	@Override
	public Student updateById(int id, Student student) {
		// TODO Auto-generated method stub
		return sd.updateById(id, student);
	}

	@Override
	public Student updateByName(String name, Student student) {
		// TODO Auto-generated method stub
		return sd.updateByName(name, student);
	}

	

}
