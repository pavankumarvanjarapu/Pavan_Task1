package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.SKILL_TYPE;
import com.example.demo.entity.SkillTracker;

public interface SkillTrackerService {
	public SkillTracker addSkillRecord(SkillTracker skill);
	
	public List<SkillTracker> getAllSkillRecords();
	
	public Optional<SkillTracker> findByAssociateId(int associateId);
	
	public SkillTracker findByName(String name);
	
	public SkillTracker findByEmail(String email);
	
	public SkillTracker findByMobNum(String mobnum);
	
	public SkillTracker findBySkills(SKILL_TYPE skills);
	
	public Integer deleteByAssociateId(int associateId);
	
	public SkillTracker updateSkillTrackerDetails(int associateId,SkillTracker skill);
}
