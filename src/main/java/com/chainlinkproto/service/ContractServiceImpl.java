package com.chainlinkproto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainlinkproto.dao.CLPDao;
import com.chainlinkproto.model.Accounts;
import com.chainlinkproto.model.Contracts;
import com.chainlinkproto.model.IntelProperties;
import com.chainlinkproto.model.Users;

@Service
public class ContractServiceImpl implements ContractService {

	@Autowired
	CLPDao dao;
	
	@Override
	public List<IntelProperties> getProperties(Users user) {
		List<IntelProperties> propertyList = new ArrayList<>();
		Set<Accounts> accounts = user.getAccounts();
		
		for(Accounts account: accounts) {
			propertyList.addAll(account.getIntelProperties());
		}
		
		return propertyList;
	}

	@Override
	public void saveNewProperty(IntelProperties property) {
		dao.saveNewProperty(property);
	}

	@Override
	public List<Contracts> getContracts(Users user) {
		List<Contracts> contractList = new ArrayList<>();
		Set<Accounts> accounts = user.getAccounts();
		
		for(Accounts account: accounts) {
			contractList.addAll(account.getContracts());
		}
		return contractList;
	}

	@Override
	public IntelProperties getPropertyFromId(Integer id) {
		return dao.getPropertyFromId(id);
	}

	@Override
	public Contracts getContractFromId(Integer id) {
		return dao.getContractFromId(id);
	}

}
