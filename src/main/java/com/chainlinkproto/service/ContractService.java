package com.chainlinkproto.service;

import java.util.List;

import com.chainlinkproto.model.Contracts;
import com.chainlinkproto.model.IntelProperties;
import com.chainlinkproto.model.Users;

public interface ContractService {

	public List<IntelProperties> getProperties(Users user);
	
	public void saveNewProperty(IntelProperties property);
	
	public List<Contracts> getContracts(Users user);
	
	public IntelProperties getPropertyFromId(Integer id);
	
	public Contracts getContractFromId(Integer id);
}
