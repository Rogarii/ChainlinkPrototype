package com.chainlinkproto.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainlinkproto.dao.LoginRepository;
import com.chainlinkproto.model.Users;

@Service
public class BlockChainServiceImpl implements BlockChainService{

	@Autowired
	LoginRepository dao;
	
	public File getUserWallet(Users user) {
		try {
			Path tempDir = Files.createTempDirectory("walletsGet");
			File file = new File(tempDir.toString() + "\\" + user.getId() + "wallet.json");
			OutputStream output = new FileOutputStream(file);
			output.write(user.getWalletFile());
			output.close();
			return file;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
