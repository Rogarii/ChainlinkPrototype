package com.chainlinkproto.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.chainlinkproto.dto.NewUserForm;
import com.chainlinkproto.model.Users;
import com.chainlinkproto.service.UserService;

@Controller
public class NewUserController {

	@Autowired
	UserService newUserService;
	
	
	@GetMapping("/newUser")
	public String newUser(Model model) {
		model.addAttribute("newUserForm", new NewUserForm());
		return "newUser";
	}
	
	@PostMapping("/createUser")
	public String createUser(Model model, HttpSession session, RedirectAttributes redirectAttrs, @Valid @ModelAttribute("newUserForm") NewUserForm newUser, BindingResult result) {
		Users user = new Users();
		if(result.hasErrors()) {
			redirectAttrs.addAttribute("unknownError", true);
			return "redirect:/newUser";
		}
		if(newUser.getEmail().equals(newUser.getEmail2())) {
			user.setEmailAddress(newUser.getEmail());
		}else {
			redirectAttrs.addAttribute("invalidEmail", true);
			return "redirect:/newUser";
		}
		if(!(newUser.getPassword().equals(newUser.getPassword2()))) {
			redirectAttrs.addAttribute("invalidPassword", true);
			return "redirect:/newUser";
		}
		user.setFirstName(newUser.getFirstName());
		user.setLastName(newUser.getLastName());
		try {
			newUserService.createNewUser(user, newUser.getPassword());
		}catch(Exception e) {
			e.printStackTrace();
			redirectAttrs.addAttribute("unknownError", true);
			return "redirect:/newUser";
		}
		redirectAttrs.addAttribute("userCreation", true);
		return "redirect:/login";
	}
}
