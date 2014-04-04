package dao;

import java.util.List;

import model.LdapUser;

public interface LdapUserDao {

	public LdapUser findLdapUserById(String userId);

	public List<LdapUser> findAllLdapUsers();

}
