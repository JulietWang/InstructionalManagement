package com.guigu.instructional.recruitstudent.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.po.TrackRecordCustom;
import com.guigu.instructional.po.TrackRecordInfo;
import com.guigu.instructional.po.TrackRecordInfoExample;
import com.guigu.instructional.po.TrackRecordInfoExample.Criteria;
import com.guigu.instructional.recruitstudent.mapper.TrackRecordInfoMapper;
import com.guigu.instructional.recruitstudent.service.TrackRecordInfoService;
import com.guigu.instructional.student.service.StudentInfoService;

@Service(value = "trackRecordInfoServiceImpl")
public class TrackRecordInfoServiceImpl implements TrackRecordInfoService{
	
	@Resource(name="trackRecordInfoMapper")
	private TrackRecordInfoMapper trackRecordInfoMapper;
	
	@Resource(name = "studentInfoServiceImpl")
	private StudentInfoService studentInfoService;

	@Override
	public boolean addTrackRecord(TrackRecordInfo trackRecordInfo) {
		int result = trackRecordInfoMapper.insertSelective(trackRecordInfo);
		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean upadteTrackRecord(TrackRecordInfo trackRecordInfo) {
		int result = trackRecordInfoMapper.updateByPrimaryKeySelective(trackRecordInfo);
		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public TrackRecordInfo getTrackRecordInfo(Integer trackRecordId) {
		
		return trackRecordInfoMapper.selectByPrimaryKey(trackRecordId);
	}

	@Override
	public int deleteTrackRecordInfo(Integer trackRecordId) {
		
		return trackRecordInfoMapper.deleteByPrimaryKey(trackRecordId);
	}

	@Override
	public List<TrackRecordCustom> getTrackRecordCustomList(StudentInfo studentInfo) {
		
		TrackRecordInfoExample trackRecordInfoExample=new TrackRecordInfoExample();
		Criteria criteria=trackRecordInfoExample.createCriteria();
		
		if(studentInfo!=null && studentInfo.getStudentName()!=null) {
			List<StudentInfo> studentList=studentInfoService.getStudentNameList(studentInfo);
			System.out.println(studentList);
			if(!studentList.isEmpty()) {
				List<Integer> slist=new ArrayList<>();
				
				for (StudentInfo student : studentList) {
					slist.add(student.getStudentId());
				}
				criteria.andStudentIdIn(slist);
			}else {
				return null;
			}
		}
		
		List<TrackRecordInfo> trackRecordList=trackRecordInfoMapper.selectByExample(trackRecordInfoExample);
		
		if(trackRecordList!=null) {
			List<TrackRecordCustom> trlist=new ArrayList<>();
			for (TrackRecordInfo trackRecordInfo : trackRecordList) {
				TrackRecordCustom trackRecordCustom=new TrackRecordCustom();
				trackRecordCustom.setTrackRecordInfo(trackRecordInfo);
				if(trackRecordInfo.getStudentId()!=null) {
					StudentInfo s=studentInfoService.getStudentInfo(trackRecordInfo.getStudentId());
					trackRecordCustom.setStudentName(s.getStudentName());
					trackRecordCustom.setStudentState(s.getStudentState());
				}
				trlist.add(trackRecordCustom);
			}
			return trlist;
		}else {
			return null;
		}
	}
}
