package com.globalsoftwaresupport.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.globalsoftwaresupport.model.Status;

@Service
public interface StatusService {
	public void save(Status status);
	public List<Status> findAll();
}
