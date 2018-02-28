package com.guigu.instructional.classinfo.serviceImpl;

 import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.guigu.instructional.classinfo.mapper.DisciplineInfoMapper;
import com.guigu.instructional.classinfo.service.DisciplineInfoService;
import com.guigu.instructional.po.DisciplineInfo;
import com.guigu.instructional.po.DisciplineInfoExample;
import com.guigu.instructional.po.DisciplineInfoExample.Criteria;


@Service("DisciplineInfoServiceImpl")
public class DisciplineInfoServiceImpl implements DisciplineInfoService{

	@Resource(name="disciplineInfoMapper")
	private DisciplineInfoMapper disciplineInfoMapper;
	
	@Override
	public boolean addRole(DisciplineInfo disciplineInfo) {
		if(disciplineInfo!=null) {
			disciplineInfo.setDisciplineIsused("1");
		}
		int i = disciplineInfoMapper.insertSelective(disciplineInfo);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateRole(DisciplineInfo disciplineInfo) {
		int i = disciplineInfoMapper.updateByPrimaryKeySelective(disciplineInfo);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public List<DisciplineInfo> getDisciplineInfoList(DisciplineInfo disciplineInfo) {
		DisciplineInfoExample disciplineInfoExample = new DisciplineInfoExample();
		Criteria criteria = disciplineInfoExample.createCriteria();
		if(disciplineInfo!=null) {
			if(disciplineInfo.getDisciplineName()!=null) {
				disciplineInfo.setDisciplineName("%"+disciplineInfo.getDisciplineName()+"%");
				criteria.andDisciplineNameLike(disciplineInfo.getDisciplineName());
			}
		}
		criteria.andDisciplineIsusedEqualTo("1");
		return disciplineInfoMapper.selectByExample(disciplineInfoExample);
	}

	@Override
	public DisciplineInfo getDisciplineInfo(Integer disciplineId) {
		return disciplineInfoMapper.selectByPrimaryKey(disciplineId);
	}

	@Override
	public List<DisciplineInfo> getDisciplineNameList(DisciplineInfo disciplineInfo) {
		
		DisciplineInfoExample disciplineInfoExample=new DisciplineInfoExample();
		Criteria criteria=disciplineInfoExample.createCriteria();
		
        if(disciplineInfo!=null && disciplineInfo.getDisciplineName()!=null) {
        	disciplineInfo.setDisciplineName("%"+disciplineInfo.getDisciplineName()+"%");
        	criteria.andDisciplineNameLike(disciplineInfo.getDisciplineName());
        }
		
		return disciplineInfoMapper.selectByExample(disciplineInfoExample);
	}

	@Override
	public List<DisciplineInfo> getDisciplinePoolList(DisciplineInfo disciplineInfo) {
		
		DisciplineInfoExample disciplineInfoExample=new DisciplineInfoExample();
		return disciplineInfoMapper.selectByExample(disciplineInfoExample);
	}

}
