package com.globalsoftwaresupport.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.globalsoftwaresupport.model.Student;

@Service
public interface StudentService {
	public void save(Student student);
	public void remove(Student student);
	public List<Student> findAll();
	public List<Student> find(String substring);
}
