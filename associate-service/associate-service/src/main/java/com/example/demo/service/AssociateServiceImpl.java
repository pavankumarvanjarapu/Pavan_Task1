package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Associate;
import com.example.demo.repository.AssociateRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AssociateServiceImpl implements AssociateService {
	private final AssociateRepository associateRepository;

	@Override
	public Associate addAssociate(Associate associate) {
		// TODO Auto-generated method stub
		return associateRepository.save(associate);
	}

	@Override
	public Iterable<Associate> getAllAssociates() {
		// TODO Auto-generated method stub
		return associateRepository.findAll();
	}

	@Override
	public Associate addSkillRecord(Associate skillRecord) {
		// TODO Auto-generated method stub
		return skillTrackerRepository.save(skillRecord);
	}

	@Override
	public List<Associate> getAllSkillRecords() {
		// TODO Auto-generated method stub
		return skillTrackerRepository.findAll();
	}

	@Override
	public Optional<Associate> findByAssociateId(int associateId) {
		// TODO Auto-generated method stub
		return skillTrackerRepository.findById(associateId);
	}
	@Override
	public Associate findByName(String name) {
		// TODO Auto-generated method stub
		Associate SkillRecord = null;
		List<Associate> skillTrackerList = getAllSkillRecords();
		for (Associate s : skillTrackerList) {
			if (s.getName() == (name)) {
				SkillRecord = s;

				break;
			}
		}
		return SkillRecord;
	}

	@Override
	public Associate findByEmail(String email) {
		// TODO Auto-generated method stub
		Associate SkillRecord = null;
		List<Associate> skillTrackerList = getAllSkillRecords();
		for (Associate s : skillTrackerList) {
			if (s.getEmail() == (email)) {
				SkillRecord = s;

				break;
			}
		}
		return SkillRecord;
	}

	@Override
	public Associate findByMobNum(String mobnum) {
		// TODO Auto-generated method stub
		Associate SkillRecord = null;
		List<Associate> skillTrackerList = getAllSkillRecords();
		for (Associate s : skillTrackerList) {
			if (s.getMob_number() == (mobnum)) {
				SkillRecord = s;

				break;
			}
		}
		return SkillRecord;
	}

	@Override
	public Associate findBySkills(SKILL_TYPE skills) {
		// TODO Auto-generated method stub
		Associate SkillRecord = null;
		List<Associate> skillTrackerList = getAllSkillRecords();
		for (Associate s : skillTrackerList) {
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
	public Associate updateSkillTrackerDetails(int associateId, Associate skill) {
		// TODO Auto-generated method stub
		Associate SkillRecord = null;
		List<Associate> skillTrackerList = getAllSkillRecords();
		for (Associate s : skillTrackerList) {
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
