package com.chainlinkproto.controller;

import java.math.BigDecimal;

import javax.persistence.PersistenceException;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.NestedServletException;

import com.chainlinkproto.dto.NewAccountForm;
import com.chainlinkproto.dto.NewUserForm;
import com.chainlinkproto.model.Accounts;
import com.chainlinkproto.model.Users;
import com.chainlinkproto.service.UserService;
import com.microsoft.sqlserver.jdbc.SQLServerException;

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
			redirectAttrs.addFlashAttribute("error", true);
			redirectAttrs.addAttribute("validationError", true);
			return "redirect:/newUser";
		}
		if(newUser.getEmail().equals(newUser.getEmail2())) {
			user.setEmailAddress(newUser.getEmail());
		}else {
			redirectAttrs.addFlashAttribute("error", true);
			redirectAttrs.addFlashAttribute("invalidEmail", true);
			return "redirect:/newUser";
		}
		if(!(newUser.getPassword().equals(newUser.getPassword2()))) {
			redirectAttrs.addFlashAttribute("error", true);
			redirectAttrs.addFlashAttribute("invalidPassword", true);
			return "redirect:/newUser";
		}
		user.setFirstName(newUser.getFirstName());
		user.setLastName(newUser.getLastName());
		try {
			userService.createNewUser(user, newUser.getPassword());
		}catch(PersistenceException e) {
			redirectAttrs.addFlashAttribute("error", true);
			redirectAttrs.addFlashAttribute("duplicateLogin", true);
			return "redirect:/newUser";
		}
		catch(Exception e) {
			redirectAttrs.addFlashAttribute("error", true);
			redirectAttrs.addFlashAttribute("serverError", true);
			return "redirect:/newUser";
		}
		redirectAttrs.addFlashAttribute("userCreation", true);
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
			redirectAttrs.addFlashAttribute("unknownError", true);
			redirectAttrs.addFlashAttribute("errorField", result.getFieldError().getField());
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

		redirectAttrs.addFlashAttribute("accountCreation", true);
		switch(account.getAccountType()) {
			case "PER":
				redirectAttrs.addFlashAttribute("accountType", "Personal");
				break;
			case "BUS":
				redirectAttrs.addFlashAttribute("accountType", "Group");
				break;
			case "GRP":
				redirectAttrs.addFlashAttribute("accountType", "Business");
				break;
		}
		return "redirect:/dashboard";
	}
}
