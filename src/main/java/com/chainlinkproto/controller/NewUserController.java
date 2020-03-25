package com.chainlinkproto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.chainlinkproto.model.Users;
import com.chainlinkproto.service.NewUserService;

@Controller
public class NewUserController {

	@Autowired
	NewUserService newUserService;
	
	
	@GetMapping("/newUser")
	public String createUser() {
		Users user = new Users();
		user.setEmailAddress("KarlMetz926@gmail.com");
		user.setFirstName("Raymond");
		user.setLastName("Metz");
		newUserService.createNewUser(user, "testPassword");
		return "newUser";
	}
}
