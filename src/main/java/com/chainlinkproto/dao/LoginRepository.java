package com.chainlinkproto.dao;

import com.chainlinkproto.model.Users;

public interface LoginRepository{
   
	public Users getUserByEmail(String emailAddress);
	
	public void saveNewUser(Users user);
}
