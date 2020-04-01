package com.chainlinkproto.dao;

import com.chainlinkproto.model.Accounts;
import com.chainlinkproto.model.Users;

public interface CLPDao{
   
	public Users getUserByEmail(String emailAddress);
	
	public Users getUserById(Integer id);
	
	public void saveNewUser(Users user);
	
	public void saveNewAccount(Accounts account, Integer id);
}
