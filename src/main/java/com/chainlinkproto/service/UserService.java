package com.chainlinkproto.service;

import com.chainlinkproto.model.Users;

public interface UserService {

	public void createNewUser(Users user, String password);
}
