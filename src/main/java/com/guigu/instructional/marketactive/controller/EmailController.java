package com.guigu.instructional.marketactive.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.marketactive.service.EmailService;
import com.guigu.instructional.marketactive.service.TemplateInfoService;
import com.guigu.instructional.po.EmailInfo;
import com.guigu.instructional.po.EmailVO;
import com.guigu.instructional.po.MarketActive;
import com.guigu.instructional.po.MarketActiveVO;
import com.guigu.instructional.po.StaffInfo;
import com.guigu.instructional.po.TemplateInfo;
import com.guigu.instructional.system.service.StaffInfoService;


@Controller
@RequestMapping("/marketactive/emailinfo/")
public class EmailController {
	@Resource(name="emailServiceImpl")
	private EmailService emailService; 
	@Resource(name="staffInfoServiceImpl")
	private StaffInfoService staffInfoService;
	
	@Resource(name="templateInfoServiceImpl")
	private TemplateInfoService templateInfoService;
	
	@RequestMapping("list.action")
	public String emailList(EmailInfo emailInfo,Model model) {
		List<EmailInfo> list=emailService.getEmailStaff(emailInfo);
		model.addAttribute("list", list);
		return "/marketactive/emailinfo/emailinfo_list";
	}
	
	@RequestMapping("add.action")
	public String addEmail(Model model,@Validated EmailVO emailVO,BindingResult bindingResult) {
		StaffInfo staffInfo= staffInfoService.getStaffInfo(emailVO.getStaffName());
		if(staffInfo!=null) {
			emailVO.setStaffId(staffInfo.getStaffId());
			if(bindingResult.hasErrors()) {
				List<ObjectError> allErrors=bindingResult.getAllErrors();
				model.addAttribute("allErrors", allErrors);
				model.addAttribute("emailVO", emailVO);
				return this.send(model);
			}
		}else {
			if(bindingResult.hasErrors()) {
				List<ObjectError> allErrors=bindingResult.getAllErrors();
				model.addAttribute("allErrors", allErrors);
				model.addAttribute("error", "该用户没有权限");
				model.addAttribute("emailVO", emailVO);
				return this.send(model);
			}
				model.addAttribute("error", "该用户没有权限");
			return this.send(model);
		}
		emailVO.setEmailTime(new Date());
		emailVO.setEmailState("已发送");
		boolean flag=emailService.addEmail(emailVO);
		if(flag) {
			model.addAttribute("info", "发送成功");
		}else {
			model.addAttribute("info", "发送失败");
		}
		
		return this.emailList(null,model);
	}
	
	@RequestMapping("load.action")
	public String load(Integer emailId,Model model) {
		EmailVO emailVO =emailService.findEmailById(emailId);
		emailVO.setStaffName(staffInfoService.getStaffInfo(emailVO.getStaffId()).getStaffName());
		model.addAttribute("email", emailVO);
		return "marketactive/emailinfo/emailinfo_show";
	}
	
	
	@RequestMapping("delete.action")
	public String deleteEmail(EmailInfo emailInfo,Model model) {
		boolean flag=emailService.deleteEmail(emailInfo.getEmailId());
		if(flag) {
			model.addAttribute("info", "刪除成功");
		}else {
			model.addAttribute("info", "刪除失败");
		}
		return this.emailList(null,model);
	}
	
	@RequestMapping("send.action")
	public String send(Model model) {
		TemplateInfo templateInfo=new TemplateInfo();
		templateInfo.setTemplateType("邮件");
		List<TemplateInfo> list=templateInfoService.findList(templateInfo);
		model.addAttribute("list", list);
		return "marketactive/emailinfo/emailinfo_send";
	}

}
