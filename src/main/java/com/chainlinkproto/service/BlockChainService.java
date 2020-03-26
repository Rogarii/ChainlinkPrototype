package com.chainlinkproto.service;

import java.io.File;

import com.chainlinkproto.model.Users;

public interface BlockChainService {

	public File getUserWallet(Users user);
}
