package com.guigu.instructional.student2.service;

import java.util.List;

import com.guigu.instructional.po.EvaluationInfo;
import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.po.StudentInfoCustom;

public interface StudentInfo2Service {

	
	public boolean addStudent(StudentInfo studentInfo);
	
	public boolean updateStudent(StudentInfo studentInfo);
	
	public StudentInfo getStudent(Integer studentId );
	
	public List<StudentInfoCustom> getStudentInfoList(StudentInfo studentInfo);
	
	public List<StudentInfo> getStudentInfoNameList(StudentInfo studentInfo);
}
