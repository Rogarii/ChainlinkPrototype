package com.chainlinkproto.model;

import java.io.Serializable;
import java.sql.Timestamp;

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
@Table(name = "UserInbox")
public class UserInbox implements Serializable {

	private static final long serialVersionUID = 5353717719487310809L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "UserID")
	private Users user;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ContractID")
	private Contracts contract;
	
	@NotEmpty
	@Column(name = "SentBy")
	private String sentBy;
	
	@NotEmpty
	@Column(name = "SentTime")
	private Timestamp sentTime;

	public Integer getId() {
		return id;
	}

	public Users getUser() {
		return user;
	}

	public Contracts getContract() {
		return contract;
	}

	public String getSentBy() {
		return sentBy;
	}

	public Timestamp getSentTime() {
		return sentTime;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public void setContract(Contracts contract) {
		this.contract = contract;
	}

	public void setSentBy(String sentBy) {
		this.sentBy = sentBy;
	}

	public void setSentTime(Timestamp sentTime) {
		this.sentTime = sentTime;
	}
}
