package com.chainlinkproto.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class NewGroupForm implements Serializable {

	private static final long serialVersionUID = 2027162305155787803L;
	
	@NotNull
	private String groupTitle;

	public String getGroupTitle() {
		return groupTitle;
	}

	public void setGroupTitle(String groupTitle) {
		this.groupTitle = groupTitle;
	}
}
