package com.chainlinkproto.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Users")
public class Users implements Serializable{

	private static final long serialVersionUID = 6255214904830542829L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@NotEmpty
	@Column(name = "FirstName", nullable = false)
	private String firstName;
	
	@NotEmpty
	@Column(name = "LastName", nullable = false)
	private String lastName;
	
	@NotEmpty
	@Column(name = "EmailAddress", nullable = false, unique = true)
	private String emailAddress;

	@NotEmpty
	@Column(name = "PasswordHash", nullable = false)
	private String passwordHash;
	
	@Column(name = "WalletKey")
	private String walletKey;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "user", fetch = FetchType.EAGER)
	private Set<UserAuthority> userAuthority = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getWalletKey() {
		return walletKey;
	}

	public void setWalletKey(String walletKey) {
		this.walletKey = walletKey;
	}

	public Set<UserAuthority> getUserAuthority() {
		return userAuthority;
	}

	public void setUserAuthority(Set<UserAuthority> userAuthority) {
		this.userAuthority = userAuthority;
	}
}
