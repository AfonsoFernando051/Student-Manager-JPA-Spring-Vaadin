package com.globalsoftwaresupport.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.persistence.Id;

@Entity
public class Student {

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	@NotEmpty(message = "Name can not be null")
	private String name;
	
	@Column
	@Min(value = 0, message = "Age can not be smaller than 0")
	@Max(value = 120, message = "Age can not be larger than 120")
	@NotEmpty(message = "Age must be specified")
	private int age;
	
	@Column
	@Min(value = 0, message = "Zip code can not be smaller than 0")
	@Max(value = 9999, message = "Zip code can not be larger than 9999")
	@NotNull(message = "Zip code can not be empty")
	@Digits(integer = 4, fraction = 0, message = "Zip code is a 4 digits integer")
	private int zipCode;
	
	@Column
	@NotNull(message = "Country must be specified")
	private String country;
	
	@ManyToOne
	@JoinColumn(name = "status_id")
	private Status status;
	
	public Student() {
		
	}
	
	public Student(String name, int age, int zipCode, String country, Status status) {
		super();
		this.name = name;
		this.age = age;
		this.zipCode = zipCode;
		this.country = country;
		this.status = status; 
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return this.name;
	}

}
