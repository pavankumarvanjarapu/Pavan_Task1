package com.example.demo.service;

import com.example.demo.entity.Associate;

public interface AssociateService {
	public Associate addAssociate(Associate associate);
	Iterable<Associate> getAllAssociates();
	
	public List<Associate> getAllSkillRecords();
	
	public Optional<Associate> findByAssociateId(int associateId);
	
	public Associate findByName(String name);
	
	public Associate findByEmail(String email);
	
	public Associate findByMobNum(String mobnum);
	
	public Associate findBySkills(SKILL_TYPE skills);
	
	public Integer deleteByAssociateId(int associateId);
	
	public Associate updateSkillTrackerDetails(int associateId,Associate skill);
}
