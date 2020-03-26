package com.chainlinkproto.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.WalletUtils;

import com.chainlinkproto.dao.LoginRepository;
import com.chainlinkproto.model.Users;


@Service
public class UserServiceImpl implements UserService {

   @Autowired
   private LoginRepository dao;
   
   @Autowired
   private PasswordEncoder encoder;

   @Override
   public void createNewUser(Users user, String password) {
	   user.setPasswordHash(encoder.encode(password));
	   try {
		   	Path tempDir = Files.createTempDirectory("walletsCreate");
		   	String filename = WalletUtils.generateNewWalletFile(encoder.encode(password), new File(tempDir.toUri()));
		   	File walletFile = new File(tempDir.toString()  + "\\" + filename);
		   	byte[] fileBytes = new byte[(int) walletFile.length()];	   
		   	FileInputStream fis = new FileInputStream(walletFile);
		   	fis.read(fileBytes);
		   	fis.close();
		   	user.setWalletFile(fileBytes);
			dao.saveNewUser(user);
	   } catch (InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException | CipherException
			| IOException e) {
		e.printStackTrace();
	   }

   }


}
