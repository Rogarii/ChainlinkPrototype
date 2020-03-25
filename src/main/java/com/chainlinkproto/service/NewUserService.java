package com.chainlinkproto.service;

import com.chainlinkproto.model.Users;

public interface NewUserService {

	public void createNewUser(Users user, String password);
}
