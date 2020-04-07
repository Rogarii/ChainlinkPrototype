package com.chainlinkproto.service;

import com.chainlinkproto.model.Accounts;
import com.chainlinkproto.model.Users;

public interface UserService {

	public void createNewUser(Users user, String password);
	
	public void createNewAccount(Accounts account, Integer id);
	
	public Users getUserById(Integer id);
	
	public void updateAccount(Accounts account);
}
