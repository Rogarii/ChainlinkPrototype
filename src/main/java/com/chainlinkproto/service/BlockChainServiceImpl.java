package com.chainlinkproto.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Keys;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthGetTransactionReceipt;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert.Unit;
import org.web3j.utils.Numeric;

import com.chainlinkproto.model.Users;

@Service
public class BlockChainServiceImpl implements BlockChainService{
	
	private static final String ADMIN_PK = "4e87d2b4b444aac89514d19a67242b06849932fbabfede57e1df508330b3a661";
	Web3j web3 = Web3j.build(new HttpService("HTTP://127.0.0.1:7545"));

	@Override
	public Users initiateNewWallet(Users user) {
		try {
			Credentials toCreds = Credentials.create(Keys.createEcKeyPair());
			Credentials fromCreds = Credentials.create(ECKeyPair.create(Numeric.toBigInt(ADMIN_PK)));
			user.setWalletKey(Numeric.toHexString(toCreds.getEcKeyPair().getPrivateKey().toByteArray()));
			
			TransactionReceipt receipt = Transfer.sendFunds(web3, fromCreds, toCreds.getAddress(), BigDecimal.valueOf(1), Unit.ETHER).send();
			
			String transactionHash = receipt.getTransactionHash();
			
			Optional<TransactionReceipt> transactionReceipt = null;
			do {
			  EthGetTransactionReceipt ethGetTransactionReceiptResp = web3.ethGetTransactionReceipt(transactionHash).send();
			  transactionReceipt = ethGetTransactionReceiptResp.getTransactionReceipt();

			  Thread.sleep(3000);
			} while(!transactionReceipt.isPresent());
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
}
