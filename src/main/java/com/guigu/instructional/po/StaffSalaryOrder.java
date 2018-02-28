package com.guigu.instructional.po;

public class StaffSalaryOrder {
	
	private StaffSalary staffSalary;
	
	private String staffName;
	
	private String financeName;
	
	private int staffSalaryOrderId;

	public int getStaffSalaryOrderId() {
		return staffSalaryOrderId;
	}

	public void setStaffSalaryOrderId(int staffSalaryOrderId) {
		this.staffSalaryOrderId = staffSalaryOrderId;
	}

	public StaffSalary getStaffSalary() {
		return staffSalary;
	}

	public void setStaffSalary(StaffSalary staffSalary) {
		this.staffSalary = staffSalary;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getFinanceName() {
		return financeName;
	}

	public void setFinanceName(String financeName) {
		this.financeName = financeName;
	}
	
}
