package com.infobip.credentials;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Credentials for registered users
 * @author Jelena
 *
 */
public class UserCredentials implements UserDetails {

	private String username;
	private String password;
	private boolean notExpiredCredentials;
	private boolean notExpiredAccount;
	private boolean notEnabled;
	private boolean notLocked;
	// List of authorities for user
	private List<GrantedAuthority> authorities;

	public UserCredentials() {
		super();
		this.authorities = new ArrayList<GrantedAuthority>();

		// Ovo ide u factory
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.notExpiredAccount;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.notLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.notExpiredCredentials;
	}

	@Override
	public boolean isEnabled() {
		return this.notEnabled;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setNotExpiredCredentials(boolean notExpiredCredentials) {
		this.notExpiredCredentials = notExpiredCredentials;
	}

	public void setNotExpiredAccount(boolean notExpiredAccount) {
		this.notExpiredAccount = notExpiredAccount;
	}

	public void setNotEnabled(boolean notEnabled) {
		this.notEnabled = notEnabled;
	}

	public void setNotLocked(boolean notLocked) {
		this.notLocked = notLocked;
	}



}
