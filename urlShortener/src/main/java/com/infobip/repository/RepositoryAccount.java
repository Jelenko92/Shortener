package com.infobip.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infobip.model.Account;
import com.infobip.model.factory.AccountFactory;


/**
 * Repository for registered accounts and basic authentification users
 * 
 * @author Jelena
 *
 */
@Repository
public class RepositoryAccount {

	// NOTE to myself: POPRAVI OVO
	// static -> private
	// ako je private, za UserCredentialsRepository se stvori
	// novi bean, iako je scope ok i ne bi trebalo, svuda dalje je ok
	// A to je jedina klasa koja se implicitno poziva, i to od strane spring
	// security filter chaina -- Potencijalni problem
	/**
	 * Map with registered accounts. Key: AccountID Value: Password
	 */
	static Map<String, Account> accounts = new HashMap<String, Account>();

	@Autowired
	AccountFactory accountFactory;

	public RepositoryAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Registering account
	 * 
	 * @param account
	 *            AccountId
	 * @return password if registered, otherwise empty string
	 */
	public String addAccount(String account) {
		String password = "";
		if (accountExists(account)) {
			return password;
		}

		Account newAccount = accountFactory.createAccount(account);
		accounts.put(account, newAccount);
		return newAccount.getPassword();
	}

	/**
	 * Checks if account is already registered
	 * 
	 * @param account
	 * @return true if registered, otherwise false
	 */
	private boolean accountExists(String account) {
		return RepositoryAccount.accounts.containsKey(account);
	}

	public Account getAccount(String accountId) {
		if (accountExists(accountId) == false) {
			return null;
		}

		return accounts.get(accountId);
	}

	public List<Account> getAllAccounts() {
		List<Account> allAccounts = new ArrayList<Account>();
		for (Map.Entry<String, Account> entry : accounts.entrySet()) {
			allAccounts.add(entry.getValue());
		}

		return allAccounts;
	}

	/**
	 * Get number of registered accounts
	 * @return
	 */
	public String getSize() {
		return accounts.size() + "";
	}

}
