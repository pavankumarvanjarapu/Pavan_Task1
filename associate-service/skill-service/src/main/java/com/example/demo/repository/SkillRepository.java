package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Skill;

public interface SkillRepository extends JpaRepository<Skill, Integer>{
//	@Transactional
//	@Modifying
//	@Query("DELETE FROM SkillTracker WHERE associate_id = :id")
//	public Integer deleteByAssociateId(int id);

}
