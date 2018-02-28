package com.guigu.instructional.student2.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.po.CommunicationInfo;
import com.guigu.instructional.po.CommunicationInfoCustom;
import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.student2.service.CommunicationInfoService;

@Controller
@RequestMapping("student/communicateinfo")
public class CommunicationInfoController {

	@Resource(name="communicationInfoService")
	private CommunicationInfoService communicationInfoService;
	
	
	@RequestMapping("list.action")
	public String list(StudentInfo studentInfo,Model model) {
		List<CommunicationInfoCustom> list=communicationInfoService.getCommunicatinList(studentInfo);
		
		model.addAttribute("list",list);
		
		return "student/communicateinfo/communicateinfo_list";
	}
	
	@RequestMapping("add.action")
	public String add(@Validated CommunicationInfo communicationInfo,BindingResult bindingResult,Model model) {
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors=bindingResult.getAllErrors();
			
			model.addAttribute("allErrors",allErrors);
			
			model.addAttribute("communicationInfo",communicationInfo);
			
			return "student/communicateinfo/communicateinfo_add";
		}else {
		boolean result=communicationInfoService.addCommunication(communicationInfo);
		if(result) {
			model.addAttribute("info", "添加成功");
		}else {
			model.addAttribute("info", "添加失败");
		}
			
		
		return this.list(null, model);
		}
	}
	
	@RequestMapping("load.action")
	public String load(Integer communicationId,Model model) {
		CommunicationInfo communicationInfo=communicationInfoService.getCommunicationInfo(communicationId);
		 
		model.addAttribute("communicationInfo",communicationInfo);
		return "student/communicateinfo/communicateinfo_update";
	}
	
	@RequestMapping("update.action")
	public String update(@Validated CommunicationInfo communicationInfo,BindingResult bindingResult,Model model) {
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors=bindingResult.getAllErrors();
			
			model.addAttribute("allErrors",allErrors);
			
			model.addAttribute("communicationInfo",communicationInfo);
			
			return "student/communicateinfo/communicateinfo_update";
		}else {
		
		boolean result=communicationInfoService.updateCommunication(communicationInfo);
		if(result) {
			model.addAttribute("info", "修改成功");
		}else {
			model.addAttribute("info", "修改失败");
		}
			
		
		return this.list(null, model);
		}
	}
	@RequestMapping("delete.action")
	public String delete(Integer communicationId,Model model) {
		boolean result=communicationInfoService.deleteCommunication(communicationId);
		 
		if(result) {
			model.addAttribute("info", "删除成功");
		}else {
			model.addAttribute("info", "删除失败");
		}
		return this.list(null, model);
	}
	
}
