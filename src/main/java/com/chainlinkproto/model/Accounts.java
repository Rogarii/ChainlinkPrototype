package com.chainlinkproto.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "Accounts")
public class Accounts implements Serializable{

	private static final long serialVersionUID = -1589008854180275026L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "UserID", nullable = false)
	private Users user;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "GroupID", nullable = false)
	private UserGroups userGroup;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "EnterpriseID", nullable = false)
	private EnterpriseAffiliates enterpriseAffiliate;
	
	@Column(name = "AccountTitle")
	private String accountTitle;
	
	@NotEmpty
	@Column(name = "AccountType")
	private String accountType;
	
	@Column(name = "SubType")
	private String subType;
	
	@Column(name = "SubStatus", columnDefinition = "BIT")
	private boolean subStatus;
	
	@NotEmpty
	@Column(name = "Citizenship")
	private String citizenship;
	
	@NotEmpty
	@Column(name = "Country")
	private String country;
	
	@NotEmpty
	@Column(name = "Address1")
	private String address1;
	
	@Column(name = "Address2")
	private String address2;
	
	@NotEmpty
	@Column(name = "City")
	private String city;
	
	@NotEmpty
	@Column(name = "StateAd")
	private String state;
	
	@NotNull
	@Column(name = "Zip")
	private Integer zip;
	
	@NotNull
	@Column(name = "PrimaryPhone")
	private BigDecimal primaryPhone;
	
	@Column(name = "CellPhone")
	private BigDecimal cellPhone;
	
	@Column(name = "Fax")
	private BigDecimal fax;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "account", fetch = FetchType.EAGER)
	private Set<IntelProperties> intelProperties = new HashSet<>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ContractAccounts", joinColumns = { @JoinColumn(name = "AccountID") }, inverseJoinColumns = { @JoinColumn(name = "ContractID")})
	private Set<Contracts> contracts = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public Users getUser() {
		return user;
	}

	public UserGroups getUserGroup() {
		return userGroup;
	}

	public EnterpriseAffiliates getEnterpriseAffiliate() {
		return enterpriseAffiliate;
	}

	public String getAccountTitle() {
		return accountTitle;
	}

	public String getAccountType() {
		return accountType;
	}

	public String getSubType() {
		return subType;
	}

	public boolean isSubStatus() {
		return subStatus;
	}

	public String getCitizenship() {
		return citizenship;
	}

	public String getCountry() {
		return country;
	}

	public String getAddress1() {
		return address1;
	}

	public String getAddress2() {
		return address2;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public Integer getZip() {
		return zip;
	}

	public BigDecimal getPrimaryPhone() {
		return primaryPhone;
	}

	public BigDecimal getCellPhone() {
		return cellPhone;
	}

	public BigDecimal getFax() {
		return fax;
	}

	public Set<IntelProperties> getIntelProperties() {
		return intelProperties;
	}

	public Set<Contracts> getContracts() {
		return contracts;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public void setUserGroup(UserGroups userGroup) {
		this.userGroup = userGroup;
	}

	public void setEnterpriseAffiliate(EnterpriseAffiliates enterpriseAffiliate) {
		this.enterpriseAffiliate = enterpriseAffiliate;
	}

	public void setAccountTitle(String accountTitle) {
		this.accountTitle = accountTitle;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public void setSubStatus(boolean subStatus) {
		this.subStatus = subStatus;
	}

	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}

	public void setPrimaryPhone(BigDecimal primaryPhone) {
		this.primaryPhone = primaryPhone;
	}

	public void setCellPhone(BigDecimal cellPhone) {
		this.cellPhone = cellPhone;
	}

	public void setFax(BigDecimal fax) {
		this.fax = fax;
	}

	public void setIntelProperties(Set<IntelProperties> intelProperties) {
		this.intelProperties = intelProperties;
	}

	public void setContracts(Set<Contracts> contracts) {
		this.contracts = contracts;
	}
}
