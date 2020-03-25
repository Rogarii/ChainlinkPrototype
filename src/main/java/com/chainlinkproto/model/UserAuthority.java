package com.chainlinkproto.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "UserAuthority")
public class UserAuthority implements Serializable{

	private static final long serialVersionUID = 898142735950545134L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@NotEmpty
	@Column(name = "RoleAuth", nullable = false)
	private String roleAuth;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="UserID", nullable = false)
	private Users user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleAuth() {
		return roleAuth;
	}

	public void setRoleAuth(String roleAuth) {
		this.roleAuth = roleAuth;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
}
