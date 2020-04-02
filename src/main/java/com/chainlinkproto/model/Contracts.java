package com.chainlinkproto.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;



@Entity
@Table(name = "Contracts")
public class Contracts implements Serializable {

	private static final long serialVersionUID = 9212005858929458226L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@NotEmpty
	@Column(name = "ContractType")
	private String contractType;
	
	@NotEmpty
	@Column(name = "DateCreated")
	private Timestamp dateCreated;
	
	@NotEmpty
	@Column(name = "DateModified")
	private Timestamp dateModified;
	
	@Column(name = "BCKey")
	private String bcKey;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "contract", fetch = FetchType.EAGER)
	private Set<ContractAccountApproval> contractApprovals = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "contract", fetch = FetchType.EAGER)
	private Set<UserInbox> userInbox = new HashSet<>();
	
	@ManyToMany(mappedBy = "contracts")
	private Set<Accounts> accounts = new HashSet<>();
	
	@ManyToMany(mappedBy = "contracts")
	private Set<IntelProperties> intelProperties = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public String getContractType() {
		return contractType;
	}

	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public Timestamp getDateModified() {
		return dateModified;
	}

	public String getBcKey() {
		return bcKey;
	}

	public Set<ContractAccountApproval> getContractApprovals() {
		return contractApprovals;
	}

	public Set<UserInbox> getUserInbox() {
		return userInbox;
	}

	public Set<Accounts> getAccounts() {
		return accounts;
	}

	public Set<IntelProperties> getIntelProperties() {
		return intelProperties;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public void setDateModified(Timestamp dateModified) {
		this.dateModified = dateModified;
	}

	public void setBcKey(String bcKey) {
		this.bcKey = bcKey;
	}

	public void setContractApprovals(Set<ContractAccountApproval> contractApprovals) {
		this.contractApprovals = contractApprovals;
	}

	public void setUserInbox(Set<UserInbox> userInbox) {
		this.userInbox = userInbox;
	}

	public void setAccounts(Set<Accounts> accounts) {
		this.accounts = accounts;
	}

	public void setIntelProperties(Set<IntelProperties> intelProperties) {
		this.intelProperties = intelProperties;
	}
}
