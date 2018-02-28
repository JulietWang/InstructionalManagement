package com.guigu.instructional.classinfo.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.guigu.instructional.classinfo.mapper.SyllabusInfoMapper;
import com.guigu.instructional.classinfo.service.SyllabusInfoService;
import com.guigu.instructional.po.SyllabusInfo;
import com.guigu.instructional.po.SyllabusInfoExample;
import com.guigu.instructional.po.SyllabusInfoExample.Criteria;

@Service("syllabusInfoServiceImpl")
public class SyllabusInfoServiceImpl implements SyllabusInfoService {

	@Resource(name="syllabusInfoMapper")
	private SyllabusInfoMapper syllabusInfoMapper;
	
	@Override
	public boolean addSyllabus(SyllabusInfo syllabusInfo) {
		if(syllabusInfo!=null) {
			syllabusInfo.setSyllabusIsused("1");
		}
		int i = syllabusInfoMapper.insertSelective(syllabusInfo);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateSyllabus(SyllabusInfo syllabusInfo) {
		int i = syllabusInfoMapper.updateByPrimaryKeySelective(syllabusInfo);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public List<SyllabusInfo> getSyllabusList(SyllabusInfo syllabusInfo) {
		SyllabusInfoExample syllabusInfoExample = new SyllabusInfoExample();
		Criteria criteria = syllabusInfoExample.createCriteria();
		if(syllabusInfo!=null) {
			if(syllabusInfo.getSyllabusName()!=null) {
				syllabusInfo.setSyllabusName("%"+syllabusInfo.getSyllabusName()+"%");
				criteria.andSyllabusNameLike(syllabusInfo.getSyllabusName());
			}
		}
		criteria.andSyllabusIsusedEqualTo("1");
		return syllabusInfoMapper.selectByExample(syllabusInfoExample);
	}

	@Override
	public SyllabusInfo getSyllabus(Integer syllabusId) {
		return syllabusInfoMapper.selectByPrimaryKey(syllabusId);
	}

}
