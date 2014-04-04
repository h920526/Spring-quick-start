package model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class UserAuthorityInfo implements UserDetails {
	private static final long serialVersionUID = 1;

	private User user;
	private Collection<? extends GrantedAuthority> authorities;

	public UserAuthorityInfo(User user,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.user = user;
		this.authorities = authorities;
	}

	/**
	 * Get
	 * 
	 * @return User
	 */
	public static User get() {
		return ((UserAuthorityInfo) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal()).getUser();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return user.getUserPassword();
	}

	@Override
	public String getUsername() {
		return user.getUserId();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setAuthorities(
			Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

}
