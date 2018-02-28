package com.guigu.instructional.transaction.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.po.ClassInfo;
import com.guigu.instructional.po.ClassTransactionInfo;
import com.guigu.instructional.po.ClassroomInfo;
import com.guigu.instructional.transaction.services.ClassroomServices;

/**
 * <p>
 * project_name:InstructionalManagement
 * </p>
 * <p>
 * package_name:com.guigu.instructional.system.controller.StaffInfoController
 * </p>
 * <p>
 * description：
 * </p>
 * <p>
 * @author：刘老师
 * <p>
 * <p>
 * date:2018年1月26日上午9:15:58
 * </p>
 * <p>
 * comments：
 * </p>
 * <p>
 * @version jdk1.8
 * </p>
 * 
 * <p>
 * Copyright (c) 2018, 980991634@qq.com All Rights Reserved.
 * </p>
 */
@Controller
@RequestMapping("/transaction/class_transaction/")
public class ClassroomController {

	@Resource(name = "classroomServiceImpl")
	private ClassroomServices classroomServices;

	// 进行数据校验 你们的功能
	@RequestMapping("add.action")
	public String addClassroomInfo(Model model, @Validated ClassroomInfo classroomInfo, BindingResult bindingResult) {
		// ClassroomInfo.setStaffState("1");
		if (bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);
			return "transaction/class_transaction/class_add";
		}
		boolean result = classroomServices.addClassroomInfo(classroomInfo);

		if (result) {
			model.addAttribute("info", "添加成功");
		} else {
			model.addAttribute("info", "添加失败");
		}
		return this.list(null, model);

	}

	@RequestMapping("list.action")
	public String list(ClassroomInfo classroomInfo, Model model) {
		List<ClassroomInfo> list = classroomServices.getClassroomInfoList(classroomInfo);
		model.addAttribute("list", list);
		return "transaction/class_transaction/class_list";
	}

	@RequestMapping("show.action")
	public String showClassroomInfo(Integer classroomId, Model model) {
		ClassInfo classInfo = classroomServices.getClassInfo(classroomId);
		model.addAttribute("classInfo", classInfo);
		return "transaction/class_transaction/class_show";

	}

	@RequestMapping("show1.action")
	public String showTransactionInfo(Integer classId, Model model) {
		ClassTransactionInfo classTransactionInfo = classroomServices.getClassTransactionInfo(classId);
		model.addAttribute("classTransactionInfo", classTransactionInfo);
		return "transaction/class_transaction/show";

	}

	@RequestMapping("load.action")
	public String loadUpate(Integer classroomId, Model model) {
		ClassroomInfo classroomInfo = classroomServices.getClassroomInfo(classroomId);
		model.addAttribute("classroomInfo", classroomInfo);
		return "transaction/class_transaction/class_update";
	}

	@RequestMapping("update.action")
	public String updateClassroomInfo(ClassroomInfo classroomInfo, Model model) {
		boolean result = classroomServices.updateClassroomInfo(classroomInfo);
		if (result) {
			model.addAttribute("info", "修改成功");
		} else {
			model.addAttribute("info", "修改失败");
		}
		return this.list(null, model);
	}

	@RequestMapping("delete.action")
	public String deleteClassroomInfo(ClassroomInfo classroomInfo, Model model) {

		// //设置员工为 0 代表无效
		// staffInfo.setStaffState("0");
		classroomInfo.setClassroomMark("0");

		boolean result = classroomServices.updateClassroomInfo(classroomInfo);
		if (result) {
			model.addAttribute("info", "删除成功");
		} else {
			model.addAttribute("info", "删除失败");
		}
		return this.list(null, model);
	}

}
