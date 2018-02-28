package com.guigu.instructional.recruitstudent.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.guigu.instructional.classinfo.service.DisciplineInfoService;
import com.guigu.instructional.po.AuditionCustom;
import com.guigu.instructional.po.DisciplineInfo;
import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.po.AuditionInfo;
import com.guigu.instructional.po.AuditionInfoExample;
import com.guigu.instructional.po.AuditionInfoExample.Criteria;
import com.guigu.instructional.recruitstudent.mapper.AuditionInfoMapper;
import com.guigu.instructional.recruitstudent.service.AuditionInfoService;
import com.guigu.instructional.student.service.StudentInfoService;

@Service(value = "auditionInfoServiceImpl")
public class AuditionInfoServiceImpl implements AuditionInfoService {

	@Resource(name = "auditionInfoMapper")
	private AuditionInfoMapper auditionInfoMapper;
	
	@Resource(name = "studentInfoServiceImpl")
	private StudentInfoService studentInfoService;
	
	@Resource(name = "disciplineInfoServiceImpl")
	private DisciplineInfoService disciplineInfoService;
	
	@Override
	public boolean addAudition(AuditionInfo auditionInfo) {

		int result = auditionInfoMapper.insertSelective(auditionInfo);
		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean upadteAudition(AuditionInfo auditionInfo) {
		int result = auditionInfoMapper.updateByPrimaryKeySelective(auditionInfo);
		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public AuditionInfo getAuditionInfo(Integer auditionId) {
		return auditionInfoMapper.selectByPrimaryKey(auditionId);
	}

	@Override
	public int deleteAuditionInfo(Integer auditionId) {

		return auditionInfoMapper.deleteByPrimaryKey(auditionId);
	}

	@Override
	public List<AuditionCustom> getAuditionCustomList(StudentInfo studentInfo,DisciplineInfo disciplineInfo){
		
		AuditionInfoExample auditionInfoExample=new AuditionInfoExample();
		Criteria criteria=auditionInfoExample.createCriteria();
		
		if(studentInfo!=null && studentInfo.getStudentName()!=null) {
			
			List<StudentInfo> studentList=studentInfoService.getStudentNameList(studentInfo);
			if(!studentList.isEmpty()) {
				List<Integer> slist=new ArrayList<>();
				
				for (StudentInfo student : studentList) {
					slist.add(student.getStudentId());
				}
				criteria.andStudentIdIn(slist);
			}
			else {
				return null;
			}
		}
		if(disciplineInfo!=null && disciplineInfo.getDisciplineName()!=null) {
			
			List<DisciplineInfo> disciplineList=disciplineInfoService.getDisciplineNameList(disciplineInfo);
			if(!disciplineList.isEmpty()) {
				List<Integer> dlist=new ArrayList<>();
				for (DisciplineInfo discipline : disciplineList) {
					dlist.add(discipline.getDisciplineId());
				};
				criteria.andAuditionCourseIn(dlist);
			}
			else {
				return null;
			}
		}
		
		List<AuditionInfo> auditionList=auditionInfoMapper.selectByExample(auditionInfoExample);
		if(auditionList!=null) {
			List<AuditionCustom> asdlist=new ArrayList<>();
			for (AuditionInfo auditionInfo : auditionList) {
				AuditionCustom auditionCustom=new AuditionCustom();
				auditionCustom.setAuditionInfo(auditionInfo);
				if(auditionInfo.getStudentId()!=null) {
					auditionCustom.setStudentName(studentInfoService.getStudentInfo(auditionInfo.getStudentId()).getStudentName());
				}
				if(auditionInfo.getAuditionCourse()!=null){
					auditionCustom.setDisciplineName(disciplineInfoService.getDisciplineInfo(auditionInfo.getAuditionCourse()).getDisciplineName());
				}
				asdlist.add(auditionCustom);
			}
			return asdlist;
			
		}else {
			return null;
		}
	}
	
}
