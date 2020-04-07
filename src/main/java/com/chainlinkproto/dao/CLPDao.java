package com.chainlinkproto.dao;

import com.chainlinkproto.model.Accounts;
import com.chainlinkproto.model.Contracts;
import com.chainlinkproto.model.EnterpriseAffiliates;
import com.chainlinkproto.model.IntelProperties;
import com.chainlinkproto.model.UserGroups;
import com.chainlinkproto.model.Users;

public interface CLPDao{
   
	public Users getUserByEmail(String emailAddress);
	
	public Users getUserById(Integer id);
	
	public void saveNewUser(Users user);
	
	public void saveNewAccount(Accounts account, Integer id);
	
	public UserGroups getGroupById(Integer id);
	
	public EnterpriseAffiliates getEnterpriseById(Integer id);
	
	public void saveNewProperty(IntelProperties property);
	
	public void updateAccount(Accounts account);
	
	public IntelProperties getPropertyFromId(Integer id);
	
	public Contracts getContractFromId(Integer id);
}
