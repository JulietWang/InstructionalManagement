package com.guigu.instructional.po;

public class StudentCustom {
	
	private StudentInfo studentInfo;
	
	private String staffName;
	
	private String activeName;

	public StudentInfo getStudentInfo() {
		return studentInfo;
	}

	public void setStudentInfo(StudentInfo studentInfo) {
		this.studentInfo = studentInfo;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getActiveName() {
		return activeName;
	}

	public void setActiveName(String activeName) {
		this.activeName = activeName;
	}

	@Override
	public String toString() {
		return "StudentCustom [studentInfo=" + studentInfo + ", staffName=" + staffName + ", activeName=" + activeName
				+ "]";
	}

	
	
}
