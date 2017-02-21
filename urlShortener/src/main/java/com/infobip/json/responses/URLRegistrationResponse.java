package com.infobip.json.responses;

import java.io.Serializable;

/**
 * Response body for Url registration
 * 
 * @author Jelena
 *
 */
public class URLRegistrationResponse extends JsonResponse implements Serializable {

	// short url
	private String shortUrl;

	public URLRegistrationResponse() {
		super();
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

}
