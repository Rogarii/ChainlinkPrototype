package com.chainlinkproto.service;

import org.web3j.crypto.Credentials;

import com.chainlinkproto.model.Accounts;
import com.chainlinkproto.model.Contracts;
import com.chainlinkproto.model.IntelProperties;
import com.chainlinkproto.model.Users;

public interface BlockChainService {
	public Users initiateNewWallet(Users user);
	
	public Contracts initiateNewRoyaltyContract(Credentials creds, Accounts account, IntelProperties property) throws Exception;
}
