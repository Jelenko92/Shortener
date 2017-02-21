package com.infobip.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.infobip.json.requests.RegistrationRequest;
import com.infobip.json.responses.RegistrationResponse;
import com.infobip.model.Account;
import com.infobip.repository.RepositoryAccount;

/**
 * 
 * @author Jelena
 *
 */
@RestController
@EnableWebMvc
public class AccountController {

	@Autowired
	RepositoryAccount accountRepository;

	/**
	 * Register new account
	 * 
	 * @param request
	 * @return {@link RegistrationResponse} json that contains password, if new account with new password,
	 *         otherwise with existing password
	 */
	@RequestMapping(value = "/account", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public RegistrationResponse account(@RequestBody RegistrationRequest request) {
		String password = accountRepository.addAccount(request.getAccountId());
		RegistrationResponse response = new RegistrationResponse();
		response.registration(password, request.getAccountId());
		return response;
	}

	/**
	 * Get all registered acounts
	 * 
	 * @return all registered accounts
	 */
	@RequestMapping(value = "/accountAll", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
	public List<Account> account() {
		return accountRepository.getAllAccounts();
	}

}
