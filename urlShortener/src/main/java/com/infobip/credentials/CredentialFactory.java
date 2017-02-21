package com.infobip.credentials;

import org.springframework.stereotype.Service;

@Service
public class CredentialFactory {

	/**
	 * Return new user credentials
	 * @param accountId account id
	 * @param password account password
	 * @return user credentials
	 */
	public UserCredentials generateNewCredentials(String accountId, String password){
		UserCredentials newCredentials = new UserCredentials();
		newCredentials.setNotEnabled(true);
		newCredentials.setNotExpiredAccount(true);
		newCredentials.setNotExpiredCredentials(true);
		newCredentials.setNotLocked(true);
		newCredentials.setPassword(password);
		newCredentials.setUsername(accountId);
		return newCredentials;
	}
}
