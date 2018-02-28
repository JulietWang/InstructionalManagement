package com.guigu.instructional.student2.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.po.EvaluationInfo;
import com.guigu.instructional.po.EvaluationInfoExample;
import com.guigu.instructional.po.EvaluationInfoExampleVO;
import com.guigu.instructional.po.StaffInfo;
import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.po.StudentInfoCustom;
import com.guigu.instructional.po.StudentInfoExample;
import com.guigu.instructional.po.StudentWriteGrade;
import com.guigu.instructional.po.StudentWriteGradeCustom;
import com.guigu.instructional.po.StudentWriteGradeExample;
import com.guigu.instructional.po.StudentWriteGradeExample.Criteria;
import com.guigu.instructional.student.mapper.StudentInfoMapper;
import com.guigu.instructional.student.mapper.StudentWriteGradeMapper;
import com.guigu.instructional.student2.service.StudentInfo2Service;
import com.guigu.instructional.student2.service.StudentWriteGradeService;
import com.guigu.instructional.system.service.StaffInfoService;

@Service("studentWriteGradeServiceImpl")
public class StudentWriteGradeServiceImpl implements StudentWriteGradeService {


	@Resource(name = "studentWriteGradeMapper")
	private StudentWriteGradeMapper studentWriteGradeMapper;

	@Resource(name = "studentInfoMapper")
	private StudentInfoMapper studentInfoMapper;

	@Resource(name = "staffInfoServiceImpl")
	private StaffInfoService staffInfoService;

	@Resource(name = "studentInfoService")
	private StudentInfo2Service studentInfoService;


	@Override
	public boolean addStudentWriteGrade(StudentWriteGrade studentWriteGrade) {
		int i = studentWriteGradeMapper.insertSelective(studentWriteGrade);
		if (i > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateStudentWriteGrade(StudentWriteGrade studentWriteGrade) {
		int i = studentWriteGradeMapper.updateByPrimaryKeySelective(studentWriteGrade);
		if (i > 0) {
			return true;
		}

		return false;
	}

	@Override
	public boolean deleteStudentWriteGrade(Integer writeGradeId) {
		int i = studentWriteGradeMapper.deleteByPrimaryKey(writeGradeId);
		if (i > 0) {
			return true;
		}
		return false;
	}

	@Override
	public StudentWriteGrade getStudentWriteGrade(Integer writeGradeId) {
		return studentWriteGradeMapper.selectByPrimaryKey(writeGradeId);
	}

	@Override
	public List<StudentWriteGradeCustom> getStudentWriteGradeList(StudentInfo studentInfo) {

		StudentWriteGradeExample studentWriteGradeExample = new StudentWriteGradeExample();
		Criteria criteria = studentWriteGradeExample.createCriteria();
		if (studentInfo != null && studentInfo.getStudentName()!= null) {

			List<StudentInfo> list = studentInfoService.getStudentInfoNameList(studentInfo);
			List<Integer> sid = new ArrayList<>();
			if (!list.isEmpty()) {
				for (StudentInfo stu : list) {
					sid.add(stu.getStudentId());
				}
				criteria.andStudentIdIn(sid);
			} else {
				return null;
			}
		}

		List<StudentWriteGrade> list2 = studentWriteGradeMapper.selectByExample(studentWriteGradeExample);
		List<StudentWriteGradeCustom> liststudentwritegrade = new ArrayList<>();
		if (list2!= null) {

			
			for (StudentWriteGrade studentWriteGrade : list2) {
				StudentWriteGradeCustom studentWriteGradeCustom = new StudentWriteGradeCustom();
				studentWriteGradeCustom.setStudentWriteGrade(studentWriteGrade);

				if (studentWriteGrade.getStudentId() != null) {
					StudentInfo student = studentInfoService.getStudent(studentWriteGrade.getStudentId());
					studentWriteGradeCustom.setStudentName(student.getStudentName());
				}
				if (studentWriteGrade.getStaffId() != null) {
					StaffInfo staffInfo = staffInfoService.getStaffInfo(studentWriteGrade.getStaffId());
					studentWriteGradeCustom.setStaffName(staffInfo.getStaffName());
				}

				liststudentwritegrade.add(studentWriteGradeCustom);
			}
			
		}
		return liststudentwritegrade;
	}

}
