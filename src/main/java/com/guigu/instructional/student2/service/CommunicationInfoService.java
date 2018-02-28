package com.guigu.instructional.student2.service;

import java.util.List;

import com.guigu.instructional.po.CommunicationInfo;
import com.guigu.instructional.po.CommunicationInfoCustom;
import com.guigu.instructional.po.StudentInfo;

public interface CommunicationInfoService {

	
	public boolean addCommunication(CommunicationInfo communicationInfo);
	
	public boolean updateCommunication(CommunicationInfo communicationInfo);
	
	public boolean deleteCommunication(Integer communicationId);
	
	public CommunicationInfo getCommunicationInfo(Integer communicationId);
	
	public List<CommunicationInfoCustom> getCommunicatinList(StudentInfo studentInfo);
}
