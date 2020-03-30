package com.chainlinkproto.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.chainlinkproto.dto.NewAccountForm;
import com.chainlinkproto.dto.NewUserForm;

@Controller
public class DashboardController 
{
	@GetMapping("/dashboard")
	public String getDashboard(Model model, HttpSession session) {	
		return "dashboard";
	}
	
	@GetMapping("/newAccount")
	public String newAccount(Model model, HttpSession session) {
		model.addAttribute("newAccountForm", new NewAccountForm());
		return "newAccount";
	}
}
