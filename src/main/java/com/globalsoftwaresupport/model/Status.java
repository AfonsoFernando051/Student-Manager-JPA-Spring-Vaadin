package com.globalsoftwaresupport.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.vaadin.flow.component.polymertemplate.Id;

@Entity
public class Status {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	private String name;

	public String getName() {
		return name;
	}

	public Status(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
