package com.chainlinkproto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.util.NestedServletException;

import com.chainlinkproto.dao.CLPDao;
import com.chainlinkproto.model.Accounts;
import com.chainlinkproto.model.Users;
import com.microsoft.sqlserver.jdbc.SQLServerException;

@Service
public class UserServiceImpl implements UserService {

   @Autowired
   private CLPDao dao;
   
   @Autowired
   private PasswordEncoder encoder;
   
   @Autowired
   private BlockChainService blockChainService;

   @Override
   public void createNewUser(Users user, String password) throws NestedServletException {
	   user.setPasswordHash(encoder.encode(password));
	   dao.saveNewUser(blockChainService.initiateNewWallet(user));
   }

	@Override
	public void createNewAccount(Accounts account, Integer id) {
		dao.saveNewAccount(account, id);
	}

	@Override
	public Users getUserById(Integer id) {
		return dao.getUserById(id);
	}

	@Override
	public void updateAccount(Accounts account) {
		dao.updateAccount(account);
	}
}
