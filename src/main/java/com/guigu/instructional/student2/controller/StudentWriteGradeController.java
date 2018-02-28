package com.guigu.instructional.student2.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.po.EvaluationInfoExampleVO;
import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.po.StudentWriteGrade;
import com.guigu.instructional.po.StudentWriteGradeCustom;
import com.guigu.instructional.student2.service.StudentWriteGradeService;

@Controller
@RequestMapping("/student/studentwritegrade")
public class StudentWriteGradeController {

	@Resource(name="studentWriteGradeServiceImpl")
	private StudentWriteGradeService studentWriteGradeService;
	
	
	@RequestMapping("list.action")
	public String list(StudentInfo studentInfo,Model model) {
		
		List<StudentWriteGradeCustom> list=studentWriteGradeService.getStudentWriteGradeList(studentInfo);
		model.addAttribute("list",list);
		
		return "student/studentwritegrade/studentwritegrade_list";
	}
	
	@RequestMapping("add.action")
	public String add(@Validated StudentWriteGrade studentWriteGrade,BindingResult bindingResult,Model model) {
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors=bindingResult.getAllErrors();
			
			model.addAttribute("allErrors",allErrors);
			
			model.addAttribute("studentWriteGrade",studentWriteGrade);
			
			return "student/studentwritegrade/studentwritegrade_add";
		}else {
		boolean result=studentWriteGradeService.addStudentWriteGrade(studentWriteGrade);
		
		if(result) {
			model.addAttribute("info","添加成功");
		}else {
			model.addAttribute("info","添加失败");
		}
		
		return this.list(null, model);
		}
	}
	
	@RequestMapping("load.action")
	public String load(Integer writeGradeId,Model model) {
		StudentWriteGrade studentWriteGrade=studentWriteGradeService.getStudentWriteGrade(writeGradeId);
		
		model.addAttribute("studentWriteGrade", studentWriteGrade);
		
		return "student/studentwritegrade/studentwritegrade_update";
	}
	
	@RequestMapping("update.action")
	public String update(@Validated StudentWriteGrade studentWriteGrade,BindingResult bindingResult,Model model) {
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors=bindingResult.getAllErrors();
			
			model.addAttribute("allErrors",allErrors);
			
			model.addAttribute("studentWriteGrade",studentWriteGrade);
			
			return "student/studentwritegrade/studentwritegrade_update";
		}else {
		boolean result=studentWriteGradeService.updateStudentWriteGrade(studentWriteGrade);
		
		if(result) {
			model.addAttribute("info","修改成功");
		}else {
			model.addAttribute("info","修改失败");
		}
		
		return this.list(null, model);
		}
	}
	
	@RequestMapping("delete.action")
	public String delete(Integer writeGradeId,Model model) {
		boolean result=studentWriteGradeService.deleteStudentWriteGrade(writeGradeId);
		
		if(result) {
			model.addAttribute("info","删除成功");
		}else {
			model.addAttribute("info","删除失败");
		}
		
		return this.list(null, model);
	}
}
