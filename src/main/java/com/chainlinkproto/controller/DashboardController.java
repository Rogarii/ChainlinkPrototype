package com.chainlinkproto.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController 
{
	@GetMapping("/dashboard")
	public String getDashboard(Model model, HttpSession session) {	
		return "dashboard";
	}
}
