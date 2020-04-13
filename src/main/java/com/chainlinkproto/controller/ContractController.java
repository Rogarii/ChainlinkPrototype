package com.chainlinkproto.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.utils.Numeric;

import com.chainlinkproto.dto.NewPropertyForm;
import com.chainlinkproto.model.Accounts;
import com.chainlinkproto.model.Contracts;
import com.chainlinkproto.model.IntelProperties;
import com.chainlinkproto.model.Users;
import com.chainlinkproto.service.BlockChainService;
import com.chainlinkproto.service.ContractService;
import com.chainlinkproto.service.UserService;

@Controller
public class ContractController {

	@Autowired
	UserService userService;
	
	@Autowired
	ContractService contractService;
	
	@Autowired
	BlockChainService blockChainService;
	
	@GetMapping("/propertyInfo/{propId}")
	public String getPropertyInfo(@PathVariable(name = "propId") String propId, Model model, HttpSession session) {
		model.addAttribute("property", contractService.getPropertyFromId(Integer.valueOf(propId)));
		return "propertyInfo";
	}
	
	@GetMapping("/propertyComp/{propId}")
	public @ResponseBody void getPropertyComp(HttpServletRequest request, HttpServletResponse response, @PathVariable(name = "propId") String propId) {
		IntelProperties property = contractService.getPropertyFromId(Integer.valueOf(propId));
		byte[] file = property.getCompData();
		response.reset();
		//TODO save file type and modify accordingly
		response.setContentType("text/plain");
		try {
			response.getOutputStream().write(file);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("/propertyLyrics/{propId}")
	public @ResponseBody void getPropertyLyrics(HttpServletRequest request, HttpServletResponse response, @PathVariable(name = "propId") String propId) {
		IntelProperties property = contractService.getPropertyFromId(Integer.valueOf(propId));
		byte[] file = property.getLyricsData();
		response.reset();
		//TODO save file type and modify accordingly
		response.setContentType("text/plain");
		try {
			response.getOutputStream().write(file);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("/contractInfo/{contractId}")
	public String getContractInfo(@PathVariable(name = "contractId") String contractId, Model model, HttpSession session) {
		model.addAttribute("contract", contractService.getContractFromId(Integer.valueOf(contractId)));
		return "contractInfo";
	}
	
	@GetMapping("/newProperty")
	public String addProperty(Model model, HttpSession session) {
		model.addAttribute("newPropertyForm", new NewPropertyForm());
		return "newProperty";
	}
	
	@PostMapping("/addProperty")
	public String newProperty(Model model, HttpSession session, RedirectAttributes redirectAttrs, @ModelAttribute("newPropertyForm") NewPropertyForm newProperty) {
		IntelProperties property = new IntelProperties();
		try {
			Users user = userService.getUserById((Integer)session.getAttribute("userId"));
			Accounts account = (Accounts)user.getAccounts().toArray()[0];		
			property.setAccount(account);
			property.setPropName(newProperty.getPropName());
			property.setDateAdded(new Timestamp(System.currentTimeMillis())); 
			property.setDateModified(new Timestamp(System.currentTimeMillis()));
			property.setLyricsData(newProperty.getLyricsData().getBytes());
			property.setCompData(newProperty.getCompData().getBytes());
			property.setMetaSong(newProperty.getMetaSong());
			property.setMetaArtist(newProperty.getMetaArtist());
			property.setMetaAlbum(newProperty.getMetaAlbum());
			property.setMetaAlbumArtist(newProperty.getMetaAlbumArtist());
			property.setMetaComposer(newProperty.getMetaComposer());
			property.setMetaGrouping(newProperty.getMetaGrouping());
			property.setMetaGenre(newProperty.getMetaGenre());
			property.setMetaYear(newProperty.getMetaYear().equals("") ? 0 : Integer.valueOf(newProperty.getMetaYear()));
			property.setMetaBpm(newProperty.getMetaBpm().equals("") ? 0 : Integer.valueOf(newProperty.getMetaBpm()));
			if(!newProperty.getMetaAlbumArt().isEmpty()) {
				property.setMetaAlbumArt(newProperty.getMetaAlbumArt().getBytes());
			}
			contractService.saveNewProperty(property);
			Contracts contract = blockChainService.initiateNewRoyaltyContract(Credentials.create(ECKeyPair.create(Numeric.toBigInt(user.getWalletKey()))), account, property);
			contract.getAccounts().add(account);
			property.getContracts().add(contract);
			account.getContracts().add(contract);
			account.getIntelProperties().add(property);
			userService.updateAccount(account);;
		}catch(Exception e) {
			e.printStackTrace();
			redirectAttrs.addAttribute("propertySubmissionError", true);
			return "redirect:/newProperty";
		}
		return "redirect:/properties";
	}
	
}
