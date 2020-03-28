package com.chainlinkproto.service;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Keys;
import org.web3j.crypto.Wallet;
import org.web3j.crypto.WalletFile;

import com.chainlinkproto.dao.LoginRepository;
import com.chainlinkproto.model.Users;


@Service
public class UserServiceImpl implements UserService {

   @Autowired
   private LoginRepository dao;
   
   @Autowired
   private PasswordEncoder encoder;
   
   @Autowired
   private BlockChainService blockChainService;

   @Override
   public void createNewUser(Users user, String password) {
	   user.setPasswordHash(encoder.encode(password));
	   ByteArrayOutputStream bos = new ByteArrayOutputStream();
	   ObjectOutputStream out = null;
	   try {
		   	ECKeyPair keyPair = Keys.createEcKeyPair();
		   	WalletFile wallet = Wallet.createStandard(password, keyPair);
//		   	
//		   	out = new ObjectOutputStream(bos);
//		   	out.writeObject(wallet);
//		   	out.flush();
//		   	byte[] walletBytes = bos.toByteArray();  
//		   	user.setWalletFile(walletBytes);
		   	blockChainService.initiateNewWallet(wallet, password);
			dao.saveNewUser(user);
			bos.close();
	   }catch(Exception e) {
		   	e.printStackTrace();
	   }finally {
		   	try {
		   		bos.close();
		   	}catch(Exception e) {
		   		e.printStackTrace();
		   	}
	   	}

   }


}
