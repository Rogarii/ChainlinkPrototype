package com.chainlinkproto.controller;

import java.math.BigDecimal;

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

import com.chainlinkproto.dto.NewAccountForm;
import com.chainlinkproto.dto.NewUserForm;
import com.chainlinkproto.model.Accounts;
import com.chainlinkproto.model.Users;
import com.chainlinkproto.service.UserService;

@Controller
public class NewUserController {

	@Autowired
	UserService userService;
	
	
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
			userService.createNewUser(user, newUser.getPassword());
		}catch(Exception e) {
			e.printStackTrace();
			redirectAttrs.addAttribute("unknownError", true);
			return "redirect:/newUser";
		}
		redirectAttrs.addAttribute("userCreation", true);
		return "redirect:/login";
	}
	
	@GetMapping("/newAccount")
	public String newAccount(Model model, HttpSession session) {
		model.addAttribute("newAccountForm", new NewAccountForm());
		return "newAccount";
	}
	
	@PostMapping("/createAccount")
	public String createUser(Model model, HttpSession session, RedirectAttributes redirectAttrs, @Valid @ModelAttribute("newAccountForm") NewAccountForm newAccount, BindingResult result) {
		Accounts account = new Accounts();
		if(result.hasErrors()) {
			redirectAttrs.addAttribute("unknownError", true);
			redirectAttrs.addAttribute("errorField", result.getFieldError().getRejectedValue().toString());
			return "redirect:/newAccount";
		}
		account.setAccountType(newAccount.getAccountType());
		account.setAccountTitle(newAccount.getAccountTitle());
		account.setCitizenship(newAccount.getCitizenship());
		account.setCountry(newAccount.getCountry());
		account.setAddress1(newAccount.getAddress1());
		account.setAddress2(newAccount.getAddress2());
		account.setCity(newAccount.getCity());
		account.setState(newAccount.getState());
		
		try {
			account.setZip(Integer.parseInt(newAccount.getZip().trim()));
			account.setPrimaryPhone(new BigDecimal(newAccount.getPrimaryPhone().trim()));
			account.setCellPhone(newAccount.getCellPhone().equals("") ? null : new BigDecimal(newAccount.getCellPhone().trim()));
			account.setFax(newAccount.getFax().equals("") ? null :new BigDecimal(newAccount.getFax().trim()));
			userService.createNewAccount(account, (Integer)session.getAttribute("userId"));
		}catch(Exception e) {
			e.printStackTrace();
			return "redirect:/newAccount";
		}

		redirectAttrs.addAttribute("accountCreation", true);
		return "redirect:/dashboard";
	}
}
