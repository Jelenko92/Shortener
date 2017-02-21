package com.infobip.model.factory;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Service;

import com.infobip.model.Account;

@Service
public class AccountFactory {

	//Password length
	private final int passwordLength = 8;
	
	/**
	 * Create new account
	 * @param accountId
	 * @return new account
	 */
	public Account createAccount(String accountId){
		Account account = new Account();
		account.setName(accountId);
		String password = generateAlphanumericString(passwordLength);
		account.setPassword(password);
		return account;
	}
	
	/**
	 * Generate random alphanumeric string
	 * @param length string length
	 * @return random string
	 */
	private String generateAlphanumericString(int length){
		return RandomStringUtils.randomAlphanumeric(length);		
	}
}
