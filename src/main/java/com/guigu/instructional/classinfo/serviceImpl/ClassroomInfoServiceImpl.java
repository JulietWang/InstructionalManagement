package com.guigu.instructional.classinfo.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.guigu.instructional.classinfo.service.ClassroomInfoService;
import com.guigu.instructional.po.ClassroomInfo;
import com.guigu.instructional.po.ClassroomInfoExample;
import com.guigu.instructional.po.ClassroomInfoExample.Criteria;
import com.guigu.instructional.transaction.mapper.ClassroomInfoMapper;

@Service("classroomInfoServiceImpl")
public class ClassroomInfoServiceImpl implements ClassroomInfoService {

	@Resource(name="classroomInfoMapper")
	private ClassroomInfoMapper classroomInfoMapper;
	
	@Override
	public boolean addClassroomInfo(ClassroomInfo classroomInfo) {
		if(classroomInfo!=null) {
			classroomInfo.setClassroomMark("1");
		}
		int i = classroomInfoMapper.insertSelective(classroomInfo);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateClassroomInfo(ClassroomInfo classroomInfo) {
		int i = classroomInfoMapper.updateByPrimaryKeySelective(classroomInfo);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public List<ClassroomInfo> getClassroomInfoList(ClassroomInfo classroomInfo) {
		ClassroomInfoExample classroomInfoExample = new ClassroomInfoExample();
		Criteria criteria = classroomInfoExample.createCriteria();
		if(classroomInfo!=null) {
			if(classroomInfo.getClassroomName()!=null) {
				classroomInfo.setClassroomName("%"+classroomInfo.getClassroomName()+"%");
				criteria.andClassroomNameLike(classroomInfo.getClassroomName());
			}
		}
		criteria.andClassroomMarkEqualTo("1");
		return classroomInfoMapper.selectByExample(classroomInfoExample);
	}

	@Override
	public ClassroomInfo getClassroomInfo(Integer classroomId) {
		
		return classroomInfoMapper.selectByPrimaryKey(classroomId);
	}

}
