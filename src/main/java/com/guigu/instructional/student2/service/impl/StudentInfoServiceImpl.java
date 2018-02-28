package com.guigu.instructional.student2.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.guigu.instructional.po.ClassInfo;
import com.guigu.instructional.po.StaffInfo;
import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.po.StudentInfoCustom;
import com.guigu.instructional.po.StudentInfoExample;
import com.guigu.instructional.student.mapper.StudentInfoMapper;
import com.guigu.instructional.po.StudentInfoExample.Criteria;
import com.guigu.instructional.student2.service.StudentInfo2Service;
import com.guigu.instructional.system.mapper.StaffInfoMapper;
import com.guigu.instructional.transaction.mapper.ClassInfoMapper;

@Service("studentInfoService")
public class StudentInfoServiceImpl implements StudentInfo2Service {


	@Resource(name = "studentInfoMapper")
	private StudentInfoMapper studentInfoMapper;

	@Resource(name = "classInfoMapper")
	private ClassInfoMapper classInfoMapper;

	@Resource(name = "staffInfoMapper")
	private StaffInfoMapper staffInfoMapper;
	


	@Override
	public boolean addStudent(StudentInfo studentInfo) {
		int i = studentInfoMapper.insertSelective(studentInfo);
		if (i > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateStudent(StudentInfo studentInfo) {
		int i = studentInfoMapper.updateByPrimaryKeySelective(studentInfo);
		if (i > 0) {
			return true;
		}
		return false;
	}

	@Override
	public StudentInfo getStudent(Integer studentId) {
		return studentInfoMapper.selectByPrimaryKey(studentId);
	}

	@Override
	public List<StudentInfoCustom> getStudentInfoList(StudentInfo studentInfo) {
		

		StudentInfoExample studentInfoExample = new StudentInfoExample();
		Criteria criteria = studentInfoExample.createCriteria();

		if (studentInfo!= null && studentInfo.getStudentName()!= null) {
			studentInfo.setStudentName("%"+studentInfo.getStudentName()+"%");
			criteria.andStudentNameLike(studentInfo.getStudentName());
		}

		criteria.andStudentMarkEqualTo(1);
		List<StudentInfo> list= studentInfoMapper.selectByExample(studentInfoExample);
		
		List<StudentInfoCustom> liststudent = new ArrayList<>();
		
		if (!list.isEmpty()) {
			for (StudentInfo student:list) {
				StudentInfoCustom studentInfoCustom = new StudentInfoCustom();
				
				if(student.getStaffId()!=null) {
				StaffInfo staffInfo = staffInfoMapper.selectByPrimaryKey(student.getStaffId());
				studentInfoCustom.setStaffName(staffInfo.getStaffName());
			}
				if(student.getClassId()!=null) {
				ClassInfo classInfo=classInfoMapper.selectByPrimaryKey(student.getClassId());
				studentInfoCustom.setClassName(classInfo.getClassName());
				}
				studentInfoCustom.setStudentInfo(student);
				
				
				liststudent.add(studentInfoCustom);
			}
		}

		return liststudent;

	}

	@Override
	public List<StudentInfo> getStudentInfoNameList(StudentInfo studentInfo) {

		StudentInfoExample studentInfoExample = new StudentInfoExample();
		Criteria criteria = studentInfoExample.createCriteria();

		if (studentInfo != null && studentInfo.getStudentName() != null) {
			studentInfo.setStudentName("%" + studentInfo.getStudentName() + "%");
			criteria.andStudentNameLike(studentInfo.getStudentName());
		}
		List<StudentInfo> studentlist =studentInfoMapper.selectByExample(studentInfoExample);
		if(studentlist!=null) {
			return studentlist;
		}else {
			return null;
		}
	}
}
