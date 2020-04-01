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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "EnterpriseAffiliates")
public class EnterpriseAffiliates implements Serializable {
	
	private static final long serialVersionUID = 1045974422987538463L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "BusinessTitle")
	private String businessTitle;
	
	@NotEmpty
	@Column(name = "DateCreated")
	private Timestamp dateCreated;
	
	@Column(name = "BusinessInfoPH1")
	private String businessInfoPH1;
	
	@Column(name = "BusinessInfoPH2")
	private String businessInfoPH2;
	
	@Column(name = "BusinessInfoPH3")
	private String businessInfoPH3;	
	
	@Column(name = "BusinessInfoPH4")
	private String businessInfoPH4;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "enterpriseAffiliate", fetch = FetchType.EAGER)
	private Set<Accounts> accounts = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBusinessTitle() {
		return businessTitle;
	}

	public void setBusinessTitle(String businessTitle) {
		this.businessTitle = businessTitle;
	}

	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getBusinessInfoPH1() {
		return businessInfoPH1;
	}

	public void setBusinessInfoPH1(String businessInfoPH1) {
		this.businessInfoPH1 = businessInfoPH1;
	}

	public String getBusinessInfoPH2() {
		return businessInfoPH2;
	}

	public void setBusinessInfoPH2(String businessInfoPH2) {
		this.businessInfoPH2 = businessInfoPH2;
	}

	public String getBusinessInfoPH3() {
		return businessInfoPH3;
	}

	public void setBusinessInfoPH3(String businessInfoPH3) {
		this.businessInfoPH3 = businessInfoPH3;
	}

	public String getBusinessInfoPH4() {
		return businessInfoPH4;
	}

	public void setBusinessInfoPH4(String businessInfoPH4) {
		this.businessInfoPH4 = businessInfoPH4;
	}

	public Set<Accounts> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Accounts> accounts) {
		this.accounts = accounts;
	}
}
