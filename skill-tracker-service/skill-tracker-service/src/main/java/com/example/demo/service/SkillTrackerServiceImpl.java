package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.SKILL_TYPE;
import com.example.demo.entity.SkillTracker;
import com.example.demo.repository.SkillTrackerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SkillTrackerServiceImpl implements SkillTrackerService {
	private final SkillTrackerRepository skillTrackerRepository;

	@Override
	public SkillTracker addSkillRecord(SkillTracker skillRecord) {
		// TODO Auto-generated method stub
		return skillTrackerRepository.save(skillRecord);
	}

	@Override
	public List<SkillTracker> getAllSkillRecords() {
		// TODO Auto-generated method stub
		return skillTrackerRepository.findAll();
	}

	@Override
	public Optional<SkillTracker> findByAssociateId(int associateId) {
		// TODO Auto-generated method stub
		return skillTrackerRepository.findById(associateId);
	}
	@Override
	public SkillTracker findByName(String name) {
		// TODO Auto-generated method stub
		SkillTracker SkillRecord = null;
		List<SkillTracker> skillTrackerList = getAllSkillRecords();
		for (SkillTracker s : skillTrackerList) {
			if (s.getName() == (name)) {
				SkillRecord = s;

				break;
			}
		}
		return SkillRecord;
	}

	@Override
	public SkillTracker findByEmail(String email) {
		// TODO Auto-generated method stub
		SkillTracker SkillRecord = null;
		List<SkillTracker> skillTrackerList = getAllSkillRecords();
		for (SkillTracker s : skillTrackerList) {
			if (s.getEmail() == (email)) {
				SkillRecord = s;

				break;
			}
		}
		return SkillRecord;
	}

	@Override
	public SkillTracker findByMobNum(String mobnum) {
		// TODO Auto-generated method stub
		SkillTracker SkillRecord = null;
		List<SkillTracker> skillTrackerList = getAllSkillRecords();
		for (SkillTracker s : skillTrackerList) {
			if (s.getMob_number() == (mobnum)) {
				SkillRecord = s;

				break;
			}
		}
		return SkillRecord;
	}

	@Override
	public SkillTracker findBySkills(SKILL_TYPE skills) {
		// TODO Auto-generated method stub
		SkillTracker SkillRecord = null;
		List<SkillTracker> skillTrackerList = getAllSkillRecords();
		for (SkillTracker s : skillTrackerList) {
			if (s.getSkills() == (skills)) {
				SkillRecord = s;

				break;
			}
		}
		return SkillRecord;
	}

	@Override
	public Integer deleteByAssociateId(int associateId) {
		return skillTrackerRepository.deleteByAssociateId(associateId);

	}

	@Override
	public SkillTracker updateSkillTrackerDetails(int associateId, SkillTracker skill) {
		// TODO Auto-generated method stub
		SkillTracker SkillRecord = null;
		List<SkillTracker> skillTrackerList = getAllSkillRecords();
		for (SkillTracker s : skillTrackerList) {
			if (s.getId() == (associateId)) {
				SkillRecord = s;

				break;
			}

			if (!(SkillRecord == null)) {

				SkillRecord.setName(skill.getName());
				SkillRecord.setEmail(skill.getEmail());
				SkillRecord.setMob_number(skill.getMob_number());
				SkillRecord = skillTrackerRepository.save(SkillRecord);
			}

		}
		return SkillRecord;
	}
}
