package com.chainlinkproto.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.chainlinkproto.model.LoginUserDetails;
import com.chainlinkproto.model.Users;
import com.chainlinkproto.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	UserService userService;

	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/login")
	public String login(HttpSession session) {
		if(session.getAttribute("userId") != null) {
			return "redirect:/dashboard";
		}
		return "login";
	}
	
	@GetMapping("/loginFailed")
	public String loginFailed(Model model, HttpSession session, RedirectAttributes redirectAttrs) {
		redirectAttrs.addFlashAttribute("loginError", true);
		return "redirect:/login";
	}
	
	@GetMapping("/logout")
	public String logout(SessionStatus session) {
		SecurityContextHolder.getContext().setAuthentication(null);
		session.setComplete();
		return "redirect:/login";
	}
	
	@PostMapping("/postLogin")
	public String postLogin(Model model, HttpSession session) {
		UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
		validatePrincipal(authentication.getPrincipal());
		Users user = ((LoginUserDetails)authentication.getPrincipal()).getUserDetails();
		session.setAttribute("userId", user.getId());
		if(userService.getUserById(user.getId()).getAccounts().isEmpty()) {
			return "redirect:/newAccount";
		}
		return "redirect:/dashboard";
	}
	
	private void validatePrincipal(Object principal) {
		if(!(principal instanceof LoginUserDetails)) {
			throw new IllegalArgumentException("Principal cannot be null");
		}
	}
}
