package com.chainlinkproto.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class NewEnterpriseForm implements Serializable{

	private static final long serialVersionUID = 8550380200564730729L;

	@NotNull
	private String buisnessTitle;
	
	private String info1;
	
	private String info2;
	
	private String info3;
	
	private String info4;

	public String getBuisnessTitle() {
		return buisnessTitle;
	}

	public void setBuisnessTitle(String buisnessTitle) {
		this.buisnessTitle = buisnessTitle;
	}

	public String getInfo1() {
		return info1;
	}

	public void setInfo1(String info1) {
		this.info1 = info1;
	}

	public String getInfo2() {
		return info2;
	}

	public void setInfo2(String info2) {
		this.info2 = info2;
	}

	public String getInfo3() {
		return info3;
	}

	public void setInfo3(String info3) {
		this.info3 = info3;
	}

	public String getInfo4() {
		return info4;
	}

	public void setInfo4(String info4) {
		this.info4 = info4;
	}
}
