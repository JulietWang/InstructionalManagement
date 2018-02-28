package com.guigu.instructional.system.service;

import java.util.List;

import com.guigu.instructional.po.DataDictionary;

public interface DataDictionaryService {
	
	public List<DataDictionary> findDataDictionaryList(DataDictionary dataDictionary);
	
	public boolean addDataDictionary(DataDictionary dataDictionary);
	
	public boolean uppateDataDictionary(DataDictionary dataDictionary);
	
	public boolean deleteDataDictionary(Integer dataDictionaryId);
	
	public DataDictionary findDataDictionaryById(Integer dataDictionaryId);
}
