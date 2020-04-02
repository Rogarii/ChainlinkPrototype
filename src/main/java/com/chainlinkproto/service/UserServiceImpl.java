package com.chainlinkproto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.chainlinkproto.dao.CLPDao;
import com.chainlinkproto.model.Accounts;
import com.chainlinkproto.model.Users;

@Service
public class UserServiceImpl implements UserService {

   @Autowired
   private CLPDao dao;
   
   @Autowired
   private PasswordEncoder encoder;
   
   @Autowired
   private BlockChainService blockChainService;

   @Override
   public void createNewUser(Users user, String password) {
	   user.setPasswordHash(encoder.encode(password));
	   try {
		   dao.saveNewUser(blockChainService.initiateNewWallet(user));
	   }catch(Exception e) {
		   e.printStackTrace();
	   } 
   }

	@Override
	public void createNewAccount(Accounts account, Integer id) {
		dao.saveNewAccount(account, id);
	}

	@Override
	public Users getUserById(Integer id) {
		return dao.getUserById(id);
	}
}
