package org.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="student_name")
	private String name;
	
	@Column(name="Date")
	private String enteringDate;
	
	@Column(name="Nationality")
	private String nationality;
	
	@Column(name="code")
	private int code;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Student(int id, String name, String enteringDate, String nationality, int code) {
		super();
		this.id = id;
		this.name = name;
		this.enteringDate = enteringDate;
		this.nationality = nationality;
		this.code = code;
	}

	
//	public Student(String name1, String enteringDate1, String nationality2) {
//		// TODO Auto-generated constructor stub
//	}

	public Student(String name2, String enteringDate2, String nationality2) {
		// TODO Auto-generated constructor stub
	}

//	public Student(String name2, String enteringDate2, String nationality2, int code2) {
//		// TODO Auto-generated constructor stub
//	}

	public Student(String name2, String enteringDate2, String nationality2, int code2) {
		this.name = name2;
		this.enteringDate = enteringDate2;
		this.nationality = nationality2;
		this.code = code2;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEnteringDate() {
		return enteringDate;
	}
	public void setEnteringDate(String enteringDate) {
		this.enteringDate = enteringDate;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", enteringDate=" + enteringDate + ", nationality="
				+ nationality + ", code=" + code + "]";
	}
	

}
