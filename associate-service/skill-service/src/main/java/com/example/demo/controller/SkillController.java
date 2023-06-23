package com.example.demo.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Skill;
import com.example.demo.service.SkillService;

import lombok.AllArgsConstructor;
@RestController
@RequestMapping("/skills")
@AllArgsConstructor
public class SkillController {
	   private final SkillService skillService;
	   
	   @PostMapping
		public ResponseEntity<Skill> addSkillRecord(@RequestBody Skill skill) {
		   return ResponseEntity.status(HttpStatus.CREATED).body(skillService.addSkill(skill));
		}
	   @GetMapping("/{skillId}")
		public Optional<Skill> findDepartment(@PathVariable("skillId") int skillId)
		{
			return skillService.getSkillById(skillId);
		}
//	   @GetMapping
//		public ResponseEntity<List<SkillTracker>> getAllSkillRecords() {
//			return ResponseEntity.status(HttpStatus.OK).body(skillTrackerService.getAllSkillRecords());
//		}
//	   @GetMapping("/{id}")
//		public ResponseEntity<Optional<SkillTracker>> findByAssociateId(int id) {
//			return ResponseEntity.status(HttpStatus.OK).body(skillTrackerService.findByAssociateId(id));
//		}
//	   @GetMapping("/{name}")
//		public ResponseEntity<SkillTracker> findByName(String  name) {
//			return ResponseEntity.status(HttpStatus.OK).body(skillTrackerService.findByName(name));
//		}
//	   @GetMapping("/{email}")
//		public ResponseEntity<SkillTracker> findByEmail(String email) {
//			return ResponseEntity.status(HttpStatus.OK).body(skillTrackerService.findByEmail(email));
//		}
//	   @GetMapping("/{mobnum}")
//		public ResponseEntity<SkillTracker> findByMobNum(String mobnum) {
//			return ResponseEntity.status(HttpStatus.OK).body(skillTrackerService.findByMobNum(mobnum));
//		}
//	   @GetMapping("/{skills}")
//		public ResponseEntity<SkillTracker> findBySkills(SKILL_TYPE skills) {
//			return ResponseEntity.status(HttpStatus.OK).body(skillTrackerService.findBySkills(skills));
//		}
//	   @DeleteMapping("/{id}")
//		public ResponseEntity<Integer> deleteByAssociateId(int id) {
//			return ResponseEntity.status(HttpStatus.OK).body(skillTrackerService.deleteByAssociateId(id));
//		}
//
//	   @PutMapping("/{id}")
//		public ResponseEntity<SkillTracker> updateUserById(@PathVariable("id") int id,
//				@RequestBody SkillTracker skillRecord) {
//			return ResponseEntity.status(HttpStatus.ACCEPTED).body(skillTrackerService.updateSkillTrackerDetails(id, skillRecord));
//		}

}
