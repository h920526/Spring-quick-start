package service.impl;

import java.util.Arrays;
import java.util.Collection;

import model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.UserService;

@Service
@Transactional(readOnly = true)
public class DBUserDetailsService implements UserDetailsService {

	private static Collection<? extends GrantedAuthority> ROLE_USER_AUTHORITY = Arrays
			.asList(new GrantedAuthority[] { new SimpleGrantedAuthority(
					"ROLE_USER") });

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String userId)
			throws UsernameNotFoundException {
		final User user = userService.findUserById(userId);
		if (user == null) {
			throw new UsernameNotFoundException("user not found");
		}
		return new UserDetails() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isEnabled() {
				return true;
			}

			@Override
			public boolean isCredentialsNonExpired() {
				return true;
			}

			@Override
			public boolean isAccountNonLocked() {
				return true;
			}

			@Override
			public boolean isAccountNonExpired() {
				return true;
			}

			@Override
			public String getUsername() {
				return user.getUserId();
			}

			@Override
			public String getPassword() {
				return user.getUserPassword();
			}

			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				return ROLE_USER_AUTHORITY;
			}
		};
	}

}
