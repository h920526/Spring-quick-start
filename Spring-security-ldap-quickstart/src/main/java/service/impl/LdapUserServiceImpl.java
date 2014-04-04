package service.impl;

import java.util.List;

import model.LdapUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import service.LdapUserService;
import dao.LdapUserDao;

@Service
public class LdapUserServiceImpl implements LdapUserService {

	@Autowired
	private LdapUserDao ldapUserDao;

	@Override
	public LdapUser findLdapUserById(String userId) {
		return ldapUserDao.findLdapUserById(userId);
	}

	@Override
	public List<LdapUser> findAllLdapUsers() {
		return ldapUserDao.findAllLdapUsers();
	}

	@Override
	public LdapUser loadAuthenticatedUser() {
		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		if (authentication == null || !authentication.isAuthenticated()) {
			return null;
		}
		Object principal = authentication.getPrincipal();
		if (principal instanceof String) {
			// for AD, OpenLDAP or others
			String userId = (String) principal;
			return findLdapUserById(userId);
		}
		return null;
	}

}
