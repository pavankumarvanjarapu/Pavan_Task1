package com.example.demo.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "skill_tracker")
public class SkillTracker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "associate_id")
    private int id;
    @Column(name = "associate_name")
    private String name;
    private String email;
    private String mob_number;
    @Column(name = "skills")
	@Enumerated(EnumType.STRING)
	private SKILL_TYPE skills;

    
    //@ManyToOne(fetch=FetchType.LAZY)  
   // private MovieUsers movieUsers;  
}