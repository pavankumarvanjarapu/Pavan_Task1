package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.SKILL_TYPE;
import com.example.demo.entity.SkillTracker;
import com.example.demo.service.SkillTrackerService;

import lombok.AllArgsConstructor;
@RestController
@RequestMapping("/skillTrackerDetails")
@AllArgsConstructor
public class SkillTrackerController {
	   private final SkillTrackerService skillTrackerService;
	   
	   @PostMapping
		public ResponseEntity<SkillTracker> addSkillRecord(@RequestBody SkillTracker skill) {
			return ResponseEntity.status(HttpStatus.CREATED).body(skillTrackerService.addSkillRecord(skill));
		}
	   @GetMapping
		public ResponseEntity<List<SkillTracker>> getAllSkillRecords() {
			return ResponseEntity.status(HttpStatus.OK).body(skillTrackerService.getAllSkillRecords());
		}
	   @GetMapping("/{id}")
		public ResponseEntity<Optional<SkillTracker>> findByAssociateId(int id) {
			return ResponseEntity.status(HttpStatus.OK).body(skillTrackerService.findByAssociateId(id));
		}
	   @GetMapping("/{name}")
		public ResponseEntity<SkillTracker> findByName(String  name) {
			return ResponseEntity.status(HttpStatus.OK).body(skillTrackerService.findByName(name));
		}
	   @GetMapping("/{email}")
		public ResponseEntity<SkillTracker> findByEmail(String email) {
			return ResponseEntity.status(HttpStatus.OK).body(skillTrackerService.findByEmail(email));
		}
	   @GetMapping("/{mobnum}")
		public ResponseEntity<SkillTracker> findByMobNum(String mobnum) {
			return ResponseEntity.status(HttpStatus.OK).body(skillTrackerService.findByMobNum(mobnum));
		}
	   @GetMapping("/{skills}")
		public ResponseEntity<SkillTracker> findBySkills(SKILL_TYPE skills) {
			return ResponseEntity.status(HttpStatus.OK).body(skillTrackerService.findBySkills(skills));
		}
	   @DeleteMapping("/{id}")
		public ResponseEntity<Integer> deleteByAssociateId(int id) {
			return ResponseEntity.status(HttpStatus.OK).body(skillTrackerService.deleteByAssociateId(id));
		}
//	   @GetMapping("/{id}")
//		public ResponseEntity<Movie> FindMovieByMovieId(@PathVariable Integer id) {
//		   Movie findByMovieId = movieService.findByMovieId(id);
//		   if(findByMovieId == null)
//			   throw new MyCustomException("Movie With id " + id + " nt found");
//		   else
//			   return ResponseEntity.status(HttpStatus.FOUND).body(findByMovieId);
//		}

	   @PutMapping("/{id}")
		public ResponseEntity<SkillTracker> updateUserById(@PathVariable("id") int id,
				@RequestBody SkillTracker skillRecord) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(skillTrackerService.updateSkillTrackerDetails(id, skillRecord));
		}

}
