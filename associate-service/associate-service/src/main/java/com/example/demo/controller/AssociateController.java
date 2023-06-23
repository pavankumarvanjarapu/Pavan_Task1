package com.example.demo.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Associate;
import com.example.demo.entity.Skill;
import com.example.demo.service.AssociateService;

import lombok.AllArgsConstructor;
@RestController
@RequestMapping("/associates")
@AllArgsConstructor
public class AssociateController {
	   private final AssociateService associateService;
	   private final RestTemplate restTemplate;
	   
	   @PostMapping
		public ResponseEntity<Associate> addAssociate(@RequestBody Associate associate) {
		   Skill skill=restTemplate.getForObject("http://localhost:8082/skill-service/skills/{associateId}", Skill.class, Map.of("associateId",associate.getSkillId()));
		   associate.setSkillName(skill.getSkillName());
		   return ResponseEntity.status(HttpStatus.CREATED).body(associateService.addAssociate(associate));
		}
	   @GetMapping
		public ResponseEntity<List<Associate>> getAllSkillRecords() {
			return ResponseEntity.status(HttpStatus.OK).body(skillTrackerService.getAllSkillRecords());
		}
	   @GetMapping("/{id}")
		public ResponseEntity<Optional<Associate>> findByAssociateId(int id) {
			return ResponseEntity.status(HttpStatus.OK).body(skillTrackerService.findByAssociateId(id));
		}
	   @GetMapping("/{name}")
		public ResponseEntity<Associate> findByName(String  name) {
			return ResponseEntity.status(HttpStatus.OK).body(skillTrackerService.findByName(name));
		}
	   @GetMapping("/{email}")
		public ResponseEntity<Associate> findByEmail(String email) {
			return ResponseEntity.status(HttpStatus.OK).body(skillTrackerService.findByEmail(email));
		}
	   @GetMapping("/{mobnum}")
		public ResponseEntity<Associate> findByMobNum(String mobnum) {
			return ResponseEntity.status(HttpStatus.OK).body(skillTrackerService.findByMobNum(mobnum));
		}
	   @GetMapping("/{skills}")
		public ResponseEntity<Associate> findBySkills(SKILL_TYPE skills) {
			return ResponseEntity.status(HttpStatus.OK).body(skillTrackerService.findBySkills(skills));
		}
	   @DeleteMapping("/{id}")
		public ResponseEntity<Integer> deleteByAssociateId(int id) {
			return ResponseEntity.status(HttpStatus.OK).body(skillTrackerService.deleteByAssociateId(id));
		}

	   @PutMapping("/{id}")
		public ResponseEntity<Associate> updateUserById(@PathVariable("id") int id,
				@RequestBody Associate skillRecord) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(skillTrackerService.updateSkillTrackerDetails(id, skillRecord));
		}

}
