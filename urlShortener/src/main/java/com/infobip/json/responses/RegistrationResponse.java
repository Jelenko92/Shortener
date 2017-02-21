package com.infobip.json.responses;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Response body for account registration
 * 
 * @author Jelena
 *
 */
public class RegistrationResponse extends JsonResponse implements Serializable {

	private boolean success;

	// registration descriotrion
	private String description;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String password;

	public RegistrationResponse() {
		super();
	}

	public boolean getSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Depending on registration success generate response
	 * 
	 * @param password
	 *            new password
	 * @param accountId
	 *            accountId
	 */
	public void registration(String password, String accountId) {
		if (password.length() != 0) {
			this.setPassword(password);
			this.setDescription("Account " + accountId + " successfully registered");
			this.setSuccess(true);
		} else {
			this.setDescription("Account " + accountId + " not successfully registered because already exists");
			this.setSuccess(false);
		}
	}

}
