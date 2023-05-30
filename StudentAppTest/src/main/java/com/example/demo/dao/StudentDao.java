package com.example.demo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {

	@Query(value = "SELECT * FROM newstudent u WHERE u.name = :name", nativeQuery = true)
	Optional<Student> findByName(@Param("name") String name);

}
