package com.project.basic.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name = "student_data")
public class Student {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "student_name")
	private String name;
	
	
	@Column(name = "student_city")
	private String city;
	
	
	@Column(name = "student_gender")
	private String geneder;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getGeneder() {
		return geneder;
	}

	public void setGeneder(String geneder) {
		this.geneder = geneder;
	}
	
	
	
	
}
