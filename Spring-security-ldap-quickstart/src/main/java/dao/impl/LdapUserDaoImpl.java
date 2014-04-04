package dao.impl;

import java.util.List;

import model.LdapUser;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.query.LdapQuery;
import org.springframework.ldap.query.LdapQueryBuilder;

import dao.LdapUserDao;

public class LdapUserDaoImpl implements LdapUserDao {

	private LdapTemplate ldapTemplate;
	private String userIdAttribute;

	public LdapUserDaoImpl() {
		super();
	}

	public void setLdapTemplate(LdapTemplate ldapTemplate) {
		this.ldapTemplate = ldapTemplate;
	}

	public void setUserIdAttribute(String userIdAttribute) {
		this.userIdAttribute = userIdAttribute;
	}

	@Override
	public LdapUser findLdapUserById(String userId) {
		LdapQuery query = LdapQueryBuilder.query().where(userIdAttribute)
				.is(userId);
		try {
			return ldapTemplate.findOne(query, LdapUser.class);
		} catch (IncorrectResultSizeDataAccessException e) {
		}
		return null;
	}

	@Override
	public List<LdapUser> findAllLdapUsers() {
		return ldapTemplate.findAll(LdapUser.class);
	}

}
