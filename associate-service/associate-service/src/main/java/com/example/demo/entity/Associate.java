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
@Table(name = "associate")
public class Associate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "associate_id")
	private int associateId;
	@Column(name = "associate_name")
	private String associateName;
	private String email;
	@Column(name = "mob_number")
	private String mobNumber;
	private int skillId;
	private String skillName;

	// @ManyToOne(fetch=FetchType.LAZY)
	// private MovieUsers movieUsers;
}