package com.infobip.json.requests;

import java.io.Serializable;

/**
 * Request body for account registration
 * 
 * @author Jelena
 *
 */
public class RegistrationRequest extends JsonRequest implements Serializable{

	private String accountId;

	public RegistrationRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RegistrationRequest(String accountId) {
		super();
		this.accountId = accountId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

}
