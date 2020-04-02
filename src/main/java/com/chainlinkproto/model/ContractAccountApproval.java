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

@Entity
@Table(name = "ContractAccounts")
public class ContractAccountApproval implements Serializable{

	private static final long serialVersionUID = -5314208054566561464L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "ContractID", nullable = false)
	private Contracts contract;
	
	@ManyToOne
	@JoinColumn(name = "AccountID", nullable = false)
	private Accounts account;
	
	@Column(name ="ApprovalStatus", columnDefinition = "BIT")
	private boolean approvalStatus;

	public Contracts getContract() {
		return contract;
	}

	public Accounts getAccount() {
		return account;
	}

	public boolean isApprovalStatus() {
		return approvalStatus;
	}

	public void setContract(Contracts contract) {
		this.contract = contract;
	}

	public void setAccount(Accounts account) {
		this.account = account;
	}

	public void setApprovalStatus(boolean approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
}
