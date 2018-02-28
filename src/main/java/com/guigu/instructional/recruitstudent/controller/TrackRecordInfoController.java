package com.guigu.instructional.recruitstudent.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.po.TrackRecordInfo;
import com.guigu.instructional.po.ValidGroupAdd;
import com.guigu.instructional.po.ValidGroupUpdate;
import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.po.TrackRecordCustom;
import com.guigu.instructional.recruitstudent.service.TrackRecordInfoService;
import com.guigu.instructional.student.service.StudentInfoService;

@Controller
@RequestMapping("/recruitstudent/trackrecord")
public class TrackRecordInfoController {
	
	@Resource(name="trackRecordInfoServiceImpl")
	private TrackRecordInfoService trackRecordInfoService;
	
	@Resource(name = "studentInfoServiceImpl")
	private StudentInfoService studentInfoService;
	
	@RequestMapping("loadAdd.action")
	public String loadAdd(Model model) {

		List<StudentInfo> slist = studentInfoService.getStudentInfoPoolList(null);
		model.addAttribute("studentlist", slist);

		return "recruitstudent/trackrecord/trackrecord_add";
	}

	@RequestMapping("add.action")
	public String addTrackRecordInfo(@Validated(value= {ValidGroupAdd.class}) TrackRecordInfo trackRecordInfo,BindingResult bindingResult, Model model) throws Exception{
		
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors=bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);
			model.addAttribute("trackRecordInfo", trackRecordInfo);
			return this.loadAdd(model);
		}
		// 添加试听记录
		boolean result = trackRecordInfoService.addTrackRecord(trackRecordInfo);
		if (result) {
			model.addAttribute("info", "添加成功");
		} else {
			model.addAttribute("info", "添加失败");
		}
		return this.list(null, model);
	}

	@RequestMapping("delete.action")
	public String delete(Integer trackRecordId, Model model) throws Exception{
		int reuslt = trackRecordInfoService.deleteTrackRecordInfo(trackRecordId);
		if (reuslt > 0) {
			model.addAttribute("info", "删除成功");
		} else {
			model.addAttribute("info", "删除失败");
		}
		return this.list(null, model);
	}

	@RequestMapping("loadUpdate.action")
	public String loadUpdate(Integer trackRecordId, Model model) {

		TrackRecordInfo trackRecordInfo = trackRecordInfoService.getTrackRecordInfo(trackRecordId);
		model.addAttribute("trackRecordInfo", trackRecordInfo);

		List<StudentInfo> slist = studentInfoService.getStudentInfoPoolList(null);
		model.addAttribute("studentlist", slist);

		return "recruitstudent/trackrecord/trackrecord_update";
	}

	@RequestMapping("update.action")
	public String updateTrackRecordInfo(@Validated(value= {ValidGroupUpdate.class})TrackRecordInfo trackRecordInfo,BindingResult bindingResult, Model model) throws Exception{
		
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors=bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);
			model.addAttribute("trackRecordInfo", trackRecordInfo);
			return this.loadUpdate(trackRecordInfo.getTrackRecordId(),model);
		}
		
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors=bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);
			return this.loadUpdate(trackRecordInfo.getTrackRecordId(),model);
		}
		System.out.println("111111111111");
		boolean result = trackRecordInfoService.upadteTrackRecord(trackRecordInfo);
		System.out.println("22222222222");
		if (result) {
			model.addAttribute("info", "修改成功");
		} else {
			model.addAttribute("info", "修改失败");
		}
		return this.list(null, model);
	}

	@RequestMapping("list.action")
	public String list(StudentInfo studentInfo, Model model) throws Exception{
		List<TrackRecordCustom> list = trackRecordInfoService.getTrackRecordCustomList(studentInfo);
		model.addAttribute("list", list);
		return "recruitstudent/trackrecord/trackrecord_list";
	}

}
