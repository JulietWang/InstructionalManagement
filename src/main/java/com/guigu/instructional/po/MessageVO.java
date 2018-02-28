package com.guigu.instructional.po;

public class MessageVO extends MessageInfo{

	private String staffName;

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	@Override
	public String toString() {
		return "EmailVO [staffName=" + staffName + "]";
	}
	
}
