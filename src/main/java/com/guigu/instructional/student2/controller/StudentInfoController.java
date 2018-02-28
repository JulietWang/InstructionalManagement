package com.guigu.instructional.student2.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.classinfo.service.CDSCSService;
import com.guigu.instructional.po.StaffInfo;
import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.po.StudentInfoCustom;
import com.guigu.instructional.po.ValidGroupAdd;
import com.guigu.instructional.po.ValidGroupUpdate;
import com.guigu.instructional.student2.service.StudentInfo2Service;
import com.guigu.instructional.system.service.StaffInfoService;

@Controller
@RequestMapping("/student/student")
public class StudentInfoController {

	@Resource(name="studentInfoService")
	private StudentInfo2Service studentInfoService;
	
	@Resource(name="StaffInfoService")
	private StaffInfoService staffInfoService;
	
	@Resource(name="CDSCSServiceiMPL")
	private CDSCSService CDSCSService;
	
	@RequestMapping("list.action")
	public String list(StudentInfo studentInfo,Model model) {
		List<StudentInfoCustom> list=studentInfoService.getStudentInfoList(studentInfo);
		model.addAttribute("list",list);
		return "student/student/student_list";
	}
	
	
	@RequestMapping("add.action")
	public String add(@Validated(value = { ValidGroupAdd.class }) StudentInfo studentInfo,BindingResult bindingResult,Model model) {
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors=bindingResult.getAllErrors();
			
			model.addAttribute("allErrors",allErrors);
			
			model.addAttribute("studentInfo",studentInfo);
			
			return "student/student/student_add";
		}else {
			studentInfo.setStudentMark(1);
		boolean result=studentInfoService.addStudent(studentInfo);
		if(result) {
			model.addAttribute("info","增加成功");
			
		}else {
			model.addAttribute("info","增加失败");
		}
		
		return this.list(null,model);
		}
	} 
	
	@RequestMapping("load.action")
	public String load(Integer studentId,Model model ) {
		StudentInfo studentInfo=studentInfoService.getStudent(studentId);
		model.addAttribute("studentInfo",studentInfo);
		
		return "student/student/student_update";
	}
	
	
	@RequestMapping("update.action")
	public String update(@Validated (value = { ValidGroupUpdate.class })StudentInfo studentInfo,BindingResult bindingResult,Model model ) {
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors=bindingResult.getAllErrors();
			
			model.addAttribute("allErrors",allErrors);
			
			model.addAttribute("studentInfo",studentInfo);
			
			return "student/student/student_update";
		}else {
			studentInfo.setStudentMark(1);
		boolean result=studentInfoService.updateStudent(studentInfo);
		if(result) {
			model.addAttribute("info", "修改成功");
			
		}else {
			model.addAttribute("info", "修改失败");
		}
		
		 return this.list(null,model);
		}
	}
	
	@RequestMapping("delete.action")
	public String delete(StudentInfo studentInfo,Model model ) {
		studentInfo.setStudentMark(0);
		boolean result=studentInfoService.updateStudent(studentInfo);
		
		if(result) {
			model.addAttribute("info", "删除成功");
		}else {
			model.addAttribute("info", "删除失败");
		}
		return this.list(null,model);
	}
	
	@RequestMapping("loadUpdate.action")
	public String loadUpdate(Integer studentId, Model model) {

		StudentInfo studentInfo = studentInfoService.getStudent(studentId);
		model.addAttribute("studentInfo", studentInfo);

		List<StaffInfo> slist = staffInfoService.getStaffInfoList(null);
		model.addAttribute("stafflist", slist);

		return "recruitstudent/studentpool/studentpool_update";
	}

	
	@RequestMapping("loadAdd.action")
	public String loadAdd(Model model) {

		List<StaffInfo> slist = staffInfoService.getStaffInfoList(null);
		model.addAttribute("stafflist", slist);

		return "recruitstudent/studentpool/studentpool_add";
	}
}
