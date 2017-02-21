package com.infobip.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infobip.credentials.CredentialFactory;
import com.infobip.credentials.UserCredentials;
import com.infobip.model.Account;

/**
 * Service for providing user credentials to Spring Security
 * 
 * @author Jelena
 *
 */
@Service
@Transactional
public class UserCredentialsRepository implements UserDetailsService {

	@Autowired
	private RepositoryAccount accountRepository;
	@Autowired
	private CredentialFactory credentialFactory;	

	public UserCredentialsRepository() {
		super();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Account account = accountRepository.getAccount(username);
		if (account.equals(null) == false) {
			UserCredentials user = credentialFactory.generateNewCredentials(account.getName(), account.getPassword());
			return user;
		} else {
			throw new UsernameNotFoundException("User: " + username + "don't exists");
		}
	}

}
