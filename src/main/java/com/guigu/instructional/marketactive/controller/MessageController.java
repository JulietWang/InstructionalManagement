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

import com.guigu.instructional.marketactive.service.MessageService;
import com.guigu.instructional.marketactive.service.TemplateInfoService;
import com.guigu.instructional.po.EmailInfo;
import com.guigu.instructional.po.EmailVO;
import com.guigu.instructional.po.MessageInfo;
import com.guigu.instructional.po.MessageVO;
import com.guigu.instructional.po.StaffInfo;
import com.guigu.instructional.po.TemplateInfo;
import com.guigu.instructional.system.service.StaffInfoService;

@Controller
@RequestMapping("/marketactive/messageinfo/")
public class MessageController {
	@Resource(name = "messageServiceImpl")
	private MessageService messageService;
	@Resource(name = "staffInfoServiceImpl")
	private StaffInfoService staffInfoService;
	
	@Resource(name="templateInfoServiceImpl")
	private TemplateInfoService templateInfoService;

	@RequestMapping("list.action")
	public String msgList(MessageInfo messageInfo, Model model) {
		List<MessageInfo> list = messageService.getMsgStaff(messageInfo);
		model.addAttribute("list", list);
		return "marketactive/messageinfo/messageinfo_list";
	}
	@RequestMapping("add.action")
	public String addMsg(@Validated MessageVO messageVO,BindingResult bindingResult,Model model) {
		StaffInfo staffInfo= staffInfoService.getStaffInfo(messageVO.getStaffName());
		if(staffInfo!=null) {
			messageVO.setStaffId(staffInfo.getStaffId());
			if(bindingResult.hasErrors()) {
				List<ObjectError> allErrors=bindingResult.getAllErrors();
				model.addAttribute("allErrors", allErrors);
				model.addAttribute("msg", messageVO);
				return this.send(model);
			}
		}else {
			if(bindingResult.hasErrors()) {
				List<ObjectError> allErrors=bindingResult.getAllErrors();
				model.addAttribute("allErrors", allErrors);
				model.addAttribute("error", "该用户没有权限");
				model.addAttribute("msg", messageVO);
				return this.send(model);
			}
			model.addAttribute("error", "该用户没有权限");
			model.addAttribute("msg", messageVO);
			return this.send(model);
		}
		messageVO.setMessageTime(new Date());
		messageVO.setMessageState("已发送");
		boolean flag=messageService.addMsg(messageVO);
		if(flag) {
			model.addAttribute("info", "发送成功");
		}else {
			model.addAttribute("info", "发送失败");
		}
		
		return this.msgList(null,model);
	}
	
	@RequestMapping("load.action")
	public String load(Integer messageId1,Model model) {
		System.out.println(messageId1);
		MessageVO messageVO =messageService.findMsgById(messageId1);
		messageVO.setStaffName(staffInfoService.getStaffInfo(messageVO.getStaffId()).getStaffName());
		model.addAttribute("msg", messageVO);
		return "marketactive/messageinfo/messageinfo_show";
	}
	
	@RequestMapping("delete.action")
	public String deleteMsg(MessageInfo messageInfo,Model model) {
		boolean flag=messageService.deleteMsg(messageInfo.getMessageId1());
		if(flag) {
			model.addAttribute("info", "刪除成功");
		}else {
			model.addAttribute("info", "刪除失败");
		}
		return this.msgList(null,model);
	}
	@RequestMapping("send.action")
	public String send(Model model) {
		TemplateInfo templateInfo=new TemplateInfo();
		templateInfo.setTemplateType("短信");
		List<TemplateInfo> list=templateInfoService.findList(templateInfo);
		model.addAttribute("list", list);
		return "marketactive/messageinfo/messageinfo_send";
	}
	
}
