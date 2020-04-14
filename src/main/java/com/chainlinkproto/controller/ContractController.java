package com.chainlinkproto.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.activation.MimetypesFileTypeMap;
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
	
	@GetMapping("/editProperty/{propId}")
	public String editProperty(@PathVariable(name = "propId") String propId, Model model, HttpSession session) {
		IntelProperties property = contractService.getPropertyFromId(Integer.valueOf(propId));
		Users user = userService.getUserById((Integer)session.getAttribute("userId"));
		List<Integer> ids = user.getAccounts().stream().map(Accounts::getId).collect(Collectors.toList());
		if(ids.contains(property.getAccount().getId())){
			model.addAttribute("newPropertyForm", new NewPropertyForm());
			model.addAttribute("property", property);			
			return "editProperty";
		}else {
			return "redirect:/dashboard";
		}

	}
	
	@GetMapping("/propertyComp/{propId}")
	public @ResponseBody void getPropertyComp(HttpServletRequest request, HttpServletResponse response, @PathVariable(name = "propId") String propId) {
		IntelProperties property = contractService.getPropertyFromId(Integer.valueOf(propId));
		byte[] file = property.getCompData();
		response.reset();
		//TODO save file type and modify accordingly	
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
		if(newProperty.getId() != null && newProperty.getId() != "undefined" && newProperty.getId().length() > 0) {
			//Edit Property
			Users user = userService.getUserById((Integer)session.getAttribute("userId"));
			Set<Accounts> accounts = user.getAccounts();
			List<IntelProperties> properties = new ArrayList<IntelProperties>();
			accounts.forEach(account -> account.getIntelProperties().forEach(property -> properties.add(property)));
			IntelProperties property = properties.stream().filter(searchProperty -> Integer.valueOf(newProperty.getId()) == searchProperty.getId()).findAny().orElse(null);
			if(property == null) {
				return "redirect:/dashboard";
			}else {
				property.setPropName(newProperty.getPropName());
				property.setDateModified(new Timestamp(System.currentTimeMillis()));
				property.setMetaSong(newProperty.getMetaSong());
				property.setMetaArtist(newProperty.getMetaArtist());
				property.setMetaAlbum(newProperty.getMetaAlbum());
				property.setMetaAlbumArtist(newProperty.getMetaAlbumArtist());
				property.setMetaComposer(newProperty.getMetaComposer());
				property.setMetaGrouping(newProperty.getMetaGrouping());
				property.setMetaGenre(newProperty.getMetaGenre());
				if(!newProperty.getMetaYear().isEmpty()) {
					property.setMetaYear(Integer.valueOf(newProperty.getMetaYear()));
				}
				if(!newProperty.getMetaBpm().isEmpty()) {
					property.setMetaBpm(Integer.valueOf(newProperty.getMetaBpm()));
				}
				try {
					if(!newProperty.getLyricsData().isEmpty()) {
						property.setLyricsData(newProperty.getLyricsData().getBytes());
					}
					if(!newProperty.getCompData().isEmpty()) {
						property.setCompData(newProperty.getCompData().getBytes());
					}
					if(!newProperty.getMetaAlbumArt().isEmpty()) {
						property.setMetaAlbumArt(newProperty.getMetaAlbumArt().getBytes());
					}
				} catch (IOException e) {
					e.printStackTrace();
					return "redirect:/editProperty";
				}
				return "redirect:/properties";
				
			}
		}else {
			//new property
			Users user = userService.getUserById((Integer)session.getAttribute("userId"));
			Set<Accounts> accounts = user.getAccounts();
			Accounts account = null;
			if(accounts.size() == 1) {
				account = accounts.stream().distinct().collect(Collectors.toList()).get(0);
			}else {
				//ask user for proper account; for now just grab the first one
				account = accounts.stream().distinct().collect(Collectors.toList()).get(0);
			}
			
			IntelProperties property = new IntelProperties();
			
			property.setPropName(newProperty.getPropName());
			property.setDateAdded(new Timestamp(System.currentTimeMillis()));
			property.setDateModified(new Timestamp(System.currentTimeMillis()));
			property.setMetaSong(newProperty.getMetaSong());
			property.setMetaArtist(newProperty.getMetaArtist());
			property.setMetaAlbum(newProperty.getMetaAlbum());
			property.setMetaAlbumArtist(newProperty.getMetaAlbumArtist());
			property.setMetaComposer(newProperty.getMetaComposer());
			property.setMetaGrouping(newProperty.getMetaGrouping());
			property.setMetaGenre(newProperty.getMetaGenre());
			if(!newProperty.getMetaYear().isEmpty()) {
				property.setMetaYear(Integer.valueOf(newProperty.getMetaYear()));
			}
			if(!newProperty.getMetaBpm().isEmpty()) {
				property.setMetaBpm(Integer.valueOf(newProperty.getMetaBpm()));
			}
			try {
				property.setLyricsData(newProperty.getLyricsData().getBytes());
				property.setCompData(newProperty.getCompData().getBytes());
				if(!newProperty.getMetaAlbumArt().isEmpty()) {
					property.setMetaAlbumArt(newProperty.getMetaAlbumArt().getBytes());
				}
				contractService.saveNewProperty(property);
				Contracts contract = blockChainService.initiateNewRoyaltyContract(Credentials.create(ECKeyPair.create(Numeric.toBigInt(user.getWalletKey()))), account, property);
				contract.getAccounts().add(account); property.getContracts().add(contract);
				account.getContracts().add(contract);
				account.getIntelProperties().add(property);
				userService.updateAccount(account);
			} catch (Exception e) {
				e.printStackTrace();
				return "redirect:/newProperty";
			}
			return "redirect:/properties";
		}
	}
	
}
