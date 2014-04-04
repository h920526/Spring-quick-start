package service;

import java.util.List;

import model.LdapUser;

public interface LdapUserService {

	public LdapUser findLdapUserById(String userId);

	public List<LdapUser> findAllLdapUsers();

	public LdapUser loadAuthenticatedUser();

}
