package com.infobip.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infobip.model.URL;
import com.infobip.model.factory.URLFactory;

/**
 * Repossitory for urls
 * @author Jelena
 *
 */
@Repository
public class URLRepository {

	/**
	 * Key: short url , Value: url {@link URL}
	 */
	private Map<String, URL> registeredURLs;

	@Autowired
	URLFactory urlFactory;
	
	@Autowired
	RepositoryAccount accountRepository;

	public URLRepository() {
		super();
		this.registeredURLs = new HashMap<String, URL>();
	}

	/**
	 * Add url to repository
	 * @param url long url
	 * @param account owner account
	 * @param redirectType
	 * @return if url exists new short url, otherwise existing short url
	 */
	public String addURL(String url, String account, int redirectType) {
		String existing = urlExists(url);
		
		if (existing.length() != 0) {
			return existing;
		}

		URL newURL = urlFactory.createUrl(url, account, redirectType);
		registeredURLs.put(newURL.getShortURL(), newURL);
		return newURL.getShortURL();
	}

	/**
	 * Get URL by short url
	 * @param shortURL
	 * @return {@link URL}
	 */
	public URL getURLByShortURL(String shortURL) {
		if (registeredURLs.containsKey(shortURL) == false) {
			return null;
		}
		return registeredURLs.get(shortURL);

	}

	/**
	 * Check if short url already exists
	 * @param url short url
	 * @return true if exists, otherwise false
	 */
	public boolean shortURLExists(String url) {
		return registeredURLs.containsKey(url);
	}

	// U ovom sluèaju nije važna brzina
	
	/**
	 * Return short url for given long url
	 * @param longURL
	 * @return if short url exists then short url, otherwise empty string
	 */
	private String urlExists(String longURL) {
		for (Map.Entry<String, URL> entry : registeredURLs.entrySet()) {
			if (entry.getValue().getUrl().equals(longURL)) {
				return entry.getValue().getShortURL();
			}
		}

		return "";
	}

	/**
	 * Short url is visited
	 * 
	 * @param shortUrl
	 *            short url
	 */
	private void visitUrl(String shortUrl) {
		URL url = registeredURLs.get(shortUrl);
		url.visited();
	}
	
	/**
	 * Get number of registered urls
	 * @return number of registered urls
	 */
	public int getSize(){
		return registeredURLs.size();
	}

}
