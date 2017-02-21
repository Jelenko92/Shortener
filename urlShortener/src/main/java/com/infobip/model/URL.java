package com.infobip.model;

import java.io.Serializable;

/**
 * 
 * @author Jelena
 *
 */
public class URL implements Serializable{

	//reference to real url
	private String url;
	//short url
	private String shortURL;
	//HTTP status code
	private int redirectType;
	//Who createde short url
	private Account registeredAccount;
	//Number of visitings
	private long numberVists;
	
	public URL() {
		super();
		// TODO Auto-generated constructor stub
		this.numberVists = 0;
		//Default
		this.redirectType = 302;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getShortURL() {
		return shortURL;
	}

	public void setShortURL(String shortURL) {
		this.shortURL = shortURL;
	}

	public int getRedirectType() {
		return redirectType;
	}

	public void setRedirectType(int redirectType) {
		this.redirectType = redirectType;
	}

	public Account getRegisteredAccount() {
		return registeredAccount;
	}

	public void setRegisteredAccount(Account registeredAccount) {
		this.registeredAccount = registeredAccount;
	}	
	
	/**
	 * Url is visited 
	 */
	public void visited(){
		this.numberVists ++;
	}

	public long getNumberVists() {
		return numberVists;
	}

	public void setNumberVists(long numberVists) {
		this.numberVists = numberVists;
	}
	
	
	
	
	
}
