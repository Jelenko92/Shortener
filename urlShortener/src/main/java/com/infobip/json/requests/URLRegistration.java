package com.infobip.json.requests;

import java.io.Serializable;

/**
 * Request for URL registration
 * @author Jelena
 *
 */
public class URLRegistration  extends JsonRequest implements Serializable{

	//url
	private String url;
	private int redirectType;
	
	public URLRegistration() {
		super();
		//defautl 302
		this.redirectType = 302;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getRedirectType() {
		return redirectType;
	}
	public void setRedirectType(int redirectType) {
		if(redirectType == 302 || redirectType == 301){
			this.redirectType = redirectType;	
		}
	}
	
	
	
}
