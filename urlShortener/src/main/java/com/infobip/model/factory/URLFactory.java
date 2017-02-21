package com.infobip.model.factory;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infobip.model.Account;
import com.infobip.model.URL;
import com.infobip.repository.RepositoryAccount;

@Service
public class URLFactory {

	@Autowired
	private RepositoryAccount accountRepository;
	
	//Short url id length
	private final int urlLength = 8;
	//Short url starts with
	private final String shortUrlStart = "http://short.com/";

	/**
	 * Create new url
	 * @param url
	 * @param account owner account id
	 * @param redirectType
	 * @return new url
	 */
	public  URL createUrl(String url, String account, int redirectType){
		
		URL newURL = new URL();
		Account accountOwner = accountRepository.getAccount(account);
		newURL.setUrl(url);	
		newURL.setRegisteredAccount(accountOwner);
		newURL.setRedirectType(redirectType);
		String shortURL = generateShortURL();
		newURL.setShortURL(shortURL);
		accountOwner.addURL(newURL);
		return newURL;		
	}

	/**
	 * Generating short url
	 * @return short url
	 */
	private String generateShortURL() {
		String shortURL = "";
		shortURL = shortUrlStart + RandomStringUtils.randomAlphanumeric(urlLength);
		return shortURL;
	}
}
