package com.chainlinkproto.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.chainlinkproto.model.Contracts;
import com.chainlinkproto.model.IntelProperties;
import com.chainlinkproto.service.ContractService;
import com.chainlinkproto.service.UserService;

@Controller
public class DashboardController 
{
	@Autowired
	UserService userService;
	
	@Autowired
	ContractService contractService;
	
	@GetMapping("/dashboard")
	public String getDashboard(Model model, HttpSession session) {	
		return "dashboard";
	}
	
	@GetMapping("/properties")
	public String getProperties(Model model, HttpSession session) {
		List<IntelProperties> propertyList = contractService.getProperties(userService.getUserById((Integer)session.getAttribute("userId")));
		model.addAttribute("intelProperties", propertyList);
		return "properties";
	}	
	
	@GetMapping("/contracts")
	public String getContracts(Model model, HttpSession session) {
		List<Contracts> contractList = contractService.getContracts(userService.getUserById((Integer)session.getAttribute("userId")));
		model.addAttribute("contracts", contractList);
		for(Contracts contract: contractList) {
			model.addAttribute("properties" + contract.getId(), contract.getIntelProperties().toArray());
			model.addAttribute("users" + contract.getId(), contract.getAccounts().toArray());
		}
		return "contracts";
	}
}
