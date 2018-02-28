package com.guigu.instructional.student2.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.po.EvaluationInfo;
import com.guigu.instructional.po.EvaluationInfoExampleVO;
import com.guigu.instructional.student2.service.EvaluationInfoService;

@Controller
@RequestMapping("/student/evaluationinfo")
public class EvaluationInfoController {

	
	@Resource(name="evaluationInfoServiceImpl")
	private EvaluationInfoService evaluationInfoService;
	
	
	@RequestMapping("list.action")
	public String list(EvaluationInfo evaluationInfo,Model model) {
		
		List<EvaluationInfoExampleVO> aaa=evaluationInfoService.getEvaluationInfoList(evaluationInfo);
		
		model.addAttribute("aaa",aaa);
		return "student/evaluationinfo/evaluationinfo_list";
	}
	
	
	@RequestMapping("add.action")
	public String add(@Validated EvaluationInfo evaluationInfo,BindingResult bindingResult,Model model) {
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors=bindingResult.getAllErrors();
			
			model.addAttribute("allErrors",allErrors);
			
			model.addAttribute("evaluationInfo",evaluationInfo);
			
			return "student/evaluationinfo/evaluationinfo_add";
		}else {
		boolean result=evaluationInfoService.addEvaluation(evaluationInfo);
		if(result) {
			model.addAttribute("info","添加成功");
		}else {
			model.addAttribute("info","添加失败");
		}
		return this.list(null, model);
		}
	}
	
	@RequestMapping("load.action")
	public String load(Integer evaluationId,Model model) {
		EvaluationInfo evaluationInfo=evaluationInfoService.getEvaluationInfo(evaluationId);
		
		model.addAttribute("evaluationInfo",evaluationInfo);
		
		
		return"student/evaluationinfo/evaluationinfo_update";
	}
	
	@RequestMapping("update.action")
	public String update(@Validated EvaluationInfo evaluationInfo,BindingResult bindingResult,Model model) {
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors=bindingResult.getAllErrors();
			
			model.addAttribute("allErrors",allErrors);
			
			model.addAttribute("evaluationInfo",evaluationInfo);
			
			return "student/evaluationinfo/evaluationinfo_update";
		}else {
		boolean result=evaluationInfoService.updateEvaluation(evaluationInfo);
		
		if(result) {
			model.addAttribute("info","更新成功");
		}else {
			model.addAttribute("info","更新失败");
		}
		return this.list(null,model);
		}
	}
	
	@RequestMapping("delete.action")
	public String delete(Integer evaluationId,Model model) {
	  boolean result=evaluationInfoService.deleteEvaluationInfo(evaluationId);
	  if(result) {
		  model.addAttribute("info","删除成功");
		  
	  }else {
	  model.addAttribute("info","删除失败");
	  }
	  return this.list(null, model);
	}
}
