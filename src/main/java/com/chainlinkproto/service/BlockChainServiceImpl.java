package com.chainlinkproto.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Keys;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Transfer;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.utils.Convert.Unit;
import org.web3j.utils.Numeric;

import com.chainlinkproto.contracts.RoyaltyContract;
import com.chainlinkproto.model.Accounts;
import com.chainlinkproto.model.Contracts;
import com.chainlinkproto.model.IntelProperties;
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
			Transfer.sendFunds(web3, fromCreds, toCreds.getAddress(), BigDecimal.valueOf(1), Unit.ETHER).send();		
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Contracts initiateNewRoyaltyContract(Credentials creds, Accounts account, IntelProperties property) throws Exception {
		RoyaltyContract royaltyContract = null;
		try {
			royaltyContract = RoyaltyContract.deploy(web3, creds, new DefaultGasProvider(), account.getUser().getFirstName(), account.getUser().getLastName(),
					BigInteger.valueOf(System.currentTimeMillis()), BigInteger.valueOf(100000), BigInteger.valueOf(100000), 
					BigInteger.valueOf(5), property.getMetaArtist(), property.getMetaArtist(), BigInteger.valueOf(property.getId())).send();
		}catch(Exception e) {
			e.printStackTrace();
		}
		Contracts contract = new Contracts();
		contract.setContractType("ROY");
		contract.setDateCreated(new Timestamp(System.currentTimeMillis()));
		contract.setDateModified(new Timestamp(System.currentTimeMillis()));
		contract.setBcKey(royaltyContract.getContractAddress());
		contract.getAccounts().add(account);
		contract.getIntelProperties().add(property);		
		return contract;
	}
}
