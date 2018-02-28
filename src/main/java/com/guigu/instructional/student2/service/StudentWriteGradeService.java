package com.guigu.instructional.student2.service;

import java.util.List;

import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.po.StudentWriteGrade;
import com.guigu.instructional.po.StudentWriteGradeCustom;

public interface StudentWriteGradeService {

	
	public boolean addStudentWriteGrade(StudentWriteGrade studentWriteGrade);
	
	public boolean updateStudentWriteGrade(StudentWriteGrade studentWriteGrade);
	
	public boolean deleteStudentWriteGrade(Integer writeGradeId);
	
	public StudentWriteGrade getStudentWriteGrade(Integer writeGradeId);
	
	public List<StudentWriteGradeCustom> getStudentWriteGradeList(StudentInfo studentInfo);
}
