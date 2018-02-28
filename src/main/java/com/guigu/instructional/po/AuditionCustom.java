package com.guigu.instructional.po;

public class AuditionCustom {
	
	private AuditionInfo auditionInfo;
	
	private String disciplineName;

	private String studentName;

	public AuditionInfo getAuditionInfo() {
		return auditionInfo;
	}

	public void setAuditionInfo(AuditionInfo auditionInfo) {
		this.auditionInfo = auditionInfo;
	}

	public String getDisciplineName() {
		return disciplineName;
	}

	public void setDisciplineName(String disciplineName) {
		this.disciplineName = disciplineName;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Override
	public String toString() {
		return "AuditionCustom [auditionInfo=" + auditionInfo + ", disciplineName=" + disciplineName + ", studentName="
				+ studentName + "]";
	}
	
	
}
