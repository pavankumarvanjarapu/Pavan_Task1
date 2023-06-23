package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entity.Skill;

public interface SkillService {
	public Skill addSkill(Skill skill);
	Optional<Skill> getSkillById(int skillId);
//	
//	public List<SkillTracker> getAllSkillRecords();
//	
//	public Optional<SkillTracker> findByAssociateId(int associateId);
//	
//	public SkillTracker findByName(String name);
//	
//	public SkillTracker findByEmail(String email);
//	
//	public SkillTracker findByMobNum(String mobnum);
//	
//	public SkillTracker findBySkills(SKILL_TYPE skills);
//	
//	public Integer deleteByAssociateId(int associateId);
//	
//	public SkillTracker updateSkillTrackerDetails(int associateId,SkillTracker skill);
}
