package com.globalsoftwaresupport.security;

import com.globalsoftwaresupport.model.User;

public interface SecurityService {
	public void save(String username, String password);
	public void logout();

}
