package model;

import java.io.Serializable;

import javax.naming.Name;

import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

@Entry(objectClasses = { "user", "organizationalPerson", "person", "top" })
public class LdapUser implements Serializable {
	private static final long serialVersionUID = 1;

	@Id
	private Name DN;
	private String SAMAccountName;

	public LdapUser() {
		super();
	}

	public Name getDN() {
		return DN;
	}

	public void setDN(Name dN) {
		DN = dN;
	}

	public String getSAMAccountName() {
		return SAMAccountName;
	}

	public void setSAMAccountName(String sAMAccountName) {
		SAMAccountName = sAMAccountName;
	}

}
