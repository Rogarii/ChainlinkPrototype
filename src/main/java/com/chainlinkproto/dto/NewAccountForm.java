package com.chainlinkproto.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

public class NewAccountForm implements Serializable{

	private static final long serialVersionUID = 469277037022105458L;

	@NotNull
	private String accountType;
	
	private String accountTitle;
	
	@NotNull
	private String citizenship;
	
	@NotNull
	private String country;
	
	@NotNull
	private String address1;
	
	private String address2;
	
	@NotNull
	private String city;
	
	@NotNull
	private String state;
	
	@NotNull
	private String zip;
	
	@NotNull
	private String primaryPhone;
	
	private String cellPhone;
	
	private String fax;

	public String getAccountType() {
		return accountType;
	}

	public String getAccountTitle() {
		return accountTitle;
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

	public String getZip() {
		return zip;
	}

	public String getPrimaryPhone() {
		return primaryPhone;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public String getFax() {
		return fax;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public void setAccountTitle(String accountTitle) {
		this.accountTitle = accountTitle;
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

	public void setZip(String zip) {
		this.zip = zip;
	}

	public void setPrimaryPhone(String primaryPhone) {
		this.primaryPhone = primaryPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}
}
