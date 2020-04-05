package com.chainlinkproto.service;

import org.web3j.crypto.Credentials;

import com.chainlinkproto.model.Users;

public interface BlockChainService {
	public Users initiateNewWallet(Users user);
	
	public boolean initiateNewRoyaltyContract(Credentials creds, Users user) throws Exception;
}
