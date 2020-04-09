package com.chainlinkproto.service;

import org.springframework.web.util.NestedServletException;

import com.chainlinkproto.model.Accounts;
import com.chainlinkproto.model.Users;
import com.microsoft.sqlserver.jdbc.SQLServerException;

public interface UserService {

	public void createNewUser(Users user, String password) throws NestedServletException;
	
	public void createNewAccount(Accounts account, Integer id);
	
	public Users getUserById(Integer id);
	
	public void updateAccount(Accounts account);
}
