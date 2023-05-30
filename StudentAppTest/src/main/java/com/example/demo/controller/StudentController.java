package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@Controller
public class StudentController {

	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@GetMapping
	public String listStudents(Model theModel) {
		List<Student> thestudents = studentService.getAllStudents();
		theModel.addAttribute("students", thestudents);
		return "list-students";
	}

	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		Student thestudent = new Student();
		theModel.addAttribute("student", thestudent);
		return "student-form";
	}

	@PostMapping("/saveCustomer")
	public String saveStudent(@ModelAttribute("student") Student thestudent) {
		studentService.createStudent(thestudent);
		return "redirect:/";
	}

	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("studentId") int theId, Model theModel) {
		Optional<Student> thestudent = studentService.getStudent(theId);
		theModel.addAttribute("student", thestudent);
		return "student-form";
	}

	@GetMapping("/delete")
	public String deleteStudent(@RequestParam("studentId") int theId) {
		studentService.deleteStudent(theId);
		return "redirect:/";
	}

	@GetMapping("/findbyid")
	public String showStudentFormById(Model theModel) {
		Student theStudent = new Student();
		theModel.addAttribute("student", theStudent);
		return "findbyid";
	}

	@PostMapping("/listStudentsById")
	public String showStudentById(@ModelAttribute("student") Student theStudent, @RequestParam("id") int theId,
			Model theModel) {
		Optional<Student> student = studentService.findStudent(theId);
		if (student.isEmpty()) {
			theStudent.setErrorMessage("*** No student found for the given Id:");
			return "findbyid";
		} else {
			List<Student> theStudents = new ArrayList<>();
			theStudents.add(student.get());

			theModel.addAttribute("students", theStudents);

			return "list-students";

		}
	}

	@GetMapping("/findbyname")
	public String showStudentFormByName(Model theModel) {
		Student theStudent = new Student();
		theModel.addAttribute("student", theStudent);
		return "findbyname";
	}

	@PostMapping("/listStudentsByName")
	public String showStudentByName(@ModelAttribute("student") Student theStudent, @RequestParam("name") String name,
			Model theModel) {
		Optional<Student> student = studentService.findStudent(name);
		if (student.isEmpty()) {
			theStudent.setErrorMessage("*** No student found for the given Name:" + name);
			return "findbyname";
		} else {
			List<Student> theStudents = new ArrayList<>();
			theStudents.add(student.get());

			theModel.addAttribute("students", theStudents);

			return "list-students";

		}
	}

}