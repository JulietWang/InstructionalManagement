package com.guigu.instructional.marketactive.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.guigu.instructional.marketactive.mapper.TemplateInfoMapper;
import com.guigu.instructional.marketactive.service.TemplateInfoService;
import com.guigu.instructional.po.TemplateInfo;
import com.guigu.instructional.po.TemplateInfoExample;
import com.guigu.instructional.po.TemplateInfoExample.Criteria;
@Service("templateInfoServiceImpl")
public class TemplateInfoServiceImpl implements TemplateInfoService{
	@Resource(name="templateInfoMapper")
	private  TemplateInfoMapper templateInfoMapper;
	
	
	@Override
	public boolean addTemplate(TemplateInfo templateInfo) {
		 try {
	            int i = templateInfoMapper.insertSelective(templateInfo);
	            if (i > 0) {
	                return true;
	            }
	        } catch (Exception e) {

	        }
	        return false;
	}

	@Override
	public boolean updateTemplate(TemplateInfo templateInfo) {
		 try {
	            int i = templateInfoMapper.updateByPrimaryKeySelective(templateInfo);
	            if (i > 0) {
	                return true;
	            }
	        } catch (Exception e) {

	        }

	        return false;
	}

	@Override
	public List<TemplateInfo> getTemplateInfoList(TemplateInfo templateInfo) {
			TemplateInfoExample templateInfoExample=new TemplateInfoExample();
			Criteria criteria=templateInfoExample.createCriteria();
			if (templateInfo!=null) {
				if(templateInfo.getTemplateTitle()!=null) {
					templateInfo.setTemplateTitle("%"+templateInfo.getTemplateTitle()+"%");
					criteria.andTemplateTitleLike(templateInfo.getTemplateTitle());
				}
				
			}
		return templateInfoMapper.selectByExample(templateInfoExample);
	}

	@Override
	public TemplateInfo getTemplateInfo(Integer templateId) {
		return templateInfoMapper.selectByPrimaryKey(templateId);
	}

	@Override
	public boolean deleteTemplate(Integer templateId) {
		try {
			int i=templateInfoMapper.deleteByPrimaryKey(templateId);
			if(i>0) {
				return true;
			}
		}catch (Exception e) {
		}
		return false;
	}

	@Override
	public List<TemplateInfo> findList(TemplateInfo templateInfo) {
		TemplateInfoExample templateInfoExample=new TemplateInfoExample();
		Criteria criteria=templateInfoExample.createCriteria();
		if(templateInfo!=null) {
			if(templateInfo.getTemplateType()!=null&& templateInfo.getTemplateType().equals("ÓÊ¼þ")) {
				criteria.andTemplateTypeEqualTo(templateInfo.getTemplateType());
			}
			if (templateInfo.getTemplateType()!=null&& templateInfo.getTemplateType().equals("¶ÌÐÅ")) {
				criteria.andTemplateTypeEqualTo(templateInfo.getTemplateType());
			}
		}
		return templateInfoMapper.selectByExample(templateInfoExample);
	}
	

	
}
