package com.guigu.instructional.po;

public class EvaluationInfoExampleVO extends EvaluationInfo {

	private StudentInfo studentInfo;
	
	private EvaluationInfo evaluationInfo;

	private String studentName;
	
	
	
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public StudentInfo getStudentInfo() {
		return studentInfo;
	}

	public void setStudentInfo(StudentInfo studentInfo) {
		this.studentInfo = studentInfo;
	}

	public EvaluationInfo getEvaluationInfo() {
		return evaluationInfo;
	}

	public void setEvaluationInfo(EvaluationInfo evaluationInfo) {
		this.evaluationInfo = evaluationInfo;
	}

	@Override
	public String toString() {
		return "EvaluationInfoExampleVO [studentInfo=" + studentInfo + ", evaluationInfo=" + evaluationInfo
				+ ", studentName=" + studentName + "]";
	}

	
	
	
	
}
