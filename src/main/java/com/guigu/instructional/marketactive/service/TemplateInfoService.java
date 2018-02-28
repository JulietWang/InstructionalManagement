package com.guigu.instructional.marketactive.service;

import java.util.List;

import com.guigu.instructional.po.TemplateInfo;

public interface TemplateInfoService {
	
		public boolean addTemplate(TemplateInfo templateInfo);
	   
	    public boolean updateTemplate(TemplateInfo templateInfo);
	    
	    public List<TemplateInfo> getTemplateInfoList(TemplateInfo templateInfo);
	    
	    public TemplateInfo getTemplateInfo(Integer templateId);
	    
	    public boolean deleteTemplate(Integer templateId);
	    
	    public List<TemplateInfo> findList(TemplateInfo templateInfo);
	    
}
