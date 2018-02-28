package com.guigu.instructional.po;


public class EmailVO extends EmailInfo{
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
