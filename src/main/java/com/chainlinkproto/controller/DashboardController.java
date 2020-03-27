package com.chainlinkproto.controller;


import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

@Controller
public class DashboardController 
{
	@GetMapping("/dashboard")
	public String getDashboard(Model model, HttpSession session) throws IOException {
		Web3j web3 = Web3j.build(new HttpService("HTTP://127.0.0.1:7545"));
		Web3ClientVersion web3ClientVersion = web3.web3ClientVersion().send();
		System.out.println(web3ClientVersion.getWeb3ClientVersion());
		return "dashboard";
	}
}
