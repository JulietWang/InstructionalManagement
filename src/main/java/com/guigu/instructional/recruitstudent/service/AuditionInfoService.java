package com.guigu.instructional.recruitstudent.service;

import java.util.List;

import com.guigu.instructional.po.AuditionCustom;
import com.guigu.instructional.po.DisciplineInfo;
import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.po.AuditionInfo;

public interface AuditionInfoService {
	
    /**
     * addAudition:添加试听记录信息
     * @author 王珠玲
     * @param auditionInfo
     * @return  <br/> 
     * @since JDK 1.8
     */
	public boolean addAudition(AuditionInfo auditionInfo);
	
    /**
     * upadteAudition:更新试听记录信息
     * @author 王珠玲
     * @param auditionInfo
     * @return  <br/> 
     * @since JDK 1.8
     */
	public boolean upadteAudition(AuditionInfo auditionInfo);
	
    /**
     * getAuditionInfo:根据条件编号查询试听记录信息
     * @author 王珠玲
     * @param auditionId
     * @return  <br/> 
     * @since JDK 1.8
     */
	public AuditionInfo getAuditionInfo(Integer auditionId);
	
    /**
     * getAuditionInfo:根据条件编号删除试听记录信息
     * @author 王珠玲
     * @param auditionId
     * @return  <br/> 
     * @since JDK 1.8
     */
	public int deleteAuditionInfo(Integer auditionId);
	
    /**
     * getAuditionCustomList:根据条件查询试听记录信息
     * @author 王珠玲
     * @param studentInfo disciplineInfo
     * @return  <br/> 
     * @since JDK 1.8
     */
	public List<AuditionCustom> getAuditionCustomList(StudentInfo studentInfo,DisciplineInfo disciplineInfo);
	
}
