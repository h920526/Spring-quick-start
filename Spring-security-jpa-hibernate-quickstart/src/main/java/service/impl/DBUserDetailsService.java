package service.impl;

import java.util.Arrays;
import java.util.Collection;

import model.User;
import model.UserAuthorityInfo;

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
		User user = userService.findUserById(userId);
		if (user == null) {
			throw new UsernameNotFoundException("user not found");
		}
		return new UserAuthorityInfo(user, ROLE_USER_AUTHORITY);
	}

}
