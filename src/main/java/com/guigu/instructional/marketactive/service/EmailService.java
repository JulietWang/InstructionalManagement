package com.guigu.instructional.marketactive.service;

import java.util.List;

import com.guigu.instructional.po.EmailInfo;
import com.guigu.instructional.po.EmailVO;
import com.guigu.instructional.po.MarketActive;
import com.guigu.instructional.po.MarketActiveVO;

public interface EmailService {
	
	
	public boolean updateEmail(EmailVO emailVO);
	
	public EmailVO findEmailById(Integer id);
	
	public List<EmailInfo> getEmailStaff(EmailInfo emailInfo);
	
	public boolean addEmail(EmailVO emailVO);
	
	public boolean deleteEmail(Integer emailId);


}
