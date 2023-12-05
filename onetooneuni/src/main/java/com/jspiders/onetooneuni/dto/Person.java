package com.jspiders.onetooneuni.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  int id;
	private String name;
	private  String email;
	//if it is LAZY then it will not fetch the data of non owning side when
	//we fetch the data of owning side.
	@OneToOne
	private AadharCard aadharCard;
	
}
