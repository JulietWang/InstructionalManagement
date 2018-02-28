package com.guigu.instructional.classinfo.service;

import java.util.List;

import com.guigu.instructional.po.DisciplineInfo;

public interface DisciplineInfoService {
	
    /**
     * getAuditionInfoList:根据条件查询学科信息
     * @author 王珠玲
     * @param disciplineInfo
     * @return  <br/> 
     * @since JDK 1.8
     */
	public List<DisciplineInfo> getDisciplineNameList(DisciplineInfo disciplineInfo);
	
    /**
     * getDisciplineInfo:根据disciplineId查询学科信息
     * @author 王珠玲
     * @param disciplineInfo
     * @return  <br/> 
     * @since JDK 1.8
     */
	public DisciplineInfo getDisciplineInfo(Integer disciplineId);
	
    /**
     * getDisciplineList:根据条件查询学科信息
     * @author 王珠玲
     * @param disciplineInfo
     * @return  <br/> 
     * @since JDK 1.8
     */
	public List<DisciplineInfo> getDisciplinePoolList(DisciplineInfo disciplineInfo) ;

	public boolean addRole(DisciplineInfo disciplineInfo);
	
	public boolean updateRole(DisciplineInfo disciplineInfo);
	
	public List<DisciplineInfo> getDisciplineInfoList(DisciplineInfo disciplineInfo);
	 
}
