package com.guigu.instructional.recruitstudent.service;

import java.util.List;

import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.po.TrackRecordCustom;
import com.guigu.instructional.po.TrackRecordInfo;

public interface TrackRecordInfoService {
	
	 /**
     * addTrackRecord:添加追踪记录信息
     * @author 王珠玲
     * @param trackRecordInfo
     * @return  <br/> 
     * @since JDK 1.8
     */
	public boolean addTrackRecord(TrackRecordInfo trackRecordInfo);
	
    /**
     * upadteAudition:更新追踪记录信息
     * @author 王珠玲
     * @param trackRecordInfo
     * @return  <br/> 
     * @since JDK 1.8
     */
	public boolean upadteTrackRecord(TrackRecordInfo trackRecordInfo);
	
    /**
     * getTrackRecordInfo:根据条件编号查询追踪记录信息
     * @author 王珠玲
     * @param trackRecordId
     * @return  <br/> 
     * @since JDK 1.8
     */
	public TrackRecordInfo getTrackRecordInfo(Integer trackRecordId);
	
    /**
     * deleteTrackRecordInfo:根据条件编号删除追踪记录信息
     * @author 王珠玲
     * @param trackRecordId
     * @return  <br/> 
     * @since JDK 1.8
     */
	public int deleteTrackRecordInfo(Integer trackRecordId);
	
    /**
     * getTrackRecordCustomList:根据条件查询试听记录信息
     * @author 王珠玲
     * @param studentInfo
     * @return  <br/> 
     * @since JDK 1.8
     */
	public List<TrackRecordCustom> getTrackRecordCustomList(StudentInfo studentInfo);
	
}
