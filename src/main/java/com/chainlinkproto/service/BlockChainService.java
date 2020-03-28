package com.chainlinkproto.service;

import org.web3j.crypto.WalletFile;

public interface BlockChainService {
	public void initiateNewWallet(WalletFile wallet, String password);
}
