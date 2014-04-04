package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user")
public class User implements Serializable {
	private static final long serialVersionUID = 1;

	@Id
	@Column(name = "user_key")
	@NotNull
	private Integer userKey;

	@Column(name = "user_name")
	@NotNull
	private String userName;

	public User() {
		super();
	}

	public Integer getUserKey() {
		return userKey;
	}

	public void setUserKey(Integer userKey) {
		this.userKey = userKey;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
