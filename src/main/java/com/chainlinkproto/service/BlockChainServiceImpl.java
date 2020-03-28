package com.chainlinkproto.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Wallet;
import org.web3j.crypto.WalletFile;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthGetTransactionReceipt;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert.Unit;
import org.web3j.utils.Numeric;


@Service
public class BlockChainServiceImpl implements BlockChainService{
	
	private static final String ADMIN_PK = "abade1674f3bdfafb5f3ba3ee19771db279dd32a4edd3ae11c94b332255eb7d8";
	Web3j web3 = Web3j.build(new HttpService("HTTP://127.0.0.1:7545"));

	@Override
	public void initiateNewWallet(WalletFile wallet, String password) {
		try {
			Credentials toCreds = Credentials.create(Wallet.decrypt(password, wallet));
			Credentials fromCreds = Credentials.create(ECKeyPair.create(Numeric.toBigInt(ADMIN_PK)));
			
			TransactionReceipt receipt = Transfer.sendFunds(web3, fromCreds, toCreds.getAddress(), BigDecimal.valueOf(10), Unit.ETHER).send();
			
			String transactionHash = receipt.getTransactionHash();
			
			Optional<TransactionReceipt> transactionReceipt = null;
			do {
			  EthGetTransactionReceipt ethGetTransactionReceiptResp = web3.ethGetTransactionReceipt(transactionHash).send();
			  transactionReceipt = ethGetTransactionReceiptResp.getTransactionReceipt();

			  Thread.sleep(3000);
			} while(!transactionReceipt.isPresent());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
