package dao.impl;

import java.util.List;

import model.LdapUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.query.LdapQuery;
import org.springframework.ldap.query.LdapQueryBuilder;
import org.springframework.stereotype.Repository;

import dao.LdapUserDao;

@Repository
public class LdapUserDaoImpl implements LdapUserDao {

	@Autowired
	private LdapTemplate ldapTemplate;
	@Value("${user_id_attr}")
	private String userIdAttribute;

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
