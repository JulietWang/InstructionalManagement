package com.guigu.instructional.po;

//StudentPayment的包装类
public class StudentPaymentOrder {
	
	private StudentPayment studentPayment;
	
	private String studnetName;
	
	private String staffName;
	
	private String className;
	
	private int studentPaymentId;
	
	public int getStudentPaymentId() {
		return studentPaymentId;
	}

	public void setStudentPaymentId(int studentPaymentId) {
		this.studentPaymentId = studentPaymentId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public StudentPayment getStudentPayment() {
		return studentPayment;
	}

	public void setStudentPayment(StudentPayment studentPayment) {
		this.studentPayment = studentPayment;
	}

	public String getStudnetName() {
		return studnetName;
	}

	public void setStudnetName(String studnetName) {
		this.studnetName = studnetName;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	
}
