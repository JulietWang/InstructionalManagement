package com.guigu.instructional.marketactive.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import com.guigu.instructional.marketactive.mapper.EmailInfoMapper;
import com.guigu.instructional.marketactive.mapper.EmailVOMapper;
import com.guigu.instructional.marketactive.service.EmailService;
import com.guigu.instructional.po.EmailInfo;
import com.guigu.instructional.po.EmailInfoExample;
import com.guigu.instructional.po.EmailInfoExample.Criteria;
import com.guigu.instructional.po.EmailVO;
import com.guigu.instructional.po.StaffInfo;
import com.guigu.instructional.system.mapper.StaffInfoMapper;
@Service("emailServiceImpl")
public class EmailServiceImpl implements EmailService{

	@Resource(name="emailInfoMapper")
	private EmailInfoMapper emailInfoMapper;
	
	@Resource(name="emailVOMapper")
	private EmailVOMapper  emailVOMapper;
	
	@Resource(name="staffInfoMapper")
	private StaffInfoMapper staffInfoMapper;
	
	@Override
	public boolean updateEmail(EmailVO emailVO) {
		try {
            int i = emailVOMapper.updateEmail(emailVO);
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {

        }

        return false;
	}

	@Override
	public EmailVO findEmailById(Integer id) {
		String staffName=null;
		EmailInfo emailInfo=emailInfoMapper.selectByPrimaryKey(id);
		StaffInfo staffInfo=staffInfoMapper.selectByPrimaryKey(emailInfo.getStaffId());
		if(staffInfo!=null) {
			staffName=staffInfo.getStaffName();
		}
		EmailVO emailVO=new EmailVO();
		try {
			BeanUtils.copyProperties(emailVO,emailInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		emailVO.setStaffName(staffName);
		return emailVO;
	}

	@Override
	public List<EmailInfo> getEmailStaff(EmailInfo emailInfo) {
		EmailInfoExample emailInfoExample=new EmailInfoExample();
		Criteria criteria=emailInfoExample.createCriteria();
		if(emailInfo!=null) {
			if(emailInfo.getEmailTitle()!=null) {
				emailInfo.setEmailTitle("%"+emailInfo.getEmailTitle()+"%");
				criteria.andEmailTitleLike(emailInfo.getEmailTitle());
			}
		}
		return emailInfoMapper.selectByExample(emailInfoExample);
	}

	@Override
	public boolean addEmail(EmailVO emailVO) {
		try {
            int i = emailVOMapper.addEmail(emailVO);
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {

        }

        return false;
	}

	@Override
	public boolean deleteEmail(Integer emailId) {
		int i=emailInfoMapper.deleteByPrimaryKey(emailId);
		if (i>0) {
			return true;
		}
		return false;
	}

}
