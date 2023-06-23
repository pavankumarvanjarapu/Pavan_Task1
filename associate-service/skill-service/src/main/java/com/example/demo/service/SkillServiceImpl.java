package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Skill;
import com.example.demo.repository.SkillRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SkillServiceImpl implements SkillService {
	private final SkillRepository skillRepository;

	@Override
	public Skill addSkill(Skill skill) {
		// TODO Auto-generated method stub
		return skillRepository.save(skill);
	}

	@Override
	public Optional<Skill> getSkillById(int skillId) {
		// TODO Auto-generated method stub
		return skillRepository.findById(skillId);
	}
//
//	@Override
//	public List<SkillTracker> getAllSkillRecords() {
//		// TODO Auto-generated method stub
//		return skillTrackerRepository.findAll();
//	}
//
//	@Override
//	public Optional<SkillTracker> findByAssociateId(int associateId) {
//		// TODO Auto-generated method stub
//		return skillTrackerRepository.findById(associateId);
//	}
//	@Override
//	public SkillTracker findByName(String name) {
//		// TODO Auto-generated method stub
//		SkillTracker SkillRecord = null;
//		List<SkillTracker> skillTrackerList = getAllSkillRecords();
//		for (SkillTracker s : skillTrackerList) {
//			if (s.getName() == (name)) {
//				SkillRecord = s;
//
//				break;
//			}
//		}
//		return SkillRecord;
//	}
//
//	@Override
//	public SkillTracker findByEmail(String email) {
//		// TODO Auto-generated method stub
//		SkillTracker SkillRecord = null;
//		List<SkillTracker> skillTrackerList = getAllSkillRecords();
//		for (SkillTracker s : skillTrackerList) {
//			if (s.getEmail() == (email)) {
//				SkillRecord = s;
//
//				break;
//			}
//		}
//		return SkillRecord;
//	}
//
//	@Override
//	public SkillTracker findByMobNum(String mobnum) {
//		// TODO Auto-generated method stub
//		SkillTracker SkillRecord = null;
//		List<SkillTracker> skillTrackerList = getAllSkillRecords();
//		for (SkillTracker s : skillTrackerList) {
//			if (s.getMob_number() == (mobnum)) {
//				SkillRecord = s;
//
//				break;
//			}
//		}
//		return SkillRecord;
//	}
//
//	@Override
//	public SkillTracker findBySkills(SKILL_TYPE skills) {
//		// TODO Auto-generated method stub
//		SkillTracker SkillRecord = null;
//		List<SkillTracker> skillTrackerList = getAllSkillRecords();
//		for (SkillTracker s : skillTrackerList) {
//			if (s.getSkills() == (skills)) {
//				SkillRecord = s;
//
//				break;
//			}
//		}
//		return SkillRecord;
//	}
//
//	@Override
//	public Integer deleteByAssociateId(int associateId) {
//		return skillTrackerRepository.deleteByAssociateId(associateId);
//
//	}
//
//	@Override
//	public SkillTracker updateSkillTrackerDetails(int associateId, SkillTracker skill) {
//		// TODO Auto-generated method stub
//		SkillTracker SkillRecord = null;
//		List<SkillTracker> skillTrackerList = getAllSkillRecords();
//		for (SkillTracker s : skillTrackerList) {
//			if (s.getId() == (associateId)) {
//				SkillRecord = s;
//
//				break;
//			}
//
//			if (!(SkillRecord == null)) {
//
//				SkillRecord.setName(skill.getName());
//				SkillRecord.setEmail(skill.getEmail());
//				SkillRecord.setMob_number(skill.getMob_number());
//				SkillRecord = skillTrackerRepository.save(SkillRecord);
//			}
//
//		}
//		return SkillRecord;
//	}
}
