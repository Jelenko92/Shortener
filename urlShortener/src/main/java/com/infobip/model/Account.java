package com.infobip.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Registered account
 * Used for Basic authorization
 * 
 * @author Jelena
 *
 */
public class Account implements Serializable {

	// Account name
	private String name;
	// Password for account
	private String password;
	// Urls registered with this account
	private List<URL> registeredUrls;

	public Account() {
		super();
		this.registeredUrls = new ArrayList<URL>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean addURL(URL url) {
		if (registeredUrls.contains(url)) {
			return false;
		}

		registeredUrls.add(url);
		return true;

	}

	/**
	 * Visiting statistics for account. Visiting statistics contains map of urls
	 * registered with this account and value is visiting number
	 * 
	 * @return visiting statistics
	 */
	public Map<String, Long> getStatistics() {
		Map<String, Long> statistics = new HashMap<String, Long>();
		for (URL url : registeredUrls) {
			statistics.put(url.getUrl(), url.getNumberVists());
		}
		return statistics;
	}
	
	/**
	 * Get number of registered urls
	 * @return
	 */
	public int getNumRegisteredUrls(){
		return registeredUrls.size();
	}

}
