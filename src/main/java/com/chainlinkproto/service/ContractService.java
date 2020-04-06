package com.chainlinkproto.service;

import java.util.List;

import com.chainlinkproto.model.IntelProperties;
import com.chainlinkproto.model.Users;

public interface ContractService {

	public List<IntelProperties> getProperties(Users user);
	
	public void saveNewProperty(IntelProperties property);
	
	public void updateProperty(IntelProperties property);
}
