package com.guigu.instructional.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.guigu.instructional.po.DataDictionary;
import com.guigu.instructional.po.DataDictionaryExample;
import com.guigu.instructional.po.DataDictionaryExample.Criteria;
import com.guigu.instructional.system.mapper.DataDictionaryMapper;
import com.guigu.instructional.system.service.DataDictionaryService;

@Service("dataDictionaryServiceImpl")
public class DataDictionaryServiceImpl implements DataDictionaryService{
	
	@Resource(name="dataDictionaryMapper")
	private DataDictionaryMapper dataDictionaryMapper;
	
	@Override
	public List<DataDictionary> findDataDictionaryList(DataDictionary dataDictionary) {
		DataDictionaryExample dataDictionaryExample=new DataDictionaryExample();
		
		Criteria criteria=dataDictionaryExample.createCriteria();
		if(dataDictionary!=null) {
			if(dataDictionary.getDataId()!=null) {
				criteria.andDataIdEqualTo(dataDictionary.getDataId());
			}
			
			if(dataDictionary.getDataType()!=null) {
				dataDictionary.setDataType("%"+dataDictionary.getDataType()+"%");
				criteria.andDataTypeLike(dataDictionary.getDataType());
			}
		}
		return dataDictionaryMapper.selectByExample(dataDictionaryExample);
	}

	@Override
	public boolean addDataDictionary(DataDictionary dataDictionary) {
		int i=dataDictionaryMapper.insertSelective(dataDictionary);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean uppateDataDictionary(DataDictionary dataDictionary) {
		int i=dataDictionaryMapper.updateByPrimaryKeySelective(dataDictionary);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteDataDictionary(Integer dataDictionaryId) {
		int i=dataDictionaryMapper.deleteByPrimaryKey(dataDictionaryId);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public DataDictionary findDataDictionaryById(Integer dataDictionaryId) {
		return dataDictionaryMapper.selectByPrimaryKey(dataDictionaryId);
	}

	

}
